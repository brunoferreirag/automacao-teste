package pages.Home;


import support.browser.BrowserManager;


public class HomePage extends BrowserManager {


    String btnFacaSimulacao = "#facaUmaSimulacao";

    public void clicarBtnFacaSimulacao(){
        page.click(btnFacaSimulacao);
    }

}
