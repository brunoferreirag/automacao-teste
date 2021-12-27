package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarPastaRequest {
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("FileLeafRef")
	private String fileLeagRef;
	
	@JsonProperty("__metadata")
	private Metadata metadada;
}
