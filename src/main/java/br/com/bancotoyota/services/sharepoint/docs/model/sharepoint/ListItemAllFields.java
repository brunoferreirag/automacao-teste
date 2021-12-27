package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListItemAllFields {
	 @JsonProperty("__deferred")
	 Deferred __deferredObject;
}
