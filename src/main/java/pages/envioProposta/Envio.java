package pages.envioProposta;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

@Log4j2
public class Envio extends DriverManager implements CommonTestingType {

    private By lblEnvio = By.xpath("//h4[contains(text(),'Enviar')]");

    private By comboConsultor = By.id("consultor");
    private By comboResponsavel = By.id("responsavel");

    private By txtInformacoesComplementares = By.xpath("//textarea");

    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    private By btnEnviarPrePropostaAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='ENVIAR PRÉ-PROPOSTA']");
    private By btnEnviarPrePropostaInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='ENVIAR PRÉ-PROPOSTA']");


    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblEnvio);
    }

    public void selecionarConsultor(String consultor) {
        if (consultor != null) {
            if(consultor.equalsIgnoreCase("Primeiro")){
                getDriver().findElements(comboConsultor).get(1).click();
                getDriver().findElement(By.xpath("//ng-dropdown-panel//div//div//div[1]")).click();
            }else {
                getDriver().findElements(comboConsultor).get(1).click();
                Util.selecionarItemDropdownPanel(consultor.toUpperCase());
            }
        }
    }

    public void selecionarResponsavel(String responsavel){
        if (responsavel != null) {
            if(responsavel.equalsIgnoreCase("Primeiro")){
                getDriver().findElements(comboResponsavel).get(1).click();
                getDriver().findElement(By.xpath("//ng-dropdown-panel//div//div//div[1]")).click();
            }else {
                getDriver().findElements(comboResponsavel).get(1).click();
                Util.selecionarItemDropdownPanel(responsavel.toUpperCase());
            }
        }
    }

    public void clicarBotaoEnviarPreProposta() {
        Verifications.verifyElementIsClickable(btnEnviarPrePropostaAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnEnviarPrePropostaAtivo);
        log.info("Clicado no botao Envia Pre Proposta da tela de Envio");
        Util.aguardarLoaderDirect();
    }

    public void clicarBotaoProximo() {
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de Veiculo");
    }

}
