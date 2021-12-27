package br.com.bancotoyota.services.sharepoint.docs.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class Erro implements Serializable {
	@EqualsAndHashCode.Exclude
	static final long serialVersionUID = -7034897190745766939L;

    @EqualsAndHashCode.Exclude
    private String field;
    @EqualsAndHashCode.Exclude
    private String value;
    private String message;

    public Erro(String message) {
        this.message = message;
    }
}
