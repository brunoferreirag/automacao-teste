package steps.Login;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import data.DataYaml;
import org.junit.Assert;
import pages.selecaoLoja.SelecaoLoja;
import pages.login.Login;

public class LoginSteps {

    private Login loginPage = new Login();

    @Dado("eu estou na pagina de login")
    public void eu_estou_na_pagina_de_login() {
        loginPage.acessaAplicacao();
        Assert.assertTrue(loginPage.isPresent());
    }

    @E("eu efetuar o login com usuario com o perfil de representante")
    public void eu_efetuar_o_login_com_credencias_validas_representante() {
        loginPage.executaLogin(DataYaml.getMapYamlValues("Usuarios","credenciais_representante"));
    }

    @E("eu efetuar o login com usuario com o perfil de vendedor")
    public void eu_efetuar_o_login_com_credencias_validas_vendedor() {
        loginPage.executaLogin(DataYaml.getMapYamlValues("Usuarios","credenciais_vendedor"));
    }

}
