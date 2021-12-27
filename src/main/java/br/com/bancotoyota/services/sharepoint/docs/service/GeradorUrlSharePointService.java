package br.com.bancotoyota.services.sharepoint.docs.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.bancotoyota.services.sharepoint.docs.common.Constants;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;

@Service
public class GeradorUrlSharePointService {
	private String urlSharePointService;
	public GeradorUrlSharePointService(@Value("${sharepoint.url}") String urlSharePoint) {
		this.urlSharePointService = urlSharePoint;
	}
	
	public String getFileByRelativeUrl(String subSiteSharePoint, String path) {
		return String.format(
				this.urlSharePointService + "/" + subSiteSharePoint
						+ "/_api/web/GetFileByServerRelativeUrl('//%s/Documentos Compartilhados/%s')",
				Constants.SITES + "/" + subSiteSharePoint, path);
	}
	
	public String GetFolderByServerRelativeUrl(String subSiteSharePoint, String path) {
		return  String.format(this.urlSharePointService + "/"
				+ subSiteSharePoint
				+ "/_api/web/GetFolderByServerRelativeUrl('//%s/Documentos Compartilhados/%s')",
				Constants.SITES + "/" + subSiteSharePoint, StringUtils.isEmpty(path) ? "" : "/" + path);
	}

	public String gerarURLPathTratado(String serverRelativeUrl, String subSiteSharepoint) {
		return serverRelativeUrl.replace(String.format("/%s/%s/Documentos Compartilhados", Constants.SITES, subSiteSharepoint),"").trim();
	}

	public String getUrlCriacaoPasta(String subSiteSharePoint) {
		return this.urlSharePointService + "/" + subSiteSharePoint + "/_api/web/folders";
	}
}
