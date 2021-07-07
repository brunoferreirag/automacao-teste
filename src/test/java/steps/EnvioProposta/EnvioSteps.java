package steps.EnvioProposta;

import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import pages.envioProposta.Envio;
import report.Report;

import java.util.Map;

public class EnvioSteps {

    Envio envio = new Envio();


    @E("eu estou na pagina de envio de proposta")
    public void eu_estou_na_pagina_de_envio_de_proposta() {
        envio.isPresent();
    }

    @E("^eu seleciono o Consultor e Responsavel na tela de envio")
    public void eu_seleciono_o_consultor_e_responsavel_na_tela_de_envio(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        envio.selecionarConsultor(data.get("CONSULTOR"));
        envio.selecionarResponsavel(data.get("RESPONSAVEL"));
        Report.takeScreenShot();
    }

    @E("^eu seleciono o primeiro Consultor e Responsavel disponivel na tela de envio")
    public void eu_seleciono_o_primeiro_consultor_e_responsavel_na_tela_de_envio() {
        envio.selecionarConsultor("Primeiro");
        envio.selecionarResponsavel("Primeiro");
        Report.takeScreenShot();
    }

    @E("^eu seleciono o Responsavel na tela de envio")
    public void eu_seleciono_o_responsavel_na_tela_de_envio(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        envio.selecionarResponsavel(data.get("RESPONSAVEL"));
        Report.takeScreenShot();
    }

    @E("^eu seleciono o primeiro Responsavel disponivel na tela de envio")
    public void eu_seleciono_o_primeiro_responsavel_na_tela_de_envio() {
        envio.selecionarResponsavel("Primeiro");
        Report.takeScreenShot();
    }

    @E("eu clico no botao 'Enviar Pre-Proposta' na tela de envio")
    public void eu_clico_no_botao_enviar_preproposta_na_tela_de_envio(){
        envio.clicarBotaoEnviarPreProposta();
    }

}
