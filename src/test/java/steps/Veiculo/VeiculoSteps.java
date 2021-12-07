package steps.Veiculo;



import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import pages.Configuracao.ConfiguracaoPage;
import pages.Veiculo.VeiculoPage;

import java.util.Map;

import static support.report.Report.takeScreenShot;

public class VeiculoSteps {

    private VeiculoPage veiculoPage;

    public VeiculoSteps(){
        veiculoPage = new VeiculoPage();
    }


    @Dado("seleciono as opcoes de veiculo")
    public void seleciono_as_opcoes_de_veiculo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        veiculoPage.selecionarCicloToyota(data.get("CICLO TOYOTA"));
        veiculoPage.selecionarMarca(data.get("MARCA"));
        veiculoPage.selecionarAnoFabricacao(data.get("ANO FABRICACAO"));
        veiculoPage.selecionarAnoModelo(data.get("ANO MODELO"));
        veiculoPage.selecionarModeloVersao(data.get("MODELO VERSAO"));
        veiculoPage.selecionarTabelaFlex(data.get("TABELA FLEX"));
        veiculoPage.selecionarTabela(data.get("TABELA DE NEGOCIACAO"));
        veiculoPage.selecionarUfEmplacamento(data.get("UF EMPLACAMENTO"));
        veiculoPage.selecionarCodigoSimulacao(data.get("CODIGO SIMULACAO"));
        veiculoPage.selecionarDiaPagamento(data.get("DIA DE PAGAMENTO"));
        veiculoPage.selecionarPrimeiroVencimento(data.get("VENCIMENTO"));
        veiculoPage.selecionarCestaDeServico(data.get("CESTA DE SERVICO"));
        takeScreenShot();
    }

    @E("clico em Proximo - Veiculo")
    public void clicoEmProximoVeiculo() {
        veiculoPage.clicarBtnProximoVeiculo();
    }

    @E("altero as configurações do veículo")
    public void alteroAsConfiguraçõesDoVeículo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        veiculoPage.selecionarCicloToyota(data.get("CICLO"));
        veiculoPage.selecionarMarca(data.get("MARCA"));
        veiculoPage.selecionarAnoFabricacao(data.get("ANO FABRICACAO"));
        veiculoPage.selecionarAnoModelo(data.get("ANO MODELO"));
        veiculoPage.selecionarModeloVersao(data.get("MODELO VERSAO"));
        veiculoPage.selecionarTabelaFlex(data.get("TABELA FLEX"));
        veiculoPage.selecionarTabela(data.get("TABELA DE NEGOCIACAO"));
        veiculoPage.selecionarUfEmplacamento(data.get("UF EMPLACAMENTO"));
        veiculoPage.selecionarCodigoSimulacao(data.get("CODIGO SIMULACAO"));
        veiculoPage.selecionarDiaPagamento(data.get("DIA DE PAGAMENTO"));
        veiculoPage.selecionarPrimeiroVencimento(data.get("VENCIMENTO"));
        veiculoPage.selecionarCestaDeServico(data.get("CESTA DE SERVICO"));
    }


}
