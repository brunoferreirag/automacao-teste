package steps.EnvioProposta;

import cucumber.api.java.pt.E;
import pages.envioProposta.ConfirmacaoEnvio;

public class ConfirmacaoEnvioSteps {

    ConfirmacaoEnvio confirmacaoEnvio = new ConfirmacaoEnvio();

    @E("eu estou na pagina de confirmacao de envio")
    public void eu_estou_na_pagina_de_confirmacao_de_envio() {
        confirmacaoEnvio.isPresent();
    }

    @E("eu visualizo mensagem de sucesso no envio")
    public void eu_visualizo_mensagem_de_sucesso_no_envio(){
        confirmacaoEnvio.validarMensagemEnvio("Sua proposta foi enviada!");
    }

}
