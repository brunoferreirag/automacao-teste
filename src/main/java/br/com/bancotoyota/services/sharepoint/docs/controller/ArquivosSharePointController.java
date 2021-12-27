package br.com.bancotoyota.services.sharepoint.docs.controller;

import java.io.IOException;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointRequestDTO;

import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUploadRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.service.ArquivosSharePointService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
@Api(tags = "Arquivos")
@CrossOrigin(origins = "*")
@Validated
public class ArquivosSharePointController {
	private ArquivosSharePointService arquivosSharePointService;

	@Autowired
	public ArquivosSharePointController(ArquivosSharePointService arquivosSharePointService) {
		this.arquivosSharePointService = arquivosSharePointService;
	}

	@ApiOperation(value = "Exclusão de um arquivo no Sharepoint", notes = "Exclusão de um arquivo no Sharepoint", tags = {
			"Arquivos" })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "OK") })
	@DeleteMapping(value = "/arquivos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluirPasta(
			@RequestHeader(name = "token-sharepoint", required = true) String tokenSharepoint,
			@ApiParam(value = "Dados para exclusão do arquivo", required = true) @Valid @RequestBody ItemSharePointRequestDTO request) {
		ItemSharepointRequest item = criarItemRequest(tokenSharepoint, request);
		this.arquivosSharePointService.excluirArquivo(item);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Download de um arquivo no sharepoint", notes = "Download de um arquivo no Sharepoint.Retorna o binário do arquivo", tags = {
			"Arquivos" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@PostMapping(value = "/arquivos/download", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> downloadArquivo(
			@RequestHeader(name = "token-sharepoint", required = true) String tokenSharepoint,
			@ApiParam(value = "Dados para download do arquivo", required = true) @Valid @RequestBody ItemSharePointRequestDTO request) {
		ItemSharepointRequest item = criarItemRequest(tokenSharepoint, request);
		return ResponseEntity.ok(this.arquivosSharePointService.downloadArquivo(item));
	}

	@ApiOperation(value = "Envia um arquivo para o Sharepoint", notes = "Envia um arquivo para o Sharepoint.Retorna a resposta do sharepoint", response = SharepointResponse.class, tags = {
			"Arquivos" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", examples = @Example(@ExampleProperty(mediaType = "application/json", value = "{\r\n"
					+ "    \"nome\": \"teste\",\r\n" + "    \"caminho-relativo\": \"/teste\",\r\n"
					+ "    \"data-criacao\": \"2021-12-20T22:54:06Z\",\r\n"
					+ "    \"data-alteracao\": \"2021-12-20T22:54:06Z\",\r\n"
					+ "    \"identificador\": \"900a83a5-c00d-4ea4-a580-bcd06bee1de9\"\r\n" + "}"))) })
	@PostMapping(value = "/arquivos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SharepointResponse> enviarArquivo(
			@RequestHeader(name = "token-sharepoint", required = true)@NotEmpty(message="Token sharepoint é obrigatório") String tokenSharepoint,
			@RequestParam(name = "subsite-sharepoint", required = true)@NotEmpty(message="Subsite do sharepoint é obrigatório") String subSiteSharePoint,
			@RequestParam(name = "sobrescrever", required = true) Boolean sobreescrever,
			@RequestParam(name = "path-diretorio", required = true) @NotEmpty(message="O caminho do arquivo é obrigatório") String pathDiretorio,
			@ApiParam(value = "Arquivo a ser enviado", required = true) @Valid @RequestPart MultipartFile file)
			throws IOException {
		ItemSharepointUploadRequest item = new ItemSharepointUploadRequest();
		item.getDadosBasicosRequest().setPath(pathDiretorio);
		item.getDadosBasicosRequest().setSubSiteSharepoint(subSiteSharePoint);
		item.getDadosBasicosRequest().setTokenSharePoint(tokenSharepoint);
		item.setSobrescrever(sobreescrever);
		item.setNomeArquivo(file.getOriginalFilename());
		item.setArquivo(file);
		return ResponseEntity.ok(this.arquivosSharePointService.uploadArquivo(item));
	}

	private ItemSharepointRequest criarItemRequest(String tokenSharepoint, ItemSharePointRequestDTO request) {
		ItemSharepointRequest item = new ItemSharepointRequest();
		item.setPath(request.getPath());
		item.setSubSiteSharepoint(request.getSubSiteSharepoint());
		item.setTokenSharePoint(tokenSharepoint);
		return item;
	}

}
