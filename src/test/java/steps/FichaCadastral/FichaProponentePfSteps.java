package steps.FichaCadastral;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import pages.FichaCadastral.FichaProponentePfPage;
import pages.FichaCadastral.FichaProponentePjPage;

import java.util.Map;

public class FichaProponentePfSteps {

    private FichaProponentePfPage fichaCadastralPFPage;

    public FichaProponentePfSteps(){

        fichaCadastralPFPage = new FichaProponentePfPage();
    }

    @Dado("preencho a Ficha Cadastral PF - Dados Gerais")
    public void preencho_a_ficha_cadastral_pf_dados_gerais(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.selecionarNacionalidade(data.get("NACIONALIDADE"));
        fichaCadastralPFPage.selecionarEstadoCivil(data.get("ESTADO CIVIL"));

    }

    @Dado("preencho a Ficha Cadastral PF - Contato")
    public void preencho_a_ficha_cadastral_pf_contato(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.preencherCelular(data.get("CELULAR"));
        fichaCadastralPFPage.preencherEmail(data.get("EMAIL"));

    }
    @Dado("preencho a Ficha Cadastral PF - Endereco Residencial")
    public void preencho_a_ficha_cadastral_pf_endereco_residencial(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.preencherNumeroResidencial(data.get("NUMERO"));

    }
    @Dado("preencho a Ficha Cadastral PF - Documentos")
    public void preencho_a_ficha_cadastral_pf_documentos(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.preencherRgRne(data.get("RG RNE"));
        fichaCadastralPFPage.preencherOrgaoEmissor(data.get("ORGAO EMISSOR"));
        fichaCadastralPFPage.selecionarUfEmissaoDoc(data.get("UF EMISSAO"));
        fichaCadastralPFPage.preencherDataEmissaoDoc(data.get("DATA EMISSAO"));
        fichaCadastralPFPage.preencherNomeMae(data.get("NOME DA MAE"));

    }
    @Dado("preencho a Ficha Cadastral PF - Dados Profissionais")
    public void preencho_a_ficha_cadastral_pf_dados_profissionais(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.selecionarProfissao(data.get("PROFISSAO"));
        fichaCadastralPFPage.selecionarOcupassaoProfissional(data.get("OCUPACAO"));
        fichaCadastralPFPage.preencherNomeEmpresa(data.get("NOME DA EMPRESA"));
        fichaCadastralPFPage.selecionarDataAdmissao(data.get("DATA ADMISSAO"));

    }
    @Dado("preencho a Ficha Cadastral PF - Endereco Profissional")
    public void preencho_a_ficha_cadastral_pf_endereco_profissional() {
        fichaCadastralPFPage.clicarLinkCopiarEnderecoResidencial();
    }
    @Dado("preencho a Ficha Cadastral PF - Dados do Conjuge")
    public void preenchoAFichaCadastralPFDadosDoConjuge(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        //Dados Conjuge
        fichaCadastralPFPage.preencherCpfConjuge(data.get("CPF"));
        fichaCadastralPFPage.preencherNomeConjuge(data.get("NOME COMPLETO"));
        fichaCadastralPFPage.preencherDataNascimentoConjuge(data.get("DATA NASCIMENTO"));
        //Documentos Conjuge
        fichaCadastralPFPage.preencherRgRneConjuge(data.get("RG RNE"));
        fichaCadastralPFPage.preencherOrgaoEmissoeConjuge(data.get("ORGAO EMISSOR"));
        //Dados Profissionais
        fichaCadastralPFPage.selecionaProfissaoConjuge(data.get("PROFISSAO"));
        fichaCadastralPFPage.selecionarOcupacaoProfissionalConjuge(data.get("OCUPACAO"));
        fichaCadastralPFPage.preencherNomeEmpresaConjuge(data.get("NOME DA EMPRESA"));
        fichaCadastralPFPage.selecionarDataAdmissaoConjuge(data.get("DATA ADMISSAO"));
    }
    @Dado("preencho a Ficha Cadastral PF - Renda")
    public void preencho_a_ficha_cadastral_pf_renda(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.preencherSalario(data.get("SALARIO"));
    }
    @Dado("preencho a Ficha Cadastral PF - Patrimonio")
    public void preencho_a_ficha_cadastral_pf_patrimonio(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.preencherPatrimonio(data.get("PATRIMONIO"));
    }
    @Dado("preencho a Ficha Cadastral PF - Bens")
    public void preenchoAFichaCadastralPFBens(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.selecionarVeiculoBens();
        fichaCadastralPFPage.preencherMarcaVeiculoBens(data.get("MARCA"));
        fichaCadastralPFPage.preencherModeloVeiculoBens(data.get("MODELO"));
        fichaCadastralPFPage.preencherPlacaBens(data.get("PLACA"));
    }
    @Dado("preencho a Ficha Cadastral PF - Dados Conta")
    public void preencho_a_ficha_cadastral_pf_dados_conta(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaCadastralPFPage.selecionarBanco(data.get("BANCO"));
        fichaCadastralPFPage.preencherAgencia(data.get("AGENCIA"));
        fichaCadastralPFPage.preencherContaCorrente(data.get("CONTA"));
    }

    

    //@E("preencho a Ficha Cadastral Proponente PF - Solteiro")
    //public void preenchoAFichaCadastralPFSolteiro() {
        
    //    fichaCadastralPFPage.preencherFichaProponentePf("SOLTEIRO");
    //}

    //@E("preencho a Ficha Cadastral Proponente PF - Casado")
    //public void preenchoAFichaCadastralPFCasado() {
    //    fichaCadastralPFPage.preencherFichaProponentePf("CASADO");
    //}


    @E("preencho a Ficha Cadastral Proponente PF {string}")
    public void preenchoAFichaCadastralProponentePF(String estadoCivil) {
        fichaCadastralPFPage.preencherFichaProponentePf(estadoCivil);
    }

   @E("preencho a Ficha Cadastral Proponente Enriquecido PF")
    public void preenchoAFichaCadastralProponenteEnriquecidoPF() {
       fichaCadastralPFPage.preencherFichaProponentePfEnriquecido();
    }

    @E("preencho a Ficha Cadastral Proponente PF - Com Farol {string}")
    public void preenchoAFichaCadastralProponentePFComFarol(String arg0) {
        fichaCadastralPFPage.preencherFichaProponentePfFarol(arg0);
    }

}
