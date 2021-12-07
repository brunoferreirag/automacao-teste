package steps.PreFicha;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import pages.PreFicha.PreFichaPage;
import pages.SelecaoLoja.SelecaoLojaPage;
import support.data.DataYaml;

import java.util.HashMap;
import java.util.Map;

import static support.report.Report.takeScreenShot;

public class PreFichaSteps {

    private PreFichaPage preFichaPage;

    public PreFichaSteps(){

        preFichaPage = new PreFichaPage();
    }

    @Dado("preencho os dados do proponente PF")
    public void preencho_os_dados_do_proponentePF(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        preFichaPage.preencherCpf(data.get("CPF"));
        preFichaPage.preencherNome(data.get("NOME COMPLETO"));
        preFichaPage.preencherPlaca(data.get("PLACA VEICULO"));
        preFichaPage.selecionarSexo(data.get("SEXO"));
        preFichaPage.preencherDataNascimento(data.get("DATA NASCIMENTO"));
        preFichaPage.preencherCep(data.get("CEP RESIDENCIAL"));
        preFichaPage.selecionarCondutorEntre18e25Anos(data.get("CONDUTOR ENTRE 18 E 25 ANOS"));
        preFichaPage.selecionarVeiculoUsoComercial(data.get("VEICULO USO COMERCIAL"));
        preFichaPage.selecionarTaxiOuFrota(data.get("TAXI OU FROTA"));
        takeScreenShot();
    }

    @E("preencho os dados do proponente Enriquecido PF {string}")
    public void preenchoOsDadosDoProponenteEnriquecidoPF(String tipo, io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        preFichaPage.preencherCpf(DataYaml.getMapYamlValues("Massa", "massa PF").get(tipo));
        preFichaPage.selecionarCondutorEntre18e25Anos(data.get("CONDUTOR ENTRE 18 E 25 ANOS"));
        preFichaPage.selecionarVeiculoUsoComercial(data.get("VEICULO USO COMERCIAL"));
        preFichaPage.selecionarTaxiOuFrota(data.get("TAXI OU FROTA"));
        takeScreenShot();

    }

    @E("gero massa PF {string}")
    public void geroMassaPF(String tipo) {
        preFichaPage.gerarMassaPF(tipo);
    }


    @E("preencho os dados do proponente PF - Com Farol")
    public void preenchoOsDadosDoProponentePFComFarol(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        preFichaPage.selecionarSexo(data.get("SEXO"));
        preFichaPage.preencherDataNascimento(data.get("DATA NASCIMENTO"));
        preFichaPage.preencherCep(data.get("CEP RESIDENCIAL"));
        preFichaPage.selecionarCondutorEntre18e25Anos(data.get("CONDUTOR ENTRE 18 E 25 ANOS"));
        preFichaPage.selecionarVeiculoUsoComercial(data.get("VEICULO USO COMERCIAL"));
        preFichaPage.selecionarTaxiOuFrota(data.get("TAXI OU FROTA"));
        takeScreenShot();
    }


}
