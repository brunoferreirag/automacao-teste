package br.com.bancotoyota.services.sharepoint.docs;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.springframework.test.web.client.RequestMatcher;

public class RequestContainsUriMatcher implements RequestMatcher {
	private final String uri;

	public RequestContainsUriMatcher(String uri) {
		this.uri = uri;
	}

	@Override
	public void match(org.springframework.http.client.ClientHttpRequest request) throws IOException, AssertionError {
		assertTrue(request.getURI().toString().contains(uri));
	}

}
