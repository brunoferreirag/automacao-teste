package br.com.bancotoyota.services.sharepoint.docs.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUpdateRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Files;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Folders;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.ListItemAllFields;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Metadata;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.ParentFolder;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Properties;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Result;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponseBody;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.StorageMetrics;
import br.com.bancotoyota.services.sharepoint.docs.util.GeradorStringErroChamadasHttp;
import br.com.bancotoyota.services.sharepoint.docs.util.TestDataFactory;

@RunWith(SpringRunner.class)
public class PastasSharePointServiceTest {
	@Mock
	private RestTemplate restTemplate;

	private PastasSharePointService service;

	@Mock
	private GeradorUrlSharePointService geradorUrlSharePoint;

	@Mock
	private GeradorStringErroChamadasHttp geradorStringHttp;

	@Before
	public void init() {
		this.service = new PastasSharePointService(geradorUrlSharePoint, restTemplate, geradorStringHttp, "");
		
		when(geradorUrlSharePoint.getUrlCriacaoPasta(Mockito.anyString())).thenReturn("https://bancotoyota.sharepoint.com/sites/direct_toolbox/_api/web/folders");

		when(geradorUrlSharePoint.GetFolderByServerRelativeUrl(anyString(), anyString())).thenReturn(
				"https://bancotoyota.sharepoint.com/sites/direct_toolbox/_api/web/GetFolderByServerRelativeUrl('//sites/direct_toolbox/Documentos Compartilhados/teste3')");
	}

	@Test
	public void deveApagarPasta() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<Void> response = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenReturn(response);

		this.service.excluirPasta(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any());

	}

	@Test
	public void deveApagarPastaComBarraNaFrente() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("/corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		ResponseEntity<Void> response = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenReturn(response);

		this.service.excluirPasta(dados);

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

		this.service.excluirPasta(dados);

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

		this.service.excluirPasta(dados);

	}

	@Test
	public void deveCriarPasta() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo");
		dados.setSubSiteSharepoint("direct-toolbox");
		dados.setTokenSharePoint(" ");

		SharePointResponse spr =TestDataFactory.criarRespostaApiSharePoint();
		ResponseEntity<SharePointResponse> response = new ResponseEntity(spr, HttpStatus.CREATED);
		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);

		this.service.criarPasta(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());

	}

	@Test
	public void deveEditarPasta() {
		ItemSharepointUpdateRequest dados = new ItemSharepointUpdateRequest();
		dados.setNovoPath("corporativo");
		dados.setPathAtual("corporativo2");
		dados.setTokenSharePoint("direct_toolbox");

		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.setName("corporativo");
		sprb.setParentFolderObject(new ParentFolder());
		sprb.setProgID("1");
		sprb.setPropertiesObject(new Properties());
		sprb.setServerRelativeUrl("");
		sprb.setStorageMetricsObject(new StorageMetrics());
		sprb.setTimeCreated(" ");
		sprb.setTimeLastModified(" ");
		sprb.setUniqueId(" ");
		sprb.setWelcomePage(" ");
		sprb.setWOPIEnabled(true);
		spr.setResponse(sprb);
		spr.setResponse(sprb);
		ResponseEntity<SharePointResponse> response = new ResponseEntity(spr, HttpStatus.OK);

		ResponseEntity<Void> responseUpdate = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenReturn(responseUpdate);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);

		this.service.editarPasta(dados);

		verify(this.restTemplate, times(2)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());

	}

	@Test
	public void deveEditarPastaComBarra() {
		ItemSharepointUpdateRequest dados = new ItemSharepointUpdateRequest();
		dados.setNovoPath("/corporativo");
		dados.setPathAtual("/corporativo2");
		dados.setTokenSharePoint("direct_toolbox");

		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.setName("corporativo");
		sprb.setParentFolderObject(new ParentFolder());
		sprb.setProgID("1");
		sprb.setPropertiesObject(new Properties());
		sprb.setServerRelativeUrl("");
		sprb.setStorageMetricsObject(new StorageMetrics());
		sprb.setTimeCreated(" ");
		sprb.setTimeLastModified(" ");
		sprb.setUniqueId(" ");
		sprb.setWelcomePage(" ");
		sprb.setWOPIEnabled(true);
		spr.setResponse(sprb);
		spr.setResponse(sprb);
		ResponseEntity<SharePointResponse> response = new ResponseEntity(spr, HttpStatus.OK);

		ResponseEntity<Void> responseUpdate = new ResponseEntity(HttpStatus.NO_CONTENT);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<Void>>any())).thenReturn(responseUpdate);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);

		this.service.editarPasta(dados);

		verify(this.restTemplate, times(2)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());

	}

	@Test
	public void devePesquisarConteudo() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo");
		dados.setTokenSharePoint("direct_toolbox");
		dados.setSubSiteSharepoint("direct_toolbox");

		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.setName("corporativo");
		sprb.setParentFolderObject(new ParentFolder());
		sprb.setProgID("1");
		sprb.setPropertiesObject(new Properties());
		sprb.setServerRelativeUrl("");
		sprb.setStorageMetricsObject(new StorageMetrics());
		sprb.setTimeCreated(" ");
		sprb.setTimeLastModified(" ");
		sprb.setUniqueId(" ");
		sprb.setWelcomePage(" ");
		sprb.setWOPIEnabled(true);
		spr.setResponse(sprb);
		spr.setResponse(sprb);
		ResponseEntity<SharePointResponse> response = new ResponseEntity(spr, HttpStatus.OK);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);

		this.service.pesquisarConteudo(dados);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());

	}

	@Test
	public void devePesquisarConteudoComSubNiveis() {
		ItemSharepointRequest dados = new ItemSharepointRequest();
		dados.setPath("corporativo");
		dados.setTokenSharePoint("direct_toolbox");
		dados.setSubSiteSharepoint("direct_toolbox");

		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.setName("corporativo");
		sprb.setParentFolderObject(new ParentFolder());
		sprb.setProgID("1");
		sprb.setPropertiesObject(new Properties());
		sprb.setServerRelativeUrl("");
		sprb.setStorageMetricsObject(new StorageMetrics());
		sprb.setTimeCreated(" ");
		sprb.setTimeLastModified(" ");
		sprb.setUniqueId(" ");
		sprb.setWelcomePage(" ");
		sprb.setWOPIEnabled(true);
		spr.setResponse(sprb);
		spr.setResponse(sprb);

		List<Result> resultsFiles = new ArrayList<>();
		Result resultFile = new Result();
		resultFile.setName("cdc.mp3");
		resultFile.setTimeLastModified(new Date());
		resultFile.setTimeCreated(new Date());
		resultFile.setServerRelativeUrl("/cdc");
		resultFile.setFolders(new Folders());
		resultFile.setFiles(new Files());
		resultFile.getFiles().setResults(new ArrayList<>());
		resultsFiles.add(resultFile);

		List<Result> resultsFolders = new ArrayList<>();
		Result resultFolder = new Result();
		resultFolder.setName("cdc");
		resultFolder.setTimeLastModified(new Date());
		resultFolder.setTimeCreated(new Date());
		resultFolder.setFolders(new Folders());
		resultFolder.setFiles(new Files());
		resultFolder.getFiles().setResults(new ArrayList<>());
		resultFolder.setServerRelativeUrl("/cdc");

		Result resultFolder2 = new Result();
		resultFolder2.setName("cdc2");
		resultFolder2.setTimeLastModified(new Date());
		resultFolder2.setServerRelativeUrl("/cdc");
		resultFolder2.setTimeCreated(new Date());
		resultFolder2.setFolders(new Folders());
		resultFolder2.setFiles(new Files());
		resultFolder2.getFiles().setResults(new ArrayList<>());

		Result resultSubFolder = new Result();
		resultSubFolder.setName("subnivel");
		resultSubFolder.setTimeLastModified(new Date());
		resultSubFolder.setServerRelativeUrl("/cdc");
		resultSubFolder.setFolders(new Folders());
		resultSubFolder.setFiles(new Files());
		resultSubFolder.setTimeCreated(new Date());
		resultSubFolder.getFiles().setResults(new ArrayList<>());

		resultFolder.setFolders(new Folders());

		resultsFolders.add(resultFolder);
		resultsFolders.add(resultFolder2);

		sprb.getFilesObject().setResults(resultsFiles);
		sprb.getFoldersObject().setResults(resultsFolders);
		ResponseEntity<SharePointResponse> response = new ResponseEntity(spr, HttpStatus.OK);

		when(restTemplate.exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any())).thenReturn(response);

		var retorno = this.service.pesquisarConteudo(dados);

		assertTrue(retorno.getResultados().get(0).getArquivos().size() == 1);
		assertTrue(retorno.getResultados().get(0).getPastas().size() == 2);

		verify(this.restTemplate, times(1)).exchange(Mockito.anyString(), Mockito.any(), Mockito.any(),
				ArgumentMatchers.<ParameterizedTypeReference<SharePointResponse>>any());

	}

}
