package br.com.bancotoyota.services.sharepoint.docs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SharepointResponse {
	@JsonProperty("nome")
	@ApiModelProperty(value="Nome do elemento no sharepoint")
	private String nome;
	@ApiModelProperty(value="Caminho relativo do elemento no Sharepoint")
	@JsonProperty("caminho-relativo")
	private String caminhoRelativoPasta;
	@ApiModelProperty(value="Data de criação do elemento no Sharepoint")	
	@JsonProperty("data-criacao")
	private String dataCriacao;
	@JsonProperty("data-alteracao")
	@ApiModelProperty(value="Data que o elemento sofreu alteração")	
	private String dataAlteracao;
	@JsonProperty("identificador")
	@ApiModelProperty(value="Identificador única do Elemento no Sharepoint")	
	private String identificador;
}
