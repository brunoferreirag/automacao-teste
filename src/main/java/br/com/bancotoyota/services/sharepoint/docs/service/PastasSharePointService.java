package br.com.bancotoyota.services.sharepoint.docs.service;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.AtualizarPastaRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.CriarPastaRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Metadata;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.Result;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.sharepoint.SharePointResponseBody;
import br.com.bancotoyota.services.sharepoint.docs.common.Constants;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.ItemSharepointUpdateRequest;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponse;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponseItemArquivo;
import br.com.bancotoyota.services.sharepoint.docs.model.PastaBuscaSharePointResponseItemPasta;
import br.com.bancotoyota.services.sharepoint.docs.model.SharepointResponse;
import br.com.bancotoyota.services.sharepoint.docs.util.GeradorStringErroChamadasHttp;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PastasSharePointService {
	@Getter
	private RestTemplate restTemplate;

	private GeradorStringErroChamadasHttp geradorStringHttp;

	private String expressaoConsultaConteudo;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private GeradorUrlSharePointService geradorUrlSharePoint;

	@Autowired
	public PastasSharePointService(GeradorUrlSharePointService geradorUrlSharePoint, RestTemplate restTemplate,
			GeradorStringErroChamadasHttp geradorStringHttp,
			@Value("${sharepoint.expressao-consulta-conteudo}") String expressaoConsultaConteudo) {
		this.geradorUrlSharePoint =geradorUrlSharePoint;
		this.restTemplate = restTemplate;
		this.geradorStringHttp = geradorStringHttp;
		this.expressaoConsultaConteudo = expressaoConsultaConteudo;
	}

	public void excluirPasta(ItemSharepointRequest dadosExclusao) {
		removeBarraPath(dadosExclusao);
		
		String enderecoFinalAPi = geradorUrlSharePoint.GetFolderByServerRelativeUrl(dadosExclusao.getSubSiteSharepoint(), dadosExclusao.getPath());

		String tokenSharePoint = dadosExclusao.getTokenSharePoint();
		HttpHeaders headers = getHeaders(tokenSharePoint);
		headers.add("X-HTTP-Method", "DELETE");
		HttpEntity request = new HttpEntity<>(headers);
		try {
			this.restTemplate.exchange(enderecoFinalAPi, HttpMethod.POST, request,
					new ParameterizedTypeReference<Void>() {
					});
		} catch (HttpServerErrorException | HttpClientErrorException ex) {
			String erroLog = this.geradorStringHttp.gerarString(
					"Erro ao realizar a chamada para excluir uma pasta. Url chamada:" + enderecoFinalAPi, "",
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

	private void removeBarraPath(ItemSharepointRequest dadosExclusao) {
		if (dadosExclusao.getPath().startsWith(Constants.BARRA)) {
			dadosExclusao.setPath(dadosExclusao.getPath().replace(Constants.BARRA, "").trim());
		}
	}

	public SharepointResponse criarPasta(ItemSharepointRequest requestItem) {
		removeBarraPath(requestItem);
		String enderecoFinalAPi = this.geradorUrlSharePoint.getUrlCriacaoPasta(requestItem.getSubSiteSharepoint());
		String relativeUrl = "/sites/" + requestItem.getSubSiteSharepoint() + "/Documentos Compartilhados";
		Metadata metadada = new Metadata();
		metadada.setType("SP.Folder");
		CriarPastaRequest criarPastaRequest = new CriarPastaRequest();
		criarPastaRequest.setServerRelativeUrl(relativeUrl + "/" + requestItem.getPath());
		criarPastaRequest.setMetadada(metadada);

		HttpHeaders headers = getHeaders(requestItem.getTokenSharePoint());
		HttpEntity request = new HttpEntity<>(criarPastaRequest, headers);

		ResponseEntity<SharePointResponse> response = null;
		try {
			response = this.restTemplate.exchange(enderecoFinalAPi, HttpMethod.POST, request,
					new ParameterizedTypeReference<SharePointResponse>() {
					});
		} catch (HttpServerErrorException | HttpClientErrorException ex) {
			String erroLog = this.geradorStringHttp.gerarString(
					"Erro ao realizar a chamada para excluir uma pasta. Url chamada:" + enderecoFinalAPi, "",
					ExceptionUtils.getStackTrace(ex), ExceptionUtils.getMessage(ex));
			log.error(erroLog);
			throw ex;
		}

		SharePointResponse sharepointResponse = response.getBody();

		SharePointResponseBody body = sharepointResponse.getResponse();

		SharepointResponse pastaResponse = new SharepointResponse();

		pastaResponse.setNome(body.getName());
		pastaResponse.setCaminhoRelativoPasta(body.getServerRelativeUrl().replace(relativeUrl, "").trim());
		pastaResponse.setDataCriacao(body.getTimeCreated());
		pastaResponse.setDataAlteracao(body.getTimeLastModified());
		pastaResponse.setIdentificador(body.getUniqueId());
		return pastaResponse;
	}

	public void editarPasta(ItemSharepointUpdateRequest item) {
		removerBarraEditarPasta(item);
		String enderecoFinalAPi = geradorUrlSharePoint.GetFolderByServerRelativeUrl(item.getSubSiteSharepoint(), item.getPathAtual())+"//ListItemAllFields";
		HttpHeaders headers = getHeaders(item.getTokenSharePoint());
		HttpEntity request = new HttpEntity<>(headers);

		ResponseEntity<SharePointResponse> response = this.restTemplate.exchange(enderecoFinalAPi, HttpMethod.GET,
				request, new ParameterizedTypeReference<SharePointResponse>() {
				});

		headers.add("If-Match", "*");
		headers.add("X-HTTP-Method", "MERGE");

		Metadata metadata = new Metadata();
		metadata.setType(response.getBody().getResponse().getMetadataObject().getType());
		AtualizarPastaRequest requestAtualizar = new AtualizarPastaRequest();
		requestAtualizar.setTitle(item.getNovoPath());
		requestAtualizar.setFileLeagRef(item.getNovoPath());
		requestAtualizar.setMetadada(metadata);
		HttpEntity requestAtualizarPasta = new HttpEntity<>(requestAtualizar, headers);

		this.restTemplate.exchange(enderecoFinalAPi, HttpMethod.POST, requestAtualizarPasta,
				new ParameterizedTypeReference<Void>() {
				});
	}

	private void removerBarraEditarPasta(ItemSharepointUpdateRequest item) {
		if (item.getPathAtual().startsWith(Constants.BARRA)) {
			item.setPathAtual(item.getPathAtual().replace(Constants.BARRA, "").trim());
		}

		if (item.getNovoPath().startsWith(Constants.BARRA)) {
			item.setNovoPath(item.getNovoPath().replace(Constants.BARRA, "").trim());
		}
	}

	private String removeCaminhoDocumentosCompartilhados(String caminho, String subSiteSharepoint) {
		return caminho.replace(String.format("/sites/%s/Documentos Compartilhados", subSiteSharepoint), "");
	}

	public PastaBuscaSharePointResponse pesquisarConteudo(ItemSharepointRequest item) {
		removeBarraPath(item);
		String enderecoFinalAPI=String.format(geradorUrlSharePoint.GetFolderByServerRelativeUrl(item.getSubSiteSharepoint(), item.getPath())+"?$expand=%s",this.expressaoConsultaConteudo);

		HttpHeaders headers = getHeaders(item.getTokenSharePoint());
		HttpEntity request = new HttpEntity<>(headers);

		ResponseEntity<SharePointResponse> response = null;
		try {
			response = this.restTemplate.exchange(enderecoFinalAPI, HttpMethod.GET, request,
					new ParameterizedTypeReference<SharePointResponse>() {
					});
		} catch (HttpServerErrorException | HttpClientErrorException ex) {
			String erroLog = this.geradorStringHttp.gerarString(
					"Erro ao realizar a chamada para excluir uma pasta. Url chamada:" + enderecoFinalAPI, "",
					ExceptionUtils.getStackTrace(ex), ExceptionUtils.getMessage(ex));
			log.error(erroLog);
			throw ex;
		}

		PastaBuscaSharePointResponse resultados = new PastaBuscaSharePointResponse();
		SharePointResponseBody body = response.getBody().getResponse();
		List<PastaBuscaSharePointResponseItemPasta> items = new ArrayList<PastaBuscaSharePointResponseItemPasta>();
		PastaBuscaSharePointResponseItemPasta pastaRaiz = preencherPastaRaiz(body, item.getSubSiteSharepoint());

		if (!CollectionUtils.isEmpty(body.getFoldersObject().getResults())) {
			List<Result> folders = body.getFoldersObject().getResults();
			List<PastaBuscaSharePointResponseItemPasta> pastas = new ArrayList<>();
			lerPastasEArquivosRecursivamente(folders, pastas, item.getSubSiteSharepoint());
			pastaRaiz.setPastas(pastas);
		}

		items.add(pastaRaiz);
		resultados.setResultados(items);

		return resultados;

	}

	private PastaBuscaSharePointResponseItemPasta preencherPastaRaiz(SharePointResponseBody body,
			String subSiteSharePoint) {
		PastaBuscaSharePointResponseItemPasta pastaRaiz = new PastaBuscaSharePointResponseItemPasta();
		pastaRaiz.setCaminhoRelativo(
				this.removeCaminhoDocumentosCompartilhados(body.getServerRelativeUrl(), subSiteSharePoint));
		pastaRaiz.setDataCriacao(body.getTimeCreated());
		pastaRaiz.setNome(body.getName());
		pastaRaiz.setQuantidade(body.getItemCount());
		pastaRaiz.setUltimaModificacao(body.getTimeLastModified());
		if (!CollectionUtils.isEmpty(body.getFilesObject().getResults())) {
			List<PastaBuscaSharePointResponseItemArquivo> arquivos = new ArrayList<>();
			for (Result resultado : body.getFilesObject().getResults()) {
				PastaBuscaSharePointResponseItemArquivo arquivo = new PastaBuscaSharePointResponseItemArquivo();
				arquivo.setCaminhoRelativo(this.removeCaminhoDocumentosCompartilhados(resultado.getServerRelativeUrl(),
						subSiteSharePoint));
				arquivo.setDataCriacao(
						resultado.getTimeCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				arquivo.setNome(resultado.getName());
				arquivo.setUltimaModificacao(
						resultado.getTimeLastModified().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				arquivo.setTamanho(resultado.getLength());
				arquivos.add(arquivo);
			}
			pastaRaiz.setArquivos(arquivos);
		}
		return pastaRaiz;
	}

	private void lerPastasEArquivosRecursivamente(List<Result> folders,
			List<PastaBuscaSharePointResponseItemPasta> pastas, String subSiteSharePoint) {
		for (Result resultado : folders) {
			PastaBuscaSharePointResponseItemPasta pasta = new PastaBuscaSharePointResponseItemPasta();
			pasta.setCaminhoRelativo(
					this.removeCaminhoDocumentosCompartilhados(resultado.getServerRelativeUrl(), subSiteSharePoint));
			pasta.setDataCriacao(sdf.format(resultado.getTimeCreated()));
			pasta.setNome(resultado.getName());
			pasta.setQuantidade(resultado.getItemCount());
			pasta.setUltimaModificacao(sdf.format(resultado.getTimeLastModified()));
			List<PastaBuscaSharePointResponseItemArquivo> arquivos = new ArrayList<>();
			for (Result resultadoArquivo : resultado.getFiles().getResults()) {
				PastaBuscaSharePointResponseItemArquivo arquivo = new PastaBuscaSharePointResponseItemArquivo();
				arquivo.setCaminhoRelativo(this.removeCaminhoDocumentosCompartilhados(
						resultadoArquivo.getServerRelativeUrl(), subSiteSharePoint));
				arquivo.setDataCriacao(
						resultadoArquivo.getTimeCreated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				arquivo.setNome(resultadoArquivo.getName());
				arquivo.setUltimaModificacao(resultadoArquivo.getTimeLastModified().toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate());
				arquivo.setTamanho(resultadoArquivo.getLength());
				arquivos.add(arquivo);
			}
			if (!CollectionUtils.isEmpty(resultado.getFolders().getResults())) {
				this.lerPastasEArquivosRecursivamente(resultado.getFolders().getResults(), pastas, subSiteSharePoint);
			}
			pasta.setArquivos(arquivos);
			pastas.add(pasta);
		}
	}
}
