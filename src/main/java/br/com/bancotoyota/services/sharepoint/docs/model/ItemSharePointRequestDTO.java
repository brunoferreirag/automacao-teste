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
@AllArgsConstructor
@NoArgsConstructor
public class ItemSharePointRequestDTO {
	@NotNull(message = "Path da pasta ou arquivo é obrigatório")
	@NotEmpty(message = "Path da pasta ou arquivo é obrigatório")
	@JsonProperty(value = "path")
	@ApiModelProperty(value="Path do arquivo ou pasta. Se não informado equivale que o diretório é a raiz da pasta documentos compartilhados")
	private String path;

	@NotNull(message = "Subsite do sharepoint é obrigatório")
	@NotEmpty(message = "Subsite do sharepoint é obrigatório")
	@JsonProperty(value = "subsite-sharepoint")
	@ApiModelProperty(value="Subsite do sharepoint.Ex: direct_toobox")
	private String subSiteSharepoint;
	
}
