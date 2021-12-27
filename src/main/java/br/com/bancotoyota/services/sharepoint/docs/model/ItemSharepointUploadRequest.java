package br.com.bancotoyota.services.sharepoint.docs.model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemSharepointUploadRequest {
	private ItemSharepointRequest dadosBasicosRequest;
	private MultipartFile arquivo;
	private Boolean sobrescrever;
	private String nomeArquivo;
	
	public ItemSharepointUploadRequest() {
		this.dadosBasicosRequest = new ItemSharepointRequest();
		this.sobrescrever = false;
	}
}
