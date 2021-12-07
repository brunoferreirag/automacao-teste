package pages.FichaCadastral;


import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import support.browser.BrowserManager;
import support.documents.Documents;
import support.Utils.Util;
import support.dates.DatePicker;

import java.util.Locale;

import static support.report.Report.takeScreenShot;

public class FichaProponentePfPage extends BrowserManager {


    //DADOS GERAIS
    String comboNacionalidade = "//app-complemento-pessoal//*[@id='nacionalidade']";//drop down
    String comboNaturalidade = "//app-complemento-pessoal//*[@id='uf-naturalidade']"; //mat opt
    String comboMunicipio = "//app-complemento-pessoal//*[@id='naturalidade']"; //drop down
    String comboEstadoCivil = "//app-complemento-pessoal//*[@id='estado-civil']"; //mat opt
    String radioBeneficiarioFinalSim = "//app-complemento-pessoal//mat-radio-group//*[text()='Sim']";
    String radioBeneficiarioFinalNao = "//app-complemento-pessoal//mat-radio-group//*[text()='Não']";
    String txtCpfBeneficiarioFinal = "//app-complemento-pessoal//*[@id='cpf-cnpj-beneficiario-final']";
    String txtNomeBeneficiarioFInal = "//app-complemento-pessoal//*[@id='nome-beneficiario-final']";
    //CONTATO
    String txtCelular = "//app-contato//input[@id='tel-celular']";
    String txtTelFixo = "//app-contato//input[@id='tel-fixo']";
    String txtEmail = "//app-contato//input[@id='email']";
    //ENDEREÇO RESIDENCIAL
    String txtCepResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='cep']";
    String txtLogradouroResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='logradouro']";
    String txtNumResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='numero']";
    String txtComplementoResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='complemento']";
    String txtBairroResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='bairro']";
    String txtMunicipioResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='cidade']";
    String txtUfResidencial = "//app-endereco[@tipoendereco='Residencial']//input[@id='estado']";
    //ENDEREÇO EMPLACAMENTO
    String txtCepEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='cep']";
    String txtLogradouroEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='logradouro']";
    String txtNumEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='numero']";
    String txtComplementoEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='complemento']";
    String txtBairroEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='bairro']";
    String txtMunicipioEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='cidade']";
    String txtUfEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='estado']";
    String comboUfEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//mat-select[@id='uf-emplacamento']"; //mat opt
    String txtTelefoneEmplacamento = "//app-endereco[@tipoendereco='Emplacamento']//input[@id='tel-emplacamento']";
    //DOCUMENTOS
    String txtRgRne = "//app-documento//input[@id='rg-rne-proponente']";
    String txtOrgaoEmissor = "//app-documento//input[@id='orgao-emissor-proponente']";
    String comboUfEmissao = "//app-documento//mat-select[@id='uf-emissao-proponente']"; //mat opt
    String txtDataEmissao = "//app-documento//input[@id='data-emissao-proponente']";
    String txtNomeDaMae = "//app-documento//input[@id='nome-mae-proponente']";
    //DADOS PROFISSIONAIS
    //String comboProfissao = "//app-dado-profissional//ng-select[@id='profissao-proponente']"; //dropdown
    String comboProfissao = "//app-dado-profissional//ng-select[@id='profissao-proponente']"; //dropdown
    String comboOcupacaoProfissional = "//app-dado-profissional//ng-select[@id='ocupacao-proponente']"; //dropdown
    String txtNomeEmpresa = "//app-dado-profissional//input[@id='nome-empresa-proponente']";
    String comboDataAdmissao = "//app-dado-profissional//mat-select[@id='data-admissao-proponente']"; //mat opt
    //ENDEREÇO PROFISSIONAL
    String linkCopiarEnderecoResidencial = "//app-endereco[@tipoendereco='Profissional']//span[text()='Copiar endereço residencial']";
    String txtCepProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='cep']";
    String txtLogradouroProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='logradouro']";
    String txtNumProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='numero']";
    String txtComplementoProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='complemento']";
    String txtBairroProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='bairro']";
    String txtMunicipioProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='cidade']";
    String txtUfProfissional = "//app-endereco[@tipoendereco='Profissional']//input[@id='estado']";
    //DADOS GERAIS DO CÔNJUGE
    String txtCpfConjuge = "//app-dado-pessoal//input[@id='cpf-cnpj-conjuge']";
    String txtNomeConjuge = "//app-dado-pessoal//input[@id='nome-conjuge']";
    String txtDataNascimentoConjuge = "//app-dado-pessoal//input[@id='data-nascimento-conjuge']";
    //DOCUMENTOS DO CÔNJUGE
    String txtRgRneConjuge = "//app-documento//input[@id='rg-rne-conjuge']";
    String txtOrgaoEmissorConjuge = "//app-documento//input[@id='orgao-emissor-conjuge']";
    //DADOS PROFISSIONAIS DO CÔNJUGE
    String comboProfissaoConjuge = "//app-dado-profissional//ng-select[@id='profissao-conjuge']"; //dropdown
    String comboOcupacaoProfissionalConjuge = "//app-dado-profissional//ng-select[@id='ocupacao-conjuge']"; //dropdown
    String txtNomeEmpresaConjuge = "//app-dado-profissional//input[@id='nome-empresa-conjuge']";
    String comboDataAdmissaoConjuge = "//app-dado-profissional//mat-select[@id='data-admissao-conjuge']"; //mat opt
    //RENDA
    String txtSalario = "//app-renda//input[@id='salario-proponente']";
    String txtSalarioConjuge = "//app-renda//input[@id='salario-conjuge']";
    String txtOutrasRendas = "//app-renda//input[@id='outras-rendas']";
    //PATRIMONIO
    String txtPatrimonio = "//mat-accordion//input[@id='valor-patrimonio']";
    //BENS
    String checkboxVeiculoDesmarcado = "//app-bem//mat-checkbox[@id='veiculo-selecionado-proponente']";
    String checkboxVeiculoMarcado = "//app-bem//mat-checkbox//input[@id='veiculo-selecionado-proponente-input'][@aria-checked='true']";
    String txtBensMarca = "//app-bem//input[@id='marca']";
    String txtBensModelo = "//app-bem//input[@id='modelo']";
    String txtBensPlaca = "//app-bem//input[@id='placa']";
    //DADOS DA CONTA
    String comboBanco = "//app-dado-bancario//ng-select[@id='banco']"; //dropdown
    String txtAgencia = "//app-dado-bancario//input[@id='agencia']";
    String txtContaCorrente = "//app-dado-bancario//input[@id='conta']";
    //OUTROS
    String btnProximoAtivo = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    String btnProximoInativo = "//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']";


    public void selecionarNaturalidade(String naturalidade) {
        page.click(comboNaturalidade);
        Util.selecionarItemMatOption(naturalidade);
    }

    public void selecionarNacionalidade(String nacionalidade){
        page.click(comboNacionalidade);
        Util.selecionarItemDropdownPanel(nacionalidade);
    }

    public void selecionarMunicipio(String municipio) {
        page.click(comboMunicipio);
        Util.selecionarItemDropdownPanel(municipio);
    }

    public void selecionarEstadoCivil(String estadoCivil) {
        page.click(comboEstadoCivil);
        Util.selecionarItemMatOption(estadoCivil);
    }

    public void selecionarBeneficiarioFinal(String opcao) {
        if (opcao.equalsIgnoreCase("SIM")) {
            page.click(radioBeneficiarioFinalSim);
        } else {
            page.click(radioBeneficiarioFinalNao);
        }
    }

    public void preencherCelular(String celular) {
        page.type(txtCelular, celular);
    }

    public void preencherTelFixo(String telefone) {
        page.type(txtTelFixo, telefone);
    }

    public void preencherEmail(String email) {
        page.type(txtEmail, email);
    }

    public void preencherNumeroResidencial(String numero) {
        Util.aguardarLoader();
        page.isEnabled(txtNumResidencial);
        page.waitForTimeout(3000);
        page.type(txtNumResidencial, numero);
    }

    public void preencherRgRne(String rgRne) {
        page.type(txtRgRne, rgRne);
        page.press(txtRgRne, "Control+c");
    }

    public void preencherOrgaoEmissor(String orgaoEmissor) {
        page.type(txtOrgaoEmissor, orgaoEmissor);
    }

    public void selecionarUfEmissaoDoc(String ufEmissao) {
        page.click(comboUfEmissao);
        Util.selecionarItemMatOption(ufEmissao);
    }

    public void preencherDataEmissaoDoc(String dataEmissao) {
        page.type(txtDataEmissao, dataEmissao);
    }

    public void preencherNomeMae(String nomeMae) {
        page.type(txtNomeDaMae, nomeMae);
    }

    public void selecionarProfissao(String profissao) {
        page.click(comboProfissao);
        Util.selecionarItemDropdownPanel(profissao);
    }

    public void selecionarOcupassaoProfissional(String ocupacao) {
        page.click(comboOcupacaoProfissional);
        Util.selecionarItemDropdownPanel(ocupacao);
    }

    public void preencherNomeEmpresa(String nomeEmpresa) {
        page.type(txtNomeEmpresa, nomeEmpresa);
    }

    public void selecionarDataAdmissao(String dataAdmissao) {
        page.click(comboDataAdmissao);
        Util.selecionarItemMatOption(dataAdmissao);
    }

    public void clicarLinkCopiarEnderecoResidencial() {
        page.click(linkCopiarEnderecoResidencial);
    }

    public void preencherCpfConjuge(String cpf) {
        page.type(txtCpfConjuge, cpf);
        page.press(txtCpfConjuge, "Tab");
    }

    public void preencherNomeConjuge(String nomeCompleto) {
        page.type(txtNomeConjuge, nomeCompleto);
    }

    public void preencherDataNascimentoConjuge(String dataNascimento) {
        page.type(txtDataNascimentoConjuge, dataNascimento);
    }

    public void preencherRgRneConjuge(String rgRne) {
        page.type(txtRgRneConjuge, rgRne);
        page.press(txtRgRneConjuge, "Control+c");
    }

    public void preencherOrgaoEmissoeConjuge(String orgaoEmissor) {
        page.type(txtOrgaoEmissorConjuge, orgaoEmissor);
    }

    public void selecionaProfissaoConjuge(String profissao) {
        page.click(comboProfissaoConjuge);
        Util.selecionarItemDropdownPanel(profissao);
    }

    public void selecionarOcupacaoProfissionalConjuge(String ocupacao) {
        page.click(comboOcupacaoProfissionalConjuge);
        Util.selecionarItemDropdownPanel(ocupacao);
    }

    public void preencherNomeEmpresaConjuge(String nomeEmpresa) {
        page.type(txtNomeEmpresaConjuge, nomeEmpresa);
    }

    public void selecionarDataAdmissaoConjuge(String dataAdmissao) {
        page.click(comboDataAdmissaoConjuge);
        Util.selecionarItemMatOption(dataAdmissao);
    }

    public void preencherSalario(String salario) {
        page.dblclick(txtSalario);
        page.type(txtSalario, salario);
    }

    public void preencherSalarioConjuge(String salarioConjuge) {
        page.dblclick(txtSalarioConjuge);
        page.type(txtSalarioConjuge, salarioConjuge);
    }

    public void preencherOutrasRendas(String outrasRendas) {
        page.dblclick(txtOutrasRendas);
        page.type(txtOutrasRendas, outrasRendas);
    }

    public void preencherPatrimonio(String patrimonio) {
        page.type(txtPatrimonio, patrimonio);
    }

    public void selecionarVeiculoBens() {
        page.waitForTimeout(1500);
        page.click(checkboxVeiculoDesmarcado);
        page.waitForTimeout(1500);
    }

    public void preencherMarcaVeiculoBens(String marca) {
        page.type(txtBensMarca, marca, new Page.TypeOptions().setDelay(150));
    }

    public void preencherModeloVeiculoBens(String modelo) {
        page.type(txtBensModelo, modelo);
        page.press(txtBensModelo, "Control+c");
    }

    public void preencherPlacaBens(String placa) {
        page.type(txtBensPlaca, placa);
        page.press(txtBensPlaca, "Control+c");
    }

    public void selecionarBanco(String banco) {
        page.click(comboBanco);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void preencherAgencia(String agencia) {
        page.type(txtAgencia, agencia);
        page.press(txtAgencia, "Tab");
    }

    public void preencherContaCorrente(String conta) {
        page.type(txtContaCorrente, conta);
        page.waitForTimeout(3000);
    }


    public void preencherFichaProponentePf(String estadoCivil) {
        Faker faker = new Faker(new Locale("pt-BR"));

        Util.aguardarLoader();
        //Dados Gerais
        selecionarNaturalidade("ES");
        selecionarMunicipio("ALEGRE");

        if (estadoCivil.equalsIgnoreCase("SOLTEIRO")) {
            selecionarEstadoCivil("Solteiro (a)");
        } else if (estadoCivil.equalsIgnoreCase("CASADO")) {
            selecionarEstadoCivil("Casado (a)");
        }
        selecionarBeneficiarioFinal("SIM");
        takeScreenShot();
        //Contato
        preencherCelular("11983915851");
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherEmail("guilherme@gft.com");
        takeScreenShot();
        //Endereco Residencial
        preencherNumeroResidencial("" + faker.number().numberBetween(10, 999));
        takeScreenShot();
        //Endereco Emplacamento
        Util.aguardarLoader();
        //Documentos
        preencherRgRne("" + faker.number().randomNumber(9, false));
        preencherOrgaoEmissor("ES");
        selecionarUfEmissaoDoc("ES");
        preencherDataEmissaoDoc("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        preencherNomeMae("" + faker.name().fullName());
        takeScreenShot();
        //Dados Profissionais
        selecionarProfissao("ADMINISTRADOR");
        selecionarOcupassaoProfissional("OUTROS");
        preencherNomeEmpresa("BANCO TOYOTA");
        selecionarDataAdmissao("MAIS DE 5 ANOS");
        takeScreenShot();
        //Endereco Profissional
        clicarLinkCopiarEnderecoResidencial();
        takeScreenShot();
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            //Dados Conjuge
            preencherCpfConjuge("" + Documents.getCpf(false));
            preencherNomeConjuge("" + faker.name().fullName());
            preencherDataNascimentoConjuge("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 24));
            takeScreenShot();
            //Documentos Conjuge
            preencherRgRneConjuge("" + faker.number().randomNumber(9, false));
            preencherOrgaoEmissoeConjuge("ES");
            takeScreenShot();
            //Dados Profissionais
            selecionaProfissaoConjuge("ADMINISTRADOR");
            selecionarOcupacaoProfissionalConjuge("OUTROS");
            preencherNomeEmpresaConjuge("BANCO TOYOTA");
            selecionarDataAdmissaoConjuge("MAIS DE 5 ANOS");
            takeScreenShot();
        }
        //Renda
        preencherSalario("" + faker.number().numberBetween(100000, 1000000));
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            preencherSalarioConjuge("" + faker.number().numberBetween(100000, 1000000));
        }
        preencherOutrasRendas("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        preencherPatrimonio("" + faker.number().numberBetween(1000000, 30000000));
        takeScreenShot();
        //Bens
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaBens("AAA" + faker.number().numberBetween(1111, 9999));
        takeScreenShot();
        //Banco
        selecionarBanco(" 0237 - BCO BRADESCO S.A. ");
        preencherAgencia("0897");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        takeScreenShot();
        page.waitForTimeout(3000);
    }

    public void preencherFichaProponentePfEnriquecido(){
        Faker faker = new Faker(new Locale("pt-BR"));
        page.waitForTimeout(3000);
        //Banco
        selecionarBanco(" 0237 - BCO BRADESCO S.A. ");
        preencherAgencia("0897");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        takeScreenShot();

    }

    public void preencherFichaProponentePfFarol(String arg0) {
        Faker faker = new Faker(new Locale("pt-BR"));

        Util.aguardarLoader();
        //Dados Gerais
        selecionarNaturalidade("ES");
        selecionarMunicipio("ALEGRE");
        selecionarEstadoCivil("Solteiro (a)");
        selecionarBeneficiarioFinal("SIM");
        takeScreenShot();
        //Contato
        if (arg0.equalsIgnoreCase("completo")) {
            preencherCelular("11983915851");
            preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
            preencherEmail("guilherme@gft.com");
            takeScreenShot();
        }
        //Endereco Residencial
        preencherNumeroResidencial("" + faker.number().numberBetween(10, 999));
        takeScreenShot();
        //Endereco Emplacamento
        Util.aguardarLoader();
        //Documentos
        preencherRgRne("" + faker.number().randomNumber(9, false));
        preencherOrgaoEmissor("ES");
        selecionarUfEmissaoDoc("ES");
        preencherDataEmissaoDoc("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        preencherNomeMae("" + faker.name().fullName());
        takeScreenShot();
        //Dados Profissionais
        selecionarProfissao("ADMINISTRADOR");
        selecionarOcupassaoProfissional("OUTROS");
        preencherNomeEmpresa("BANCO TOYOTA");
        selecionarDataAdmissao("MAIS DE 5 ANOS");
        takeScreenShot();
        //Endereco Profissional
        clicarLinkCopiarEnderecoResidencial();
        takeScreenShot();
        //Renda
        preencherSalario("" + faker.number().numberBetween(100000, 1000000));
        preencherOutrasRendas("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        preencherPatrimonio("" + faker.number().numberBetween(1000000, 30000000));
        takeScreenShot();
        //Bens
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaBens("AAA" + faker.number().numberBetween(1111, 9999));
        takeScreenShot();
        //Banco
        selecionarBanco(" 0237 - BCO BRADESCO S.A. ");
        preencherAgencia("0897");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        takeScreenShot();
        page.waitForTimeout(3000);
    }
}

