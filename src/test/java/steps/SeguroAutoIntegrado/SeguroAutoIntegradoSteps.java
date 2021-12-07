package steps.SeguroAutoIntegrado;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.Simulacao.SimulacaoPage;

import java.util.Map;

public class SeguroAutoIntegradoSteps {

    private SimulacaoPage simulacaoPage;

    public SeguroAutoIntegradoSteps() {
        simulacaoPage = new SimulacaoPage();
    }

    @E("clico na opção de incluir Seguro Auto")
    public void clicoNaOpçãoDeIncluirSeguroAuto() {
        simulacaoPage.clicarBtnAdicionarSeguroAuto();
    }

    @E("Seleciono o seguinte tipo de seguro")
    public void selecionoOSeguinteTipoDeSeguro(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.selecionarTipoSeguro(data.get("ITEM"));
    }

    @E("informo os dados do cliente")
    public void informoOsDadosDoCliente(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.preencherCpfSeguroAuto();
        simulacaoPage.preencherNomeSeguroAuto();
        simulacaoPage.preencherSexoSeguroAuto();
        simulacaoPage.preencherDataSeguroAuto("18081987");
        simulacaoPage.preencherCepSeguroAuto("09280260");
        simulacaoPage.selecionarCondutorEntre18e25Anos(data.get("CONDUTORES ENTRE 18 E 25"));
        simulacaoPage.selecionarVeiculoUsoComercial(data.get("USO COMERCIAL"));
        simulacaoPage.selecionarCobrancaDePassagem(data.get("COBRANCA DE PASSAGEM"));
    }

    @E("clico em continuar")
    public void clicoEmContinuar() {
        simulacaoPage.clickContinuarSeguroAuto();
    }

    @Quando("seleciono o seguinte plano de financiamento")
    public void selecionoOSeguintePlanoDeFinanciamento(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.selecionarParcelasPlanoFinanciamento(data.get("PLANO"));
        
    }

    @E("informo o prazo - Aba prazo")
    public void informoOPrazoAbaPrazo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.clicarAbaPrazo();
        simulacaoPage.inserirPrazo(data.get("PRAZO"));
    }

    @E("clico no Step de configurações do veículo")
    public void clicoNoStepDeConfiguraçõesDoVeículo() {
        simulacaoPage.clicarStepVeiculo();
    }

    @Então("o sistema exibe somente as opções de seguro com vigência de {int} meses")
    public void oSistemaExibeSomenteAsOpçõesDeSeguroComVigênciaDeMeses(int arg0) {
        simulacaoPage.validarSeguro12meses();
    }

    @Então("o sistema exibe as opções de seguro com vigência de {int} meses e do contrato")
    public void oSistemaExibeAsOpçõesDeSeguroComVigênciaDeMesesEDoContrato(int arg0) {
        simulacaoPage.validarSegurosTipos();
    }


    @Quando("clico em Detalhes da cobertura")
    public void clicoEmDetalhesDaCobertura() {
        simulacaoPage.abrirDetalhesCobertura();
    }

    @Então("o sistema exibe modal com o tipo de vigência e detalhes da oferta")
    public void oSistemaExibeModalComOTipoDeVigênciaEDetalhesDaOferta() {
        simulacaoPage.validarModalDetalhesSeguro();
        simulacaoPage.validarDetalhesModalSeguroAuto();
    }

    @E("clico no Step de configurações")
    public void clicoNoStepDeConfigurações() {
        simulacaoPage.clicarStepConfiguracao();
    }

    @Entao("Verifico que a opção de {string} não é disponibilizada")
    public void verificoQueAOpçãoDeNãoÉDisponibilizada(String item) {
        simulacaoPage.ValidarSeguroAutoParaPJ(item);
    }
}
