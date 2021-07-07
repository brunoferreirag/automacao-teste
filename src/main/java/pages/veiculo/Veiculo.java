package pages.veiculo;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Verifications;
import support.Util;

import java.util.HashMap;


@Log4j2
public class Veiculo extends DriverManager implements CommonTestingType {

    private By lblVeiculo = By.xpath("//h4[contains(text(),'Veículo')]");

    private By btnCicloSim = By.xpath("//*[@name='tipo-produto']//*[text()='Sim']");
    private By btnCicloNao = By.xpath("//*[@name='tipo-produto']//*[text()='Não']");

    private By btnTabelaFlexSim = By.xpath("//*[@id='tabela-flex']//*[text()='Sim']");
    private By btnTabelaFlexNao = By.xpath("//*[@id='tabela-flex']//*[text()='Não']");

    private By comboMarca = By.id("marca");
    private By comboAnoFab = By.id("anoFabricacao");
    private By comboAnoMod = By.id("ano-modelo");
    private By comboModeloVersao = By.id("modelo");
    private By txtComboTabela = By.xpath("//*[@id='plano']//input");
    private By comboTabela = By.xpath("//*[@id='plano']");
    private By comboUfEmplacamento = By.id("uf-emplacamento");
    private By comboCodSimulacao = By.id("codigo-simulacao");
    private By comboDiaPagamento = By.id("dia-parcelas");
    private By comboVencimentoParcela = By.id("primeira-parcela");
    private By comboCestaServico = By.id("cesta-servicos");

    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblVeiculo);
    }

    public void selecionarCicloToyota(String opcao) throws Exception {
        Verifications.wait(2);
        Util.aguardarLoaderDirect();
        if (opcao.equalsIgnoreCase("SIM")) {
            Action.clickOnElement(btnCicloSim);
            log.info("Selecionado Ciclo Toyota SIM");
        } else if (opcao.equalsIgnoreCase("NAO") || opcao.equalsIgnoreCase("NÃO")) {
            Action.clickOnElement(btnCicloNao);
            log.info("Selecionado Ciclo Toyota NAO");
        } else {
            log.info("Valor invalido informado para selecao de Ciclo Toyota - " + opcao);
            throw new Exception("Valor informado invalido: " + opcao);
        }
    }

    public void selecionarMarca(String marca) {
        Action.clickOnElement(comboMarca);
        Util.selecionarItemMatOption(marca);
    }

    public void selecionarAnoFabricacao(String anoFab) {
        Action.clickOnElement(comboAnoFab);
        Util.selecionarItemMatOption(anoFab);
    }

    public void selecionarAnoModelo(String anoModelo) {
        Action.clickOnElement(comboAnoMod);
        Util.selecionarItemMatOption(anoModelo);
    }

    public void selecionarModeloVersao(String modeloVersao) {
        Action.clickOnElement(comboModeloVersao);
        Util.selecionarItemDropdownPanel(modeloVersao);
    }

    public void selecionarTabelaFlex(String opcao) {
        if (opcao != null) {
            if (opcao.equalsIgnoreCase("SIM")) {
                Action.clickOnElement(btnTabelaFlexSim);
                log.info("Selecionado Tabela Flex SIM");
            } else if (opcao.equalsIgnoreCase("NAO") || opcao.equalsIgnoreCase("NÃO")) {
                Action.clickOnElement(btnTabelaFlexNao);
                log.info("Selecionado Tabela Flex NAO");
            }
        }
    }

    public void selecionarTabela(HashMap tabela) {
        Action.clickOnElement(comboTabela);
        Action.setText(txtComboTabela, tabela.get("PLANO").toString());
        Util.selecionarItemDropdownPanel(tabela.get("PLANO").toString());
    }

    public void selecionarUfEmplacamento(String UF) {
        Action.clickOnElement(comboUfEmplacamento);
        Util.selecionarItemDropdownPanel(UF);
    }

    public void selecionarCodigoSimulacao(String codigo) {
        if (codigo != null) {
            Action.clickOnElement(comboCodSimulacao);
            Util.selecionarItemMatOption(codigo);
        }
    }

    public void selecionarDiaPagamento(String dia) {
        Action.clickOnElement(comboDiaPagamento);
        Util.selecionarItemMatOption(dia);
    }

    public void selecionarPrimeiroVencimento(String vencimento) {
        if (vencimento != null) {
            if (vencimento.isEmpty()) {
                Action.clickOnElement(comboVencimentoParcela);
                String primeiroMesDisponivel = "//*[contains(@class, 'mat-option ng-star-inserted mat')]";
                Action.clickOnElement(By.xpath(primeiroMesDisponivel));
            } else {
                Action.clickOnElement(comboVencimentoParcela);
                Util.selecionarItemMatOption(vencimento);
            }
        }
    }

    public void selecionarCestaDeServico(String cesta) {
        Action.clickOnElement(comboCestaServico);
        Util.selecionarItemMatOption(cesta);
    }

    public void clicarBotaoProximo() {
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de Veiculo");
    }
}
