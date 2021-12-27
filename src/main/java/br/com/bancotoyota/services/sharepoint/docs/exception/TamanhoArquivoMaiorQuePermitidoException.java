package br.com.bancotoyota.services.sharepoint.docs.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class TamanhoArquivoMaiorQuePermitidoException extends RuntimeException{

    @Getter
    private final List<Erro> erros;

    public TamanhoArquivoMaiorQuePermitidoException(String tamanhoArquivo, String maximoConfigurado) {
        Erro e = new Erro("arquivo", tamanhoArquivo, String.format("Tamanho %s em bytes maior que o configurado %s bytes", tamanhoArquivo,maximoConfigurado));
        this.erros = Arrays.asList(e);
    }

}
