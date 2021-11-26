package steps.Simulacao;



import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import pages.Simulacao.SimulacaoPage;
import pages.Veiculo.VeiculoPage;
import support.data.DataYaml;

import java.util.Map;

import static support.report.Report.takeScreenShot;

public class SimulacaoSteps {

    private SimulacaoPage simulacaoPage;

    public SimulacaoSteps(){
        simulacaoPage = new SimulacaoPage();
    }

    @Dado("preencho os valores da simulacao - parcela")
    public void preencho_os_valores_da_simulacao_parcela(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.clicarAbaParcela();
        simulacaoPage.inserirValorVeiculo(data.get("VALOR VEICULO"));
        simulacaoPage.inserirValorEntrada(data.get("VALOR ENTRADA"));
        simulacaoPage.inserirValorParcela(data.get("VALOR PARCELA"));
        simulacaoPage.inserirValorResidual(data.get("VALOR RESIDUAL"));
        simulacaoPage.inserirPrazo(data.get("PRAZO"));
        simulacaoPage.inserirTaxaSubsidio(data.get("TAXA SUBSIDIO"));
        simulacaoPage.inserirValorSubsidio(data.get("VALOR SUBSIDIO"));
        simulacaoPage.inserirPrazoSubsidio(data.get("PRAZO SUBSIDIO"));
        takeScreenShot();
    }

    @E("preencho os valores da simulacao - prazo")
    public void preenchoOsValoresDaSimulacaoPrazo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.clicarAbaPrazo();
        simulacaoPage.inserirValorVeiculo(data.get("VALOR VEICULO"));
        simulacaoPage.inserirValorEntrada(data.get("VALOR ENTRADA"));
        simulacaoPage.inserirValorParcela(data.get("VALOR PARCELA"));
        simulacaoPage.inserirValorResidual(data.get("VALOR RESIDUAL"));
        simulacaoPage.inserirPrazo(data.get("PRAZO"));
        simulacaoPage.inserirTaxaSubsidio(data.get("TAXA SUBSIDIO"));
        simulacaoPage.inserirValorSubsidio(data.get("VALOR SUBSIDIO"));
        simulacaoPage.inserirPrazoSubsidio(data.get("PRAZO SUBSIDIO"));
        takeScreenShot();
    }


    @E("clico em Proximo - Simulacao")
    public void clicoEmProximoSimulacao() {
        simulacaoPage.clicarBtnProximoSimulacao();
    }

    @E("preencho os valores da simulacao - residual")
    public void preenchoOsValoresDaSimulacaoResidual(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.clicarAbaResidual();
        simulacaoPage.inserirValorVeiculo(data.get("VALOR VEICULO"));
        simulacaoPage.inserirValorEntrada(data.get("VALOR ENTRADA"));
        simulacaoPage.inserirValorParcela(data.get("VALOR PARCELA"));
        simulacaoPage.inserirValorResidual(data.get("VALOR RESIDUAL"));
        simulacaoPage.inserirPrazo(data.get("PRAZO"));
        simulacaoPage.inserirTaxaSubsidio(data.get("TAXA SUBSIDIO"));
        simulacaoPage.inserirValorSubsidio(data.get("VALOR SUBSIDIO"));
        simulacaoPage.inserirPrazoSubsidio(data.get("PRAZO SUBSIDIO"));
        takeScreenShot();
    }

    @E("preencho o farol completo - Proponente PF Novo")
    public void preenchoOFarolCompletoProponentePFNovo() {
        simulacaoPage.clicarBtnAdicionarSeguroAuto();
        simulacaoPage.preencherCpfSeguroAuto();
        simulacaoPage.preencherNomeSeguroAuto();
        simulacaoPage.preencherSexoSeguroAuto("MASCULINO");
        simulacaoPage.preencherDataSeguroAuto("25/08/1985");
        simulacaoPage.preencherCepSeguroAuto("29114-360");
        simulacaoPage.selecionarCondutorEntre18e25Anos("SIM");
        simulacaoPage.selecionarVeiculoUsoComercial("SIM");
        simulacaoPage.selecionarCobrancaDePassagem("SIM");
        simulacaoPage.clickContinuarSeguroAuto();
        //cpf,nome,sexo,data,cep,nao,nao,continuar
    }

    @E("preencho o farol completo - Proponente PF Enriquecido")
    public void preenchoOFarolCompletoProponentePFEnriquecido() {
        simulacaoPage.clicarBtnAdicionarSeguroAuto();
        simulacaoPage.preencherCpfSeguroAutoEnriquecido(DataYaml.getMapYamlValues("Massa", "massa PF").get("solteiro"));
        simulacaoPage.selecionarCondutorEntre18e25Anos("SIM");
        simulacaoPage.selecionarVeiculoUsoComercial("SIM");
        simulacaoPage.selecionarCobrancaDePassagem("SIM");
        simulacaoPage.clickContinuarSeguroAuto();
    }

    @Então("o sistema não deve incluir seguro ao carrinho")
    public void oSistemaNãoDeveIncluirSeguroAoCarrinho() {
        simulacaoPage.validarPrestamistaPJ();
    }
}
