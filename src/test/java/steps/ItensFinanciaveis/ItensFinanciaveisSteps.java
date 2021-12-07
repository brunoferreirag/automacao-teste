package steps.ItensFinanciaveis;
import cucumber.api.java.pt.*;
import pages.Simulacao.SimulacaoPage;
import support.Utils.Util;
import cucumber.api.java.pt.E;
import java.util.Map;

public class ItensFinanciaveisSteps {

    private SimulacaoPage simulacaoPage;

    public ItensFinanciaveisSteps() {
        simulacaoPage = new SimulacaoPage();
    }

    @E("clico na opção de incluir Itens Financiáveis")
    public void adicionarItem() {
        simulacaoPage.addItemFinanciavel();
    }

    @E("Seleciono o seguinte {string}")
    public void selecionoOSeguinte(String item) {
        simulacaoPage.selecionarItemFinanciavel(item);
    }

    @E("informo o valor do item")
    public void informoOValorDoItem(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.inserirValorItem(data.get("VALOR DO ITEM"));
    }

    @E("clico em adicionar")
    public void clicoEmAdicionar() { simulacaoPage.adicionartemFinanciavel(); }

    @Entao("o item financiavel é adicionado no carrinho")
    public void oItemFinanciavelÉAdicionadoNoCarrinho() {
        simulacaoPage.validarItemCarrinho();
    }

    @E("resolvo editar o valor do item")
    public void resolvoEditarOValorDoItem(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.EditarvalorItem();
        simulacaoPage.inserirValorItem(data.get("VALOR DO ITEM"));
    }

    @Então("o valor é atualizado no carrinho")
    public void oValorÉAtualizadoNoCarrinho() { simulacaoPage.validarItemCarrinho(); }

    @E("a mensagem {string} é exibida")
    public void aMensagemÉExibida(String msg) {
        simulacaoPage.validarMensagem(msg);
    }

    @E("Seleciono o seguinte item")
    public void selecionoOSeguinteItem(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.selecionarItemFinanciavel(data.get("ITEM"));
    }

    @E("clico em incluir mais um item")
    public void clicoEmIncluirMaisUmItem() {
        simulacaoPage.addItemFinanciavel();
    }

    @Então("verifico que o seguinte item não foi listado novamente")
    public void verificoQueOSeguinteItemNãoFoiListadoNovamente(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        simulacaoPage.validarItensNaoListados(data.get("ITEM"));
    }

    @Quando("clico em excluir o item")
    public void clicoEmExcluirOItem() {
        simulacaoPage.excluirItemFinanciavel();
    }

    @Então("o sistema exclui o item e a mensagem {string} é exibida")
    public void oSistemaExcluiOItemEAMensagemEExibida(String msg) {
        simulacaoPage.validarMensagem(msg);
    }

}
