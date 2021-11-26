package steps.Perfil;

import com.microsoft.playwright.Page;
import cucumber.api.java.pt.*;
import pages.Perfil.PerfilPage;
import pages.Simulacao.SimulacaoPage;
import pages._basePages.BasePage;
import support.Utils.Util;
import support.data.DataYaml;
import java.util.Map;

public class PerfilSteps {

    private PerfilPage perfilPage;

    public PerfilSteps() {
    perfilPage = new PerfilPage();
    }


    @E("realizo a troca da imagem")
    public void clicoEmTrocarImagem() {
        perfilPage.clicarTrocarImagem();
    }


    @Quando("clico em salvar edicao da imagem")
    public void clicoEmSalvarEdiçãoDaImagem() {
        perfilPage.clicarSalvarImagem();
    }

    @Quando("clico em remover imagem")
    public void clicoEmRemoverFoto() {
        perfilPage.clicarRemoverImagem();
        perfilPage.clicarRemoverImagemSim();
    }


    @E("confirmo a alteracao")
    public void confirmoAAlteracao() {
        perfilPage.clicarAlterarImagemSim();
    }

    @E("clico em Alterar Imagem")
    public void clicoEmAlterarImagem() {
        perfilPage.clicarAlterarImagem();
    }

    @Entao("mensagem {string} é exibida")
    public void mensagemÉExibida(String msg) {
        perfilPage.validarMensagem(msg);
    }

    @E("incluo a imagem")
    public void incluoAImagem() {
        perfilPage.incluirImagem();
    }

    @E("clico em editar")
    public void clicoEmEditar() {
        perfilPage.clicarEditar();
    }

    @E("insiro um email válido")
    public void insiroUmEmailValido() {
        perfilPage.inserirEmail();
    }

    @Quando("clico em salvar")
    public void clicoEmSalvar() {
        perfilPage.salvarPerfil();
    }

    @Entao("o email é salvo com sucesso")
    public void osEmailESalvoComSucesso() {
        perfilPage.validarEmail();
    }

    @E("insiro um celular válido")
    public void insiroUmCelularValido() {
        perfilPage.inserirCelular();
    }

    @Entao("o celular é salvo com sucesso")
    public void oCelularESalvoComSucesso() {
        perfilPage.validarCelular();
    }

}
