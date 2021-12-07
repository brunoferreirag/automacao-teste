package pages.Veiculo;


import support.Utils.Util;
import support.browser.BrowserManager;
import support.data.DataYaml;


public class VeiculoPage extends BrowserManager {


    String btnCicloSim = "//*[@name='tipo-produto']//*[text()='Sim']";
    String btnCicloNao = "//*[@name='tipo-produto']//*[text()='Não']";

    String btnTabelaFlexSim = "//*[@id='tabela-flex']//*[text()='Sim']";
    String btnTabelaFlexNao = "//*[@id='tabela-flex']//*[text()='Não']";

    String comboMarca = "#marca";
    String comboAnoFab = "#anoFabricacao";
    String comboAnoMod = "#ano-modelo";
    String comboModeloVersao = "#modelo";
    String txtComboTabela = "//*[@id='plano']//input";
    String comboTabela = "//*[@id='plano']";
    String comboUfEmplacamento = "#uf-emplacamento";
    String comboCodSimulacao = "#codigo-simulacao";
    String comboDiaPagamento = "#dia-parcelas";
    String comboVencimentoParcela = "#primeira-parcela";
    String comboCestaServico = "#cesta-servicos";
    String btnProximoVeiculoAtivo = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";


    public void selecionarCicloToyota(String cicloToyota) {
        page.waitForTimeout(2000);
        if (cicloToyota.equalsIgnoreCase("SIM")) {
            page.click(btnCicloSim);
            page.waitForTimeout(3000);
        } else if (cicloToyota.equalsIgnoreCase("NAO") || cicloToyota.equalsIgnoreCase("NÃO")) {
            page.click(btnCicloNao);
            page.waitForTimeout(3000);
        }
    }

    public void selecionarMarca(String marca) {
        page.click(comboMarca);
        Util.selecionarItemMatOption(marca);
    }

    public void selecionarAnoFabricacao(String anoFabricacao) {
        page.click(comboAnoFab);
        Util.selecionarItemMatOption(anoFabricacao);
    }

    public void selecionarAnoModelo(String anoModelo) {
        page.click(comboAnoMod);
        Util.selecionarItemMatOption(anoModelo);
    }

    public void selecionarModeloVersao(String modeloVersao) {
        page.waitForTimeout(1500);
        page.click(comboModeloVersao);
        Util.selecionarItemDropdownPanel(modeloVersao);
    }

    public void selecionarTabelaFlex(String tabelaFlex) {
        if (tabelaFlex != null) {
            if (tabelaFlex.equalsIgnoreCase("SIM")) {
                page.click(btnTabelaFlexSim);
                page.waitForTimeout(3000);
            } else if (tabelaFlex.equalsIgnoreCase("NAO") || tabelaFlex.equalsIgnoreCase("NÃO")) {
                page.click(btnTabelaFlexNao);
                page.waitForTimeout(3000);
            }
        }
    }

    public void selecionarTabela(String tabelaNegociacao){
        page.click(comboTabela);
        page.fill(txtComboTabela, DataYaml.getMapYamlValues("Planos", "tabela").get(tabelaNegociacao));
        Util.selecionarItemDropdownPanel(DataYaml.getMapYamlValues("Planos", "tabela").get(tabelaNegociacao));
        //page.fill(txtComboTabela, tabelaNegociacao);
        //Util.selecionarItemDropdownPanel(tabelaNegociacao);
    }

    public void selecionarUfEmplacamento(String ufEmplacamento) {
        page.click(comboUfEmplacamento);
        Util.selecionarItemDropdownPanel(ufEmplacamento);
    }

    public void selecionarCodigoSimulacao(String codSimulacao) {
        if (codSimulacao != null) {
            page.click(comboCodSimulacao);
            Util.selecionarItemMatOption(codSimulacao);
        }
    }

    public void selecionarDiaPagamento(String diaPagamento) {
        page.click(comboDiaPagamento);
        Util.selecionarItemMatOption(diaPagamento);
    }

    public void selecionarPrimeiroVencimento(String vencimento) {
        page.waitForTimeout(2000);
        if (vencimento != null) {
            if (vencimento.isEmpty()) {
                page.click(comboVencimentoParcela);
                String primeiroMesDisponivel = "//*[contains(@class, 'mat-option ng-star-inserted mat')]";
                page.click(primeiroMesDisponivel);
            } else {
                page.click(comboVencimentoParcela);
                Util.selecionarItemMatOption(vencimento);
            }
        }
    }

    public void selecionarCestaDeServico(String cestaServico) {
        page.click(comboCestaServico);
        Util.selecionarItemMatOption(cestaServico);
    }

    public void clicarBtnProximoVeiculo() {
        page.click(btnProximoVeiculoAtivo);
    }
}
