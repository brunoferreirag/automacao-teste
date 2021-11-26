package pages.SelecaoLoja;


import support.browser.BrowserManager;


import static support.report.Report.takeScreenShot;

public class SelecaoLojaPage extends BrowserManager {


    String comboConcessionaria = "//div[contains(@class, 'selecao-loja-content')]//input[@type='text']";
    //String comboConcessionaria = "[placeholder='Concessionária'] input[@type='text']";

    public void selecionarLoja (String data){
        page.click(comboConcessionaria);
        page.fill(comboConcessionaria, data);
        page.press("body", "Enter" );
        takeScreenShot();
    }



}
