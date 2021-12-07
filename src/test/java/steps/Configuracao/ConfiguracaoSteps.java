package steps.Configuracao;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import pages.Configuracao.ConfiguracaoPage;
import pages._basePages.BasePage;

import java.util.Map;

public class ConfiguracaoSteps {

    private ConfiguracaoPage configuracaoPage;

    public ConfiguracaoSteps(){
        configuracaoPage = new ConfiguracaoPage();
    }

    @Dado("seleciono as configuracoes")
    public void selecionoAsConfiguracoes(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        configuracaoPage.selecionarTipoPessoa(data.get("TIPO PESSOA"));
        configuracaoPage.selecionarTipoVeiculo(data.get("TIPO VEICULO"));
        configuracaoPage.selecionarTabelaSubsidio(data.get("TABELA COM SUBSIDIO"));
    }

    @Dado("clico em Proximo - Configuracoes")
    public void clicoEmProximoConfiguracoes() {
        configuracaoPage.clicarBtnProximoConfiguracoes();
    }
}
