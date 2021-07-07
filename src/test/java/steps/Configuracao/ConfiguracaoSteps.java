package steps.Configuracao;

import cucumber.api.java.pt.E;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;
import org.junit.Assert;
import pages.configuracao.Configuracao;
import report.Report;

import java.util.Map;

public class ConfiguracaoSteps {

    private Configuracao configuracao = new Configuracao();

    @E("eu estou na pagina de configuracao")
    public void eu_estou_na_pagina_de_configuracao(){
        Assert.assertTrue(configuracao.isPresent());
    }

    @E("eu seleciono as configuracoes")
    public void eu_seleciono_as_configuracoes(DataTable dataTable) throws Exception {

      //Opcao usando DataTable
//      configuracao.selecionarCicloToyota(dataTable.cell(1,0));
//      configuracao.selecionarTipoDeFinanciamento(dataTable.cell(1,1));
//      configuracao.selecionarTipoDePessoa(dataTable.cell(1,2));
//      configuracao.selecionarTipoDeVeiculo(dataTable.cell(1,3));
//      configuracao.selecionarFiltroTabelaSubsidio(dataTable.cell(1,4));
//      Report.takeScreenShot();

      //Opcao usando MAP
      Map<String, String> data = dataTable.asMap(String.class, String.class);
      //configuracao.selecionarTipoDeFinanciamento(data.get("TIPO FINANCIAMENTO"));
      configuracao.selecionarTipoDePessoa(data.get("TIPO PESSOA"));
      configuracao.selecionarTipoDeVeiculo(data.get("TIPO VEICULO"));
      configuracao.selecionarFiltroTabelaSubsidio(data.get("TABELA COM SUBSIDIO"));
      Report.takeScreenShot();

    }

    @E("eu clico em 'Proximo' na tela de configuracao")
    public void eu_clico_em_Proximo_na_tela_de_configuracao(){
        configuracao.clicarBotaoProximo();
    }
}
