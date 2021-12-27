package br.com.bancotoyota.services.sharepoint.docs.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GeradorStringErroChamadasHttp {
	private ObjectMapper mapper ;
	public GeradorStringErroChamadasHttp(ObjectMapper mapper) {
		this.mapper = mapper;
		
	}
	public String gerarString(String message, Object request , String stackTrace , String mesageException) {
		StringBuilder sb = new StringBuilder();
		sb.append(message);
		
		if(request!=null) {
			sb.append(System.lineSeparator());
			sb.append(System.lineSeparator());
			try {
				sb.append("request que causou o erro: " + mapper.writeValueAsString(request));
			}
			catch(IOException ex){
				log.error("Erro ao fazer o parse da request:", ex);
			}
			
		}
		
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append("Mensagem da exception: " + message);
		
		if(!org.apache.commons.lang3.StringUtils.isEmpty(stackTrace)) {
			sb.append(System.lineSeparator());
			sb.append(System.lineSeparator());
			
			sb.append("stacktrace do erro: " + stackTrace);
		}
	
		
		return sb.toString();
		
	}
}
