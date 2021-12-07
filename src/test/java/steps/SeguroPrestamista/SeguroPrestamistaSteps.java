package steps.SeguroPrestamista;

import cucumber.api.java.pt.*;
import pages.Simulacao.SimulacaoPage;
import support.Utils.Util;
import cucumber.api.java.pt.E;
import java.util.Map;

public class SeguroPrestamistaSteps {

    private SimulacaoPage simulacaoPage;
    public SeguroPrestamistaSteps() {
        simulacaoPage = new SimulacaoPage();
    }

    @E("deve permitir que o vendedor remova o seguro do carrinho")
    public void devePermitirQueOVendedorRemovaOSeguroDoCarrinho() {
        simulacaoPage.validarRemocaoTrue();
    }

    @Quando("clico na opção de remover")
    public void clicoNaOpçãoDeRemover() {
        simulacaoPage.removerSeguroPrestamista();
    }

    @Então("o Sistema exclui o seguro e exibe a mensagem {string}")
    public void oSistemaExcluiOSeguroEExibeAMensagem(String msg) {
        simulacaoPage.validarMensagem(msg);
    }

    @Então("verifico que o sistema incluiu automaticamente o seguro Prestamista ao carrinho")
    public void verificoQueOSistemaIncluiuAutomaticamenteOSeguroPrestamistaAoCarrinho(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.validarInclusaoPrestamista(data.get("SEGURO"));
    }

    @E("não deve permitir que o vendedor remova o seguro do carrinho")
    public void nãoDevePermitirQueOVendedorRemovaOSeguroDoCarrinho() {
        simulacaoPage.validarRemocaoFalse();
    }

    @E("expando a opção de Seguro no carrinho")
    public void expandoAOpçãoDeSeguroNoCarrinho() {
        simulacaoPage.expandirSeguroPrestamistaCarrinho();
    }
}
