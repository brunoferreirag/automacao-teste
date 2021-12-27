package br.com.bancotoyota.services.sharepoint.docs.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PastaBuscaSharePointResponseItemArquivo {
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("caminho-relativo")
	private String caminhoRelativo;
	@JsonProperty("data-criacao")
	private LocalDate dataCriacao;
	@JsonProperty("ultima-modificacao")
	private LocalDate ultimaModificacao;
	@JsonProperty("tamanho-em-bytes")
	private String tamanho;
}
