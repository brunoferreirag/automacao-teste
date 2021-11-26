package steps.FichaCadastral;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.FichaCadastral.FichaProponentePjPage;
import pages.Login.LoginPage;

import java.util.Map;

public class FichaProponentePjSteps {

    private FichaProponentePjPage fichaProponentePjPage;

    public FichaProponentePjSteps(){

        fichaProponentePjPage = new FichaProponentePjPage();
    }

    @E("preencho a Ficha Cadastral Proponente PJ")
    public void preenchoAFichaCadastralProponentePJ() {
        fichaProponentePjPage.preencherFichaProponentePj(0, 1, 0, 1, 0, 0);
    }

    @E("preencho a Ficha Cadastral Proponente PJ {string}")
    public void preenchoAFichaCadastralProponentePJ(String tipo) {
        fichaProponentePjPage.preencherFichaProponentePj(0, 0, 0, 0, 0, 0, tipo);
    }

    @E("preencho a Ficha Cadastral Proponente PJ {string} com - Socio {int}, Rep Legal {int}, Procurador {int}, Socio Rep {int}, Socio Procurador {int}, Rep Procurador {int}")
    public void preenchoAFichaCadastralProponentePJComSocioRepLegalProcuradorSocioRepSocioProcuradorRepProcurador(String cnpj, int socio, int repLegal, int procurador, int socioRep, int socioProcurador, int repProcurador) {
        fichaProponentePjPage.preencherFichaProponentePj(socio, repLegal, procurador, socioRep, socioProcurador, repProcurador, cnpj);
    }

    @E("preencho a Ficha Cadastral Proponente PJ com - Socio {int}, Rep Legal {int}, Procurador {int}, Socio Rep {int}, Socio Procurador {int}, Rep Procurador {int}")
    public void preenchoAFichaCadastralProponentePJComSocioRepLegalProcuradorSocioRepSocioProcuradorRepProcurador(int socio, int repLegal, int procurador, int socioRep, int socioProcurador, int repProcurador) {
        fichaProponentePjPage.preencherFichaProponentePj(socio, repLegal, procurador, socioRep, socioProcurador, repProcurador);
    }

    @E("preencho a Ficha Cadastral Proponente PJ - Enriquecimento {string}")
    public void preenchoAFichaCadastralProponentePJParaEnriquecimento(String tipo) {
        fichaProponentePjPage.preencherFichaProponentePj(0, 2, 0, 1, 0, 0);
        fichaProponentePjPage.gerarMassaPJ(tipo);
    }

    @E("gero massa PJ {string}")
    public void geroMassaPJ(String tipo) {
        fichaProponentePjPage.gerarMassaPJ(tipo);
    }

    @E("preencho a Ficha Cadastral Proponente PJ - Com Farol")
    public void preenchoAFichaCadastralProponentePJComFarol() {
        fichaProponentePjPage.preencherFichaProponentePjFarol(0, 2, 0, 1, 0, 0);
    }

    @E("preencho a Ficha Cadastral Proponente PJ com {int} socio e {int} representantes legais")
    public void preenchoAFichaCadastralProponentePJComRepresentantesLegais(int qtdeSocio, int qtdeRepresentante) {
        fichaProponentePjPage.preencherFichaProponentePj(qtdeSocio,qtdeRepresentante, 0, 0, 0, 0);
    }

    @Quando("resolvo editar os dados do Socio")
    public void resolvoEditarOsDadosDoSocio(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePjPage.editarQuadroExecutivo(data.get("NOME"),data.get("PARTICIPACAO"),data.get("CARGO"));
    }

    @Então("verifico que os dados do Socio foram atualizados")
    public void verificoQueOsDadosDoSocioForamAtualizados() {
        fichaProponentePjPage.validarSocioAlterado();
    }

    @Quando("excluir os dados do Socio")
    public void excluirOsDadosDoSocio() {
        fichaProponentePjPage.excluirQuadroExecutivo();
    }

    @Então("verifico que o Socio foi removido da ficha")
    public void verificoQueOSocioFoiRemovidoDaFicha() {
        fichaProponentePjPage.validarExclusaoSocio();
    }

    @E("preencho a Ficha Cadastral Proponente PJ Enriquecido - Com Farol")
    public void preenchoAFichaCadastralProponentePJEnriquecidoComFarol() {
        fichaProponentePjPage.preencherFichaProponentePj(0, 0, 0, 0, 0, 0,"proponente");
    }
}
