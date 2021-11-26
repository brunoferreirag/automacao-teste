package steps.EnvioProposta;



import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.EnvioProposta.ConfirmacaoEnvioPage;
import support.Utils.Util;

import java.util.Map;

import static support.report.Report.takeScreenShot;

public class ConfirmacaoEnvioSteps {

    ConfirmacaoEnvioPage confirmacaoEnvioPage = new ConfirmacaoEnvioPage();

    @Entao("mensagem {string} deve ser exibida")
    public void mensagemDeveSerExibida(String msg) {
        Util.aguardarLoader();
        confirmacaoEnvioPage.validarMensagemEnvio(msg);

    }

    @E("ao clicar na opção de consultar propostas")
    public void aoClicarNaOpçãoDeConsultarPropostas() {
        confirmacaoEnvioPage.consultarPropostas();
    }

    @Quando("realizar a busca através do número da proposta")
    public void realizarABuscaAtravésDoNúmeroDaProposta() {
        confirmacaoEnvioPage.ralizarBuscaProposta();
    }

    @Então("o sistema exibe a proposta com o item financiavel e valor informados")
    public void oSistemaExibeAPropostaComOItemFinanciavelEValorInformados(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        confirmacaoEnvioPage.verificarItem(data.get("ITEM"));
        confirmacaoEnvioPage.verificarValorItem(data.get("VALOR"));
    }
}
