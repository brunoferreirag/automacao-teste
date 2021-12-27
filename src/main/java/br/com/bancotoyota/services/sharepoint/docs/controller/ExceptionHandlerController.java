package br.com.bancotoyota.services.sharepoint.docs.controller;

import br.com.bancotoyota.services.sharepoint.docs.common.Constants;
import br.com.bancotoyota.services.sharepoint.docs.exception.Erro;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

	private static final String ERROR = "error";

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Erro> handlerException(HttpClientErrorException ex) {
		log.error(ERROR, ex);
		log.error("HTTP response body: " + ex.getResponseBodyAsString());
		log.error("HTTP detail message: " + ex.getMessage());
		return new ResponseEntity<>(new Erro(String.format("HTTP response body:%s HTTP detail message:%s ",
				ex.getResponseBodyAsString(), ex.getMessage())), ex.getStatusCode());
	}

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<Erro> handlerException(ResourceAccessException ex) {
		log.error(ERROR, ex);
		return new ResponseEntity<>(new Erro(Constants.ERRO_TIMEOUT), HttpStatus.GATEWAY_TIMEOUT);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<Erro>> handlerConstraintViolationException(ConstraintViolationException ex) {
		log.error(ERROR, ex);
		List<Erro> erros = Arrays.asList(new Erro(ex.getMessage()));
		return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<List<Erro>> handlerException(RuntimeException ex) {
		log.error(ERROR, ex);
		List<Erro> erros = Arrays.asList(new Erro(ex.getMessage()));
		return new ResponseEntity<>(erros, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<List<Erro>> handlerException(HttpMessageNotReadableException ex) {
		log.error(ERROR, ex);
		List<Erro> erros = Arrays.asList(new Erro(Constants.ERRO_AO_LER_JSON_ENTRADA));
		return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<Erro> handlerHttpServerErrorException(HttpServerErrorException ex) {
		log.error("HTTP response body: " + ex.getResponseBodyAsString());
		log.error("HTTP detail message: " + ex.getMessage());
		return new ResponseEntity<>(new Erro(String.format("HTTP response body:%s HTTP detail message:%s ",
				ex.getResponseBodyAsString(), ex.getMessage())), ex.getStatusCode());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<Erro>> handlerException(MethodArgumentNotValidException ex) {
		log.error(ERROR, ex);
		List<Erro> erros = new ArrayList<>();
		List<FieldError> list = ex.getBindingResult().getFieldErrors();
		Class baseClass = ex.getBindingResult().getTarget().getClass();

		list.forEach(error -> {
			String fieldName = pathTraduzido(baseClass, error.getField());
			erros.add(new Erro(fieldName, "" + error.getRejectedValue(),
					String.format(getErrorMessage(error), fieldName)));
		});

		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();

		globalErrors.forEach(error -> erros.add(new Erro(error.getObjectName(), null, getErrorMessage(error))));

		List<Erro> errosUnicos = (erros.stream().distinct().sorted(new Comparator<Erro>() {

			@Override
			public int compare(Erro o1, Erro o2) {
				return o1.getMessage().compareTo(o2.getMessage());
			}
			
		})).collect(Collectors.toList());

		return new ResponseEntity<>(errosUnicos, HttpStatus.BAD_REQUEST);
	}

	protected String pathTraduzido(Class baseClass, String path) {
		String node;
		String resto;
		int i = path.indexOf('.');
		if (i >= 0) {
			node = path.substring(0, i);
			resto = path.substring(i + 1);
		} else {
			node = path;
			resto = null;
		}

		Field field = findField(baseClass, node);
		if (field != null) {
			JsonProperty a = field.getAnnotation(JsonProperty.class);
			String result = a != null ? a.value() : field.getName();
			if (resto != null) {
				result += "." + pathTraduzido(field.getType(), resto);
			}
			return result;
		} else {
			return path;
		}
	}

	private Field findField(Class baseClass, String fieldName) {
		if (baseClass == null) {
			return null;
		}
		try {
			return baseClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			return findField(baseClass.getSuperclass(), fieldName);
		}
	}

	private String getErrorMessage(ObjectError error) {
		if ("must not be null".equalsIgnoreCase(error.getDefaultMessage())) {
			return Constants.ERRO_PARAMETRO_OBRIGATORIO;
		} else {
			return error.getDefaultMessage();
		}
	}

}
