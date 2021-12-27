package br.com.bancotoyota.services.sharepoint.docs.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.com.bancotoyota.services.sharepoint.docs.exception.TamanhoArquivoMaiorQuePermitidoException;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUploadRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.util.GeradorStringErroChamadasHttp;
import br.com.bancotoyota.services.sharepoint.docs.util.TestDataFactory;

@RunWith(SpringRunner.class)
public class ArquivosSharePointServiceTest {
	@Mock
	private RestTemplate restTemplate;

	private ArquivosSharePointService service;

	@Mock
	private GeradorStringErroChamadasHttp geradorStringHttp;

	@Mock
	private GeradorUrlSharePointService geradorUrlSharePoint;

	private long tamanhoMaximoArquivo = 26214400;
	
	private int tamanhoArquivoGrande=31457280;
	
	private int tamanhoPedacoUpload = 10485760;

	@Before
	public void init() {
		this.service = new ArquivosSharePointService(geradorUrlSharePoint, restTemplate, geradorStringHttp, String.valueOf(tamanhoMaximoArquivo),
				String.valueOf(tamanhoMaximoArquivo), String.valueOf(tamanhoPedacoUpload));

		when(geradorUrlSharePoint.getFileByRelativeUrl(anyString(), anyString())).thenReturn(
				"https://bancotoyota.sharepoint.com/sites/direct_toolbox/_api/web/GetFileByServerRelativeUrl('//sites/direct_toolbox/Documentos Compartilhados/corporativo/bones/0.jpg')");

		when(geradorUrlSharePoint.GetFolderByServerRelativeUrl(anyString(), anyString())).thenReturn(
				"https://bancotoyota.sharepoint.com/sites/direct_toolbox/_api/web/GetFolderByServerRelativeUrl('//sites/direct_toolbox/Documentos Compartilhados/teste3')");
	}

	@Test
	public void deveApagarArquivos() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<Void> response = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenReturn(response);

		this.service.excluirArquivo(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any());

	}

	@Test
	public void deveApagarArquivosComBarraNaFrente() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("/corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<Void> response = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenReturn(response);

		this.service.excluirArquivo(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any());
	}

	@Test(expected = HttpServerErrorException.class)
	public void deveGerarErroHttpServerExceptionApagarPasta() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("/corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<Void> response = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenThrow(HttpServerErrorException.class);

		this.service.excluirArquivo(dados);

	}

	@Test(expected = HttpServerErrorException.class)
	public void deveGerarErroHttpClientErrorExceptionApagarPasta() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("/corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<Void> response = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenThrow(HttpServerErrorException.class);

		this.service.excluirArquivo(dados);

	}

	@Test
	public void deveFazerDownloadArquivo() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo/cdc.mp3");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<byte[]> response = new ResponseEntity(HttpStatus.OK);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<byte[]>>any())).thenReturn(response);

		this.service.downloadArquivo(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<byte[]>>any());

	}

	@Test
	public void deveFazerDownloadArquivoComBarra() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("/corporativo/cdc.mp3");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<byte[]> response = new ResponseEntity(HttpStatus.OK);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<byte[]>>any())).thenReturn(response);

		this.service.downloadArquivo(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<byte[]>>any());

	}

	@Test
	public void deveFazerUploadArquivo() throws IOException {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo/cdc.mp3");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		MultipartFile arquivo = Mockito.mock(MultipartFile.class);

		var sharePointResponse = TestDataFactory.criarRespostaApiSharePoint();

		ResponseEntity<SharePointResponse> response = new ResponseEntity(sharePointResponse, HttpStatus.OK);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);

		ItemSharepointRequest requestSharePoint = new ItemSharepointRequest();
		requestSharePoint.setPath("/cdc");
		requestSharePoint.setSubSiteSharepoint("direct_toolbox");

		ItemSharepointUploadRequest item = new ItemSharepointUploadRequest();
		item.setNomeArquivo("0.jpg");
		item.setSobrescrever(true);
		item.setArquivo(arquivo);
		item.setDadosBasicosRequest(dados);

		this.service.uploadArquivo(item);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());

	}

	@Test
	public void deveFazerUploadComMaisDeUmaEtapa() throws IOException {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo/cdc.mp3");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");
		
		MultipartFile arquivo = Mockito.mock(MultipartFile.class);
		
		when(arquivo.getSize()).thenReturn(this.tamanhoMaximoArquivo);
		var s = "hello, world";
		var inputStream = new ByteArrayInputStream(s.getBytes());
		 
		when(arquivo.getInputStream()).thenReturn(inputStream);
		
		
		var sharePointResponse = TestDataFactory.criarRespostaApiSharePoint();
		
		ResponseEntity<SharePointResponse> response= new ResponseEntity(sharePointResponse,HttpStatus.OK);
	
	
		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(),Mockito.any(), ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);	
		
		ItemSharepointRequest requestSharePoint = new ItemSharepointRequest();
		requestSharePoint.setPath("/cdc");
		requestSharePoint.setSubSiteSharepoint("direct_toolbox");
		
		
		ItemSharepointUploadRequest item = new ItemSharepointUploadRequest();
		item.setNomeArquivo("0.jpg");
		item.setSobrescrever(true);
		item.setArquivo(arquivo);
		item.setDadosBasicosRequest(dados);
		
		this.service.uploadArquivo(item);
		
		verify(this.restTemplate,times(2)).exchange(Mockito.anyString(), Mockito.any(),Mockito.any(), ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());	

	}

	
	@Test(expected=TamanhoArquivoMaiorQuePermitidoException.class)
	public void deveFazerGerarErroUpload() throws IOException {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo/cdc.mp3");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");
		
		MultipartFile arquivo = Mockito.mock(MultipartFile.class);
		
		when(arquivo.getSize()).thenReturn(this.tamanhoMaximoArquivo+1);
		var s = "hello, world";
		var inputStream = new ByteArrayInputStream(s.getBytes());
		 
		when(arquivo.getInputStream()).thenReturn(inputStream);
		
		
		var sharePointResponse = TestDataFactory.criarRespostaApiSharePoint();
		
		ResponseEntity<SharePointResponse> response= new ResponseEntity(sharePointResponse,HttpStatus.OK);
	
	
		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(),Mockito.any(), ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);	
		
		ItemSharepointRequest requestSharePoint = new ItemSharepointRequest();
		requestSharePoint.setPath("/cdc");
		requestSharePoint.setSubSiteSharepoint("direct_toolbox");
		
		
		ItemSharepointUploadRequest item = new ItemSharepointUploadRequest();
		item.setNomeArquivo("0.jpg");
		item.setSobrescrever(true);
		item.setArquivo(arquivo);
		item.setDadosBasicosRequest(dados);
		
		this.service.uploadArquivo(item);
		
		verify(this.restTemplate,times(2)).exchange(Mockito.anyString(), Mockito.any(),Mockito.any(), ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());	

	}
	
	@Test
	public void deveFazerUploadComArquivoMaiorDe20Mega() throws IOException {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo/cdc.mp3");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");
		
		MultipartFile arquivo = Mockito.mock(MultipartFile.class);
		
		when(arquivo.getSize()).thenReturn(this.tamanhoMaximoArquivo);
		byte[] bytes = new byte[this.tamanhoArquivoGrande];
		Arrays.fill( bytes, (byte) 1);
		var inputStream = new ByteArrayInputStream(bytes);
		 
		when(arquivo.getInputStream()).thenReturn(inputStream);
		
		
		var sharePointResponse = TestDataFactory.criarRespostaApiSharePoint();
		
		ResponseEntity<SharePointResponse> response= new ResponseEntity(sharePointResponse,HttpStatus.OK);
	
	
		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(),Mockito.any(), ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);	
		
		ItemSharepointRequest requestSharePoint = new ItemSharepointRequest();
		requestSharePoint.setPath("/cdc");
		requestSharePoint.setSubSiteSharepoint("direct_toolbox");
		
		
		ItemSharepointUploadRequest item = new ItemSharepointUploadRequest();
		item.setNomeArquivo("0.jpg");
		item.setSobrescrever(true);
		item.setArquivo(arquivo);
		item.setDadosBasicosRequest(dados);
		
		this.service.uploadArquivo(item);
		
		verify(this.restTemplate,times(4)).exchange(Mockito.anyString(), Mockito.any(),Mockito.any(), ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());	

	}

}
