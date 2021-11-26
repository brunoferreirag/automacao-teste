package pages.PreFicha;


import cucumber.api.java.eo.Do;
import support.Utils.Util;
import support.browser.BrowserManager;
import support.data.DataYaml;
import support.documents.Documents;
import support.Utils.Proposta;
import support.dates.DatePicker;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PreFichaPage extends BrowserManager {

    Faker faker = new Faker(new Locale("pt-BR"));
    private Map map;

    String txtCpf = ("#cpf-cnpj");
    String txtNome = ("#nome");
    String radioSexoFeminino = ("//mat-radio-group[@formcontrolname='sexo']//mat-radio-button[@value='F']");
    String radioSexoMasculinho = ("//mat-radio-group[@formcontrolname='sexo']//mat-radio-button[@value='M']");
    String txtDataNascimento = ("#data-nascimento");
    String txtCep = ("#cep-pernoite");
    String txtPlaca = "#placa";

    String radioCondutorEntre18e25AnosSim = ("//mat-radio-group[@formcontrolname='condutor-menor-25-anos']//mat-radio-button[@value='true']");
    String radioCondutorEntre18e25AnosNao = ("//mat-radio-group[@formcontrolname='condutor-menor-25-anos']//mat-radio-button[@value='false']");

    String radioVeiculoUsoComercialSim = ("//mat-radio-group[@formcontrolname='uso-comercial']//mat-radio-button[@value='true']");
    String radioVeiculoUsoComercialNao = ("//mat-radio-group[@formcontrolname='uso-comercial']//mat-radio-button[@value='false']");

    String radioTaxiOuFrotaSim = ("//mat-radio-group[@formcontrolname='uso-comercial-com-cobranca-de-passagem']//mat-radio-button[@value='true']");
    String radioTaxiOuFrotaNao = ("//mat-radio-group[@formcontrolname='uso-comercial-com-cobranca-de-passagem']//mat-radio-button[@value='false']");


    private boolean habilitaTaxiFrota = false;

    public void preencherCpf(String cpf) {
        if (cpf == null){
            String cpfGerado = Documents.getCpf(false);
            Proposta.setCpfCnpjProponente(cpfGerado);
            page.type(txtCpf, Proposta.getCpfCnpjProponente());
            page.press(txtCpf, "Tab");
        } else {
            //Proposta.setCpfCnpjProponente(cpf);
            page.type(txtCpf, cpf);
            page.waitForTimeout(3000);
            page.press(txtCpf, "Tab");

        }
    }

    public void preencherNome(String nome) {
        if(nome == null){
            page.type(txtNome, faker.name().fullName().toUpperCase());
        } else {
            page.type(txtNome, nome);
        }
    }

    public void preencherPlaca(String placa){
        if(placa != null){
            page.type(txtPlaca, placa);
        }
    }

    public void selecionarSexo(String sexo) {
        if (sexo.equalsIgnoreCase("MASCULINO") || sexo.equalsIgnoreCase("M")) {
            page.click(radioSexoMasculinho);
        } else if (sexo.equalsIgnoreCase("FEMININO") || sexo.equalsIgnoreCase("F")) {
            page.click(radioSexoFeminino);
        }
    }

    public void preencherDataNascimento(String dataNascimento) {
        if(dataNascimento == null) {
            page.type(txtDataNascimento, "15" + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 24));
        } else{
            page.type(txtDataNascimento, dataNascimento);
        }

    }

    public void preencherCep(String cepResidencial) {
        page.type(txtCep, cepResidencial);
    }

    public void selecionarCondutorEntre18e25Anos(String opcao) {
        if (opcao == null){
            page.click(radioCondutorEntre18e25AnosNao);
        } else if (opcao.equalsIgnoreCase("SIM")) {
            page.click(radioCondutorEntre18e25AnosSim);
        } else {
            page.click(radioCondutorEntre18e25AnosNao);
        }
    }

    public void selecionarVeiculoUsoComercial(String usoComercial) {
        if (usoComercial == null){
            page.click(radioVeiculoUsoComercialNao);
            habilitaTaxiFrota = false;
        } else if (usoComercial.equalsIgnoreCase("SIM")) {
            page.click(radioVeiculoUsoComercialSim);
            habilitaTaxiFrota = true;
        } else {
            page.click(radioVeiculoUsoComercialNao);
            habilitaTaxiFrota = false;
        }
    }

    public void selecionarTaxiOuFrota(String s) {
        if (habilitaTaxiFrota) {
            if (s.equalsIgnoreCase("SIM")) {
                page.click(radioTaxiOuFrotaSim);
            } else {
                page.click(radioTaxiOuFrotaNao);
            }
        }
    }

    public void gerarMassaPF(String tipo) {
        Util.salvarMassa("Massa", "massa PF", tipo, Proposta.getCpfCnpjProponente());
    }

}
