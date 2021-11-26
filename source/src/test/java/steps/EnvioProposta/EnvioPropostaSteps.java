package steps.EnvioProposta;



import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import pages.EnvioProposta.EnvioPropostaPage;

import java.util.Map;

public class EnvioPropostaSteps {

    EnvioPropostaPage envioPropostaPage = new EnvioPropostaPage();

    @Quando("seleciono Consultor e Responsavel")
    public void selecionoConsultorEResponsavel(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        //envioPropostaPage.validarPagina();
        //envioPropostaPage.selecionarConsultor(data.get("CONSULTOR"));
        //envioPropostaPage.selecionarResponsavel(data.get("RESPONSAVEL"));
        //envioPropostaPage.selecionarAssistente(data.get("ASSISTENTE"));
        envioPropostaPage.selecionarConsultor();
        envioPropostaPage.selecionarResponsavel();
        envioPropostaPage.selecionarAssistente();
    }


    @E("clico no botao Enviar Pre-Proposta")
    public void clicoNoBotaoEnviarPreProposta() {
        envioPropostaPage.clicarEnviarPreProposta();
    }
}
