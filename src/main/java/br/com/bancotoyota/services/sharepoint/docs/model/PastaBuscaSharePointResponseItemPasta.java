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
public class PastaBuscaSharePointResponseItemPasta {
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("quantidade-subniveis")
	private float quantidade;
	@JsonProperty("caminho-relativo")
	private String caminhoRelativo;
	@JsonProperty("data-criacao")
	private String dataCriacao;
	@JsonProperty("ultima-modificacao")
	private String ultimaModificacao;
	@JsonProperty("arquivos")	
	private List<PastaBuscaSharePointResponseItemArquivo> arquivos;
	@JsonProperty("pastas")	
	private List<PastaBuscaSharePointResponseItemPasta> pastas;
}
