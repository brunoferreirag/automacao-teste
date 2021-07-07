package pages.selecaoLoja;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

import java.util.HashMap;

@Log4j2
public class SelecaoLoja extends DriverManager implements CommonTestingType {

    private By lblBemVindo = By.xpath("//div[contains(text(),'Bem-vindo(a),')]");
    private By comboConcessionaria = By.xpath("//div[contains(@class, 'selecao-loja-content')]//input[@type='text']");
    private By btnProximo = By.xpath("//button[@class=\"btn ativo\" and @id=\"proximo\"]");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblBemVindo);
    }

    public void selecionarConcessionaria(HashMap data){
        Verifications.verifyElementIsClickable(comboConcessionaria);
        Action.clickOnElement(comboConcessionaria);
        getDriver().findElement(comboConcessionaria).sendKeys((CharSequence) data.get("descricao"), Keys.ENTER);
        Util.aguardarLoaderDirect();
        Verifications.wait(2);
        Report.takeScreenShot();
        log.info("Loja selecionada com sucesso");
    }

    public void botaoProximo() {
        Verifications.verifyElementIsClickable(btnProximo);
        Action.clickOnElement(btnProximo);
        log.info("Clicado no próximo habilitado na seleção de concessionaria");
    }

}
