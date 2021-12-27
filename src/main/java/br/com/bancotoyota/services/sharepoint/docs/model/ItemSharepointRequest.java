package br.com.bancotoyota.services.sharepoint.docs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemSharepointRequest {
	
	@JsonProperty(value="path")
	private String path;
	@JsonProperty(value="subsite-sharepoint")
	private String subSiteSharepoint;
	@JsonProperty(value="token-sharepoint")
	private String tokenSharePoint;
}
