package pages.comunsNoSistema;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

@Log4j2
public class Breadcrumb extends DriverManager implements CommonTestingType {

    private By breadcrumb = By.xpath("//drag-scroll");
    private By stepConfiguracao = By.xpath("//drag-scroll//img[contains(@src, 'ico-configuration-on.svg')]");
    private By stepVeiculo = By.xpath("//drag-scroll//img[contains(@src, 'ico-car-on.svg')]");
    private By stepSimulacao = By.xpath("//drag-scroll//img[contains(@src, 'ico-calc-on.svg')]");

    @Override
    public boolean isPresent() {
        return Verifications.verifyElementIsVisible(breadcrumb);
    }

    public void clicarStepConfiguracao(){
        Util.aguardarLoaderDirect();
        Verifications.verifyElementIsClickable(stepConfiguracao);
        Report.takeScreenShot();
        Action.clickOnElement(stepConfiguracao);
        log.info("Clicado no Step de Configuracao do Breadcrumb");
    }

    public void clicarStepVeiculo(){
        Verifications.verifyElementIsClickable(stepVeiculo);
        Report.takeScreenShot();
        Action.clickOnElement(stepVeiculo);
        log.info("Clicado no Step de Veiculo do Breadcrumb");
    }

    public void clicarStepSimulacao(){
        Verifications.verifyElementIsClickable(stepSimulacao);
        Report.takeScreenShot();
        Action.clickOnElement(stepSimulacao);
        log.info("Clicado no Step de Simulacao do Breadcrumb");
    }
}
