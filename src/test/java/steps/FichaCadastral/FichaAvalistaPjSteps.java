package steps.FichaCadastral;

import cucumber.api.java.pt.E;
import pages.fichaCadastral.FichaAvalistaPj;

public class FichaAvalistaPjSteps {

    FichaAvalistaPj fichaAvalistaPj = new FichaAvalistaPj();

    @E("eu clico em inserir avalista pj")
    public void eu_clico_em_inserir_avalista_pj(){
        fichaAvalistaPj.inserirAvalista();
    }

    @E("eu preencho a ficha do avalista pj com dados gerados")
    public void eu_preencho_a_ficha_do_proponente_pj_com_dados_gerados() {
        //fichaAvalistaPj.gerarFichaAvalistaPj();
        fichaAvalistaPj.gerarFichaAvalistaPj(1,3,0);
//        fichaAvalistaPj.gerarFichaAvalistaPj(0,2,0,1,0,0);
    }

    @E("eu clico em 'Salvar' na ficha do avalista pj")
    public void eu_clico_em_salvar_na_ficha_do_avalista_pj(){
        fichaAvalistaPj.botaoSalvarAvalista();
    }

}
