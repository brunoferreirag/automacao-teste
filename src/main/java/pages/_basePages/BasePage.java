package pages._basePages;


import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import support.Utils.Proposta;
import support.browser.BrowserManager;
import support.documents.Documents;
import java.util.List;
import java.util.Locale;
import static support.report.Report.takeScreenShot;

public class BasePage extends BrowserManager {

    Faker faker = new Faker(new Locale("pt-BR"));

    //String btnProximo = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    String btnProximo = "#proximo";
    String btnProximoSimulacao = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    String stepConfiguracao = "//drag-scroll//img[contains(@src, 'ico-configuration-on.svg')]";
    String stepVeiculo = "//drag-scroll//img[contains(@src, 'ico-car-on.svg')]";
    String stepSimulacao = "//drag-scroll//img[contains(@src, 'ico-calc-on.svg')]";
    String btnCalcular = "//button[text()='CALCULAR']";
    String inputSeguro = "//*[@id='inserir']//*[contains(text(),'Não quero inserir um seguro')]";

    String btnFarol = "//*[contains(@class, 'row cliente click')]//*[contains(@class, 'id-card')]";
    String txtDocumento = "//mat-dialog-container//input[contains(@id, 'cpf-cnpj')]";
    String txtNome = "//mat-dialog-container//input[contains(@id, 'nome')]";
    String txtEmail = "//mat-dialog-container//input[contains(@id, 'email')]";
    String txtCelular = "//mat-dialog-container//input[contains(@id, 'celular')]";
    String btnCancelar = "//*[contains(@class, 'mat-dialog-actions')]//button[contains(text(), 'Cancelar')]";
    String btnValidar = "//*[contains(@class, 'mat-dialog-actions')]//button[contains(text(), 'Validar')]";
    String btnAvatar = "#user";
    String btnMeuPerfil= "//a[contains(text(),'Meu perfil')]";

    public void clicarBtnProximo(){
        page.click(btnProximo);
    }

    public void clicarStepConfiguracao(){
        page.click(stepConfiguracao);
        takeScreenShot();
    }

    public void clicarStepVeiculo(){
        page.click(stepVeiculo);
        takeScreenShot();
    }

    public void clicarStepSimulacao(){
        page.click(stepSimulacao);
        takeScreenShot();
    }

    public void clicarBtnProximoSimulacao() {
        page.click(btnProximoSimulacao);
    }

    public void clicarBtnCalcular() {
        page.click(btnCalcular);
        takeScreenShot();
    }


    public void clicarBtnProximoSimulacao1() {
        page.click(btnProximoSimulacao);
    }

    public void clicarBtnProximoSimulacao2() {
        page.click(btnProximoSimulacao);
    }

    public void clicarBtnFarol(){
        page.click(btnFarol);
        page.waitForTimeout(2000);
    }

    public void clicarBtnCancelar(){
        page.click(btnCancelar);
    }

    public void clicarBtnValidar(){
        page.click(btnValidar);
        page.waitForTimeout(2000);
    }

    public void preencherCpf(String documento) {
            page.type(txtDocumento, documento);
            page.waitForTimeout(3000);
            page.press(txtDocumento, "Tab");
    }

    public void preencherCpf() {
            //String cpfGerado = Documents.getCpf(false);
            //Proposta.setCpfCnpjProponente(cpfGerado);
            page.type(txtDocumento, Documents.getCpf(false));
            page.press(txtDocumento, "Tab");
    }

    public void preencherCnpj(String documento) {
        page.type(txtDocumento, documento);
        page.waitForTimeout(3000);
        page.press(txtDocumento, "Tab");
    }

    public void preencherCnpj() {
        //String cnpjGerado = Documents.getCnpj(false);
        //Proposta.setCpfCnpjProponente(cnpjGerado);
        page.type(txtDocumento, Documents.getCnpj(false));
        page.press(txtDocumento, "Tab");
    }

    public void preencherNome() {
            page.type(txtNome, faker.name().fullName());
    }


    public void preencherEmail() {
            page.type(txtEmail, "guigft@email.com");
    }

    public void preencherCelular() {
            page.type(txtCelular, "11983915851");
    }


    public void clicarAvatar() {
        page.click(btnAvatar);
    }

    public void clicarMeuPerfil() {
        page.click(btnMeuPerfil);
        page.waitForTimeout(5000);
    }

    public void calculoSemSeguro(){
        boolean visible = page.isVisible("app-seguro-modal");
        if(visible){
            page.click("#link-calculo-sem-seguro");
        }
    }
}
