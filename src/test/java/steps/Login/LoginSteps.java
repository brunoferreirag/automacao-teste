package steps.Login;

import cucumber.api.java.pt.Dado;
import pages.Login.LoginPage;
import pages.Ofertas.OfertasPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(){

        loginPage = new LoginPage();
    }

    @Dado("eu esteja na tela de login")
    public void eu_esteja_na_tela_de_login() {
        //loginPage.navigate("https://loginhml.bctoyota.com.br/login");
        //loginPage.navigate("https://loginhml.bctoyota.com.br/?goto=https://directhml.bctoyota.com.br/");
        loginPage.navigateToUrl();

    }

    @Dado("que esteja logado com usuario representante")
    public void que_esteja_logado_com_usuario_representante() {
        loginPage.realizarLogin();

    }


}
