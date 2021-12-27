package br.com.bancotoyota.services.sharepoint.docs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PastaBuscaSharePointResponse {
	@JsonProperty("pastas")
	private List<PastaBuscaSharePointResponseItemPasta> resultados;
}
