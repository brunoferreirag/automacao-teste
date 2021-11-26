package steps.Home;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import pages.Home.HomePage;
import pages.Login.LoginPage;
import support.Utils.Util;

import static support.report.Report.takeScreenShot;

public class HomeSteps {

    private HomePage homePage;

    public HomeSteps(){

        homePage = new HomePage();
    }

    @Dado("clico em Faca Uma Simulacao")
    public void clico_em() {
        takeScreenShot();
        homePage.clicarBtnFacaSimulacao();
        //Util.aguardarLoader();
    }

}
