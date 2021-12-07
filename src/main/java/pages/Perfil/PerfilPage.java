package pages.Perfil;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import support.Utils.Proposta;
import support.browser.BrowserManager;
import support.documents.Documents;


import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static support.report.Report.takeScreenShot;

public class PerfilPage extends BrowserManager {

    String linkTrocarImagem = "//div[contains(text(),'Trocar imagem')]";
    String linkRemoverFoto = "//div[contains(text(),'Remover foto')]";
    String linkAlterarImagem = "//div[contains(text(),'Alterar imagem')]";
    String btnEditar = "//button[@id='btnDireito']";
    String btnCancelar= "//button[@id='btnEsquerdo']";
    String btnSalvarImagem = "//button[contains(text(),'SALVAR')]";
    String btnSim = "//mat-dialog-container//button[contains(text(), 'Sim')]";
    String btnNao = "//mat-dialog-container//button[contains(text(), 'Não')]";

    String emailFake = Documents.getEmail().toUpperCase();
    String celularFake = 119 + Documents.getNumero(8);
    String txtEmail = "#email";
    String txtEmailSalvo = "div[class*='dados-usuarios']>div>div:nth-child(2)>div:nth-child(2)";
    String txtCelular = "#celular";
    String txtCelularSalvo = "div[class*='dados-usuarios']>div>div:nth-child(3)>div:nth-child(2)";
    String btnSalvar = "//button[@id='btnDireito']";





    public void clicarTrocarImagem() {
        //page.click(linkTrocarImagem);
        page.setInputFiles("input#btn-incluir-imagem-avatar", Paths.get("src/main/java/support/documents/testeimg.jpg"));

    }

    public void clicarSalvarImagem() {
        page.click(btnSalvarImagem);
    }

    public void clicarRemoverImagem() {
        page.click(linkRemoverFoto);

    }

    public void clicarRemoverImagemSim() {
        page.click(btnSim);
    }

    public void clicarAlterarImagemSim() {
        page.click(btnSim);
    }

    public void clicarAlterarImagem() {
        page.click(linkAlterarImagem);
    }

    public void validarMensagem(String msg) {
        String content = page.textContent("//app-snackbar//*[text()='" + msg + "' or text()=' " + msg + " ']");
        assertEquals(msg, content);
        takeScreenShot();
    }

    public void incluirImagem() {
        if(page.isVisible(linkRemoverFoto)){
            page.click(linkRemoverFoto);
            page.click(btnSim);
        }
        page.waitForTimeout(2000);
        page.setInputFiles("input#btn-incluir-imagem-avatar", Paths.get("src/main/java/support/documents/testeimg.jpg"));

    }

    public void clicarEditar() {
        page.click(btnEditar);
    }

    public void inserirEmail() {
        page.press(txtEmail, "Control+a");
        page.type(txtEmail, emailFake);
    }

    public void salvarPerfil(){
        page.click(btnSalvar);
    }

    public void validarEmail() {
        String content = page.textContent(txtEmailSalvo);
        assertEquals(emailFake, content);
        takeScreenShot();
    }

    public void inserirCelular() {
        page.press(txtCelular, "Control+a");
        page.type(txtCelular, celularFake);
    }

    public void validarCelular() {
        String content = page.textContent(txtCelularSalvo);
        assertEquals(celularFake, content);
        takeScreenShot();
    }

}
