package pages.EnvioProposta;


import support.Utils.Util;
import support.browser.BrowserManager;
import support.data.DataYaml;

import static support.report.Report.takeScreenShot;

public class EnvioPropostaPage extends BrowserManager {


    String comboConsultor = "//body/app-root[1]/app-nav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-container[1]/div[1]/div[1]/app-pre-proposta[1]/form[1]/div[1]/div[2]/div[2]/div[1]/ng-select[1]";
    String comboResponsavel = "//body/app-root[1]/app-nav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-container[1]/div[1]/div[1]/app-pre-proposta[1]/form[1]/div[1]/div[2]/div[2]/div[2]/ng-select[1]";
    String comboAssistente = "//body/app-root[1]/app-nav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-container[1]/div[1]/div[1]/app-pre-proposta[1]/form[1]/div[1]/div[2]/div[2]/div[3]/ng-select[1]";
    String txtInformacoesComplementares = "//textarea";
    String btnEnviarPrePropostaAtivo = "//button[contains(@class, 'ativo')][text()='ENVIAR PRÉ-PROPOSTA']";



    public void selecionarConsultor(String consultor) {
        page.click(comboConsultor);
        //Util.selecionarItemDropdownPanel(consultor);
        Util.selecionarItemDropdownPanel(consultor);
    }

    public void selecionarResponsavel(String responsavel) {
        page.click(comboResponsavel);
        Util.selecionarItemDropdownPanel(responsavel);
    }

    public void selecionarAssistente(String assistente){
        page.click(comboAssistente);
        Util.selecionarItemDropdownPanel(assistente);
    }

    //buscando valores dos arquivos yml
    public void selecionarConsultor() {
        page.click(comboConsultor);
        Util.selecionarItemDropdownPanel(DataYaml.getMapYamlValues("Usuarios", "credenciais").get("consultor"));
    }

    public void selecionarResponsavel() {
        page.click(comboResponsavel);
        Util.selecionarItemDropdownPanel(DataYaml.getMapYamlValues("Usuarios", "credenciais").get("responsavel"));
    }

    public void selecionarAssistente(){
        page.click(comboAssistente);
        Util.selecionarItemDropdownPanel(DataYaml.getMapYamlValues("Usuarios", "credenciais").get("assistente"));
    }

    public void validarPagina(){
        page.isVisible(comboConsultor);
        page.isVisible(comboResponsavel);
        //page.isVisible(btnEnviarPrePropostaAtivo);

    }

    public void clicarEnviarPreProposta(){
        takeScreenShot();
        page.click(btnEnviarPrePropostaAtivo);
    }
}
