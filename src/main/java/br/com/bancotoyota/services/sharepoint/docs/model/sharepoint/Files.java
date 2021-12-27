package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Files {
	@JsonProperty("__deferred")
	Deferred deferredObject;
	private List<Result> results;
}
