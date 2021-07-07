package steps.PreFicha;

import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import pages.preFicha.PreFicha;
import report.Report;

import java.util.Map;

public class PreFichaSteps {

    PreFicha preFicha = new PreFicha();

    @E("eu estou na pagina de pre ficha")
    public void eu_estou_na_pagina_de_pre_ficha() {
        preFicha.isPresent();
    }

    @E("^eu preencho dados do proponente")
    public void eu_preencho_dados_do_proponente(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        preFicha.preencherCpf((data.get("CPF")));
        preFicha.preencherNome(data.get("NOME"));
        preFicha.selecionarSexo(data.get("SEXO"));
        preFicha.preencherDataNascimento(data.get("DATA NASCIMENTO"));
        preFicha.preencherCep(data.get("CEP RESIDENCIAL"));
        preFicha.selecionarCondutorEntre18e25Anos(data.get("CONDUTOR ENTRE 18 E 25 ANOS"));
        preFicha.selecionarVeiculoUsoComercial(data.get("VEICULO USO COMERCIAL"));
        preFicha.selecionarTaxiOuFrota(data.get("TAXI OU FROTA"));
        Report.takeScreenShot();
    }

    @E("eu clico em 'Proximo' na tela de pre ficha")
    public void eu_clico_em_Proximo_na_tela_de_configuracao() {
        preFicha.clicarBotaoProximo();
    }

}
