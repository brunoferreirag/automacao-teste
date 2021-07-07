package pages.fichaCadastral;

import com.github.javafaker.Faker;
import dates.DatePicker;
import documents.Documents;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.CommonTestingType;
import report.Report;
import support.Action;
import support.Util;
import support.Verifications;

import java.util.Locale;

@Log4j2
public class FichaProponentePf extends DriverManager implements CommonTestingType {

    //FICHA CADASTRAL
    private By lblFichaCadastral = By.xpath("//h4[contains(text(),'Ficha Cadastral')]");
    //DADOS GERAIS
    private By comboNacionalidade = By.xpath("//app-complemento-pessoal//*[@id='nacionalidade']");//drop down
    private By comboNaturalidade = By.xpath("//app-complemento-pessoal//*[@id='uf-naturalidade']"); //mat opt
    private By comboMunicipio = By.xpath("//app-complemento-pessoal//*[@id='naturalidade']"); //drop down
    private By comboEstadoCivil = By.xpath("//app-complemento-pessoal//*[@id='estado-civil']"); //mat opt
    private By radioBeneficiarioFinalSim = By.xpath("//app-complemento-pessoal//mat-radio-group//*[text()='Sim']");
    private By radioBeneficiarioFinalNao = By.xpath("//app-complemento-pessoal//mat-radio-group//*[text()='Não']");
    private By txtCpfBeneficiarioFinal = By.xpath("//app-complemento-pessoal//*[@id='cpf-cnpj-beneficiario-final']");
    private By txtNomeBeneficiarioFInal = By.xpath("//app-complemento-pessoal//*[@id='nome-beneficiario-final']");
    //CONTATO
    private By txtCelular = By.xpath("//app-contato//input[@id='tel-celular']");
    private By txtTelFixo = By.xpath("//app-contato//input[@id='tel-fixo']");
    private By txtEmail = By.xpath("//app-contato//input[@id='email']");
    //ENDEREÇO RESIDENCIAL
    private By txtCepResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='cep']");
    private By txtLogradouroResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='logradouro']");
    private By txtNumResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='numero']");
    private By txtComplementoResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='complemento']");
    private By txtBairroResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='bairro']");
    private By txtMunicipioResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='cidade']");
    private By txtUfResidencial = By.xpath("//app-endereco[@tipoendereco='Residencial']//input[@id='estado']");
    //ENDEREÇO EMPLACAMENTO
    private By txtCepEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='cep']");
    private By txtLogradouroEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='logradouro']");
    private By txtNumEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='numero']");
    private By txtComplementoEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='complemento']");
    private By txtBairroEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='bairro']");
    private By txtMunicipioEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='cidade']");
    private By txtUfEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='estado']");
    private By comboUfEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//mat-select[@id='uf-emplacamento']"); //mat opt
    private By txtTelefoneEmplacamento = By.xpath("//app-endereco[@tipoendereco='Emplacamento']//input[@id='tel-emplacamento']");
    //DOCUMENTOS
    private By txtRgRne = By.xpath("//app-documento//input[@id='rg-rne-proponente']");
    private By txtOrgaoEmissor = By.xpath("//app-documento//input[@id='orgao-emissor-proponente']");
    private By comboUfEmissao = By.xpath("//app-documento//mat-select[@id='uf-emissao-proponente']"); //mat opt
    private By txtDataEmissao = By.xpath("//app-documento//input[@id='data-emissao-proponente']");
    private By txtNomeDaMae = By.xpath("//app-documento//input[@id='nome-mae-proponente']");
    //DADOS PROFISSIONAIS
    private By comboProfissao = By.xpath("//app-dado-profissional//ng-select[@id='profissao-proponente']"); //dropdown
    private By comboOcupacaoProfissional = By.xpath("//app-dado-profissional//ng-select[@id='ocupacao-proponente']"); //dropdown
    private By txtNomeEmpresa = By.xpath("//app-dado-profissional//input[@id='nome-empresa-proponente']");
    private By comboDataAdmissao = By.xpath("//app-dado-profissional//mat-select[@id='data-admissao-proponente']"); //mat opt
    //ENDEREÇO PROFISSIONAL
    private By linkCopiarEnderecoResidencial = By.xpath("//app-endereco[@tipoendereco='Profissional']//span[text()='Copiar endereço residencial']");
    private By txtCepProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='cep']");
    private By txtLogradouroProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='logradouro']");
    private By txtNumProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='numero']");
    private By txtComplementoProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='complemento']");
    private By txtBairroProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='bairro']");
    private By txtMunicipioProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='cidade']");
    private By txtUfProfissional = By.xpath("//app-endereco[@tipoendereco='Profissional']//input[@id='estado']");
    //DADOS GERAIS DO CÔNJUGE
    private By txtCpfConjuge = By.xpath("//app-dado-pessoal//input[@id='cpf-cnpj-conjuge']");
    private By txtNomeConjuge = By.xpath("//app-dado-pessoal//input[@id='nome-conjuge']");
    private By txtDataNascimentoConjuge = By.xpath("//app-dado-pessoal//input[@id='data-nascimento-conjuge']");
    //DOCUMENTOS DO CÔNJUGE
    private By txtRgRneConjuge = By.xpath("//app-documento//input[@id='rg-rne-conjuge']");
    private By txtOrgaoEmissorConjuge = By.xpath("//app-documento//input[@id='orgao-emissor-conjuge']");
    //DADOS PROFISSIONAIS DO CÔNJUGE
    private By comboProfissaoConjuge = By.xpath("//app-dado-profissional//ng-select[@id='profissao-conjuge']"); //dropdown
    private By comboOcupacaoProfissionalConjuge = By.xpath("//app-dado-profissional//ng-select[@id='ocupacao-conjuge']"); //dropdown
    private By txtNomeEmpresaConjuge = By.xpath("//app-dado-profissional//input[@id='nome-empresa-conjuge']");
    private By comboDataAdmissaoConjuge = By.xpath("//app-dado-profissional//mat-select[@id='data-admissao-conjuge']"); //mat opt
    //RENDA
    private By txtSalario = By.xpath("//app-renda//input[@id='salario-proponente']");
    private By txtSalarioConjuge = By.xpath("//app-renda//input[@id='salario-conjuge']");
    private By txtOutrasRendas = By.xpath("//app-renda//input[@id='outras-rendas']");
    //PATRIMONIO
    private By txtPatrimonio = By.xpath("//mat-accordion//input[@id='valor-patrimonio']");
    //BENS
    private By checkboxVeiculoDesmarcado = By.xpath("//app-bem//mat-checkbox[@id='veiculo-selecionado-proponente']//div[@class='mat-checkbox-inner-container']");
    private By checkboxVeiculoMarcado = By.xpath("//app-bem//mat-checkbox//input[@id='veiculo-selecionado-proponente-input'][@aria-checked='true']");
    private By txtBensMarca = By.xpath("//app-bem//input[@id='marca']");
    private By txtBensModelo = By.xpath("//app-bem//input[@id='modelo']");
    private By txtBensPlaca = By.xpath("//app-bem//input[@id='placa']");
    //DADOS DA CONTA
    private By comboBanco = By.xpath("//app-dado-bancario//ng-select[@id='banco']"); //dropdown
    private By txtAgencia = By.xpath("//app-dado-bancario//input[@id='agencia']");
    private By txtContaCorrente = By.xpath("//app-dado-bancario//input[@id='conta']");
    //OUTROS
    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        return Verifications.verifyElementIsVisible(lblFichaCadastral);
    }

    //DADOS GERAIS
    public void selecionarNacionalidade(String pais) {
        Action.clickOnElement(comboNacionalidade);
        Util.selecionarItemDropdownPanel(pais);
    }

    public void selecionarNaturalidade(String uf) {
        Action.clickOnElement(comboNaturalidade);
        Util.selecionarItemMatOption(uf);
    }

    public void selecionarMunicipio(String municipio) {
        Action.clickOnElement(comboMunicipio);
        Util.selecionarItemDropdownPanel(municipio);
    }

    public void selecionarEstadoCivil(String estadoCivil) {
        Action.clickOnElement(comboEstadoCivil);
        Util.selecionarItemMatOption(estadoCivil);
    }

    //BENEFICIARIO FINAL
    public void selecionarRadioBeneficiarioFinal(String opcao) {
        if (opcao.equalsIgnoreCase("SIM")) {
            Action.clickOnElement(radioBeneficiarioFinalSim);
        } else {
            Action.clickOnElement(radioBeneficiarioFinalNao);
        }
    }

    public void preencherCpfBeneficiario(String cpf) {
        Action.setText(txtCpfBeneficiarioFinal, cpf);
    }

    public void preencherNomeBeneficiario(String nome) {
        Action.setText(txtNomeBeneficiarioFInal, nome);
    }

    //CONTATO
    public void preencherCelular(String celular) {
        Action.setText(txtCelular, celular);
    }

    public void preencherTelFixo(String telefone) {
        Action.setText(txtTelFixo, telefone);
    }

    public void preencherEmail(String email) {
        Action.setText(txtEmail, email.toUpperCase());
        Util.aguardarLoaderDirect();
    }

    //ENDERECO
    public void preencherCepResidencial(String cep) {
        Util.aguardarLoaderDirect();
        Action.setText(txtCepResidencial, cep);
        getDriver().findElement(txtCepResidencial).sendKeys(Keys.TAB);
    }

    public void preencherLogradouroResidencial(String logradouro) {
        Action.setText(txtLogradouroResidencial, logradouro);
    }

    public void preencherNumeroResidencial(String num) {
        Verifications.wait(1);
        Util.aguardarLoaderDirect();
        Action.setText(txtNumResidencial, num);
        Util.aguardarLoaderDirect();
    }

    public void preencherComplementoResidencial(String complemento) {
        Action.setText(txtComplementoResidencial, complemento);
    }

    public void preencherBairroResidencial(String bairro) {
        Action.setText(txtBairroResidencial, bairro);
    }

    public void preencherMunicipioResidencial(String municipio) {
        Action.setText(txtMunicipioResidencial, municipio);
    }

    public void preencherUfResidencial(String uf) {
        Action.setText(txtUfResidencial, uf);
    }

    //ENDERECO EMPLACAMENTO
    public void preencherCepEmplacamento(String cep) {
        Action.setText(txtCepEmplacamento, cep);
        getDriver().findElement(txtCepEmplacamento).sendKeys(Keys.TAB);
    }

    public void preencherLogradouroEmplacamento(String logradouro) {
        Action.setText(txtLogradouroEmplacamento, logradouro);
    }

    public void preencherNumeroEmplacamento(String num) {
        Action.setText(txtNumEmplacamento, num);
    }

    public void preencherComplementoEmplacamento(String complemento) {
        Action.setText(txtComplementoEmplacamento, complemento);
    }

    public void preencherBairroEmplacamento(String bairro) {
        Action.setText(txtBairroEmplacamento, bairro);
    }

    public void preencherMunicipioEmplacamento(String municipio) {
        Action.setText(txtMunicipioEmplacamento, municipio);
    }

    public void preencherUfEmplacamento(String uf) {
        Action.setText(txtUfEmplacamento, uf);
    }

    public void preencherComboUfEmplacamento(String uf) {
        Action.clickOnElement(comboUfEmplacamento);
        Util.selecionarItemMatOption(uf);
    }

    public void preencherTelefoneEmplacamento(String telefone) {
        Action.setText(txtTelefoneEmplacamento, telefone);
    }

    //DOCUMENTOS
    public void preencherRgRne(String rgRne) {
        Action.setText(txtRgRne, rgRne);
    }

    public void preencherOrgaoEmissor(String orgaoEmissor) {
        Action.setText(txtOrgaoEmissor, orgaoEmissor.toUpperCase());
    }

    public void selecionarUfEmissaoDoc(String ufEmissao) {
        Action.clickOnElement(comboUfEmissao);
        Util.selecionarItemMatOption(ufEmissao.toUpperCase());
    }

    public void preencherDataEmissaoDoc(String data) {
        Action.setText(txtDataEmissao, data);
    }

    public void preencherNomeMae(String nome) {
        Action.setText(txtNomeDaMae, nome.toUpperCase());
    }

    //DADOS PROFISSIONAIS
    public void selecionarProfissao(String profissao) {
        Action.clickOnElement(comboProfissao);
        Util.selecionarItemDropdownPanel(profissao);
    }

    public void selecionarOcupassaoProfissional(String ocupacao) {
        Action.clickOnElement(comboOcupacaoProfissional);
        Util.selecionarItemDropdownPanel(ocupacao);
    }

    public void preencherNomeEmpresa(String nome) {
        Action.setText(txtNomeEmpresa, nome.toUpperCase());
    }

    public void selecionarDataAdmissao(String data) {
        Action.clickOnElement(comboDataAdmissao);
        Util.selecionarItemMatOption(data);
    }

    //ENDERECO PROFISSIONAL
    public void clicarLinkCopiarEnderecoResidencial() {
        Action.clickOnElement(linkCopiarEnderecoResidencial);
    }

    public void preencherCepProfissional(String cep) {
        Action.setText(txtCepProfissional, cep);
        getDriver().findElement(txtCepProfissional).sendKeys(Keys.TAB);
    }

    public void preencherLogradouroProfissional(String logradouro) {
        Action.setText(txtLogradouroProfissional, logradouro);
    }

    public void preencherNumeroProfissional(String num) {
        Action.setText(txtNumProfissional, num);
    }

    public void preencherComplementoProfissional(String complemento) {
        Action.setText(txtComplementoProfissional, complemento.toUpperCase());
    }

    public void preencherBairroProfissional(String bairro) {
        Action.setText(txtBairroProfissional, bairro);
    }

    public void preencherMunicipioProfissional(String municipio) {
        Action.setText(txtMunicipioProfissional, municipio);
    }

    public void preencherUfProfissional(String uf) {
        Action.setText(txtUfProfissional, uf);
    }

    //DADOS GERAIS DO CÔNJUGE
    public void preencherCpfConjuge(String cpf) {
        Action.setText(txtCpfConjuge, cpf);
        getDriver().findElement(txtCpfConjuge).sendKeys(Keys.TAB);
    }

    public void preencherNomeConjuge(String nome) {
        Action.setText(txtNomeConjuge, nome.toUpperCase());
    }

    public void preencherDataNascimentoConjuge(String data) {
        Action.setText(txtDataNascimentoConjuge, data);
    }

    //DOCUMENTOS DO CÔNJUGE
    public void preencherRgRneConjuge(String rgRne) {
        Action.setText(txtRgRneConjuge, rgRne);
    }

    public void preencherOrgaoEmissoeConjuge(String orgaoEmissor) {
        Action.setText(txtOrgaoEmissorConjuge, orgaoEmissor.toUpperCase());
    }

    //DADOS PROFISSIONAIS DO CÔNJUGE
    public void selecionaProfissaoConjuge(String profissao) {
        Action.clickOnElement(comboProfissaoConjuge);
        Util.selecionarItemDropdownPanel(profissao.toUpperCase());
    }

    public void selecionarOcupacaoProfissionalConjuge(String ocupacao) {
        Action.clickOnElement(comboOcupacaoProfissionalConjuge);
        Util.selecionarItemDropdownPanel(ocupacao.toUpperCase());
    }

    public void preencherNomeEmpresaConjuge(String nome) {
        Action.setText(txtNomeEmpresaConjuge, nome.toUpperCase());
    }

    public void selecionarDataAdmissaoConjuge(String data) {
        Action.clickOnElement(comboDataAdmissaoConjuge);
        Util.selecionarItemMatOption(data);
    }

    //RENDA
    public void preencherSalario(String salario) {
        Util.preencherCampoTexto(txtSalario, Util.formatarSomenteNumeros(salario));
    }

    public void preencherSalarioConjuge(String salario) {
        Util.preencherCampoTexto(txtSalarioConjuge, Util.formatarSomenteNumeros(salario));
    }

    public void preencherOutrasRendas(String outrasRendas) {
        Util.preencherCampoTexto(txtOutrasRendas, Util.formatarSomenteNumeros(outrasRendas));
    }

    //PATRIMONIO
    public void preencherPatrimonio(String patrimonio) {
        Util.preencherCampoTexto(txtPatrimonio, Util.formatarSomenteNumeros(patrimonio));
    }

    //BENS
    public void selecionarVeiculoBens() {
        Action.clickOnElement(checkboxVeiculoDesmarcado);
        if (getDriver().findElements(checkboxVeiculoMarcado).size() == 0) {
            Action.clickOnElement(checkboxVeiculoDesmarcado);
        }
    }

    public void preencherMarcaVeiculoBens(String marca) {
        Verifications.verifyElementExists(txtBensMarca);
        Action.setText(txtBensMarca, marca.toUpperCase());
    }

    public void preencherModeloVeiculoBens(String modelo) {
        Action.setText(txtBensModelo, modelo.toUpperCase());
    }

    public void preencherPlacaBens(String placa) {
        Action.setText(txtBensPlaca, placa.toUpperCase());
    }

    //DADOS DA CONTA
    public void selecionarBanco(String banco) {
        Action.clickOnElement(comboBanco);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void preencherAgencia(String agencia) {
        Action.setText(txtAgencia, agencia);
        getDriver().findElement(txtAgencia).sendKeys(Keys.TAB);
    }

    public void preencherContaCorrente(String conta) {
        Action.setText(txtContaCorrente, conta);
    }

    //OUTROS
    public void clicarBotaoProximo() {
        Util.scrollDown(250);
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de Ficha Cadastral PF");
    }

    public void gerarFichaProponentePf(String estadoCivil) {
        Faker faker = new Faker(new Locale("pt-BR"));

        Util.aguardarLoaderDirect();
        //Dados Gerais
        selecionarNaturalidade("ES");
        selecionarMunicipio("ALEGRE");

        if (estadoCivil.equalsIgnoreCase("SOLTEIRO")) {
            selecionarEstadoCivil("Solteiro (a)");
        } else if (estadoCivil.equalsIgnoreCase("CASADO")) {
            selecionarEstadoCivil("Casado (a)");
        }
        selecionarRadioBeneficiarioFinal("SIM");
        //Contato
        preencherCelular("11983915851");
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherEmail("fabio.dantas@gft.com");
        //Endereco Residencial
        preencherNumeroResidencial("" + faker.number().numberBetween(10, 999));
        //Endereco Emplacamento
        Util.aguardarLoaderDirect();
        Util.scrollDown(250);
        Util.aguardarLoaderDirect();
        Report.takeScreenShot();
        //Documentos
        preencherRgRne("" + faker.number().randomNumber(9, false));
        preencherOrgaoEmissor("ES");
        selecionarUfEmissaoDoc("ES");
        preencherDataEmissaoDoc("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 2));
        preencherNomeMae("" + faker.name().fullName());
        //Dados Profissionais
        selecionarProfissao("ADMINISTRADOR");
        selecionarOcupassaoProfissional("OUTROS");
        preencherNomeEmpresa("BANCO TOYOTA");
        selecionarDataAdmissao("Mais de 5 anos");
        Util.scrollDown(50);
        Report.takeScreenShot();
        //Endereco Profissional
        clicarLinkCopiarEnderecoResidencial();
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            //Dados Conjuge
            preencherCpfConjuge("" + Documents.getCpf(false));
            preencherNomeConjuge("" + faker.name().fullName());
            preencherDataNascimentoConjuge("" + faker.number().numberBetween(10, 28) + DatePicker.getMonth() + "" + (Integer.parseInt(DatePicker.getYear()) - 24));
            //Documentos Conjuge
            preencherRgRneConjuge("" + faker.number().randomNumber(9, false));
            preencherOrgaoEmissoeConjuge("ES");
            //Dados Profissionais
            selecionaProfissaoConjuge("ADMINISTRADOR");
            selecionarOcupacaoProfissionalConjuge("OUTROS");
            preencherNomeEmpresaConjuge("BANCO TOYOTA");
            selecionarDataAdmissaoConjuge("Mais de 5 anos");
            Util.scrollDown(50);
            Report.takeScreenShot();
        }
        //Renda
        preencherSalario("" + faker.number().numberBetween(100000, 1000000));
        if (estadoCivil.equalsIgnoreCase("CASADO")) {
            preencherSalarioConjuge("" + faker.number().numberBetween(100000, 1000000));
        }
        preencherOutrasRendas("" + faker.number().numberBetween(100000, 1000000));
        //Patrimonio
        preencherPatrimonio("" + faker.number().numberBetween(1000000, 30000000));
        Util.scrollDown(50);
        Report.takeScreenShot();
        //Bens
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaBens("AAA" + faker.number().numberBetween(1111, 9999));
        //Banco
        selecionarBanco("0075 - ABN Amro");
        preencherAgencia("0");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        Util.scrollDown(50);
        Report.takeScreenShot();
        Util.scrollDown(250);
    }


}
