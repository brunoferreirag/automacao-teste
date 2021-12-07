package pages.EnvioProposta;


import support.browser.BrowserManager;
import static org.junit.Assert.assertEquals;
import static support.report.Report.takeScreenShot;

public class ConfirmacaoEnvioPage extends BrowserManager {

    String btnConsultarPropostas = "#btnConsultarPropostas";
    String btnPesquisarProposta = "//mat-icon[text()='search']";
    String btnVisualizarProposta = "div[class*='btb-consulta__resultado--acao no-margin espacado col-2']>div:nth-child(2)>span>img";
    String txtBuscaProposta = "input[name='cpf-ou-id']";
    String numeroProposta;



    String txtMensagem = ("//*[@class='pre-proposta']//div[@class='row'][2]//*[contains(@class, 'titulo')]");

    public void validarMensagemEnvio(String msg) {
        String content = page.textContent(txtMensagem);
        assertEquals(msg, content);
        takeScreenShot();

    }

    public void consultarPropostas(){
        numeroProposta = page.textContent("span[class='proposta']");
        page.click(btnConsultarPropostas);
        page.waitForTimeout(5000);
    }

    public void ralizarBuscaProposta(){
        page.type(txtBuscaProposta,numeroProposta);
        page.click(btnPesquisarProposta);
        page.waitForTimeout(2000);
        page.click(btnVisualizarProposta);
    }

    public void verificarItem(String Item){
        String itemSelecionado = page.textContent("#lista-itens-financiaveis>div>div>div>div>div>span");
        assertEquals(itemSelecionado,Item);
        takeScreenShot();
    }

    public void verificarValorItem(String Valor){
        String valorItemInformado = page.textContent("#lista-itens-financiaveis>div>div>div>div:nth-child(3)>div>span");
        assertEquals(valorItemInformado.substring(3,11),Valor);
        takeScreenShot();
    }
}
