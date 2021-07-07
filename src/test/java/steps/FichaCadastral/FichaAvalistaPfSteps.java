package steps.FichaCadastral;

import cucumber.api.java.pt.E;
import pages.fichaCadastral.FichaAvalistaPf;

public class FichaAvalistaPfSteps {

    FichaAvalistaPf fichaAvalistaPf = new FichaAvalistaPf();

    @E("eu clico em inserir avalista pf")
    public void eu_clico_em_inserir_avalista_pf(){
        fichaAvalistaPf.inserirAvalista();
    }

    @E("eu nao quero incluir o conjuge como avalista")
    public void eu_nao_quero_incluir_o_conjuge_como_avalista(){
        fichaAvalistaPf.inserirAvalistaConjuge("NAO");
    }

    @E("eu incluo o conjuge como avalista")
    public void eu_incluo_o_conjuge_como_avalista(){
        fichaAvalistaPf.inserirAvalistaConjuge("SIM");
    }

    @E("eu preencho a ficha do avalista pf solteiro com dados gerados")
    public void eu_preencho_a_ficha_do_proponente_pf_solteiro_com_dados_gerados() {
        fichaAvalistaPf.gerarFichaAvalistaPf("SOLTEIRO");
    }

    @E("eu preencho a ficha do avalista pf casado com dados gerados")
    public void eu_preencho_a_ficha_do_proponente_pf_casado_com_dados_gerados() {
        fichaAvalistaPf.gerarFichaAvalistaPf("CASADO");
    }

    @E("eu preencho a ficha do avalista conjuge")
    public void eu_preencho_a_ficha_do_avalista_conjuge_com_dados_gerados() {
        fichaAvalistaPf.gerarFichaAvalistaConjuge();
    }

    @E("eu clico em 'Salvar' na ficha do avalista pf")
    public void eu_clico_em_salvar_na_ficha_do_avalista_pf(){
        fichaAvalistaPf.botaoSalvarAvalista();
    }

}
