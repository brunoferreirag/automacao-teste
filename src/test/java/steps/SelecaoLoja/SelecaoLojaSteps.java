package steps.SelecaoLoja;

import cucumber.api.java.pt.E;
import data.DataYaml;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.selecaoLoja.SelecaoLoja;

import java.util.Map;

public class SelecaoLojaSteps {

    private SelecaoLoja selLojaPage = new SelecaoLoja();

    @E("eu estou na pagina de selecao de loja")
    public void estou_na_pagina_de_selecao_de_loja() {
        Assert.assertTrue(selLojaPage.isPresent());
    }

    @E("eu seleciono a concessionaria")
    public void eu_seleciono_a_concessionaria(DataTable dataTable){
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        selLojaPage.selecionarConcessionaria(DataYaml.getMapYamlValues("Lojas",data.get("CODIGO LOJA")));
        selLojaPage.botaoProximo();
    }

}
