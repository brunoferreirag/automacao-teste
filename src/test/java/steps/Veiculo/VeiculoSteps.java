package steps.Veiculo;

import cucumber.api.java.pt.E;
import data.DataYaml;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.veiculo.Veiculo;
import report.Report;

import java.util.Map;

public class VeiculoSteps {

    private Veiculo veiculo = new Veiculo();

    @E("eu estou na pagina de veiculo")
    public void eu_estou_na_pagina_de_veiculo() {
        Assert.assertTrue(veiculo.isPresent());
    }


    @E("eu seleciono as opcoes de veiculo")
    public void eu_seleciono_as_opcoes_de_veiculo(DataTable dataTable) throws Exception {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        veiculo.selecionarCicloToyota(data.get("CICLO TOYOTA"));
        veiculo.selecionarMarca(data.get("MARCA"));
        veiculo.selecionarAnoFabricacao(data.get("ANO FABRICACAO"));
        veiculo.selecionarAnoModelo(data.get("ANO MODELO"));
        veiculo.selecionarModeloVersao(data.get("MODELO VERSAO"));
        veiculo.selecionarTabelaFlex(data.get("TABELA FLEX"));
        veiculo.selecionarTabela(DataYaml.getMapYamlValues("Planos", data.get("TABELA DE NEGOCIACAO")));
        veiculo.selecionarUfEmplacamento(data.get("UF EMPLACAMENTO"));
        veiculo.selecionarCodigoSimulacao(data.get("CODIGO SIMULACAO"));
        veiculo.selecionarDiaPagamento(data.get("DIA DE PAGAMENTO"));
        veiculo.selecionarPrimeiroVencimento(data.get("VENCIMENTO"));
        veiculo.selecionarCestaDeServico(data.get("CESTA DE SERVICO"));
        Report.takeScreenShot();
    }

    @E("eu clico em 'Proximo' na tela de veiculo")
    public void eu_clico_em_Proximo_na_tela_de_veiculo() {
        veiculo.clicarBotaoProximo();
    }

}
