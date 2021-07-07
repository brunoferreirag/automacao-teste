package pages.preFicha;

import com.github.javafaker.Faker;
import dates.DatePicker;
import documents.Documents;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Proposta;
import support.Util;
import support.Verifications;

import java.util.Locale;


@Log4j2
public class PreFicha extends DriverManager implements CommonTestingType {

    Faker faker = new Faker(new Locale("pt-BR"));

    private By lblPreFicha = By.xpath("//h4[contains(text(),'Valide a Simulação')]");

    private By txtCpf = By.id("cpf-cnpj");
    private By txtNome = By.id("nome");
    private By radioSexoFeminino = By.xpath("//mat-radio-group[@formcontrolname='sexo']//mat-radio-button[@value='F']");
    private By radioSexoMasculinho = By.xpath("//mat-radio-group[@formcontrolname='sexo']//mat-radio-button[@value='M']");
    private By txtDataNascimento = By.id("data-nascimento");
    private By txtCep = By.id("cep-pernoite");

    private By radioCondutorEntre18e25AnosSim = By.xpath("//mat-radio-group[@formcontrolname='condutor-menor-25-anos']//mat-radio-button[@value='true']");
    private By radioCondutorEntre18e25AnosNao = By.xpath("//mat-radio-group[@formcontrolname='condutor-menor-25-anos']//mat-radio-button[@value='false']");

    private By radioVeiculoUsoComercialSim = By.xpath("//mat-radio-group[@formcontrolname='uso-comercial']//mat-radio-button[@value='true']");
    private By radioVeiculoUsoComercialNao = By.xpath("//mat-radio-group[@formcontrolname='uso-comercial']//mat-radio-button[@value='false']");

    private By radioTaxiOuFrotaSim = By.xpath("//mat-radio-group[@formcontrolname='uso-comercial-com-cobranca-de-passagem']//mat-radio-button[@value='true']");
    private By radioTaxiOuFrotaNao = By.xpath("//mat-radio-group[@formcontrolname='uso-comercial-com-cobranca-de-passagem']//mat-radio-button[@value='false']");

    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    private boolean habilitaTaxiFrota = false;

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        return Verifications.verifyElementIsVisible(lblPreFicha);
    }

    public void preencherCpf(String cpf) {
        if (cpf == null) {
            log.info("CPF Nao informado, utilizado gerador");
            String cpfGerado = Documents.getCpf(false);
            Proposta.setCpfCnpjProponente(cpfGerado);
            Report.info("CPF GERADO: "+Proposta.getCpfCnpjProponente());
            Action.setText(txtCpf, Proposta.getCpfCnpjProponente());
        } else {
            Proposta.setCpfCnpjProponente(cpf);
            Action.setText(txtCpf, Proposta.getCpfCnpjProponente());
        }
    }

    public void preencherNome(String nome) {
        if (nome == null) {
            log.info("Nome nao informado, utilizado faker");
            Action.setText(txtNome, faker.name().fullName().toUpperCase());
        } else {
            Action.setText(txtNome, nome);
        }
    }

    public void selecionarSexo(String sexo) {
        if (sexo == null) {
            Action.clickOnElement(radioSexoMasculinho);
        } else if (sexo.equalsIgnoreCase("MASCULINO") || sexo.equalsIgnoreCase("M")) {
            Action.clickOnElement(radioSexoMasculinho);
        } else if (sexo.equalsIgnoreCase("FEMININO") || sexo.equalsIgnoreCase("F")) {
            Action.clickOnElement(radioSexoFeminino);
        }
    }

    public void preencherDataNascimento(String dataNasc) {
        if (dataNasc == null) {
            Action.setText(txtDataNascimento, "15" + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 24));
            log.info("Data de Nascimento nao informado");
        } else {
            Action.setText(txtDataNascimento, dataNasc);
        }
    }

    public void preencherCep(String cep) {
        if (cep == null) {
            Action.setText(txtCep, "29114360");
         log.info("Cep nao informado");
        }else {
            Action.setText(txtCep, cep);
        }
    }

    public void selecionarCondutorEntre18e25Anos(String opcao) {
        if (opcao == null) {
            Action.clickOnElement(radioCondutorEntre18e25AnosNao);
            Action.clickOnElement(radioCondutorEntre18e25AnosNao);
        } else if (opcao.equalsIgnoreCase("SIM")) {
            Action.clickOnElement(radioCondutorEntre18e25AnosSim);
            Action.clickOnElement(radioCondutorEntre18e25AnosSim);
        } else {
            Action.clickOnElement(radioCondutorEntre18e25AnosNao);
            Action.clickOnElement(radioCondutorEntre18e25AnosNao);
        }
    }

    public void selecionarVeiculoUsoComercial(String opcao) {
        if (opcao == null) {
            Action.clickOnElement(radioVeiculoUsoComercialNao);
            Action.clickOnElement(radioVeiculoUsoComercialNao);
            habilitaTaxiFrota = false;
        } else if (opcao.equalsIgnoreCase("SIM")) {
            Action.clickOnElement(radioVeiculoUsoComercialSim);
            Action.clickOnElement(radioVeiculoUsoComercialSim);
            habilitaTaxiFrota = true;
        } else {
            Action.clickOnElement(radioVeiculoUsoComercialNao);
            Action.clickOnElement(radioVeiculoUsoComercialNao);
            habilitaTaxiFrota = false;
        }
    }

    public void selecionarTaxiOuFrota(String opcao) {
        if (habilitaTaxiFrota) {
            if (opcao.equalsIgnoreCase("SIM")) {
                Action.clickOnElement(radioTaxiOuFrotaSim);
                Action.clickOnElement(radioTaxiOuFrotaSim);
            } else {
                Action.clickOnElement(radioTaxiOuFrotaNao);
                Action.clickOnElement(radioTaxiOuFrotaNao);
            }
        } else {
            log.info("Campo ignorado devido a Uso Comercial = NAO");
        }
    }

    public void clicarBotaoProximo() {
        Util.scrollDown(250);
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de PreFicha");
    }

}
