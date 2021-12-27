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
public class ItemSharePointUpdateRequestDTO {
	@NotNull(message = "Path Atual da pasta é obrigatório")
	@NotEmpty(message = "Path Atual da pasta é obrigatório")
	@JsonProperty(value = "path-atual")
    @ApiModelProperty(value="Caminho atual do recurso que se deseja editar.")
	private String pathAtual;
	
	
	@NotNull(message = "Novo Path  da pasta é obrigatório")
	@NotEmpty(message = "Novo Path  da pasta é obrigatório")
	@JsonProperty(value = "novo-path")
	@ApiModelProperty(value="Novo caminho do recurso. Na prática , estamos indicando o novo nome da pasta nesse campo.")
	private String novoPath;

	@NotNull(message = "Subsite do sharepoint é obrigatório")
	@NotEmpty(message = "Subsite do sharepoint é obrigatório")
	@JsonProperty(value = "subsite-sharepoint")
	@ApiModelProperty(value="Subsite do sharepoint.Ex: direct_toobox")
	private String subSiteSharepoint;
	
}
