package steps.ComunsNoSistema;

import cucumber.api.java.pt.E;
import pages.comunsNoSistema.Breadcrumb;

public class BreadcrumbSteps {

    Breadcrumb breadcrumb = new Breadcrumb();

    @E("eu clico no step de 'Configuracao' no Breadcrumb")
    public void eu_clico_no_step_de_Configuracao_no_Breadcrumb(){
        breadcrumb.clicarStepConfiguracao();
    }

    @E("eu clico no step de 'Veiculo' no Breadcrumb")
    public void eu_clico_no_step_de_Veiculo_no_Breadcrumb(){
        breadcrumb.clicarStepVeiculo();
    }

    @E("eu clico no step de 'Simulacao' no Breadcrumb")
    public void eu_clico_no_step_de_Simulacao_no_Breadcrumb(){
        breadcrumb.clicarStepSimulacao();
    }

}
