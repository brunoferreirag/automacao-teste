package pages.Configuracao;


import support.browser.BrowserManager;
import static support.report.Report.takeScreenShot;


public class ConfiguracaoPage extends BrowserManager {



    String btnTipoFinanciamentoCdc = "//button[@name='tipo-financiamento']//*[contains(text(),'CDC')]";
    String btnTipoFinanciamentoLeasing = "//button[@name='tipo-financiamento']//*[contains(text(),'LEASING')]";

    String btnTipoPessoaPf = "//button[@name='tipo-pessoa']//*[contains(text(),'PF')]";
    String btnTipoPessoaPj = "//button[@name='tipo-pessoa']//*[contains(text(),'PJ')]";

    String btnVeiculoZeroKm = "//button[@name='situacao-veiculo']//*[contains(text(),'0KM')]";
    String btnVeiculoUsado = "//button[@name='situacao-veiculo']//*[contains(text(),'USADO')]";

    String btnTabelaSubsidioNao = "//button[@name='buscar-planos-com-subsidio']//*[contains(text(),'NÃO')]";
    String btnTabelaSubsidioSim = "//button[@name='buscar-planos-com-subsidio']//*[contains(text(),'SIM')]";
    String btnTabelaSubsidioTodas = "//button[@name='buscar-planos-com-subsidio']//*[contains(text(),'TODAS')]";

    String btnProximoConfiguracoesAtivo = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    String btnProximoInativo = "//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']";

    public void selecionarTipoFinanciamento(String data){

    }
    public void selecionarTipoPessoa(String data){
        if (data.equalsIgnoreCase("PF")){
            page.click(btnTipoPessoaPf);
        } else if (data.equalsIgnoreCase("PJ")){
            page.click(btnTipoPessoaPj);
        }

    }
    public void selecionarTipoVeiculo(String data){
        if (data.equalsIgnoreCase("0KM")){
            page.click(btnVeiculoZeroKm);
        } else if (data.equalsIgnoreCase("USADO")){
            page.click(btnVeiculoUsado);
        }

    }
    public void selecionarTabelaSubsidio(String data){
        if (data.equalsIgnoreCase("NAO")){
            page.click(btnTabelaSubsidioNao);
        } else if (data.equalsIgnoreCase("SIM")){
            page.click(btnTabelaSubsidioSim);
        } else if (data.equalsIgnoreCase("TODAS")){
            page.click(btnTabelaSubsidioTodas);
        }
        takeScreenShot();

    }

    public void clicarBtnProximoConfiguracoes(){
        page.click(btnProximoConfiguracoesAtivo);
        takeScreenShot();
    }







}
