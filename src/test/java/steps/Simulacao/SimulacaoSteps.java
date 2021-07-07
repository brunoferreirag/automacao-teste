package steps.Simulacao;

import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.simulacao.Simulacao;
import report.Report;

import java.util.Map;

public class SimulacaoSteps {

    private Simulacao simulacao = new Simulacao();

    @E("eu estou na pagina de simulacao")
    public void eu_estou_na_pagina_de_simulacao() {
        Assert.assertTrue(simulacao.isPresent());
    }

    @E("eu seleciono a aba Parcela")
    public void eu_seleciono_a_aba_Parcela() {
        simulacao.clicarAbaParcela();
    }

    @E("eu seleciono a aba Residual")
    public void eu_seleciono_a_aba_Residual() {
        simulacao.clicarAbaResidual();
    }

    @E("eu seleciono a aba Prazo")
    public void eu_seleciono_a_aba_Prazo() {
        simulacao.clicarAbaPrazo();
    }

    @E("eu preencho os valores da simulacao")
    public void eu_preencho_os_valores_da_simulacao(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacao.inserirValorVeiculo(data.get("VALOR VEICULO"));
        simulacao.inserirValorEntrada(data.get("VALOR ENTRADA"));
        simulacao.inserirValorParcela(data.get("VALOR PARCELA"));
        simulacao.inserirValorResidual(data.get("VALOR RESIDUAL"));
        simulacao.inserirPrazo(data.get("PRAZO"));
        simulacao.inserirTaxaSubsidio(data.get("TAXA SUBSIDIO"));
        simulacao.inserirValorSubsidio(data.get("VALOR SUBSIDIO"));
        simulacao.inserirPrazoSubsidio(data.get("PRAZO SUBSIDIO"));
        Report.takeScreenShot();
    }

    @E("eu clico no botao 'Calcular'")
    public void eu_clico_no_botao_Calcular() {
        simulacao.clicarCalcular();
        simulacao.validarPlanoDeFinanciamento();
    }

    @E("eu clico em 'Plano com 3 intermediárias'")
    public void eu_clico_em_plano_com_tres_intermediarias(){
        simulacao.aceitarSugestaoTresIntermediarias();
    }

    @E("eu clico em 'Insira até 6 intermediárias'")
    public void eu_clico_em_insira_ate_seis_intermediarias(){
        simulacao.clicarInserirAteSeisIntermediarias();
    }

    @E("eu visualizo o modal de inclusão de intermediárias")
    public void eu_visualizo_modal_de_inclusao_de_intermediarias(){
        simulacao.visualizarModalInsercaoIntermediarias();
    }

    @E("eu incluo intermediárias no modal de inclusão de intermediárias")
    public void incluio_intermediarias_modal_inclusao_de_intermediarias(DataTable dataTable){
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacao.incluirIntermediariaRandomModalIntermediaria(data.get("INTERMEDIARIA 01"));
        simulacao.incluirIntermediariaRandomModalIntermediaria(data.get("INTERMEDIARIA 02"));
        simulacao.incluirIntermediariaRandomModalIntermediaria(data.get("INTERMEDIARIA 03"));
        simulacao.incluirIntermediariaRandomModalIntermediaria(data.get("INTERMEDIARIA 04"));
        simulacao.incluirIntermediariaRandomModalIntermediaria(data.get("INTERMEDIARIA 05"));
        simulacao.incluirIntermediariaRandomModalIntermediaria(data.get("INTERMEDIARIA 06"));
        Report.takeScreenShot();
    }

    @E("eu clico em 'Concluir' no modal de inclusão de intermediárias")
    public void eu_clico_em_concluir_no_modal_de_inclusao_de_intermediarias(){
        simulacao.clicarConcluirModalInsercaoIntermediarias();
    }

    @E("eu visualizo as intermediárias inseridas na simulacao")
    public void eu_visualizo_as_intermediarias_inseridas_na_simulacao(){
        simulacao.visualizarIntermediariasSimulacao();
    }

    @E("eu clico em 'Proximo' na tela de simulacao")
    public void eu_clico_em_Proximo_na_tela_de_simulacao() {
        simulacao.clicarBotaoProximo();
    }

    @E("eu seleciono o dia de vencimento da parcela para acessar o modal de inclusão de intermediárias")
    public void eu_seleciono_o_dia_de_vencimento_da_parcela_para_acessar_o_modal_de_inclusao_de_intermediarias(DataTable dataTable){
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacao.alterarDiaPagamentoIntermediarias(data.get("DIA DE PAGAMENTO"));
        simulacao.alterarVencimentoIntermediarias(data.get("VENCIMENTO"));
        simulacao.concluirAlteracaoVencimentoIntermediarias();
    }

}
