package steps.Home;

import cucumber.api.java.pt.E;
import org.junit.Assert;
import pages.home.Home;

public class HomeSteps {

    private Home home = new Home();

    @E("eu estou na pagina de home")
    public void eu_estou_na_pagina_de_home(){
        Assert.assertTrue(home.isPresent());
    }

    @E("eu clico em 'Faca Uma Simulacao'")
    public void eu_clico_em_Faca_Uma_Simulacao(){
        home.clicarFacaUmaSimulacao();
    }

}
