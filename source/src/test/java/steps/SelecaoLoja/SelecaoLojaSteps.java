package steps.SelecaoLoja;



import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import pages.SelecaoLoja.SelecaoLojaPage;
import pages.Simulacao.SimulacaoPage;

import java.util.Map;

public class SelecaoLojaSteps {

    private SelecaoLojaPage selecaoLojaPage;

    public SelecaoLojaSteps(){

        selecaoLojaPage = new SelecaoLojaPage();
    }

    @Dado("eu seleciono a concessionaria")
    public void eu_seleciono_a_concessionaria(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        selecaoLojaPage.selecionarLoja(data.get("CODIGO LOJA"));

    }

}

