package pages.envioProposta;

import driver.DriverManager;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Proposta;
import support.Util;
import support.Verifications;

public class ConfirmacaoEnvio extends DriverManager implements CommonTestingType {

    private By lblConfirmacaoEnvio = By.xpath("//h4[contains(text(),'Proposta')]");

    private By txtNumeroProposta = By.xpath("//*[@class='proposta']");

    private By txtMensagem = By.xpath("//*[@class=\"pre-proposta\"]//div[@class='row'][2]//*[contains(@class, \"titulo centro\")]");

    private By btnConsultaProposta = By.id("btnConsultarPrePropostas");
    private By btnNovaSimulacao = By.id("btnNovaSimulacao");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        return Verifications.verifyElementIsVisible(lblConfirmacaoEnvio);
    }

    private void imprimirProposta(){
        Proposta.setProposta(Action.getText(txtNumeroProposta));
        Report.info("Proposta: "+Proposta.getProposta());
    }

    public void validarMensagemEnvio(String mensagem){
        //Sucesso = Sua proposta foi enviada!
        imprimirProposta();
        Verifications.verifyTextsExistingElement(txtMensagem, mensagem);
        Report.takeScreenShot();
    }
}
