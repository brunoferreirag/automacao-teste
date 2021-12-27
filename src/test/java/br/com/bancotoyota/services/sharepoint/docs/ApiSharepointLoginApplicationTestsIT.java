package br.com.bancotoyota.services.sharepoint.docs;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointUpdateRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUploadRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Author;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.CheckedOutByUser;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Deferred;
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
import br.com.bancotoyota.services.sharepoint.docs.service.ArquivosSharePointService;
import br.com.bancotoyota.services.sharepoint.docs.service.PastasSharePointService;
import br.com.bancotoyota.services.sharepoint.docs.util.TestDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiSharepointLoginApplicationTestsIT {
	@Autowired
	private PastasSharePointService servicePastas;

	@Autowired
	private ArquivosSharePointService serviceArquivos;

	private MockRestServiceServer mockServer;

	@Value("${sharepoint.url}")
	private String urlSharepointApi;

	@Autowired
	private ObjectMapper mapper;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void init() {
		mockServer = MockRestServiceServer.createServer(this.servicePastas.getRestTemplate());

		mapper.findAndRegisterModules();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	@Test
	public void deveApagarPasta() throws JsonProcessingException, URISyntaxException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web";
		String urlExclusaoPastas = "/pastas";
		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO();
		request.setPath("corporativo");
		request.setSubSiteSharepoint("direct-toolbox");

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.POST)).andRespond(
				withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString("")));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token-sharepoint", "token");
		HttpEntity<ItemSharePointRequestDTO> httpRequest = new HttpEntity<>(request, headers);

		var response = this.restTemplate.exchange(urlExclusaoPastas, HttpMethod.DELETE, httpRequest, Void.class);
		assertTrue(response.getStatusCode().value() == 204);
	}

	@Test
	public void deveApagarArquivo() throws JsonProcessingException, URISyntaxException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web";
		String urlExclusaoArquivos = "/arquivos";
		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO();
		request.setPath("corporativo/0.jpg");
		request.setSubSiteSharepoint("direct-toolbox");

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.POST)).andRespond(
				withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString("")));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token-sharepoint", "token");
		HttpEntity<ItemSharePointRequestDTO> httpRequest = new HttpEntity<>(request, headers);

		var response = this.restTemplate.exchange(urlExclusaoArquivos, HttpMethod.DELETE, httpRequest, Void.class);
		assertTrue(response.getStatusCode().value() == 204);
	}

	@Test
	public void deveFazerDownloadArquivo() throws JsonProcessingException, URISyntaxException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web";
		String urlDownloadArquivos = "/arquivos/download";
		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO();
		request.setPath("corporativo/0.jpg");
		request.setSubSiteSharepoint("direct-toolbox");

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.GET))
				.andRespond(withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(new byte[10]));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token-sharepoint", "token");
		HttpEntity<ItemSharePointRequestDTO> httpRequest = new HttpEntity<>(request, headers);

		var response = this.restTemplate.exchange(urlDownloadArquivos, HttpMethod.POST, httpRequest, String.class);
		assertTrue(response.getStatusCode().value() == 200);
	}

	@Test
	public void deveCriarPasta() throws JsonProcessingException, URISyntaxException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web";

		Deferred d = new Deferred();
		d.setUri("http://www.site.com.br");
		Result r = new Result();
		r.set__metadata(new Metadata());
		r.setAuthor(new Author());
		r.setCheckedOutByUser(new CheckedOutByUser());
		r.setCheckInComment(" ");
		r.setCheckOutType(0);
		r.setContentTag("");
		r.setExists(true);
		r.setFiles(new Files());
		List<Result> results = new ArrayList<>();
		results.add(r);

		String urlCriacaoPastas = "/pastas";
		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO();
		request.setPath("corporativo");
		request.setSubSiteSharepoint("direct-toolbox");

		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.getMetadataObject().setType(" ");
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

		sprb.getFilesObject().setResults(results);
		spr.setResponse(sprb);

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.POST)).andRespond(
				withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(spr)));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token-sharepoint", "token");
		HttpEntity<ItemSharePointRequestDTO> httpRequest = new HttpEntity<>(request, headers);

		var response = this.restTemplate.exchange(urlCriacaoPastas, HttpMethod.POST, httpRequest,
				SharepointResponse.class);
		assertTrue(response.getStatusCode().value() == 201);
	}

	@Test
	public void deveEditarPasta() throws JsonProcessingException, URISyntaxException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web/GetFolderByServerRelativeUrl";

		Deferred d = new Deferred();
		d.setUri("http://www.site.com.br");
		Result r = new Result();
		r.set__metadata(new Metadata());
		r.setAuthor(new Author());
		r.setCheckedOutByUser(new CheckedOutByUser());
		r.setCheckInComment(" ");
		r.setCheckOutType(0);
		r.setContentTag("");
		r.setExists(true);
		r.setFiles(new Files());
		List<Result> results = new ArrayList<>();
		results.add(r);

		String urlCriacaoPastas = "/pastas";
		ItemSharePointUpdateRequestDTO request = new ItemSharePointUpdateRequestDTO();
		request.setNovoPath("corporativo");
		request.setPathAtual("corporativo2");
		request.setSubSiteSharepoint("direct-toolbox");

		SharePointResponse spr = new SharePointResponse();
		SharePointResponseBody sprb = new SharePointResponseBody();
		sprb.setExists(true);
		sprb.setFilesObject(new Files());
		sprb.setFoldersObject(new Folders());
		sprb.setItemCount(1);
		sprb.setListItemAllFieldsObject(new ListItemAllFields());
		sprb.setMetadataObject(new Metadata());
		sprb.getMetadataObject().setType(" ");
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

		sprb.getFilesObject().setResults(results);
		spr.setResponse(sprb);

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.GET)).andRespond(
				withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(spr)));

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.POST))
				.andRespond(withStatus(HttpStatus.NO_CONTENT).contentType(MediaType.APPLICATION_JSON)
						.body(mapper.writeValueAsString("")));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token-sharepoint", "token");
		HttpEntity<ItemSharePointUpdateRequestDTO> httpRequest = new HttpEntity<>(request, headers);

		var response = this.restTemplate.exchange(urlCriacaoPastas, HttpMethod.PUT, httpRequest,
				SharepointResponse.class);
		assertTrue(response.getStatusCode().value() == 204);
	}

	@Test
	public void devePesquisarConteudo() throws JsonProcessingException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web/GetFolderByServerRelativeUrl";
		String urlBuscaPastas = "/pastas/busca";
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

		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.GET)).andRespond(
				withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(spr)));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token-sharepoint", "token");

		ItemSharePointRequestDTO request = new ItemSharePointRequestDTO();
		request.setPath("corporativo");
		request.setSubSiteSharepoint("direct-toolbox");

		HttpEntity<ItemSharePointRequestDTO> httpRequest = new HttpEntity<>(request, headers);

		var retorno = this.restTemplate.exchange(urlBuscaPastas, HttpMethod.POST, httpRequest,
				SharepointResponse.class);
		assertTrue(retorno.getStatusCode().value() == 200);
	}

	@Test
	public void deveFazerUploadArquivo() throws JsonProcessingException, URISyntaxException {
		String urlSharepoint = urlSharepointApi + "/direct-toolbox/_api/web";
		String urlUploadArquivos = "/arquivos";
		LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.add("file", new org.springframework.core.io.ClassPathResource("arquivo-vazio.txt"));
		parameters.add("subsite-sharepoint", "direct-toolbox");
		parameters.add("sobrescrever", true);
		parameters.add("path-diretorio", "cdc");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.set("token-sharepoint", "token");

	    HttpEntity<LinkedMultiValueMap<String, Object>> httpRequest = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);

		    
		mockServer.expect(requestContainsUri(urlSharepoint)).andExpect(method(HttpMethod.POST)).andRespond(
				withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(TestDataFactory.criarRespostaApiSharePoint())));

		var response = this.restTemplate.exchange(urlUploadArquivos, HttpMethod.POST, httpRequest, SharepointResponse.class);
		assertTrue(response.getStatusCode().value() == 200);
	}

	public RequestMatcher requestContainsUri(String uri) {
		return new RequestContainsUriMatcher(uri);
	}

}
