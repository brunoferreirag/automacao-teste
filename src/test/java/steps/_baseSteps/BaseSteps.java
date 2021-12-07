package steps._baseSteps;


import com.microsoft.playwright.Page;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import pages.Simulacao.SimulacaoPage;
import pages._basePages.BasePage;
import support.Utils.Util;
import support.data.DataYaml;
import java.util.Map;


public class BaseSteps {


    private BasePage basePage;


    public BaseSteps(){
        basePage = new BasePage();
    }


    @Dado("clico em Proximo")
    public void clico_em() {
        basePage.clicarBtnProximo();
        //Util.aguardarLoader();
    }

    @Dado("clico no step de Configuracao")
    public void clicoNoStepDeConfiguracao() {
        basePage.clicarStepConfiguracao();
    }


    @Dado("clico em Proximo - Proposta")
    public void clicoEmProximoProposta() {
        basePage.clicarBtnProximoSimulacao();
        Util.aguardarLoader();
    }

    @Dado("clico no botao Calcular")
    public void clicoNoBotaoCalcular() {
        basePage.clicarBtnCalcular();
        Util.aguardarLoader();
    }

    @E("clico em Proximo - Propostaa")
    public void clicoEmProximoPropostaa() {
        basePage.clicarBtnProximoSimulacao1();
    }

    @E("clico em Proximo - Propostaaa")
    public void clicoEmProximoPropostaaa() {
        basePage.clicarBtnProximoSimulacao2();
    }

    @E("preencho o farol simples - Proponente PF Novo")
    public void preenchoFarolNovo() {
        basePage.clicarBtnFarol();
        basePage.preencherCpf();
        basePage.preencherNome();
        basePage.preencherEmail();
        basePage.preencherCelular();
        basePage.clicarBtnValidar();
    }

    @E("preencho o farol simples - Proponente PF Enriquecido")
    public void preenchoFarolSimplesEnriquecido() {
        basePage.clicarBtnFarol();
        basePage.preencherCpf(DataYaml.getMapYamlValues("Massa", "massa PF").get("solteiro"));
        basePage.clicarBtnValidar();
    }


    @E("preencho o farol simples - Proponente PJ Novo")
    public void preenchoOFarolProponentePJNovo() {
        basePage.clicarBtnFarol();
        basePage.preencherCnpj();
        basePage.preencherNome();
        basePage.preencherEmail();
        basePage.preencherCelular();
        basePage.clicarBtnValidar();
    }

    @E("preencho o farol simples - Proponente PJ Enriquecido")
    public void preenchoOFarolProponentePJEnriquecido() {
        basePage.clicarBtnFarol();
        basePage.preencherCnpj(DataYaml.getMapYamlValues("Massa", "massa PJ").get("proponente"));
        basePage.clicarBtnValidar();
    }


    @E("clico no Avatar")
    public void clicoNoAvatar() {
        basePage.clicarAvatar();
    }

    @E("clico no menu Perfil")
    public void clicoNoMenuPerfil() {
        basePage.clicarMeuPerfil();
    }

    @E("opto por não incluir o seguro auto integrado")
    public void optoPorNãoIncluirOSeguroAutoIntegrado() {
        basePage.calculoSemSeguro();
    }
}
