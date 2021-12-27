package br.com.bancotoyota.services.sharepoint.docs.controller;


import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointUpdateRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponseItemArquivo;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponseItemPasta;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.service.PastasSharePointService;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;


@RunWith(SpringRunner.class)
@WebMvcTest({ PastasSharePointController.class, PastasSharePointService.class, ExceptionHandlerController.class })
public class PastasSharePointControllerTest {

	@MockBean
	private PastasSharePointService service;

	@Autowired
	private MockMvc mockMvc;

	private final String URI = "/";
	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testeRetornoOK() throws Exception {
		String request = this.createRequestJson(this.criarItemRequest());

		String expected = "";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.NO_CONTENT, expected, HttpMethod.DELETE);
	}
	
	@Test
	public void testeRetornoComDadoInvalido() throws Exception {
		String request = this.createRequestJson("");

		String expected = "";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.DELETE);
	}
	
	@Test
	public void testeRequestDadosEmBranco() throws Exception {
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("");
		requestExclusao.setSubSiteSharepoint("");
		String request = this.createRequestJson(requestExclusao);

		String expected = "";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.DELETE);
	}
	
	@Test
	public void testeCriacaoPastaOK() throws Exception {
		SharepointResponse response = new SharepointResponse();
		response.setCaminhoRelativoPasta("/teste/pasta1");
		response.setDataAlteracao("");
		response.setDataCriacao(" ");
		response.setIdentificador(" ");
		response.setNome("pasta1");
		
		when(service.criarPasta(Mockito.any())).thenReturn(response);
		
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("teste");
		requestExclusao.setSubSiteSharepoint("corporativo");
		
		String request = this.createRequestJson(requestExclusao);

		String expected = "{\"nome\":\"pasta1\",\"caminho-relativo\":\"/teste/pasta1\",\"data-criacao\":\" \",\"data-alteracao\":\"\",\"identificador\":\" \"}";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.CREATED, expected, HttpMethod.POST);
	}
	
	@Test
	public void testeEdicaoPastasOK() throws Exception {
		
		var requestEdicao = this.criarItemUpdateRequest();
		requestEdicao.setNovoPath("teste");
		requestEdicao.setPathAtual("teste2");
		requestEdicao.setSubSiteSharepoint("corporativo");
		
		String request = this.createRequestJson(requestEdicao);

		String expected = "";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.NO_CONTENT, expected, HttpMethod.PUT);
	}
	
	@Test
	public void testeEdicaoComDadosVazios() throws Exception {
		
		var requestEdicao = this.criarItemUpdateRequest();
		requestEdicao.setNovoPath("");
		requestEdicao.setPathAtual("");
		requestEdicao.setSubSiteSharepoint("");
		
		String request = this.createRequestJson(requestEdicao);

		String expected = "[{\"field\":\"subsite-sharepoint\",\"value\":\"\",\"message\":\"Subsite do sharepoint é obrigatório\"},{\"field\":\"path-atual\",\"value\":\"\",\"message\":\"Path Atual da pasta é obrigatório\"},{\"field\":\"novo-path\",\"value\":\"\",\"message\":\"Novo Path  da pasta é obrigatório\"}]";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.PUT);
	}
	
	@Test
	public void testeEdicaoComDadosNulos() throws Exception {
		
		var requestEdicao = this.criarItemUpdateRequest();
		requestEdicao.setNovoPath(null);
		requestEdicao.setPathAtual(null);
		requestEdicao.setSubSiteSharepoint(null);
		
		String request = this.createRequestJson(requestEdicao);

		String expected = "[{\"field\":\"path-atual\",\"value\":\"null\",\"message\":\"Path Atual da pasta é obrigatório\"},{\"field\":\"novo-path\",\"value\":\"null\",\"message\":\"Novo Path  da pasta é obrigatório\"},{\"field\":\"subsite-sharepoint\",\"value\":\"null\",\"message\":\"Subsite do sharepoint é obrigatório\"}]";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.PUT);
	}
	
	@Test
	public void testeCriacaoComDadosEmBranco() throws Exception {
		SharepointResponse response = new SharepointResponse();
		response.setCaminhoRelativoPasta("/teste/pasta1");
		response.setDataAlteracao("");
		response.setDataCriacao(" ");
		response.setIdentificador(" ");
		response.setNome("pasta1");
		
		when(service.criarPasta(Mockito.any())).thenReturn(response);
		
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("");
		requestExclusao.setSubSiteSharepoint("");
		
		String request = this.createRequestJson(requestExclusao);

		String expected = "[{\"field\":\"path\",\"value\":\"\",\"message\":\"Path da pasta ou arquivo é obrigatório\"},{\"field\":\"subsite-sharepoint\",\"value\":\"\",\"message\":\"Subsite do sharepoint é obrigatório\"}]";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.POST);
	}
	
	@Test
	public void testeServerErrorException() throws Exception {
		
		HttpServerErrorException err = new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro Client Error Exception");
		
		SharepointResponse response = new SharepointResponse();
		response.setCaminhoRelativoPasta("/teste/pasta1");
		response.setDataAlteracao("");
		response.setDataCriacao(" ");
		response.setIdentificador(" ");
		response.setNome("pasta1");
		
		when(service.criarPasta(Mockito.any())).thenThrow(err);
		
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("teste");
		requestExclusao.setSubSiteSharepoint("corporativo");
		
		String request = this.createRequestJson(requestExclusao);

		String expected = "{\"message\":\"HTTP response body: HTTP detail message:500 Erro Client Error Exception \"}\r\n"
				+ "";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.INTERNAL_SERVER_ERROR, expected, HttpMethod.POST);
	}
	
	@Test
	public void testeClientErrorException() throws Exception {
		
		HttpClientErrorException err = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Erro Client Error Exception");
		
		SharepointResponse response = new SharepointResponse();
		response.setCaminhoRelativoPasta("/teste/pasta1");
		response.setDataAlteracao("");
		response.setDataCriacao(" ");
		response.setIdentificador(" ");
		response.setNome("pasta1");
		
		when(service.criarPasta(Mockito.any())).thenThrow(err);
		
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("teste");
		requestExclusao.setSubSiteSharepoint("corporativo");
		
		String request = this.createRequestJson(requestExclusao);

		String expected = "{\"message\":\"HTTP response body: HTTP detail message:400 Erro Client Error Exception \"}";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.POST);
	}
	
	@Test
	public void  testeServerErrorRuntimeException() throws Exception {
		RuntimeException err = new RuntimeException("Erro runtime exception");

		SharepointResponse response = new SharepointResponse();
		response.setCaminhoRelativoPasta("/teste/pasta1");
		response.setDataAlteracao("");
		response.setDataCriacao(" ");
		response.setIdentificador(" ");
		response.setNome("pasta1");
		
		when(service.criarPasta(Mockito.any())).thenThrow(err);
		
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("teste");
		requestExclusao.setSubSiteSharepoint("corporativo");
		
		String request = this.createRequestJson(requestExclusao);

		String expected = "[{\"message\":\"Erro runtime exception\"}]";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.INTERNAL_SERVER_ERROR, expected, HttpMethod.POST);
	}
	
	@Test
	public void  testeResourceAccessException() throws Exception {
		ResourceAccessException err = new ResourceAccessException("Erro timeout");

		SharepointResponse response = new SharepointResponse();
		response.setCaminhoRelativoPasta("/teste/pasta1");
		response.setDataAlteracao("");
		response.setDataCriacao(" ");
		response.setIdentificador(" ");
		response.setNome("pasta1");
		
		when(service.criarPasta(Mockito.any())).thenThrow(err);
		
		var requestExclusao = this.criarItemRequest();
		requestExclusao.setPath("teste");
		requestExclusao.setSubSiteSharepoint("corporativo");
		
		String request = this.createRequestJson(requestExclusao);

		String expected = "{\"message\":\"Serviço Indisponível: Timeout\"}";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas", request, HttpStatus.GATEWAY_TIMEOUT, expected, HttpMethod.POST);
	}
	
	@Test
	public void testeHttpMessageNotReadableException() throws Exception {
		String expected = "[{\"message\":\"Impossível ler o Json de entrada\"}]";
		String request = "mocked request";
		valideStatusCodeEMensagemDeRetorno(URI +"pastas", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.POST);
	}
	
	@Test
	public void testePesquisandoConteudoOK() throws Exception {
		PastaBuscaSharePointResponse pastaBuscaSharePointResponse = new PastaBuscaSharePointResponse();
		
		List<PastaBuscaSharePointResponseItemPasta> items = new ArrayList<>(); 
		PastaBuscaSharePointResponseItemPasta pasta = new PastaBuscaSharePointResponseItemPasta();
		pasta.setCaminhoRelativo("/cdc");
		pasta.setDataCriacao("2021-12-21");
		pasta.setNome("cdc");
		pasta.setPastas(new ArrayList<>());
		
		PastaBuscaSharePointResponseItemArquivo arquivo = new PastaBuscaSharePointResponseItemArquivo();
		arquivo.setCaminhoRelativo("formalizacao.mp3");
		arquivo.setDataCriacao(LocalDate.of(2021, 12, 21));
		arquivo.setNome("formalizacao.mp3");
		arquivo.setTamanho("100000");
		arquivo.setUltimaModificacao(LocalDate.of(2021, 12, 21));
		
		List<PastaBuscaSharePointResponseItemArquivo> arquivos = new ArrayList<>();
		arquivos.add(arquivo);
		
		pasta.setArquivos(arquivos);
		items.add(pasta);
		pastaBuscaSharePointResponse.setResultados(items);
		
		when(service.pesquisarConteudo(Mockito.any())).thenReturn(pastaBuscaSharePointResponse);
		
		var requestBusca = this.criarItemRequest();
		
		String request = this.createRequestJson(requestBusca);

		String expected = "{\"pastas\":[{\"nome\":\"cdc\",\"quantidade-subniveis\":0.0,\"caminho-relativo\":\"/cdc\",\"data-criacao\":\"2021-12-21\",\"ultima-modificacao\":null,\"arquivos\":[{\"nome\":\"formalizacao.mp3\",\"caminho-relativo\":\"formalizacao.mp3\",\"data-criacao\":\"2021-12-21\",\"ultima-modificacao\":\"2021-12-21\",\"tamanho-em-bytes\":\"100000\"}],\"pastas\":[]}]}";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas/busca", request, HttpStatus.OK, expected, HttpMethod.POST);
	}
	
	
	@Test
	public void testePesquisandoConteudoSemInformacaoObrigatoriaPreenchidaOK() throws Exception {
		PastaBuscaSharePointResponse pastaBuscaSharePointResponse = new PastaBuscaSharePointResponse();
		
		List<PastaBuscaSharePointResponseItemPasta> items = new ArrayList<>(); 
		PastaBuscaSharePointResponseItemPasta pasta = new PastaBuscaSharePointResponseItemPasta();
		pasta.setCaminhoRelativo("/cdc");
		pasta.setDataCriacao("2021-12-21");
		pasta.setNome("cdc");
		pasta.setPastas(new ArrayList<>());
		
		PastaBuscaSharePointResponseItemArquivo arquivo = new PastaBuscaSharePointResponseItemArquivo();
		arquivo.setCaminhoRelativo("formalizacao.mp3");
		arquivo.setDataCriacao(LocalDate.of(2021, 12, 21));
		arquivo.setNome("formalizacao.mp3");
		arquivo.setTamanho("100000");
		arquivo.setUltimaModificacao(LocalDate.of(2021, 12, 21));
		
		List<PastaBuscaSharePointResponseItemArquivo> arquivos = new ArrayList<>();
		arquivos.add(arquivo);
		
		pasta.setArquivos(arquivos);
		items.add(pasta);
		pastaBuscaSharePointResponse.setResultados(items);
		
		when(service.pesquisarConteudo(Mockito.any())).thenReturn(pastaBuscaSharePointResponse);
		
		var requestBusca = this.criarItemRequest();
		requestBusca.setSubSiteSharepoint("");
		
		String request = this.createRequestJson(requestBusca);

		String expected = "[{\"field\":\"subsite-sharepoint\",\"value\":\"\",\"message\":\"Subsite do sharepoint é obrigatório\"}]";

		valideStatusCodeEMensagemDeRetorno(URI+"pastas/busca", request, HttpStatus.BAD_REQUEST, expected, HttpMethod.POST);
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

	private String criarItemRequestString() {
		return createRequestJson(criarItemRequest());
	}

	private ItemSharePointRequestDTO criarItemRequest() {
		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO("corporativo","toolbox");
		return request;
	}
	
	private ItemSharePointUpdateRequestDTO criarItemUpdateRequest() {
		ItemSharePointUpdateRequestDTO request = new ItemSharePointUpdateRequestDTO("corporativo","corporativo2","toolbox");
		return request;
	}

	private void valideStatusCodeEMensagemDeRetorno(String url, String bodyRequest, HttpStatus expectedStatusCode,
			String expectedBody,HttpMethod method) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.add("token", "token");
		headers.add("token-sharepoint", "token");
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
