package br.com.bancotoyota.services.sharepoint.docs.service;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.input.CountingInputStream;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.bancotoyota.services.sharepoint.docs.common.Constants;
import br.com.bancotoyota.services.sharepoint.docs.exception.TamanhoArquivoMaiorQuePermitidoException;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUploadRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponseBody;
import br.com.bancotoyota.services.sharepoint.docs.util.GeradorStringErroChamadasHttp;
import br.com.bancotoyota.services.sharepoint.docs.util.StringUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArquivosSharePointService {

	@Getter
	private RestTemplate restTemplate;

	private GeradorStringErroChamadasHttp geradorStringHttp;

	private String tamanhoOndeUploadFicaFracionado;

	private String tamanhoMaximoArquivo;
	
	private GeradorUrlSharePointService geradorUrlSharePoint;
	
	private int tamanhoPedacoUpload;

	@Autowired
	public ArquivosSharePointService(GeradorUrlSharePointService geradorUrlSharePoint, RestTemplate restTemplate,
			GeradorStringErroChamadasHttp geradorStringHttp,
			@Value("${sharepoint.arquivo.tamanho-comeca-upload-fracionado-em-bytes}") String tamanhoOndeUploadFicaFracionado,
			@Value("${sharepoint.arquivo.tamanho-maximo}") String tamanhoMaximoArquivo,
			@Value("${sharepoint.arquivo.tamanho-pedaco-upload}") String tamanhoPedacoUploadArquivo) {
		this.geradorUrlSharePoint =geradorUrlSharePoint;
		this.restTemplate = restTemplate;
		this.geradorStringHttp = geradorStringHttp;
		this.tamanhoOndeUploadFicaFracionado = tamanhoOndeUploadFicaFracionado;
		this.tamanhoMaximoArquivo = tamanhoMaximoArquivo;
		this.tamanhoPedacoUpload = Integer.valueOf(tamanhoPedacoUploadArquivo);
	}

	public void excluirArquivo(ItemSharepointRequest dadosExclusao) {
		dadosExclusao.setPath(StringUtil.removeBarraNoPrimeiroCaractere(dadosExclusao.getPath()));
		String enderecoFinalAPi = geradorUrlSharePoint.getFileByRelativeUrl(dadosExclusao.getSubSiteSharepoint(), dadosExclusao.getPath());

		String tokenSharePoint = dadosExclusao.getTokenSharePoint();
		HttpHeaders headers = getHeaders(tokenSharePoint);
		headers.add("If-Match", "*");
		headers.add("X-HTTP-Method", "DELETE");
		HttpEntity request = new HttpEntity<>(headers);
		try {
			this.restTemplate.exchange(enderecoFinalAPi, HttpMethod.POST, request,
					new ParameterizedTypeReference<Void>() {
					});
		} catch (HttpServerErrorException | HttpClientErrorException ex) {
			String erroLog = this.geradorStringHttp.gerarString(
					"Erro ao realizar a chamada para excluir um arquivo. Url chamada:" + enderecoFinalAPi, "",
					ExceptionUtils.getStackTrace(ex), ExceptionUtils.getMessage(ex));
			log.error(erroLog);
			throw ex;
		}

	}

	private HttpHeaders getHeaders(String tokenSharePoint) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", Constants.TOKEN_TYPE + " " + tokenSharePoint);
		headers.add("Accept", "application/json;odata=verbose");
		headers.add("Content-Type", "application/json;odata=verbose");
		return headers;
	}

	public byte[] downloadArquivo(ItemSharepointRequest item) {

		item.setPath(StringUtil.removeBarraNoPrimeiroCaractere(item.getPath()));

		String enderecoFinalAPi =geradorUrlSharePoint.getFileByRelativeUrl(item.getSubSiteSharepoint(),item.getPath())+"/$value";
		
		HttpHeaders headers = getHeaders(item.getTokenSharePoint());

		HttpEntity request = new HttpEntity<>(headers);

		ResponseEntity<byte[]> response = this.restTemplate.exchange(enderecoFinalAPi, HttpMethod.GET, request,
				new ParameterizedTypeReference<byte[]>() {
				});
		return response.getBody();
	}

	public SharepointResponse uploadArquivo(ItemSharepointUploadRequest item) throws  IOException {
		item.getDadosBasicosRequest().setPath(StringUtil.removeBarraNoPrimeiroCaractere(item.getDadosBasicosRequest().getPath()));
		
		SharepointResponse pastaResponse = new SharepointResponse();
		ResponseEntity<SharePointResponse> responseSharePoint =null;
		
		// Limitação no upload da api
		if (item.getArquivo().getSize() > Integer.valueOf(this.tamanhoMaximoArquivo)) {
			throw new TamanhoArquivoMaiorQuePermitidoException(String.valueOf(item.getArquivo().getSize()),
					this.tamanhoMaximoArquivo);
		}
		HttpHeaders headers = this.getHeaders(item.getDadosBasicosRequest().getTokenSharePoint());
		// Não tem nenhuma regra de upload por que isso vai na configuração do gateway.

		if (item.getArquivo().getSize() >= Long.valueOf(this.tamanhoOndeUploadFicaFracionado)) {
			log.info("Começo do upload");
			CountingInputStream is = new CountingInputStream(item.getArquivo().getInputStream());
			byte[] myBuffer = new byte[this.tamanhoPedacoUpload];
			int bytesRead = 0;
			Boolean isFirstChunk = true;
			var uploadId = java.util.UUID.randomUUID();
			var offset = 0L;

			String enderecoAPiInicio = geradorUrlSharePoint.GetFolderByServerRelativeUrl(item.getDadosBasicosRequest().getSubSiteSharepoint(), item.getDadosBasicosRequest().getPath())
					+String.format("/Files/Add(url='%s',overwrite=%s)",item.getNomeArquivo(),item.getSobrescrever());

			HttpEntity requestVazio = new HttpEntity<>(myBuffer, headers);
			responseSharePoint= restTemplate.exchange(enderecoAPiInicio, HttpMethod.POST, requestVazio,
					new ParameterizedTypeReference<SharePointResponse>() {
					});

			while ((bytesRead = is.read(myBuffer, 0, this.tamanhoPedacoUpload)) != -1) {
				if (isFirstChunk) {
					log.info("Primeira parte");
					String enderecoFinalAPI = geradorUrlSharePoint.getFileByRelativeUrl(item.getDadosBasicosRequest().getSubSiteSharepoint(), item.getDadosBasicosRequest().getPath() + "/"+ item.getNomeArquivo())
							+String.format("/startupload(uploadId=guid'%s')",uploadId.toString());
		
					HttpEntity request = new HttpEntity<>(myBuffer, headers);
					responseSharePoint = this.restTemplate.exchange(enderecoFinalAPI,
							HttpMethod.POST, request, new ParameterizedTypeReference<SharePointResponse>() {
							});
					isFirstChunk = false;
				} else if (is.getByteCount() == item.getArquivo().getSize()) {
					String enderecoFinalAPI = geradorUrlSharePoint.getFileByRelativeUrl(item.getDadosBasicosRequest().getSubSiteSharepoint(), item.getDadosBasicosRequest().getPath()+ "/"+ item.getNomeArquivo())
							+String.format("/finishupload(uploadId=guid'%s',fileOffset=%s)",uploadId.toString(),offset);
					
					var finalBuffer = Arrays.copyOf(myBuffer, bytesRead);
					HttpEntity request = new HttpEntity<>(finalBuffer, headers);
					responseSharePoint = this.restTemplate.exchange(enderecoFinalAPI,
							HttpMethod.POST, request, new ParameterizedTypeReference<SharePointResponse>() {
							});
					log.info("Terminou o upload");

				} else {
					log.info("Continuando o upload");
					String enderecoFinalAPI = geradorUrlSharePoint.getFileByRelativeUrl(item.getDadosBasicosRequest().getSubSiteSharepoint(), item.getDadosBasicosRequest().getPath()+ "/"+ item.getNomeArquivo())
							+String.format("/continueupload(uploadId=guid'%s',fileOffset=%s)",uploadId.toString(),offset);

					HttpEntity request = new HttpEntity<>(myBuffer, headers);
					responseSharePoint = this.restTemplate.exchange(enderecoFinalAPI,
							HttpMethod.POST, request, new ParameterizedTypeReference<SharePointResponse>() {
							});
				}
				offset += bytesRead;
			}
		} else {
			
			String endereçoFinalAPi = geradorUrlSharePoint.GetFolderByServerRelativeUrl(item.getDadosBasicosRequest().getSubSiteSharepoint(), item.getDadosBasicosRequest().getPath())
					+String.format("/Files/Add(url='%s',overwrite=%s)",item.getArquivo().getOriginalFilename(),item.getSobrescrever());

			HttpEntity request = new HttpEntity<>(item.getArquivo().getBytes(), headers);
			responseSharePoint = this.restTemplate.exchange(endereçoFinalAPi,
					HttpMethod.POST, request, new ParameterizedTypeReference<SharePointResponse>() {
					});

		}
		
		var responseSharePointBody = responseSharePoint.getBody().getResponse();
		pastaResponse.setNome(responseSharePointBody.getName());
		pastaResponse.setCaminhoRelativoPasta(geradorUrlSharePoint.gerarURLPathTratado(responseSharePointBody.getServerRelativeUrl(),item.getDadosBasicosRequest().getSubSiteSharepoint()));
		pastaResponse.setDataCriacao(responseSharePointBody.getTimeCreated());
		pastaResponse.setDataAlteracao(responseSharePointBody.getTimeLastModified());
		pastaResponse.setIdentificador(responseSharePointBody.getUniqueId());

		return pastaResponse;
	}

}
