package br.com.bancotoyota.services.sharepoint.docs.controller;


import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointUpdateRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponseBody;
import br.com.bancotoyota.services.sharepoint.docs.service.ArquivosSharePointService;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@RunWith(SpringRunner.class)
@WebMvcTest({ ArquivosSharePointController.class, ArquivosSharePointService.class, ExceptionHandlerController.class })
public class ArquivosSharePointControllerTest {

	@MockBean
	private ArquivosSharePointService service;

	@Autowired
	private MockMvc mockMvc;

	private final String URI = "/";
	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testeRetornoOK() throws Exception {
		String request = this.createRequestJson(this.criarItemRequest());

		String expected = "";

		valideStatusCodeEMensagemDeRetornoParaContentTypeJson(URI+"arquivos", request, HttpStatus.NO_CONTENT, expected, HttpMethod.DELETE);
	}
	
	@Test
	public void testeRequestDadosEmBranco() throws Exception {
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("");
		requestExclusao.setSubSiteSharepoint("");
		String request = this.createRequestJson(requestExclusao);

		String expected = "";

		valideStatusCodeEMensagemDeRetornoParaContentTypeJson(URI+"arquivos", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.DELETE);
	}
	
	
	@Test
	public void testeDownloadOK() throws Exception {
		String request = this.createRequestJson(this.criarItemRequest());

		String expected = "";
		
		when(service.downloadArquivo(any())).thenReturn(new byte[10]);

		valideStatusCodeEMensagemDeRetornoParaContentTypeJson(URI+"arquivos/download", request, HttpStatus.OK, expected, HttpMethod.POST);
	}
	
	@Test
	public void testeDownloadComDadosEmBranco() throws Exception {
		var requestItem = this.criarItemRequest();
		requestItem.setPath("");
		requestItem.setSubSiteSharepoint("");
		String request = this.createRequestJson(requestItem);

		String expected = "[{\"field\":\"path\",\"value\":\"\",\"message\":\"Path da pasta ou arquivo é obrigatório\"},{\"field\":\"subsite-sharepoint\",\"value\":\"\",\"message\":\"Subsite do sharepoint é obrigatório\"}]";
		
		when(service.downloadArquivo(any())).thenReturn(new byte[10]);

		valideStatusCodeEMensagemDeRetornoParaContentTypeJson(URI+"arquivos/download", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.POST);
	}
	
	
	@Test
	public void testeUploadArquivo() throws Exception {
		SharepointResponse resposta = new SharepointResponse();
		resposta.setCaminhoRelativoPasta("/cdc");
		resposta.setDataAlteracao("2021-12-27");
		resposta.setDataCriacao("2021-12-27");
		resposta.setIdentificador("1234");
		resposta.setNome("0.jpg");
		
		when(this.service.uploadArquivo(Mockito.any())).thenReturn(resposta);
		
		MockMultipartFile firstFile = new MockMultipartFile("file", "0.jpg", "image/jpeg", "0".getBytes());
		HttpHeaders headers = getHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
				
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart(URI+"arquivos").file(firstFile)
				.param("subsite-sharepoint", "direct_toolbox")
				.param("sobrescrever", "true")
				.param("path-diretorio","cdc")
				.headers(headers)
				.header("token-sharepoint", "token")).andReturn();
		
		var response = result.getResponse();
		Assert.assertEquals(200, response.getStatus());
		
		String expected = "{\"nome\":\"0.jpg\",\"caminho-relativo\":\"/cdc\",\"data-criacao\":\"2021-12-27\",\"data-alteracao\":\"2021-12-27\",\"identificador\":\"1234\"}";
		
		assertEquals(expected, response.getContentAsString());
	}
	
	@Test
	public void testeUploadArquivoComDadosInvalidos() throws Exception {
		SharepointResponse resposta = new SharepointResponse();
		resposta.setCaminhoRelativoPasta("/cdc");
		resposta.setDataAlteracao("2021-12-27");
		resposta.setDataCriacao("2021-12-27");
		resposta.setIdentificador("1234");
		resposta.setNome("0.jpg");
		
		when(this.service.uploadArquivo(Mockito.any())).thenReturn(resposta);
		
		MockMultipartFile firstFile = new MockMultipartFile("file", "0.jpg", "image/jpeg", "0".getBytes());
		HttpHeaders headers = getHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
				
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart(URI+"arquivos").file(firstFile)
				.param("subsite-sharepoint", "")
				.param("sobrescrever", "true")
				.param("path-diretorio","")
				.headers(headers)
				.header("token-sharepoint", "token")).andReturn();
		var response = result.getResponse();
		response.setCharacterEncoding("UTF-8");
		Assert.assertEquals(400, response.getStatus());
	}


	
	
	
	private String createRequestJson(Object c) {
		try {
			mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
			mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
			String request = mapper.writeValueAsString(c);
			return request;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

	private ItemSharePointRequestDTO criarItemRequest() {
		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO("corporativo","toolbox");
		return request;
	}


	private void valideStatusCodeEMensagemDeRetornoParaContentTypeJson(String url, String bodyRequest, HttpStatus expectedStatusCode,
			String expectedBody,HttpMethod method) throws Exception {
		HttpHeaders headers = getHeaders();
		MockHttpServletResponse response =null;
		if(method == HttpMethod.DELETE) {
			response = this.makeDeleteRequest(url, headers, bodyRequest);
		}
		else if (method == HttpMethod.POST){
			response = this.makePostRequest(url, headers, bodyRequest);
		}
		else if (method==HttpMethod.PUT) {
			response = this.makePutRequest(url, headers, bodyRequest);
		}
		response.setCharacterEncoding("UTF-8");
		Assert.assertEquals(expectedStatusCode.value(), response.getStatus());
		String retrieved = response.getContentAsString();
		if(StringUtils.isNotEmpty(retrieved) && StringUtils.isNotEmpty(expectedBody)) {
			JSONAssert.assertEquals(expectedBody, retrieved, false);
		}
		
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("token", "token");
		headers.add("token-sharepoint", "token");
		return headers;
	}

	private MockHttpServletResponse makePostRequest(String url, String body) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.add("token", "token");
		return makePostRequest(url, headers, body);
	}

	private MockHttpServletResponse makePostRequest(String url, HttpHeaders headers, String body) throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(headers).content(body);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		return result.getResponse();
	}
	
	private MockHttpServletResponse makePutRequest(String url, HttpHeaders headers, String body) throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(headers).content(body);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		return result.getResponse();
	}
	
	private MockHttpServletResponse makeDeleteRequest(String url, HttpHeaders headers, String body) throws Exception {
		headers.add("token", "token");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(url).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(headers).content(body);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		return result.getResponse();
	}
}
