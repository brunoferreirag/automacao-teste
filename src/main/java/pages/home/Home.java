package pages.home;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

@Log4j2
public class Home extends DriverManager implements CommonTestingType {

    private By lblBemVindo = By.xpath("//div[@class='home-content']");
    private By btnFacaUmaSimulacao = By.id("facaUmaSimulacao");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblBemVindo);
    }

    public void clicarFacaUmaSimulacao(){
        Verifications.verifyElementIsClickable(btnFacaUmaSimulacao);
        Report.takeScreenShot();
        Action.clickOnElement(btnFacaUmaSimulacao);
        log.info("Clicado no Faca Uma Simulacao na tela Home");
    }

}
