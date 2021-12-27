package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix ="sharepoint.credenciais")
@Getter
@Setter
public class CredenciaisSharepoint {
	private String clientSecret;
	private String resource;
	private String grantType;
	private String tenantId;
	private String enderecoAppTokenAcesso;
	private String clientId;
}
