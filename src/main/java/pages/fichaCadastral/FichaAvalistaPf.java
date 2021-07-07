package pages.fichaCadastral;


import com.github.javafaker.Faker;
import dates.DatePicker;
import documents.Documents;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

@Log4j2
public class FichaAvalistaPf extends DriverManager implements CommonTestingType {

    //DADOS GERAIS
    private By txtCpf = By.xpath("//*[@id='cpf-cnpj-avalista']");
    private By txtNome = By.xpath("//*[@id='nome-avalista']");
    private By radioSexoMasc = By.xpath("//*[@id='sexo-avalista']//*[@value='M']");
    private By radioSexoFem = By.xpath("//*[@id='sexo-avalista']//*[@value='F']");
    private By txtDataNascimento = By.xpath("//*[@id='data-nascimento-avalista']");
    private By comboNacionalidade = By.xpath("//*[@class='avalista']//*[@id='nacionalidade']//input");
    private By comboUfNaturalidade = By.xpath("//*[@class='avalista']//*[@id='uf-naturalidade']");
    private By comboMunicipio = By.xpath("//*[@class='avalista']//*[@id='naturalidade']//input");
    private By comboEstadoCivil = By.xpath("//*[@class='avalista']//*[@id='estado-civil']");
    //CONTATO
    private By txtCelularAvalista = By.xpath("//*[@class='avalista']//*[@id='tel-celular']");
    private By txtTelefoneAvalista = By.xpath("//*[@class='avalista']//*[@id='tel-fixo']");
    private By txtEmailAvalista = By.xpath("//*[@class='avalista']//*[@id='email']");
    //ENDERECO RESIDENCIAL
    private By txtCepResidencialAvalista = By.xpath("//*[@class='avalista']//*[@tipoendereco='Residencial']//*[@id='cep']");
    private By txtNumResidencialAvalista = By.xpath("//*[@class='avalista']//*[@tipoendereco='Residencial']//*[@id='numero']");
    private By txtComplementoResidencialAvalista = By.xpath("//*[@class='avalista']//*[@tipoendereco='Residencial']//*[@id='complemento']");
    //DOCUMENTOS
    private By txtRgRneAvalista = By.xpath("//*[@class='avalista']//*[@id='rg-rne-avalista']");
    private By txtOrgaoEmissorAvalista = By.xpath("//*[@class='avalista']//*[@id='orgao-emissor-avalista']");
    private By comboUfEmissaoAvalista = By.xpath("//*[@class='avalista']//*[@id='uf-emissao-avalista']");
    private By txtDataEmissaoAvalista = By.xpath("//*[@class='avalista']//*[@id='data-emissao-avalista']");
    //DADOS PROFISSIONAIS
    private By comboProfissaoAvalista = By.xpath("//*[@class='avalista']//*[@id='profissao-avalista']//input");
    private By comboOcupacaoAvalista = By.xpath("//*[@class='avalista']//*[@id='ocupacao-avalista']//input");
    private By txtNomeEmpresaAvalista = By.xpath("//*[@class='avalista']//*[@id='nome-empresa-avalista']");
    private By txtDataAdmissaoAvalista = By.xpath("//*[@class='avalista']//*[@id='data-admissao-avalista']");
    //ENDERECO PROFISSIONAL
    private By linkCopiarEnderecoResidencial = By.xpath("//*[@class='avalista']//*[@tipoendereco='Profissional']//*[text()='Copiar endereço residencial']");
    private By txtCepProfissionalAvalista = By.xpath("//*[@class='avalista']//*[@tipoendereco='Profissional']//*[@id='cep']");
    private By txtNumeroProfissionalAvalista = By.xpath("//*[@class='avalista']//*[@tipoendereco='Profissional']//*[@id='numero']");
    private By txtComplementoProfissionalAvalista = By.xpath("//*[@class='avalista']//*[@tipoendereco='Profissional']//*[@id='complemento']");
    //DADOS GERAIS DO CONJUGE
    private By txtCpfConjugeAvalista = By.xpath("//*[@class='avalista']//*[@id='cpf-cnpj-avalista-conjuge']");
    private By txtNomeConjugeAvalista = By.xpath("//*[@class='avalista']//*[@id='nome-avalista-conjuge']");
    private By txtNascimentoConjugeAvalista = By.xpath("//*[@class='avalista']//*[@id='data-nascimento-avalista-conjuge']");
    //DOCUMENTOS DO CONJUGE
    private By txtRgRneConjugeAvalista = By.xpath("//*[@class='avalista']//*[@id='rg-rne-avalista-conjuge']");
    private By txtOrgaoEmissorConjugeAvalista = By.xpath("//*[@class='avalista']//*[@id='orgao-emissor-avalista-conjuge']");
    //DADOS PROFISSIONAIS DO CONJUGE
    private By comboProfissaoConjuge = By.xpath("//*[@class='avalista']//*[@id='profissao-avalista-conjuge']//input");
    private By comboOcupacaoConjuge = By.xpath("//*[@class='avalista']//*[@id='ocupacao-avalista-conjuge']//input");
    private By txtEmpresaConjuge = By.xpath("//*[@class='avalista']//*[@id='nome-empresa-avalista-conjuge']");
    private By txtDataAdmissaoConjuge = By.xpath("//*[@class='avalista']//*[@id='data-admissao-avalista-conjuge']");
    //RENDA
    private By txtSalarioAvalista = By.xpath("//*[@class='avalista']//*[@id='salario-proponente']");
    private By txtSalarioConjAvalista = By.xpath("//*[@class='avalista']//*[@id='salario-conjuge']");
    private By txtOutrasRendasAvalista = By.xpath("//*[@class='avalista']//*[@id='outras-rendas']");
    //PATRIMONIO
    private By txtPatrimonioAvalista = By.xpath("//*[@class='avalista']//*[@id='valor-patrimonio']");
    //BENS
    private By radioVeiculoBensNaoSelecionado = By.xpath("//*[@class='avalista']//*[@id='veiculo-selecionado-avalista']//*[contains(@class,'checkbox-inner')]");
    private By radioVeiculoBensSelecionado = By.xpath("//*[@class='avalista']//*[@id='veiculo-selecionado-avalista']//*[contains(@class,'checkbox-inner')]");
    private By txtMarcaVeiculoBens = By.xpath("//*[@class='avalista']//*[@id='marca']");
    private By txtModeloVeiculoBens = By.xpath("//*[@class='avalista']//*[@id='modelo']");
    private By txtPlacaVeiculoBens = By.xpath("//*[@class='avalista']//*[@id='placa']");
    //DADOS DE CONTA
    private By comboBanco = By.xpath("//*[@class='avalista']//*[@id='banco']//input");
    private By txtAgencia = By.xpath("//*[@class='avalista']//*[@id='agencia']");
    private By lblValidandoAgencia = By.xpath("//*[@class='avalista']//app-dado-bancario//*[@class='area-inconsistente']//*[text()='Validando...']");
    private By txtConta = By.xpath("//*[@class='avalista']//*[@id='conta']");
    //OUTROS
    private By radioInserirAvalistaPf = By.xpath("//*[@id='adicionar-avalista-pf'] | //*[@id='adicionar-outro-avalista-pf']");
    private By btnAdicionarAvalistaDoQuadroExecutivo = By.xpath("//*[@class='avalista']//div[contains(@class,'row avalista')]//*[@class='adicionar']");
    private String modalCofirmacao = "//*[contains(@id, 'mat-dialog')]";
    private String dropDownListaOpcoes = "//div[@class=\"cdk-overlay-pane\"]//mat-option";
    private By btnSalvarAvalista = By.xpath("//*[@class='avalista']//*[@id='salvar-avalista']");

    @Override
    public boolean isPresent() {
        return false;
    }

    //DADOS GERAIS
    public void cpfDoAvalista(String cpfAvalista) {
        Verifications.verifyElementExists(txtCpf);
        Action.setText(txtCpf, cpfAvalista);
        getDriver().findElement(txtCpf).sendKeys(Keys.TAB);
    }

    public void nomeDoAvalista(String nomeAvalista) {
        Action.setText(txtNome, nomeAvalista.toUpperCase());
    }

    public void sexoDoAvalista(String sexo) {
        sexo = sexo.toUpperCase();
        if (sexo.equalsIgnoreCase("MASCULINO") || sexo.equalsIgnoreCase("M")) {
            Action.clickOnElement(radioSexoMasc);
            Action.clickOnElement(radioSexoMasc); //Clica 2x pois há um problema no componente do angular
        } else if (sexo.equalsIgnoreCase("FEMININO") || sexo.equalsIgnoreCase("F")) {
            Action.clickOnElement(radioSexoFem);
            Action.clickOnElement(radioSexoFem); //Clica 2x pois há um problema no componente do angular
        }
    }

    public void nascimentoDoAvalista(String nascimentoAvalista) {
        Action.setText(txtDataNascimento, nascimentoAvalista.replace("/", ""));
    }

    public void nacionalidadeDoAvalista(String nacionalidadeAvalista) {
        Action.clickOnElement(comboNacionalidade);
        Util.selecionarItemDropdownPanel(nacionalidadeAvalista.toUpperCase());
    }

    public void naturalidadeDoAvalista(String naturalidadeAvalista) {
        Action.clickOnElement(comboUfNaturalidade);
        Util.selecionarItemMatOption(naturalidadeAvalista.toUpperCase());
    }

    public void municipioDoAvalista(String municipioAvalista) {
        Action.clickOnElement(comboMunicipio);
        Util.selecionarItemDropdownPanel(municipioAvalista.toUpperCase());
    }

    public void estadoCivilDoAvalista(String estadoCivilAvalista) {
        String estadoCivil = "Solteiro (a)";
        if (estadoCivilAvalista.equalsIgnoreCase("CASADO")) {
            estadoCivil = "Casado (a)";
        } else if (estadoCivilAvalista.equalsIgnoreCase("SOLTEIRO")) {
            estadoCivil = "Solteiro (a)";
        } else if (estadoCivilAvalista.equalsIgnoreCase("SEPARADO")) {
            estadoCivil = "Separado (a)";
        } else if (estadoCivilAvalista.equalsIgnoreCase("DIVORCIADO")) {
            estadoCivil = "Divorciado (a)";
        } else if (estadoCivilAvalista.equalsIgnoreCase("VIUVO")) {
            estadoCivil = "Viúvo (a)";
        }
        Action.clickOnElement(comboEstadoCivil);
        Util.selecionarItemMatOption(estadoCivil);
    }

    //CONTATO
    public void celularDoAvalista(String celularAvalista) {
        Action.setText(txtCelularAvalista, celularAvalista);
    }

    public void telefoneFixoDoAvalista(String telefoneFixoAvalista) {
        Action.setText(txtTelefoneAvalista, telefoneFixoAvalista);
    }

    public void emailDoAvalista(String emailAvalista) {
        Action.setText(txtEmailAvalista, emailAvalista.toUpperCase());
    }

    //ENDERECO RESIDENCIAL
    public void cepResidencialDoAvalista(String cepResidencialAvalista) {
        getDriver().findElement(txtCepResidencialAvalista).clear();
        Action.setText(txtCepResidencialAvalista, cepResidencialAvalista);
        getDriver().findElement(txtCepResidencialAvalista).sendKeys(Keys.TAB);
        Util.aguardarLoaderDirect();
    }

    public void numResidencialDoAvalista(String numResidencialAvalista) {
        Action.setText(txtNumResidencialAvalista, numResidencialAvalista);
    }

    public void complementoResidencialDoAvalista(String complemento) {
        Action.setText(txtComplementoResidencialAvalista, complemento.toUpperCase());
    }

    //DOCUMENTOS
    public void rgRneDoAvalista(String rgRneAvalista) {
        Action.setText(txtRgRneAvalista, rgRneAvalista);
    }

    public void orgaoEmissorDoAvalista(String orgaoEmissorAvalista) {
        Action.setText(txtOrgaoEmissorAvalista, orgaoEmissorAvalista.toUpperCase());
    }

    public void ufDeEmissaoDoAvalista(String ufDeEmissaoAvalista) {
        Action.clickOnElement(comboUfEmissaoAvalista);
        Util.selecionarItemMatOption(ufDeEmissaoAvalista.toUpperCase());
    }

    public void dataDeEmissaoDoAvalista(String dataDeEmissaoAvalista) {
        Action.setText(txtDataEmissaoAvalista, dataDeEmissaoAvalista);
    }

    //DADOS PROFISSIONAIS
    public void profissaoDoAvalista(String profissaoAvalista) {
        Action.clickOnElement(comboProfissaoAvalista);
        Util.selecionarItemDropdownPanel(profissaoAvalista.toUpperCase());
    }

    public void ocupacaoProfissionalDoAvalista(String ocupacaoProfissionalAvalista) {
        Action.clickOnElement(comboOcupacaoAvalista);
        Util.selecionarItemDropdownPanel(ocupacaoProfissionalAvalista.toUpperCase());
    }

    public void nomeDaEmpresaDoAvalista(String nomeDaEmpresaAvalista) {
        Action.setText(txtNomeEmpresaAvalista, nomeDaEmpresaAvalista.toUpperCase());
    }

    public void dataDeAdmissaoDoAvalista(String dataDeAdmissaoAvalista) {
        Action.clickOnElement(txtDataAdmissaoAvalista);
        if (dataDeAdmissaoAvalista.equalsIgnoreCase("Menos de 1 ano")) {
            Util.selecionarItemMatOption("Menos de 1 ano");
        } else if (dataDeAdmissaoAvalista.equalsIgnoreCase("1 ano")) {
            Util.selecionarItemMatOption("1 ano");
        } else if (dataDeAdmissaoAvalista.equalsIgnoreCase("2 a 5 anos")) {
            Util.selecionarItemMatOption("2 a 5 anos");
        } else if (dataDeAdmissaoAvalista.equalsIgnoreCase("Mais de 5 anos")) {
            Util.selecionarItemMatOption("Mais de 5 anos");
        } else {
            Util.selecionarItemMatOption("Menos de 1 ano");
        }
    }

    //ENDERECO PROFISSIONAL
    public void copiarEnderecoResidencial() {
        Action.clickOnElement(linkCopiarEnderecoResidencial);
        Util.scrollDown(200);
        Report.takeScreenShot();
    }

    public void cepProfissionalAvalista(String cepProfissionalAvalista) {
        getDriver().findElement(txtCepProfissionalAvalista).clear();
        Action.setText(txtCepProfissionalAvalista, cepProfissionalAvalista);
        getDriver().findElement(txtCepProfissionalAvalista).sendKeys(Keys.TAB);
        Util.aguardarLoaderDirect();
    }

    public void numProfissionalAvalista(String numProfissionalAvalista) {
        Action.setText(txtNumeroProfissionalAvalista, numProfissionalAvalista);
    }

    public void complementoProfissionalDoAvalista(String complementoProfissional) {
        Action.setText(txtComplementoProfissionalAvalista, complementoProfissional.toUpperCase());
    }

    //DADOS GERAIS DO CONJUGE
    public void cpfDoConjugeAvalista(String cpfAvalista) {
        Action.setText(txtCpfConjugeAvalista, cpfAvalista);
        getDriver().findElement(txtCpfConjugeAvalista).sendKeys(Keys.TAB);
    }

    public void nomeDoConjugeAvalista(String nomeConjuge) {
        Action.setText(txtNomeConjugeAvalista, nomeConjuge.toUpperCase());
    }

    public void nascimentoDoConjugeAvalista(String dataNascConjuge) {
        Action.setText(txtNascimentoConjugeAvalista, dataNascConjuge.replace("/", ""));
    }

    //DOCUMENTOS DO CONJUGE
    public void rgRneDoConjugeAvalista(String rgRneConjuge) {
        Action.setText(txtRgRneConjugeAvalista, rgRneConjuge.toUpperCase());
    }

    public void orgaoEmissorDoConjugeAvalista(String orgaoEmissorConjuge) {
        Action.setText(txtOrgaoEmissorConjugeAvalista, orgaoEmissorConjuge.toUpperCase());
    }

    //DADOS PROFISSIONAIS DO CONJUGE
    public void profissaoDoConjugeAvalista(String profissao) {
        Action.clickOnElement(comboProfissaoConjuge);
        Util.selecionarItemDropdownPanel(profissao.toUpperCase());
    }

    public void ocupacaoProfissionalDoConjugeAvalista(String ocupacao) {
        Action.clickOnElement(comboOcupacaoConjuge);
        Util.selecionarItemDropdownPanel(ocupacao.toUpperCase());
    }

    public void nomeDaEmpresaDoConjugeAvalista(String empresa) {
        Action.setText(txtEmpresaConjuge, empresa.toUpperCase());
    }

    public void dataDeAdmissaoDoConjugeAvalista(String dataAdmissaoConjuge) {
        Action.clickOnElement(txtDataAdmissaoConjuge);
        if (dataAdmissaoConjuge.equalsIgnoreCase("Menos de 1 ano")) {
            Util.selecionarItemMatOption("Menos de 1 ano");
        } else if (dataAdmissaoConjuge.equalsIgnoreCase("1 ano")) {
            Util.selecionarItemMatOption("1 ano");
        } else if (dataAdmissaoConjuge.equalsIgnoreCase("2 a 5 anos")) {
            Util.selecionarItemMatOption("2 a 5 anos");
        } else if (dataAdmissaoConjuge.equalsIgnoreCase("Mais de 5 anos")) {
            Util.selecionarItemMatOption("Mais de 5 anos");
        } else {
            Util.selecionarItemMatOption("Menos de 1 ano");
        }
    }

    //RENDA
    public void salarioDoAvalista(String salarioAvalista) {
        Action.setText(txtSalarioAvalista, Util.formatarSomenteNumeros(salarioAvalista));
    }

    public void salarioDoConjugeAvalista(String salarioConjAvalista) {
        Action.setText(txtSalarioConjAvalista, Util.formatarSomenteNumeros(salarioConjAvalista));
    }

    public void outrasRendasDoAvalista(String outrasRendasAvalista) {
        Action.setText(txtOutrasRendasAvalista, Util.formatarSomenteNumeros(outrasRendasAvalista));
    }

    //PATRIMONIO
    public void patrimonioDoAvalista(String patrimonioAvalista) {
        Action.setText(txtPatrimonioAvalista, Util.formatarSomenteNumeros(patrimonioAvalista));
    }

    //BENS
    public void selecionarRadioVeiculoBens() {
        Action.clickOnElement(radioVeiculoBensNaoSelecionado);
    }

    public void desselecionarRadioVeiculoBens() {
        Action.clickOnElement(radioVeiculoBensSelecionado);
    }

    public void marcaVeiculoBens(String marca) {
        Action.setText(txtMarcaVeiculoBens, marca.toUpperCase());
    }

    public void modeloVeiculoBens(String modelo) {
        Action.setText(txtModeloVeiculoBens, modelo.toUpperCase());
    }

    public void placaVeiculoBens(String placa) {
        Action.setText(txtPlacaVeiculoBens, placa.toUpperCase());
    }

    //DADOS DE CONTA
    public void bancoDoAvalista(String banco) {
        Action.clickOnElement(comboBanco);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void agenciaDoAvalista(String agencia) {
        Action.setText(txtAgencia, agencia);
        getDriver().findElement(txtAgencia).sendKeys(Keys.TAB);
        Verifications.wait(2);
        Verifications.verifyElementDoesNotExist(lblValidandoAgencia);
    }

    public void contaDoAvalista(String conta) {
        Action.setText(txtConta, conta);
    }

    //OUTROS
    public void inserirAvalista() {
        Action.clickOnElement(radioInserirAvalistaPf);
        Report.takeScreenShot();
    }

    public void inserirAvalistaConjuge(String opcaoEscolhida) {
        Verifications.verifyElementIsVisible(By.xpath(modalCofirmacao));
        Verifications.wait(2);
        if (opcaoEscolhida.toUpperCase().equals("SIM")) {
            Verifications.verifyElementIsClickable(By.xpath(modalCofirmacao + "//button[text()=\"Sim\"]"));
            Action.clickOnElement(By.xpath(modalCofirmacao + "//button[text()=\"Sim\"]"));
            Verifications.wait(3);
        } else {
            Verifications.verifyElementIsClickable(By.xpath(modalCofirmacao + "//button[text()=\"Não\"]"));
            Action.clickOnElement(By.xpath(modalCofirmacao + "//button[text()=\"Não\"]"));
            Verifications.wait(3);
        }
    }

    public void botaoSalvarAvalista() {
        Verifications.verifyElementIsClickable(btnSalvarAvalista);
        Report.takeScreenShot();
        Action.clickOnElement(btnSalvarAvalista);
    }

    public void evidenciarFichaEnriquecida() {
        Util.scrollDown(300);
        Report.takeScreenShot();
        Util.scrollDown(300);
        Report.takeScreenShot();
        Util.scrollDown(300);
        Report.takeScreenShot();
        Util.scrollDown(300);
        Report.takeScreenShot();
    }

    public void gerarFichaAvalistaPf(String estadoCivil) {
        Faker faker = new Faker(new Locale("pt-BR"));
        //Dados Gerais
        cpfDoAvalista(Documents.getCpf(false));
        nomeDoAvalista(faker.name().fullName());
        sexoDoAvalista("M");
        nascimentoDoAvalista("15" + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 24));
        naturalidadeDoAvalista("ES");
        municipioDoAvalista("ALEGRE");
        estadoCivilDoAvalista(estadoCivil);
        //Contato
        celularDoAvalista("11983915851");
        telefoneFixoDoAvalista("27" + faker.number().numberBetween(11111111, 99999999));
        emailDoAvalista("fabio.dantas@gft.com");
        //Endereco Residencial
        cepResidencialDoAvalista("01124010");
        numResidencialDoAvalista("" + faker.number().numberBetween(10, 999));
        Report.takeScreenShot();
        //Documentos
        rgRneDoAvalista("" + faker.number().randomNumber(9, false));
        orgaoEmissorDoAvalista("SP");
        ufDeEmissaoDoAvalista("SP");
        dataDeEmissaoDoAvalista("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        //Dados Profissionais
        profissaoDoAvalista("ADMINISTRADOR");
        ocupacaoProfissionalDoAvalista("OUTROS");
        nomeDaEmpresaDoAvalista("BANCO TOYOTA");
        dataDeAdmissaoDoAvalista("Mais de 5 anos");
        Util.scrollDown(50);
        Report.takeScreenShot();
        //Endereco Profissional
        copiarEnderecoResidencial();
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            //Dados Conjuge
            cpfDoConjugeAvalista("" + Documents.getCpf(false));
            nomeDoConjugeAvalista("" + faker.name().fullName());
            nascimentoDoConjugeAvalista("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 24));
            //Documentos Conjuge
            rgRneDoConjugeAvalista("" + faker.number().randomNumber(9, false));
            orgaoEmissorDoConjugeAvalista("ES");
            //Dados Profissionais
            profissaoDoConjugeAvalista("ADMINISTRADOR");
            ocupacaoProfissionalDoConjugeAvalista("OUTROS");
            nomeDaEmpresaDoConjugeAvalista("BANCO TOYOTA");
            dataDeAdmissaoDoConjugeAvalista("Mais de 5 anos");
            Util.scrollDown(50);
            Report.takeScreenShot();
        }
        //Renda
        salarioDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            salarioDoConjugeAvalista("" + faker.number().numberBetween(100000, 1000000));
        }
        outrasRendasDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        patrimonioDoAvalista("" + faker.number().numberBetween(1000000, 30000000));
        Util.scrollDown(50);
        Report.takeScreenShot();
        //Bens
        selecionarRadioVeiculoBens();
        marcaVeiculoBens("TOYOTA");
        modeloVeiculoBens("ETIOS");
        placaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //Banco
        bancoDoAvalista("0075 - ABN Amro");
        agenciaDoAvalista("0");
        contaDoAvalista("" + faker.number().numberBetween(1111, 999999));
        Util.scrollDown(50);
        Report.takeScreenShot();
        Util.scrollDown(250);
    }

    public void gerarFichaAvalistaConjuge() {
        Faker faker = new Faker(new Locale("pt-BR"));
        //Dados Gerais
        sexoDoAvalista("M");
        naturalidadeDoAvalista("ES");
        municipioDoAvalista("ALEGRE");
        //Contato
        celularDoAvalista("11983915851");
        telefoneFixoDoAvalista("27" + faker.number().numberBetween(11111111, 99999999));
        emailDoAvalista("fabio.dantas@gft.com");
        Util.scrollDown(100);
        Report.takeScreenShot();
        //Documentos
        ufDeEmissaoDoAvalista("SP");
        dataDeEmissaoDoAvalista("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        //Endereco Profissional
        copiarEnderecoResidencial();
        //Renda
        outrasRendasDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        patrimonioDoAvalista("" + faker.number().numberBetween(1000000, 30000000));
        Util.scrollDown(100);
        Report.takeScreenShot();
        //Bens
        selecionarRadioVeiculoBens();
        marcaVeiculoBens("TOYOTA");
        modeloVeiculoBens("ETIOS");
        placaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //Banco
        bancoDoAvalista("0075 - ABN Amro");
        agenciaDoAvalista("0");
        contaDoAvalista("" + faker.number().numberBetween(1111, 999999));
        Util.scrollDown(50);
        Report.takeScreenShot();
        Util.scrollDown(250);
    }
}
