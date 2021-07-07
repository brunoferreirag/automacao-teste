package steps.FichaCadastral;

import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import pages.fichaCadastral.FichaProponentePf;
import report.Report;
import support.Util;

import java.util.Map;

public class FichaProponentePfSteps {

    FichaProponentePf fichaProponentePf = new FichaProponentePf();

    @E("eu estou na pagina de ficha cadastral pf")
    public void eu_estou_na_pagina_de_ficha_cadastral_pf() {
        fichaProponentePf.isPresent();
        Report.takeScreenShot();
    }

    @E("eu preencho a ficha do proponente pf solteiro com dados gerados")
    public void eu_preencho_a_ficha_do_proponente_pf_solteiro_com_dados_gerados() {
        fichaProponentePf.gerarFichaProponentePf("SOLTEIRO");
    }

    @E("eu preencho a ficha do proponente pf casado com dados gerados")
    public void eu_preencho_a_ficha_do_proponente_pf_casado_com_dados_gerados() {
        fichaProponentePf.gerarFichaProponentePf("CASADO");
    }

    @E("eu preencho os dados gerais do proponente pf")
    public void eu_preencho_os_dados_do_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        Util.aguardarLoaderDirect();
        //Dados Gerais
        fichaProponentePf.selecionarNacionalidade(data.get("NACIONALIDADE").toUpperCase());
        if (data.get("NATURALIDADE") != null) {
            fichaProponentePf.selecionarNaturalidade(data.get("NATURALIDADE").toUpperCase());
        }
        if ((data.get("MUNICIPIO") != null)) {
            fichaProponentePf.selecionarMunicipio(data.get("MUNICIPIO").toUpperCase());
        }
        if (data.get("ESTADO CIVIL").equalsIgnoreCase("SOLTEIRO")) {
            fichaProponentePf.selecionarEstadoCivil("Solteiro (a)");
        } else if (data.get("ESTADO CIVIL").equalsIgnoreCase("CASADO")) {
            fichaProponentePf.selecionarEstadoCivil("Casado (a)");
        }
        fichaProponentePf.selecionarRadioBeneficiarioFinal("SIM");
        Report.takeScreenShot();
    }

    @E("eu preencho o contato do proponente pf")
    public void eu_preencho_contato_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.preencherCelular(data.get("CELULAR"));
        if ((data.get("TELEFONE FIXO") != null)) {
            fichaProponentePf.preencherTelFixo(data.get("TELEFONE FIXO"));
        }
        fichaProponentePf.preencherEmail(data.get("EMAIL"));
    }

    @E("eu preencho o endereco residencial do proponente pf")
    public void eu_preencho_endereco_residencial_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.preencherNumeroResidencial(data.get("NUMERO"));
        Util.aguardarLoaderDirect();
        Util.scrollDown(250);
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
    }

//    @E("eu preencho o endereco de emplacamento do proponente pf")
//    public void eu_preencho_contato_proponente_pf(DataTable dataTable){
//        Map<String, String> data = dataTable.asMap(String.class, String.class);
//    }

    @E("eu preencho os documentos do proponente pf")
    public void eu_preencho_documentos_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.preencherRgRne(data.get("RG RNE"));
        fichaProponentePf.preencherOrgaoEmissor(data.get("ORGAO EMISSOR").toUpperCase());
        fichaProponentePf.selecionarUfEmissaoDoc(data.get("UF EMISSAO").toUpperCase());
        fichaProponentePf.preencherDataEmissaoDoc(data.get("DATA EMISSAO"));
        fichaProponentePf.preencherNomeMae(data.get("NOME MAE").toUpperCase());
    }

    @E("eu preencho os dados profissionais do proponente pf")
    public void eu_preencho_dados_profissionais_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.selecionarProfissao(data.get("PROFISSAO").toUpperCase());
        fichaProponentePf.selecionarOcupassaoProfissional(data.get("OCUPACAO").toUpperCase());
        fichaProponentePf.preencherNomeEmpresa(data.get("NOME EMPRESA").toUpperCase());
        fichaProponentePf.selecionarDataAdmissao("Mais de 5 anos");
        Util.scrollDown(50);
        Report.takeScreenShot();
    }

    @E("eu copio o endereco profissional do proponente pf")
    public void eu_copio_endereco_profissional_proponente_pf() {
        fichaProponentePf.clicarLinkCopiarEnderecoResidencial();
    }

//    @E("eu preencho os dados do conjuge do proponente pf")
//    public void eu_preencho_dados_do_conjuge_proponente_pf(DataTable dataTable) {
//
//        //Dados Conjuge
//        fichaProponentePf.preencherCpfConjuge(dataTable.cell(1, 0));
//        fichaProponentePf.preencherNomeConjuge(dataTable.cell(1, 1).toUpperCase());
//        fichaProponentePf.preencherDataNascimentoConjuge(dataTable.cell(1, 2));
//        //Documentos Conjuge
//        fichaProponentePf.preencherRgRneConjuge(dataTable.cell(1, 3));
//        fichaProponentePf.preencherOrgaoEmissoeConjuge(dataTable.cell(1, 4).toUpperCase());
//        //Dados Profissionais
//        fichaProponentePf.selecionaProfissaoConjuge(dataTable.cell(1, 5));
//        fichaProponentePf.selecionarOcupacaoProfissionalConjuge(dataTable.cell(1, 6));
//        fichaProponentePf.preencherNomeEmpresaConjuge(dataTable.cell(1, 7).toUpperCase());
//        fichaProponentePf.selecionarDataAdmissaoConjuge("Mais de 5 anos");
//        Util.scrollDown(50);
//        Report.takeScreenShot();
//    }

    @E("eu preencho a renda do proponente pf")
    public void eu_preencho_a_renda_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.preencherSalario(data.get("SALARIO"));
        if (data.get("SALARIO CONJUGE") != null) {
            fichaProponentePf.preencherSalarioConjuge(data.get("SALARIO CONJUGE"));
        }
    }

    @E("eu preencho o patrimonio do proponente pf")
    public void eu_preencho_patrimonio_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.preencherPatrimonio(data.get("PATRIMONIO"));
        Util.scrollDown(50);
        Report.takeScreenShot();
    }

//    @E("eu preencho os bens do proponente pf")
//    public void eu_preencho_bens_proponente_pf(DataTable dataTable) {
//        fichaProponentePf.selecionarVeiculoBens();
//        fichaProponentePf.preencherMarcaVeiculoBens(dataTable.cell(1, 0).toUpperCase());
//        fichaProponentePf.preencherModeloVeiculoBens(dataTable.cell(1, 1).toUpperCase());
//        fichaProponentePf.preencherPlacaBens(dataTable.cell(1, 2).toUpperCase());
//    }

    @E("eu preencho os dados bancarios do proponente pf")
    public void eu_preencho_dados_bancarios_proponente_pf(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        fichaProponentePf.selecionarBanco(data.get("BANCO"));
        fichaProponentePf.preencherAgencia(data.get("AGENCIA"));
        fichaProponentePf.preencherContaCorrente(data.get("CONTA"));
        Util.scrollDown(50);
        Report.takeScreenShot();
        Util.scrollDown(250);
    }


    @E("eu clico em 'Proximo' na tela de ficha cadastral pf")
    public void eu_clico_em_Proximo_na_tela_de_ficha_cadastral_pf() {
        fichaProponentePf.clicarBotaoProximo();
    }
}
