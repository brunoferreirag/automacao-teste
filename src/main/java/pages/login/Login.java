package pages.login;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Proposta;
import support.Verifications;

import java.util.HashMap;

@Log4j2
public class Login extends DriverManager implements CommonTestingType {

    private By lblErrorMsg = By.xpath("//*[contains(text(),'Problemas com o login do usuário')]");
    private By lblPaginaLogin = By.xpath("//div[contains(text(),'LOGIN DE')] | //h1[contains(text(),'LOGIN')]");
    private By txtUsuario = By.xpath("//input[@id='cpf']");
    private By txtSenha = By.xpath("//input[@id='senha']");
    private By btnAcessar = By.xpath("//button[text()='acessar' or text()='ACESSAR']");

    @Override
    public boolean isPresent() {
        return Verifications.verifyElementIsVisible(lblPaginaLogin);
    }

    public void acessaAplicacao(){
        getDriver().get(configuration.url());
        Report.takeScreenShot();
        log.info("Acesso a aplicacao efetuado com sucesso");
    }

    public void executaLogin(HashMap data){
        Action.setText(txtUsuario,data.get("usuario"));
        getDriver().findElement(txtSenha).sendKeys((CharSequence) data.get("senha"));
        Report.takeScreenShot();
        Action.clickOnElement(btnAcessar);
        log.info("Login na aplicacao efetuado com sucesso");
        Verifications.wait(2);
    }

    public boolean isErrorMsg(){
        Report.takeScreenShot();
        return Verifications.verifyElementIsClickable(lblErrorMsg);
    }

}
