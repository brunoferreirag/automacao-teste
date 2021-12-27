package br.com.bancotoyota.services.sharepoint.docs.common;


import java.util.Arrays;
import java.util.List;

import br.com.bancotoyota.services.sharepoint.docs.exception.Erro;

public class InvalidFieldException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4681665274109525781L;
	private final transient List<Erro> erros;
    private static final String MESSAGE = Constants.ERRO_CAMPO_INVALIDO;

    public InvalidFieldException(String field, String value) {
        super(String.format(MESSAGE, field) + " : " + value);
        Erro e = new Erro(field, value, String.format(MESSAGE, field));
        this.erros = Arrays.asList(e);
    }

    public List<Erro> getErros() {
        return erros;
    }
}
