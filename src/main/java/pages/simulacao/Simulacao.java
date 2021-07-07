package pages.simulacao;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

import java.util.Random;

@Log4j2
public class Simulacao extends DriverManager implements CommonTestingType {

    private By lblSimulacao = By.xpath("//h4[contains(text(),'Simulação')]");

    private By abaParcela = By.xpath("//div[@class='mat-tab-label-content'][text()='PARCELA']");
    private By abaResidual = By.xpath("//div[@class='mat-tab-label-content'][text()='RESIDUAL']");
    private By abaPrazo = By.xpath("//div[@class='mat-tab-label-content'][text()='PRAZO']");

    private By txtValorVeiculo = By.id("valor-bem");
    private By txtValorEntrada = By.id("valor-entrada");
    private By txtValorParcela = By.id("valor-parcela");
    private By txtValorResidual = By.id("valor-residual");
    private By comboPrazo = By.id("prazo-desejado");

    private By radioSubsidioTaxa = By.id("subsidio-tipo-taxa");
    private By radioSubsidioValor = By.id("subsidio-tipo-valor");
    private By txtValorSubsidio = By.id("subsidio-valor");
    private By txtTaxaSubsidio = By.id("subsidio-taxa");
    private By comboPrazoSubsidio = By.id("subsidio-prazo");

    private By btnCalcular = By.xpath("//button[text()='CALCULAR']");
    private By btnCalcularInativo = By.xpath("//button[@disabled][text()='CALCULAR']");

    private By comboPlanoDeFinanciamento = By.id("prazo");

    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    //INTERMEDIARIAS
    private By textListaDeIntermediarias = By.xpath("//*[@class='lista-intermediarias']");
    private By textLinhaListaDeIntermediarias = By.xpath("//*[@class='lista-intermediarias']//div[@class='row linha']");
    private By btnIncluirTresIntermediarias = By.id("opcoes-financ-acao-plano-ate-3-intermediarias");
    private By btnIncluirAteSeisIntermediarias = By.id("opcoes-financ-acao-seis-intermediarias");
    private By modalInclusaoIntermediarias = By.xpath("//app-intermediarias-pos-calculo");
    private By btnCancelarInclusaoIntermediarias = By.id("intermediarias-pos-calculo-cancelar");
    private By btnConcluirInclusaoIntermediarias = By.id("intermediarias-pos-calculo-concluir");

    private By modalAlterarVencimentoIntermediarias = By.xpath("//mat-dialog-container//*[contains(text(), 'Parcelas intermediárias')]");
    private By comboDiaPagamentoIntermediarias = By.id("dia-pagamento");
    private By comboVencimentoParcelaIntermediarias = By.id("vencimento-primeira-parcela");
    private By btnContinuarAlteracaoVencimentoIntermediaria = By.xpath("//button[text()=' Continuar ' or text()='Continuar'] ");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Verifications.wait(1);
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblSimulacao);
    }

    public void clicarAbaParcela() {
        Verifications.verifyElementIsClickable(abaParcela);
        Action.clickOnElement(abaParcela);
    }

    public void clicarAbaResidual() {
        Verifications.verifyElementIsClickable(abaResidual);
        Action.clickOnElement(abaResidual);
    }

    public void clicarAbaPrazo() {
        Verifications.verifyElementIsClickable(abaPrazo);
        Action.clickOnElement(abaPrazo);
    }

    public void inserirValorVeiculo(String valor) {
        Util.preencherCampoTexto(txtValorVeiculo, valor);
    }

    public void inserirValorEntrada(String valor) {
        Util.preencherCampoTexto(txtValorEntrada, valor);
    }

    public void inserirValorParcela(String valor) {
        if (valor != null) {
            Util.preencherCampoTexto(txtValorParcela, valor);
        }
    }

    public void inserirValorResidual(String valor) {
        if (valor != null) {
            Util.preencherCampoTexto(txtValorResidual, valor);
        }
    }

    public void inserirPrazo(String prazo) {
        if (prazo != null) {
            Verifications.verifyElementIsClickable(comboPrazo);
            Action.clickOnElement(comboPrazo);
            Util.selecionarItemMatOption(Util.formatarSomenteNumeros(prazo));
        }
    }

    private void selecionarSubsidioTaxa() {
        Action.clickOnElement(radioSubsidioTaxa);
        Action.clickOnElement(radioSubsidioTaxa); //Duplo clique pois ha um problema com o componente no google chrome
    }

    private void selecionarSubsidioValor() {
        Action.clickOnElement(radioSubsidioValor);
        Action.clickOnElement(radioSubsidioValor); //Duplo clique pois ha um problema com o componente no google chrome
    }

    public void inserirTaxaSubsidio(String valor) {
        if (valor != null) {
            selecionarSubsidioTaxa();
            Util.preencherCampoTexto(txtTaxaSubsidio, valor);
            getDriver().findElement(txtTaxaSubsidio).sendKeys(Keys.TAB);
        }
    }

    public void inserirValorSubsidio(String valor) {
        if (valor != null) {
            selecionarSubsidioValor();
            Util.preencherCampoTexto(txtValorSubsidio, valor);
            getDriver().findElement(txtValorSubsidio).sendKeys(Keys.TAB);
        }
    }

    public void inserirPrazoSubsidio(String prazo) {
        if (prazo != null) {
            Verifications.verifyElementIsClickable(comboPrazoSubsidio);
            Action.clickOnElement(comboPrazoSubsidio);
            Util.selecionarItemMatOption(Util.formatarSomenteNumeros(prazo));
        }
    }

    public void clicarCalcular() {
        Util.scrollDown(250);
        Verifications.verifyElementDoesNotExist(btnCalcularInativo);
        Action.clickOnElement(btnCalcular);
    }

    public void validarPlanoDeFinanciamento() {
        Util.aguardarLoaderDirect();
        Util.scrollDown(450);
        Verifications.verifyElementIsVisible(comboPlanoDeFinanciamento);
        Report.takeScreenShot();
    }

    //INTERMEDIARIAS
    public void visualizarIntermediariasSimulacao() {
        Util.aguardarLoaderDirect();
        Util.scrollDown(150);
        Verifications.verifyElementIsVisible(textListaDeIntermediarias);
        for (int x = 0; x < getDriver().findElements(textListaDeIntermediarias).size(); x++) {
            Report.info("" + getDriver().findElements(textListaDeIntermediarias).get(x).getText() + "\n");
        }
        Report.takeScreenShot();
    }

    public void aceitarSugestaoTresIntermediarias() {
        Util.scrollDown(100);
        Verifications.verifyElementIsVisible(btnIncluirTresIntermediarias);
        Report.takeScreenShot();
        Action.clickOnElement(btnIncluirTresIntermediarias);
    }

    public void clicarInserirAteSeisIntermediarias() {
        Util.scrollDown(100);
        Verifications.verifyElementIsVisible(btnIncluirAteSeisIntermediarias);
        Report.takeScreenShot();
        Action.clickOnElement(btnIncluirAteSeisIntermediarias);
    }

    public void visualizarModalInsercaoIntermediarias() {
        Util.aguardarLoaderDirect();
        Verifications.verifyElementIsVisible(modalInclusaoIntermediarias);
        Report.takeScreenShot();
    }

    public void incluirIntermediariaRandomModalIntermediaria(String valorIntermediaria) {
        if (valorIntermediaria != null) {
            By btnAdicionarIntermediariaModal = By.xpath("//app-intermediarias-pos-calculo//*[contains(@id, 'add-intermediaria')][text()=' add_circle_outline ']");
            By txtValorIntermediaria = By.xpath("//app-intermediarias-pos-calculo//input");

            int qntDeItens = getDriver().findElements(btnAdicionarIntermediariaModal).size();
            Random rn = new Random();
            int itemSelecao = rn.nextInt((qntDeItens + 1) - 1) + 1;
            getDriver().findElements(btnAdicionarIntermediariaModal).get(itemSelecao-1).click();

            Util.preencherCampoTexto(txtValorIntermediaria, Util.formatarSomenteNumeros(valorIntermediaria));
            getDriver().findElement(txtValorIntermediaria).sendKeys(Keys.ENTER);
            Util.aguardarLoaderDirect();
            Util.scrollDown(50);
        }
    }

    public void clicarConcluirModalInsercaoIntermediarias(){
            Verifications.verifyElementIsVisible(btnConcluirInclusaoIntermediarias);
            Report.takeScreenShot();
            Action.clickOnElement(btnConcluirInclusaoIntermediarias);
    }

    public void clicarBotaoProximo() {
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de Simulacao");
    }

    public void alterarDiaPagamentoIntermediarias(String dia){
        Verifications.verifyElementIsVisible(modalAlterarVencimentoIntermediarias);
        Action.clickOnElement(comboDiaPagamentoIntermediarias);
        Util.selecionarItemMatOption(dia);
    }

    public void alterarVencimentoIntermediarias(String vencimento){
        if (vencimento != null) {
            if (vencimento.isEmpty()) {
                Action.clickOnElement(comboVencimentoParcelaIntermediarias);
                String primeiroMesDisponivel = "//*[contains(@class, 'mat-option ng-star-inserted mat')]";
                Action.clickOnElement(By.xpath(primeiroMesDisponivel));
            } else {
                Action.clickOnElement(comboVencimentoParcelaIntermediarias);
                Util.selecionarItemMatOption(vencimento);
            }
        }
    }

    public void concluirAlteracaoVencimentoIntermediarias(){
        Report.takeScreenShot();
        Action.clickOnElement(btnContinuarAlteracaoVencimentoIntermediaria);
    }

}
