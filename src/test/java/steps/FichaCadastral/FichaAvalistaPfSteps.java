package steps.FichaCadastral;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.FichaCadastral.FichaAvalistaPfPage;
import support.data.DataYaml;

import java.util.Map;

public class FichaAvalistaPfSteps {

    FichaAvalistaPfPage fichaAvalistaPfPage = new FichaAvalistaPfPage();

    @Dado("clico em Inserir Avalista - PF")
    public void clicoEmInserirAvalistaPF() {
        fichaAvalistaPfPage.clicarInserirAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Solteiro")
    public void preenchoAFichaDoAvalistaPFAvalistaSolteiro(int arg0) {
        fichaAvalistaPfPage.preencherFichaAvalistaPf("SOLTEIRO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalistas Solteiros")
    public void preenchoAFichaDoAvalistaPFAvalistasSolteiros(int arg0) {
        fichaAvalistaPfPage.preencherFichaAvalistaPf("SOLTEIRO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
        fichaAvalistaPfPage.clicarInserirAvalista();
        fichaAvalistaPfPage.preencherFichaAvalistaPf("SOLTEIRO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Casado")
    public void preenchoAFichaDoAvalistaPFAvalistaCasado(int arg0) {
        fichaAvalistaPfPage.preencherFichaAvalistaPf("CASADO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalistas Casados")
    public void preenchoAFichaDoAvalistaPFAvalistasCasados(int arg0) {
        fichaAvalistaPfPage.preencherFichaAvalistaPf("CASADO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
        fichaAvalistaPfPage.clicarInserirAvalista();
        fichaAvalistaPfPage.preencherFichaAvalistaPf("CASADO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Conjuge")
    public void preenchoAFichaDoAvalistaPFAvalistaConjuge(int arg0) {
        fichaAvalistaPfPage.preencherFichaAvalistaConjuge();
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Solteiro - {int} Avalista Conjuge")
    public void preenchoAFichaDoAvalistaPFAvalistaSolteiroAvalistaConjuge(int arg0, int arg1) {
        fichaAvalistaPfPage.inserirAvalistaConjuge("NAO");
        fichaAvalistaPfPage.preencherFichaAvalistaPf("SOLTEIRO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
        fichaAvalistaPfPage.clicarInserirAvalista();
        fichaAvalistaPfPage.inserirAvalistaConjuge("SIM");
        fichaAvalistaPfPage.preencherFichaAvalistaConjuge();
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Conjuge - {int} Avalista Casado")
    public void preenchoAFichaDoAvalistaPFAvalistaConjugeAvalistaCasado(int arg0, int arg1) {
        fichaAvalistaPfPage.inserirAvalistaConjuge("SIM");
        fichaAvalistaPfPage.preencherFichaAvalistaConjuge();
        fichaAvalistaPfPage.clicarSalvarAvalista();
        fichaAvalistaPfPage.clicarInserirAvalista();
        fichaAvalistaPfPage.inserirAvalistaConjuge("NAO");
        fichaAvalistaPfPage.preencherFichaAvalistaPf("CASADO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Solteiro - {int} Avalista Casado")
    public void preenchoAFichaDoAvalistaPFAvalistaSolteiroAvalistaCasado(int arg0, int arg1) {
        fichaAvalistaPfPage.preencherFichaAvalistaPf("SOLTEIRO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
        fichaAvalistaPfPage.clicarInserirAvalista();
        fichaAvalistaPfPage.preencherFichaAvalistaPf("CASADO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("seleciono Inserir Avalista Conjuge {string}")
    public void selecionoInserioAvalistaConjuge(String opcao) {
        fichaAvalistaPfPage.inserirAvalistaConjuge(opcao);
    }


    @E("preencho a Ficha do Avalista PF - {int} Avalista Enriquecido PF {string}")
    public void preenchoAFichaDoAvalistaPFAvalistaEnriquecidoSolteiroCPF(int arg, String tipo) {
        fichaAvalistaPfPage.preencherFichaAvalistaPfEnriquecido(DataYaml.getMapYamlValues("Massa", "massa PF").get(tipo));
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @E("preencho a Ficha do Avalista PF - {int} Avalista Enriquecido Casado PF {string}")
    public void preenchoAFichaDoAvalistaPFAvalistaEnriquecidoCasadoCPF(int arg0, String cpf) {
        fichaAvalistaPfPage.preencherFichaAvalistaPfEnriquecido(cpf);
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }


    @E("preencho a Ficha do Avalista Rep PF - {int} Avalista Casado")
    public void preenchoAFichaDoAvalistaRepPFAvalistaCasado(int arg0) {
        fichaAvalistaPfPage.preencherFichaRepAvalistaPf("CASADO");
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @Quando("informar o CPF de um Avalista já existente")
    public void informarOCPFDeUmAvalistaJáExistente(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaAvalistaPfPage.cpfDoAvalista(data.get("CPF AVALISTA"));
    }

    @Então("verifico se o sistema carregou corretamente todos os dados obrigatórios")
    public void verificoSeOSistemaCarregouCorretamenteTodosOsDadosObrigatórios() {
        fichaAvalistaPfPage.validarEnriquecimentoDeDados();
    }

    @Quando("resolvo editar os dados do avalista")
    public void resolvoEditarOsDadosDoAvalista(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaAvalistaPfPage.editarAvalista(data.get("NOME"), data.get("DATA DE NASCIMENTO"), data.get("UF"), data.get("MUNICIPIO"), data.get("CONTATO"), data.get("EMAIL"));
        fichaAvalistaPfPage.clicarSalvarAvalista();
    }

    @Então("verifico que o sistema alterou os dados do avalista")
    public void verificoQueOSistemaAlterouOsDadosDoAvalista() {
        fichaAvalistaPfPage.validarAvalistaAlterado();
    }

    @Quando("excluir os dados do avalista")
    public void excluirOsDadosDoAvalista() {
        fichaAvalistaPfPage.excluirAvalista();
    }

    @Então("verifico que o avalista foi removido da ficha")
    public void verificoQueOAvalistaFoiRemovidoDaFicha() {
        fichaAvalistaPfPage.validarExclusaoAvalista();
    }
}

