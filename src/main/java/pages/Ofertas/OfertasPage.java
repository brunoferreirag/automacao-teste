package pages.Ofertas;

import support.Utils.Util;
import support.browser.BrowserManager;


public class OfertasPage extends BrowserManager {

    String btnProximoOfertas = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    String inputSeguro = "#inserir";
    String btnProximoOfertasInativo = "//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']";

    public void clicarBtnProximoOfertas() {
        Util.aguardarLoader();
        if(page.isVisible(inputSeguro)){
            page.click(inputSeguro);
        }
        page.click(btnProximoOfertas);
    }
}
