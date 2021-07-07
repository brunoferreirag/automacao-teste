package steps.FichaCadastral;

import cucumber.api.java.pt.E;
import pages.fichaCadastral.FichaProponentePj;
import report.Report;

public class FichaProponentePjSteps {

    FichaProponentePj fichaProponentePj = new FichaProponentePj();

    @E("eu estou na pagina de ficha cadastral pj")
    public void eu_estou_na_pagina_de_ficha_cadastral_pj() {
        fichaProponentePj.isPresent();
        Report.takeScreenShot();
    }

    @E("eu preencho a ficha do proponente pj com dados gerados")
    public void eu_preencho_a_ficha_do_proponente_pj_com_dados_gerados() {
        //fichaProponentePj.gerarFichaProponentePj();
        //fichaProponentePj.gerarFichaProponentePj(2,3,1);
        fichaProponentePj.gerarFichaProponentePj(0,2,0,1,0,0);
    }

    @E("eu clico em 'Proximo' na tela de ficha cadastral pj")
    public void eu_clico_em_Proximo_na_tela_de_ficha_cadastral_pj() {
        fichaProponentePj.clicarBotaoProximo();
    }
}
