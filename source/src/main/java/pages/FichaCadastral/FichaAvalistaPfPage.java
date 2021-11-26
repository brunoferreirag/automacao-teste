package pages.FichaCadastral;


import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import support.browser.BrowserManager;
import support.data.DataYaml;
import support.documents.Documents;
import support.Utils.Util;
import support.dates.DatePicker;
import java.util.Locale;

import static org.junit.Assert.*;
import static support.report.Report.takeScreenShot;

public class FichaAvalistaPfPage extends BrowserManager {



    //DADOS GERAIS
    String txtCpf = "//*[@id='cpf-cnpj-avalista']";
    String txtNome = "//*[@id='nome-avalista']";
    String radioSexoMasc = "//*[@id='sexo-avalista']//*[@value='M']";
    String radioSexoFem = "//*[@id='sexo-avalista']//*[@value='F']";
    String txtDataNascimento = "//*[@id='data-nascimento-avalista']";
    String comboNacionalidade = "//*[@class='avalista']//*[@id='nacionalidade']//input";
    String comboUfNaturalidade = "//*[@class='avalista']//*[@id='uf-naturalidade']";
    String comboMunicipio = "//*[@class='avalista']//*[@id='naturalidade']//input";
    String comboEstadoCivil = "//*[@class='avalista']//*[@id='estado-civil']";
    String btnEditarAvalista = "mat-icon[id='ico-editar-avalista-0']";
    String btnExcluirAvalista = "mat-icon[id='ico-excluir-avalista-0']";
    String frameListaAvalista = "#lista-avalista";
    String nomeAvalistaAlterado;
    //CONTATO
    String txtCelularAvalista = "//*[@class='avalista']//*[@id='tel-celular']";
    String txtTelefoneAvalista = "//*[@class='avalista']//*[@id='tel-fixo']";
    String txtEmailAvalista = "//*[@class='avalista']//*[@id='email']";
    //ENDERECO RESIDENCIAL
    String txtCepResidencialAvalista = "//*[@class='avalista']//*[@tipoendereco='Residencial']//*[@id='cep']";
    String txtNumResidencialAvalista = "//*[@class='avalista']//*[@tipoendereco='Residencial']//*[@id='numero']";
    String txtComplementoResidencialAvalista = "//*[@class='avalista']//*[@tipoendereco='Residencial']//*[@id='complemento']";
    //DOCUMENTOS
    String txtRgRneAvalista = "//*[@class='avalista']//*[@id='rg-rne-avalista']";
    String txtOrgaoEmissorAvalista = "//*[@class='avalista']//*[@id='orgao-emissor-avalista']";
    String comboUfEmissaoAvalista = "//*[@class='avalista']//*[@id='uf-emissao-avalista']";
    String txtDataEmissaoAvalista = "//*[@class='avalista']//*[@id='data-emissao-avalista']";
    //DADOS PROFISSIONAIS
    String comboProfissaoAvalista = "//*[@class='avalista']//*[@id='profissao-avalista']//input";
    String comboOcupacaoAvalista = "//*[@class='avalista']//*[@id='ocupacao-avalista']//input";
    //String comboProfissaoAvalista = "//*[@id='avalista-dados-profissionais']//ng-select[@id='profissao-avalista']//input";
    //String comboOcupacaoAvalista = "#ocupacao-avalista";
    String txtNomeEmpresaAvalista = "//*[@class='avalista']//*[@id='nome-empresa-avalista']";
    String txtDataAdmissaoAvalista = "//*[@class='avalista']//*[@id='data-admissao-avalista']";
    //ENDERECO PROFISSIONAL
    String linkCopiarEnderecoResidencial = "//*[@class='avalista']//*[@tipoendereco='Profissional']//*[text()='Copiar endereço residencial']";
    String txtCepProfissionalAvalista = "//*[@class='avalista']//*[@tipoendereco='Profissional']//*[@id='cep']";
    String txtNumeroProfissionalAvalista = "//*[@class='avalista']//*[@tipoendereco='Profissional']//*[@id='numero']";
    String txtComplementoProfissionalAvalista = "//*[@class='avalista']//*[@tipoendereco='Profissional']//*[@id='complemento']";
    //DADOS GERAIS DO CONJUGE
    String txtCpfConjugeAvalista = "//*[@class='avalista']//*[@id='cpf-cnpj-avalista-conjuge']";
    String txtNomeConjugeAvalista = "//*[@class='avalista']//*[@id='nome-avalista-conjuge']";
    String txtNascimentoConjugeAvalista = "//*[@class='avalista']//*[@id='data-nascimento-avalista-conjuge']";
    //DOCUMENTOS DO CONJUGE
    String txtRgRneConjugeAvalista = "//*[@class='avalista']//*[@id='rg-rne-avalista-conjuge']";
    String txtOrgaoEmissorConjugeAvalista = "//*[@class='avalista']//*[@id='orgao-emissor-avalista-conjuge']";
    //DADOS PROFISSIONAIS DO CONJUGE
    String comboProfissaoConjuge = "//*[@class='avalista']//*[@id='profissao-avalista-conjuge']//input";
    String comboOcupacaoConjuge = "//*[@class='avalista']//*[@id='ocupacao-avalista-conjuge']//input";
    String txtEmpresaConjuge = "//*[@class='avalista']//*[@id='nome-empresa-avalista-conjuge']";
    String txtDataAdmissaoConjuge = "//*[@class='avalista']//*[@id='data-admissao-avalista-conjuge']";
    //RENDA
    String txtSalarioAvalista = "//*[@class='avalista']//*[@id='salario-proponente']";
    String txtSalarioConjAvalista = "//*[@class='avalista']//*[@id='salario-conjuge']";
    String txtOutrasRendasAvalista = "//*[@class='avalista']//*[@id='outras-rendas']";
    //PATRIMONIO
    String txtPatrimonioAvalista = "//*[@class='avalista']//*[@id='valor-patrimonio']";
    //BENS
    String radioVeiculoBensNaoSelecionado = "//*[@class='avalista']//*[@id='veiculo-selecionado-avalista']//*[contains(@class,'checkbox-inner')]";
    String radioVeiculoBensSelecionado = "//*[@class='avalista']//*[@id='veiculo-selecionado-avalista']//*[contains(@class,'checkbox-inner')]";
    String txtMarcaVeiculoBens = "//*[@class='avalista']//*[@id='marca']";
    String txtModeloVeiculoBens = "//*[@class='avalista']//*[@id='modelo']";
    String txtPlacaVeiculoBens = "//*[@class='avalista']//*[@id='placa']";
    //DADOS DE CONTA
    String comboBanco = "//*[@class='avalista']//*[@id='banco']//input";
    String txtAgencia = "//*[@class='avalista']//*[@id='agencia']";
    String lblValidandoAgencia = "//*[@class='avalista']//app-dado-bancario//*[@class='area-inconsistente']//*[text()='Validando...']";
    String txtConta = "//*[@class='avalista']//*[@id='conta']";
    //OUTROS
    String radioInserirAvalistaPf = "//*[@id='adicionar-avalista-pf'] | //*[@id='adicionar-outro-avalista-pf']";
    String btnAdicionarAvalistaDoQuadroExecutivo = "//*[@class='avalista']//div[contains(@class,'row avalista')]//*[@class='adicionar']";
    String modalCofirmacao = "//*[contains(@id, 'mat-dialog')]";
    String dropDownListaOpcoes = "//div[@class='cdk-overlay-pane']//mat-option";
    String btnSalvarAvalista = "//*[@class='avalista']//*[@id='salvar-avalista']";

    //DADOS GERAIS
    public void cpfDoAvalista(String cpfAvalista) {
        page.type(txtCpf, cpfAvalista);
        page.press(txtCpf, "Tab");
    }

    public void nomeDoAvalista(String nomeAvalista) {
        page.type(txtNome, nomeAvalista);
    }

    public void sexoDoAvalista(String sexo) {
        if (sexo.equalsIgnoreCase("MASCULINO") || sexo.equalsIgnoreCase("M")) {
            page.click(radioSexoMasc);
            //Action.clickOnElement(radioSexoMasc); //Clica 2x pois há um problema no componente do angular
        } else if (sexo.equalsIgnoreCase("FEMININO") || sexo.equalsIgnoreCase("F")) {
            page.click(radioSexoFem);
            //Action.clickOnElement(radioSexoFem); //Clica 2x pois há um problema no componente do angular
        }
    }

    public void nascimentoDoAvalista(String nascimentoAvalista) {
        page.type(txtDataNascimento, nascimentoAvalista);
    }

    public void nacionalidadeDoAvalista(String nacionalidadeAvalista) {
        page.click(comboNacionalidade);
        Util.selecionarItemDropdownPanel(nacionalidadeAvalista);
    }

    public void naturalidadeDoAvalista(String naturalidadeAvalista) {
        page.click(comboUfNaturalidade);
        Util.selecionarItemMatOption(naturalidadeAvalista);
    }

    public void municipioDoAvalista(String municipioAvalista) {
        page.click(comboMunicipio);
        Util.selecionarItemDropdownPanel(municipioAvalista);
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
        page.isEnabled(comboEstadoCivil);
        page.click(comboEstadoCivil);
        Util.selecionarItemMatOption(estadoCivil);
    }

    //CONTATO
    public void celularDoAvalista(String celularAvalista) {
        page.type(txtCelularAvalista, celularAvalista);
    }

    public void telefoneFixoDoAvalista(String telefoneFixoAvalista) {
        page.type(txtTelefoneAvalista, telefoneFixoAvalista);
    }

    public void emailDoAvalista(String emailAvalista) {
        page.type(txtEmailAvalista, emailAvalista);
    }

    //ENDERECO RESIDENCIAL
    public void cepResidencialDoAvalista(String cepResidencialAvalista) {
        page.type(txtCepResidencialAvalista, cepResidencialAvalista);
        page.press(txtCepResidencialAvalista, "Tab");
        Util.aguardarLoader();
    }

    public void numResidencialDoAvalista(String numResidencialAvalista) {
        page.type(txtNumResidencialAvalista, numResidencialAvalista);
    }

    public void complementoResidencialDoAvalista(String complemento) {
        page.type(txtComplementoResidencialAvalista, complemento);
    }

    //DOCUMENTOS
    public void rgRneDoAvalista(String rgRneAvalista) {

        page.type(txtRgRneAvalista, rgRneAvalista);
        page.press(txtRgRneAvalista, "Control+c");
    }

    public void orgaoEmissorDoAvalista(String orgaoEmissorAvalista) {
        page.type(txtOrgaoEmissorAvalista, orgaoEmissorAvalista);
    }

    public void ufDeEmissaoDoAvalista(String ufDeEmissaoAvalista) {
        page.click(comboUfEmissaoAvalista);
        Util.selecionarItemMatOption(ufDeEmissaoAvalista);
    }

    public void dataDeEmissaoDoAvalista(String dataDeEmissaoAvalista) {
        page.type(txtDataEmissaoAvalista, dataDeEmissaoAvalista);
    }

    //DADOS PROFISSIONAIS
    public void profissaoDoAvalista(String profissaoAvalista) {
        page.waitForTimeout(1000);
        page.click(comboProfissaoAvalista);
        Util.selecionarItemDropdownPanel(profissaoAvalista);
    }

    public void ocupacaoProfissionalDoAvalista(String ocupacaoProfissionalAvalista) {
        page.waitForTimeout(1000);
        page.click(comboOcupacaoAvalista);
        Util.selecionarItemDropdownPanel(ocupacaoProfissionalAvalista);
    }

    public void nomeDaEmpresaDoAvalista(String nomeDaEmpresaAvalista) {
        page.type(txtNomeEmpresaAvalista, nomeDaEmpresaAvalista);
    }

    public void dataDeAdmissaoDoAvalista(String dataDeAdmissaoAvalista) {
        page.waitForTimeout(1000);
        page.click(txtDataAdmissaoAvalista);
        Util.selecionarItemMatOption(" MENOS DE 1 ANO ");
    }

    //ENDERECO PROFISSIONAL
    public void copiarEnderecoResidencial() {
        page.click(linkCopiarEnderecoResidencial);
        //Util.scrollDown(200);
        //Report.takeScreenShot();
    }

    public void cepProfissionalAvalista(String cepProfissionalAvalista) {
        //getDriver().findElement(txtCepProfissionalAvalista).clear();
        page.type(txtCepProfissionalAvalista, cepProfissionalAvalista);
        page.press(txtCepProfissionalAvalista, "Tab");
        //Util.aguardarLoaderDirect();
    }

    public void numProfissionalAvalista(String numProfissionalAvalista) {
        page.type(txtNumeroProfissionalAvalista, numProfissionalAvalista);
    }

    public void complementoProfissionalDoAvalista(String complementoProfissional) {
        page.type(txtComplementoProfissionalAvalista, complementoProfissional);
    }

    //DADOS GERAIS DO CONJUGE
    public void cpfDoConjugeAvalista(String cpfAvalista) {
        page.type(txtCpfConjugeAvalista, cpfAvalista);
        page.press(txtCpfConjugeAvalista, "Tab");
    }

    public void nomeDoConjugeAvalista(String nomeConjuge) {
        page.type(txtNomeConjugeAvalista, nomeConjuge.toUpperCase());
    }

    public void nascimentoDoConjugeAvalista(String dataNascConjuge) {
        page.type(txtNascimentoConjugeAvalista, dataNascConjuge.replace("/", ""));
    }

    //DOCUMENTOS DO CONJUGE
    public void rgRneDoConjugeAvalista(String rgRneConjuge) {
        page.type(txtRgRneConjugeAvalista, rgRneConjuge);
        page.press(txtRgRneConjugeAvalista, "Control+c");
    }

    public void orgaoEmissorDoConjugeAvalista(String orgaoEmissorConjuge) {
        page.type(txtOrgaoEmissorConjugeAvalista, orgaoEmissorConjuge.toUpperCase());
    }

    //DADOS PROFISSIONAIS DO CONJUGE
    public void profissaoDoConjugeAvalista(String profissao) {
        page.waitForTimeout(1000);
        page.click(comboProfissaoConjuge);
        Util.selecionarItemDropdownPanel(profissao.toUpperCase());
    }

    public void ocupacaoProfissionalDoConjugeAvalista(String ocupacao) {
        page.isEnabled(comboOcupacaoConjuge);
        page.click(comboOcupacaoConjuge);
        Util.selecionarItemDropdownPanel(ocupacao);
    }

    public void nomeDaEmpresaDoConjugeAvalista(String empresa) {
        page.type(txtEmpresaConjuge, empresa);
    }

    public void dataDeAdmissaoDoConjugeAvalista(String dataAdmissaoConjuge) {
        page.isEnabled(txtDataAdmissaoConjuge);
        page.click(txtDataAdmissaoConjuge);
        Util.selecionarItemMatOption(dataAdmissaoConjuge);
    }

    //RENDA
    public void salarioDoAvalista(String salarioAvalista) {
        page.dblclick(txtSalarioAvalista);

        page.type(txtSalarioAvalista, salarioAvalista);
    }

    public void salarioDoConjugeAvalista(String salarioConjAvalista) {
        page.dblclick(txtSalarioConjAvalista);

        page.type(txtSalarioConjAvalista, salarioConjAvalista);
    }

    public void outrasRendasDoAvalista(String outrasRendasAvalista) {
        page.dblclick(txtOutrasRendasAvalista);

        page.type(txtOutrasRendasAvalista, outrasRendasAvalista);
    }

    //PATRIMONIO
    public void patrimonioDoAvalista(String patrimonioAvalista) {

        page.type(txtPatrimonioAvalista, patrimonioAvalista);
    }

    //BENS
    public void selecionarRadioVeiculoBens() {
        page.waitForTimeout(1500);
        page.click(radioVeiculoBensNaoSelecionado);
        page.waitForTimeout(1500);
    }

    public void desselecionarRadioVeiculoBens() {

        page.click(radioVeiculoBensSelecionado);
    }

    public void marcaVeiculoBens(String marca) {
        page.type(txtMarcaVeiculoBens, marca, new Page.TypeOptions().setDelay(150));
    }

    public void modeloVeiculoBens(String modelo) {
        page.type(txtModeloVeiculoBens, modelo);
    }

    public void placaVeiculoBens(String placa) {
        page.type(txtPlacaVeiculoBens, placa);
        page.press(txtPlacaVeiculoBens, "Control+c");
    }

    //DADOS DE CONTA
    public void bancoDoAvalista(String banco) {
        page.isEnabled(comboBanco);
        page.click(comboBanco);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void agenciaDoAvalista(String agencia) {
        page.type(txtAgencia, agencia);
        page.press(txtAgencia, "Tab");
    }

    public void contaDoAvalista(String conta) {

        page.type(txtConta, conta);
    }



    public void preencherFichaAvalistaPf(String estadoCivil) {
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
        //Documentos
        rgRneDoAvalista("" + faker.number().randomNumber(9, false));
        orgaoEmissorDoAvalista("SP");
        ufDeEmissaoDoAvalista("SP");
        dataDeEmissaoDoAvalista("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        //Dados Profissionais
        profissaoDoAvalista("ADMINISTRADOR");
        ocupacaoProfissionalDoAvalista("OUTROS");
        nomeDaEmpresaDoAvalista("BANCO TOYOTA");
        dataDeAdmissaoDoAvalista("MAIS DE 5 ANOS");
        //Endereco Profissional
        copiarEnderecoResidencial();
        takeScreenShot();

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
            dataDeAdmissaoDoConjugeAvalista(" MAIS DE 5 ANOS ");
            takeScreenShot();
        }
        //Renda
        salarioDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            salarioDoConjugeAvalista("" + faker.number().numberBetween(100000, 1000000));
        }
        outrasRendasDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        patrimonioDoAvalista("" + faker.number().numberBetween(1000000, 30000000));
        //Bens
        selecionarRadioVeiculoBens();
        marcaVeiculoBens("TOYOTA");
        modeloVeiculoBens("ETIOS");
        placaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //Banco
        bancoDoAvalista("0479 - BCO ITAUBANK S.A.");
        agenciaDoAvalista("0");
        contaDoAvalista("" + faker.number().numberBetween(1111, 999999));
        page.waitForTimeout(3000);
        takeScreenShot();
    }

    public void preencherFichaRepAvalistaPf(String estadoCivil) {
        Faker faker = new Faker(new Locale("pt-BR"));
        //Dados Gerais
        cpfDoAvalista(DataYaml.getMapYamlValues("massa", "massa PJ").get("socioAvalista0"));
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
        //Documentos
        rgRneDoAvalista("" + faker.number().randomNumber(9, false));
        orgaoEmissorDoAvalista("SP");
        ufDeEmissaoDoAvalista("SP");
        dataDeEmissaoDoAvalista("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        //Dados Profissionais
        profissaoDoAvalista("ADMINISTRADOR");
        ocupacaoProfissionalDoAvalista("OUTROS");
        nomeDaEmpresaDoAvalista("BANCO TOYOTA");
        dataDeAdmissaoDoAvalista("MAIS DE 5 ANOS");
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
            dataDeAdmissaoDoConjugeAvalista("MAIS DE 5 ANOS");
        }
        //Renda
        salarioDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            salarioDoConjugeAvalista("" + faker.number().numberBetween(100000, 1000000));
        }
        outrasRendasDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        patrimonioDoAvalista("" + faker.number().numberBetween(1000000, 30000000));
        //Bens
        selecionarRadioVeiculoBens();
        marcaVeiculoBens("TOYOTA");
        modeloVeiculoBens("ETIOS");
        placaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //Banco
        bancoDoAvalista("0479 - BCO ITAUBANK S.A.");
        agenciaDoAvalista("0");
        contaDoAvalista("" + faker.number().numberBetween(1111, 999999));
        page.waitForTimeout(3000);
        takeScreenShot();
    }
    public void clicarInserirAvalista() {
        page.click(radioInserirAvalistaPf);
    }

    public void preencherFichaAvalistaConjuge() {
        Faker faker = new Faker(new Locale("pt-BR"));
        //Dados Gerais
        sexoDoAvalista("M");
        naturalidadeDoAvalista("ES");
        municipioDoAvalista("ALEGRE");
        //Contato
        celularDoAvalista("11983915851");
        telefoneFixoDoAvalista("27" + faker.number().numberBetween(11111111, 99999999));
        emailDoAvalista("fabio.dantas@gft.com");
        //Documentos
        ufDeEmissaoDoAvalista("SP");
        dataDeEmissaoDoAvalista("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        //Endereco Profissional
        copiarEnderecoResidencial();
        //Renda
        outrasRendasDoAvalista("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        patrimonioDoAvalista("" + faker.number().numberBetween(1000000, 30000000));
        //Bens
        selecionarRadioVeiculoBens();
        marcaVeiculoBens("TOYOTA");
        modeloVeiculoBens("ETIOS");
        placaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //Banco
        bancoDoAvalista("0479 - BCO ITAUBANK S.A.");
        agenciaDoAvalista("060");
        contaDoAvalista("" + faker.number().numberBetween(1111, 999999));
        page.waitForTimeout(3000);
        takeScreenShot();
    }

    public void inserirAvalistaConjuge(String opcaoEscolhida) {
        page.isVisible(modalCofirmacao);
        page.waitForTimeout(2000);
        if (opcaoEscolhida.equalsIgnoreCase("SIM")) {
            page.click(modalCofirmacao);
            page.click("//button[text()='Sim']");
        } else {
            page.waitForTimeout(3000);
            page.click(modalCofirmacao);
            page.click("//button[text()='Não']");
        }
    }

    public void clicarSalvarAvalista() {
        Util.aguardarLoader();
        page.click(btnSalvarAvalista);
    }

    public void preencherFichaAvalistaPfEnriquecido(String cpf) {
        Faker faker = new Faker(new Locale("pt-BR"));
        //Dados Gerais
        cpfDoAvalista(cpf);

        //Banco
        bancoDoAvalista("0075 - BCO ABN AMRO S.A.");
        agenciaDoAvalista("0");
        contaDoAvalista("" + faker.number().numberBetween(1111, 999999));
        page.waitForTimeout(3000);
    }

    public void editarAvalista(String nome, String dataNascimento, String uf, String municipio, String contato, String email) {
        page.click(btnEditarAvalista);
        page.press(txtNome, "Control+a");
        page.type(txtNome,nome);
        page.press(txtDataNascimento,"Control+a");
        page.type(txtDataNascimento,dataNascimento);
        naturalidadeDoAvalista(uf);
        municipioDoAvalista(municipio);
        page.press(txtCelularAvalista, "Control+a");
        page.type(txtCelularAvalista,contato);
        page.press(txtEmailAvalista , "Control+a");
        page.type(txtEmailAvalista ,email);
        nomeAvalistaAlterado = nome;
    }

    public void validarAvalistaAlterado(){
        String nomeAvalista = page.textContent("#lista-avalista>div:nth-child(2)>div:nth-child(1)");
        assertEquals(nomeAvalista.trim(),nomeAvalistaAlterado);
    }

    public void excluirAvalista(){
        page.click(btnExcluirAvalista);
        page.waitForTimeout(3000);
        page.click("app-modal-mensagem>div:nth-child(2)>div:nth-child(2)>button");
    }

    public void validarExclusaoAvalista(){
        page.waitForTimeout(3000);
        Boolean visible = page.isVisible(frameListaAvalista);
        assertFalse(visible);
    }

    public void validarEnriquecimentoDeDados() {
        page.waitForTimeout(3000);
        //String teste = page.textContent(txtNome);
        page.press("input[name='nome']", "Control+a");
        String teste = page.textContent("input[name='nome']");

        System.out.println(teste);

        //Integer Nome = page.textContent(comboOcupacaoAvalista).length();
        assertNotEquals(teste,"");

    }
}

