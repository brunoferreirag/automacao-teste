package br.com.bancotoyota.services.sharepoint.docs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointRequestBuscaDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharePointUpdateRequestDTO;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUpdateRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.service.PastasSharePointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
@Api(tags = "Pastas")
@CrossOrigin(origins = "*")
public class PastasSharePointController {
	private PastasSharePointService pastaService;

	@Autowired
	public PastasSharePointController(PastasSharePointService pastaService) {
		this.pastaService = pastaService;
	}

	@ApiOperation(value = "Exclusão de uma pasta no Sharepoint", notes = "Exclui uma pasta e deleta todo seu conteúdo", tags = {
			"Pastas" })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "OK") })
	@DeleteMapping(value = "/pastas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> excluirPasta(
			@RequestHeader(name = "token-sharepoint", required = true) String tokenSharepoint,
			@ApiParam(value = "Dados para exclusão da pasta", required = true) @Valid @RequestBody ItemSharePointRequestDTO request) {
		ItemSharepointRequest item = criarItemRequest(tokenSharepoint, request);
		this.pastaService.excluirPasta(item);
		return ResponseEntity.noContent().build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/pastas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Criação de pastas no documentos compartilhados no Sharepoint", notes = "Criação de pastas no documentos compartilhados no Sharepoint.Retorna informações do elemento criado", response = SharepointResponse.class, tags = {
			"Autenticacao" })
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "created", response = SharepointResponse.class, examples = @Example(@ExampleProperty(mediaType = "application/json", value = "{\r\n"
					+ "    \"nome\": \"teste\",\r\n" + "    \"caminho-relativo\": \"/teste\",\r\n"
					+ "    \"data-criacao\": \"2021-12-20T22:54:06Z\",\r\n"
					+ "    \"data-alteracao\": \"2021-12-20T22:54:06Z\",\r\n"
					+ "    \"identificador\": \"900a83a5-c00d-4ea4-a580-bcd06bee1de9\"\r\n" + "}"))) })
	public ResponseEntity<SharepointResponse> criarPasta(
			@RequestHeader(name = "token-sharepoint", required = true) String tokenSharepoint,
			@ApiParam(value = "Dados para inclusão da pasta", required = true) @Valid @RequestBody ItemSharePointRequestDTO request) {
		ItemSharepointRequest item = criarItemRequest(tokenSharepoint, request);
		return new ResponseEntity<SharepointResponse>(this.pastaService.criarPasta(item), HttpStatus.CREATED);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/pastas/busca", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Busca de conteúdos no Sharepoint", notes = "Busca de conteúdos no Sharepoint a partir da pasta de Documentos Compartilhados. Retorna o conteúdo das pastas buscadas", response = PastaBuscaSharePointResponse.class, tags = {
			"Autenticacao" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "ok", response = PastaBuscaSharePointResponse.class, examples = @Example(@ExampleProperty(mediaType = "application/json", value = "{\r\n"
					+ "    \"pastas\": [\r\n"
					+ "        {\r\n"
					+ "            \"nome\": \"Documentos Compartilhados\",\r\n"
					+ "            \"quantidade-subniveis\": 4.0,\r\n"
					+ "            \"caminho-relativo\": \"\",\r\n"
					+ "            \"data-criacao\": \"2021-11-07T02:31:51Z\",\r\n"
					+ "            \"ultima-modificacao\": \"2021-12-20T22:54:06Z\",\r\n"
					+ "            \"arquivos\": null,\r\n"
					+ "            \"pastas\": [\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"bones\",\r\n"
					+ "                    \"quantidade-subniveis\": 0.0,\r\n"
					+ "                    \"caminho-relativo\": \"/corporativo-old/bones\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-17\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-17\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"corporativo-old\",\r\n"
					+ "                    \"quantidade-subniveis\": 1.0,\r\n"
					+ "                    \"caminho-relativo\": \"/corporativo-old\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-17\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-17\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"Document\",\r\n"
					+ "                    \"quantidade-subniveis\": 0.0,\r\n"
					+ "                    \"caminho-relativo\": \"/Forms/Document\",\r\n"
					+ "                    \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"Forms\",\r\n"
					+ "                    \"quantidade-subniveis\": 0.0,\r\n"
					+ "                    \"caminho-relativo\": \"/Forms\",\r\n"
					+ "                    \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                    \"arquivos\": [\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"DispForm.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/DispForm.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"4250\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"Combine.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/Combine.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"2751\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"AllItems.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/AllItems.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"2751\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"Thumbnails.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/Thumbnails.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"2751\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"Upload.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/Upload.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"6076\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"repair.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/repair.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"3292\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"EditForm.aspx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/EditForm.aspx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"4250\"\r\n"
					+ "                        },\r\n"
					+ "                        {\r\n"
					+ "                            \"nome\": \"template.dotx\",\r\n"
					+ "                            \"caminho-relativo\": \"/Forms/template.dotx\",\r\n"
					+ "                            \"data-criacao\": \"2021-11-06\",\r\n"
					+ "                            \"ultima-modificacao\": \"2021-11-06\",\r\n"
					+ "                            \"tamanho-em-bytes\": \"11143\"\r\n"
					+ "                        }\r\n"
					+ "                    ],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"teste2\",\r\n"
					+ "                    \"quantidade-subniveis\": 0.0,\r\n"
					+ "                    \"caminho-relativo\": \"/teste2\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-20\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-20\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"teste1\",\r\n"
					+ "                    \"quantidade-subniveis\": 0.0,\r\n"
					+ "                    \"caminho-relativo\": \"/teste3/teste1\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-20\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-20\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"teste\",\r\n"
					+ "                    \"quantidade-subniveis\": 0.0,\r\n"
					+ "                    \"caminho-relativo\": \"/teste3/teste\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-20\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-20\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"teste3\",\r\n"
					+ "                    \"quantidade-subniveis\": 2.0,\r\n"
					+ "                    \"caminho-relativo\": \"/teste3\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-20\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-20\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"ciclo\",\r\n"
					+ "                    \"quantidade-subniveis\": 1.0,\r\n"
					+ "                    \"caminho-relativo\": \"/cdc/ciclo\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-13\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-21\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                },\r\n"
					+ "                {\r\n"
					+ "                    \"nome\": \"cdc\",\r\n"
					+ "                    \"quantidade-subniveis\": 1.0,\r\n"
					+ "                    \"caminho-relativo\": \"/cdc\",\r\n"
					+ "                    \"data-criacao\": \"2021-12-10\",\r\n"
					+ "                    \"ultima-modificacao\": \"2021-12-21\",\r\n"
					+ "                    \"arquivos\": [],\r\n"
					+ "                    \"pastas\": null\r\n"
					+ "                }\r\n"
					+ "            ]\r\n"
					+ "        }\r\n"
					+ "    ]\r\n"
					+ "}"))) })
	public ResponseEntity<PastaBuscaSharePointResponse> pesquisarPasta(
			@RequestHeader(name = "token-sharepoint", required = true) String tokenSharepoint,
			@ApiParam(value = "Dados para pesquisa do conteúdo", required = true) @Valid @RequestBody ItemSharePointRequestBuscaDTO request) {
		ItemSharepointRequest item = criarItemBuscaRequest(tokenSharepoint, request);
		return new ResponseEntity<PastaBuscaSharePointResponse>(this.pastaService.pesquisarConteudo(item), HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping(value = "/pastas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Editar o nome de uma pasta no documentos compartilhados do Sharepoint", notes = "Editar o nome de uma pasta no documentos compartilhados do Sharepoint", response = SharepointResponse.class, tags = {
			"Autenticacao" })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "OK") })
	public ResponseEntity<Void> AtualizarPasta(
			@RequestHeader(name = "token-sharepoint", required = true) String tokenSharepoint,
			@ApiParam(value = "Dados para inclusão da pasta", required = true) @Valid @RequestBody ItemSharePointUpdateRequestDTO request) {
		ItemSharepointUpdateRequest item = criarItemUpdateRequest(tokenSharepoint, request);
		this.pastaService.editarPasta(item);
		return ResponseEntity.noContent().build();
	}

	private ItemSharepointRequest criarItemRequest(String tokenSharepoint, ItemSharePointRequestDTO request) {
		ItemSharepointRequest item = new ItemSharepointRequest();
		item.setPath(request.getPath());
		item.setSubSiteSharepoint(request.getSubSiteSharepoint());
		item.setTokenSharePoint(tokenSharepoint);
		return item;
	}

	private ItemSharepointRequest criarItemBuscaRequest(String tokenSharepoint, ItemSharePointRequestBuscaDTO request) {
		ItemSharepointRequest item = new ItemSharepointRequest();
		item.setPath(request.getPath());
		item.setSubSiteSharepoint(request.getSubSiteSharepoint());
		item.setTokenSharePoint(tokenSharepoint);
		return item;
	}

	private ItemSharepointUpdateRequest criarItemUpdateRequest(String tokenSharepoint,
			ItemSharePointUpdateRequestDTO request) {
		ItemSharepointUpdateRequest item = new ItemSharepointUpdateRequest();
		item.setNovoPath(request.getNovoPath());
		item.setPathAtual(request.getPathAtual());
		item.setSubSiteSharepoint(request.getSubSiteSharepoint());
		item.setTokenSharePoint(tokenSharepoint);
		return item;
	}
}
