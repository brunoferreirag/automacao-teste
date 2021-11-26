package steps.Ofertas;

import cucumber.api.java.pt.E;
import pages.Ofertas.OfertasPage;
import pages.PreFicha.PreFichaPage;
import support.Utils.Util;

import static support.report.Report.takeScreenShot;

public class OfertasSteps {

    private OfertasPage ofertasPage;

    public OfertasSteps(){

        ofertasPage = new OfertasPage();
    }

    @E("clico em Proximo - Ofertas")
    public void clicoEmProximoOfertas() {
        Util.aguardarLoader();
        ofertasPage.clicarBtnProximoOfertas();
    }



}
