package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa um token de acesso para um site sharepoint
 * @author bags
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenAcessoSharePoint {
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("expires_in")
	private int expiresIn;
	@JsonProperty("not_before")
	private int notBefore;
	@JsonProperty("expires_on")
	private int expires_on;
	@JsonProperty("resource")
	private String resource;
	@JsonProperty("access_token")
	private String accessToken;
	
}
