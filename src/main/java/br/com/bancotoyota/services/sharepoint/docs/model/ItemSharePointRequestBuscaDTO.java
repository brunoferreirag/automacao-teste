package br.com.bancotoyota.services.sharepoint.docs.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemSharePointRequestBuscaDTO {
	@JsonProperty(value = "path")
	@ApiModelProperty(value="Path em que se deseja efetuar a busca. Se não informado equivale a buscar na raiz da pasta documentos compartilhados.Ex:Para uma pasta cdc , passaríamos a string cdc")
	private String path;

	@NotNull(message = "Subsite do sharepoint é obrigatório")
	@NotEmpty(message = "Subsite do sharepoint é obrigatório")
	@JsonProperty(value = "subsite-sharepoint")
	@ApiModelProperty(value="Subsite do sharepoint.Ex: direct_toobox")
	private String subSiteSharepoint;

}
