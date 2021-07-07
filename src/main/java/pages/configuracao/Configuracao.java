package pages.configuracao;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

@Log4j2
public class Configuracao extends DriverManager implements CommonTestingType {

    private By lblConfiguracao = By.xpath("//h4[contains(text(),'Configurações')]");

    private By btnTipoFinanciamentoCdc = By.xpath("//button[@name='tipo-financiamento']//div[contains(text(),'CDC')]");
    private By btnTipoFinanciamentoLeasing = By.xpath("//button[@name='tipo-financiamento']//div[contains(text(),'LEASING')]");

    private By btnTipoPessoaPf = By.xpath("//button[@name='tipo-pessoa']//div[contains(text(),'PF')]");
    private By btnTipoPessoaPj = By.xpath("//button[@name='tipo-pessoa']//div[contains(text(),'PJ')]");

    private By btnVeiculoZeroKm = By.xpath("//button[@name='situacao-veiculo']//div[contains(text(),'0KM')]");
    private By btnVeiculoUsado = By.xpath("//button[@name='situacao-veiculo']//div[contains(text(),'USADO')]");

    private By btnFiltroSubsidioNao = By.xpath("//button[@name='buscar-planos-com-subsidio']//div[contains(text(),'NÃO')]");
    private By btnFiltroSubsidioSim = By.xpath("//button[@name='buscar-planos-com-subsidio']//div[contains(text(),'SIM')]");
    private By btnFiltroSubsidioTodas = By.xpath("//button[@name='buscar-planos-com-subsidio']//div[contains(text(),'TODAS')]");

    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblConfiguracao);
    }

    public void selecionarTipoDeFinanciamento(String opcao) throws Exception {
        if (opcao.equalsIgnoreCase("CDC")) {
            Action.clickOnElement(btnTipoFinanciamentoCdc);
            log.info("Selecionado tipo de financiamento CDC");
        } else if (opcao.equalsIgnoreCase("LEASING")) {
            Action.clickOnElement(btnTipoFinanciamentoLeasing);
            log.info("Selecionado tipo de financiamento LEASING");
        } else {
            log.info("Valor invalido informado para selecao de Tipo de Financiamento - " + opcao);
            throw new Exception("Valor informado invalido: " + opcao);
        }
    }

    public void selecionarTipoDePessoa(String opcao) throws Exception {
        if (opcao.equalsIgnoreCase("PF")) {
            Action.clickOnElement(btnTipoPessoaPf);
            log.info("Selecionado tipo de pessoa PF");
        } else if (opcao.equalsIgnoreCase("PJ")) {
            Action.clickOnElement(btnTipoPessoaPj);
            log.info("Selecionado tipo de pessoa PJ");
        } else {
            log.info("Valor invalido informado para selecao de Tipo de Pessoa - " + opcao);
            throw new Exception("Valor informado invalido: " + opcao);
        }
    }

    public void selecionarTipoDeVeiculo(String opcao) throws Exception {
        if (opcao.equalsIgnoreCase("0KM") || opcao.equalsIgnoreCase("NOVO")) {
            Action.clickOnElement(btnVeiculoZeroKm);
            log.info("Selecionado tipo de veiculo zero km");
        } else if (opcao.equalsIgnoreCase("USADO")) {
            Action.clickOnElement(btnVeiculoUsado);
            log.info("Selecionado tipo de veiculo usado");
        } else {
            log.info("Valor invalido informado para selecao de Tipo de Veiculo - " + opcao);
            throw new Exception("Valor informado invalido: " + opcao);
        }
    }

    public void selecionarFiltroTabelaSubsidio(String opcao) throws Exception {
        if (opcao.equalsIgnoreCase("NÃO") || opcao.equalsIgnoreCase("NAO")) {
            Action.clickOnElement(btnFiltroSubsidioNao);
            log.info("Selecionado o filtro de tabela sem subsidio");
        } else if (opcao.equalsIgnoreCase("SIM")) {
            Action.clickOnElement(btnFiltroSubsidioSim);
            log.info("Selecionado o filtro de tabela com subsidio");
        } else if (opcao.equalsIgnoreCase("TODAS")) {
            Action.clickOnElement(btnFiltroSubsidioTodas);
            log.info("Selecionado o filtro com todas as tabela");
        } else {
            log.info("Valor invalido informado para selecao de filtro de tabelas - " + opcao);
            throw new Exception("Valor informado invalido: " + opcao);
        }
    }

    public void clicarBotaoProximo() {
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de Configuracao");
    }

}

