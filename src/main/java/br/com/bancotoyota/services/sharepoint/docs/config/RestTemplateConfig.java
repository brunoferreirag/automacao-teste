package br.com.bancotoyota.services.sharepoint.docs.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.Duration;

@Configuration
public class RestTemplateConfig  {

	@Bean
	public RestTemplate restTemplateFactory(RestTemplateBuilder restTemplateBuilder)
			throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException,
			KeyManagementException {

		HttpClient client= HttpClients.custom().build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(client);
		return restTemplateBuilder.requestFactory(() -> requestFactory).setConnectTimeout(Duration.ZERO).setReadTimeout(Duration.ZERO) .setBufferRequestBody(false).build();

	}
}
