package steps.FichaCadastral;

import cucumber.api.java.pt.E;
import pages.FichaCadastral.FichaAvalistaPjPage;



public class FichaAvalistaPjSteps {

    private FichaAvalistaPjPage fichaAvalistaPjPage;

    public FichaAvalistaPjSteps(){

        fichaAvalistaPjPage = new FichaAvalistaPjPage();
    }

    @E("clico em Inserir Avalista - PJ")
    public void clicoEmInserirAvalistaPJ() {
        fichaAvalistaPjPage.clicarInserirAvalista();
    }


    @E("preencho a Ficha do Avalista PJ - {int} Avalista")
    public void preenchoAFichaDoAvalistaPJAvalista(int arg0) {
        fichaAvalistaPjPage.preencherFichaAvalistaPj(0, 3, 0, 0, 0, 0);
        fichaAvalistaPjPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PJ - {int} Avalista {string}")
    public void preenchoAFichaDoAvalistaPJAvalista(int arg0, String tipo) {
        //fichaAvalistaPjPage.preencherFichaAvalistaPj(0, 2, 0, 1, 0, 0, tipo);
        fichaAvalistaPjPage.preencherFichaAvalistaPj(tipo);
        fichaAvalistaPjPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PJ - {int} Avalista com - Socio {int}, Rep Legal {int}, Procurador {int}, Socio Rep {int}, Socio Procurador {int}, Rep Procurador {int}")
    public void preenchoAFichaDoAvalistaPJAvalistaComSocioRepLegalProcuradorSocioRepSocioProcuradorRepProcurador(int arg0, int socio, int repLegal, int procurador, int socioRep, int socioProcurador, int repProcurador) {
        fichaAvalistaPjPage.preencherFichaAvalistaPj(socio, repLegal, procurador, socioRep, socioProcurador, repProcurador);
        fichaAvalistaPjPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PJ - {int} Avalista com - Rep Avalista {int}, Rep Legal {int}")
    public void preenchoAFichaDoAvalistaPJAvalistaComRepAvalistaRepLegal(int arg0, int repAvalista, int repLegal) {
        fichaAvalistaPjPage.preencherFichaAvalistaRepAvalista(repAvalista, repLegal);
        fichaAvalistaPjPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PJ - {int} Avalista com - Socio Avalista {int}, Rep Legal {int}")
    public void preenchoAFichaDoAvalistaPJAvalistaComSocioAvalistaRepLegal(int arg0, int socioAvalista, int repLegal) {
        fichaAvalistaPjPage.preencherFichaAvalistaSocioAvalista(socioAvalista, repLegal);
        fichaAvalistaPjPage.clicarSalvarAvalista();
    }

}
