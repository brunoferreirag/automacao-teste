package pages.fichaCadastral;

import com.github.javafaker.Faker;
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
public class FichaProponentePj extends DriverManager implements CommonTestingType {

    //FICHA CADASTRAL
    private By lblFichaCadastral = By.xpath("//h4[contains(text(),'Ficha Cadastral')]");
    //DADOS BASICOS
    private By txtCnpjProponenteProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-empresa\"]//input[@id=\"cpf-cnpj\"]");
    private By txtRazaoSocialProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-empresa\"]//input[@id=\"razao-social\"]");
    private By txtNomeFantasiaProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-empresa\"]//input[@id=\"nome-fantasia\"]");
    private By comboRamoAtividadePropInput = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-empresa\"]//*[@id=\"ramo-atividade\"]//input");
    private By comboSetorAtividadePropInput = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-empresa\"]//*[@id=\"setor-atividade\"]//input");
    private By txtDataFundacaoProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-empresa\"]//input[@id=\"data-fundacao\"]");
    //CONTATO
    private By txtTelefoneFixoProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"contato\"]//input[@id=\"tel-fixo\"]");
    private By txtOutroTelefoneProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"contato\"]//input[@id=\"outro-tel-fixo\"]");
    private By txtEmailProp = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"contato\"]//input[@id=\"email\"]");
    //ENDERECO
    private By txtCepEmpresa = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"endereco\"]//input[@id=\"cep\"]");
    private By txtNumeroEmpresa = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"endereco\"]//input[@id=\"numero\"]");
    //ENDERECO EMPLACAMENTO
    private By txtCepEmplacamento = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"endereco-emplacamento\"]//input[@id=\"cep\"]");
    private By txtNumeroEmplacamento = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"endereco-emplacamento\"]//input[@id=\"numero\"]");
    private By comboUfEmplacamento = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"endereco-emplacamento\"]//*[@id=\"uf-emplacamento\"]");
    private By txtTelefoneEmplacamento = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"endereco-emplacamento\"]//input[@id=\"tel-emplacamento\"]");
    //QUADRO EXECUTIVO
    private By chkboxSocioDiretor = By.xpath("//*[@id=\"tipo-executivo-socio-diretor-proponente-pessoa-juridica\"]");
    private By chkboxRepresentanteLegal = By.xpath("//*[@id=\"tipo-executivo-rep-legal-proponente-pessoa-juridica\"]");
    private By chkboxProcurador = By.xpath("//*[@id=\"tipo-executivo-procurador-proponente-pessoa-juridica\"]");
    private By txtCpfCnpjQuadroExecutivo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//input[@id=\"cpf-cnpj\"]");
    private By txtNomeRazaoQuadroExecutivo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//input[@id=\"nome-razao-social\"]");
    private By txtParitipacaoQuadroExecutivo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//input[@id=\"percentual-participacao\"]");
    private By txtCargoQuadroExecutivo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//input[@id=\"cargo\"]");
    private By txtCelularQuadroExecutivo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//input[@id=\"celular\"]");
    private By txtEmailQuadroExecutivo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//input[@id=\"email\"]");
    private By linkIncluirAlterar = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"quadro-executivo\"]//span[@id=\"link-incluir-alterar\"]");
    //BENEFICIARIO FINAL
    private By txtCpfBeneficiarioFinal = By.xpath("//*[@id=\"cpf-cnpj-beneficiario-final\"]");
    private By txtNomeBeneficiarioFinal = By.xpath("//*[@id=\"nome-beneficiario-final\"]");
    //RENDAS IMOBILIZADO
    private By txtFaturamentoEmpresa = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"rendas-imobilizado\"]//input[@id=\"faturamento-mensal\"]");
    //BENS
    private By radioBensVeiculo = By.xpath("//form[@id=\"ficha-cadastral-form\"]//mat-expansion-panel-header//mat-checkbox[@id=\"veiculo-selecionado-proponente-pessoa-juridica\"]");
    private By txtMarcaBens = By.xpath("//form[@id=\"ficha-cadastral-form\"]//input[@id='marca']");
    private By txtModeloBens = By.xpath("//form[@id=\"ficha-cadastral-form\"]//input[@id='modelo']");
    private By txtPlacaBens = By.xpath("//form[@id=\"ficha-cadastral-form\"]//input[@id='placa']");
    //DADOS BANCARIOS
    private By comboBancoInput = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-bancarios\"]//*[@id=\"banco\"]//input");
    private By txtAgencia = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-bancarios\"]//input[@id=\"agencia\"]");
    private By txtConta = By.xpath("//form[@id=\"ficha-cadastral-form\"]//*[@id=\"dados-bancarios\"]//input[@id=\"conta\"]");
    //OUTROS
    private By btnProximoAtivo = By.xpath("//button[contains(@class, 'ativo')][text()='PRÓXIMO']");
    private By btnProximoInativo = By.xpath("//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']");

    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        return Verifications.verifyElementIsVisible(lblFichaCadastral);
    }

    //DADOS BASICOS
    public void preencherCnpjProponente(String cnpj) {
        Action.setText(txtCnpjProponenteProp, Util.formatarSomenteNumeros(cnpj));
        getDriver().findElement(txtCnpjProponenteProp).sendKeys(Keys.TAB);
        Util.aguardarLoaderDirect();
    }

    public void preencherRazaoSocialProponente(String razaoSocial) {
        Action.setText(txtRazaoSocialProp, razaoSocial.toUpperCase());
    }

    public void preencherNomeFantasiaProponente(String nomeFantasia) {
        Action.setText(txtNomeFantasiaProp, nomeFantasia.toUpperCase());
    }

    public void preencherRamoDeAtividadeProponente(String ramoAtividade) {
        Action.clickOnElement(comboRamoAtividadePropInput);
        Util.selecionarItemDropdownPanel(ramoAtividade);
    }

    public void preencherSetorDeAtividadeProponente(String setorAtividade) {
        Action.clickOnElement(comboSetorAtividadePropInput);
        Util.selecionarItemDropdownPanel(setorAtividade);
    }

    public void preencherDataFundacaoProponente(String data) {
        Action.setText(txtDataFundacaoProp, Util.formatarSomenteNumeros(data));
    }

    //CONTATO
    public void preencherTelFixo(String telefone) {
        Action.setText(txtTelefoneFixoProp, Util.formatarSomenteNumeros(telefone));
    }

    public void preencherOutroTelefone(String telefone) {
        Action.setText(txtOutroTelefoneProp, Util.formatarSomenteNumeros(telefone));
    }

    public void preencherEmail(String email) {
        Action.setText(txtEmailProp, email.toUpperCase());
    }

    //ENDERECO
    public void preencherCepEmpresa(String cep) {
        Verifications.wait(2);
        Util.aguardarLoaderDirect();
        Action.setText(txtCepEmpresa, Util.formatarSomenteNumeros(cep));
        getDriver().findElement(txtCepEmpresa).sendKeys(Keys.TAB);
        Verifications.wait(2);
        Util.aguardarLoaderDirect();
    }

    public void preencherNumeroEmpresa(String numero) {
        Action.setText(txtNumeroEmpresa, Util.formatarSomenteNumeros(numero));
    }

    //ENDERECO EMPLACAMENTO
    public void preencherCepEmplacamento(String cep) {
        Verifications.wait(2);
        Util.aguardarLoaderDirect();
        Action.setText(txtCepEmplacamento, Util.formatarSomenteNumeros(cep));
        getDriver().findElement(txtCepEmplacamento).sendKeys(Keys.TAB);
        Verifications.wait(2);
        Util.aguardarLoaderDirect();
    }

    public void preencherNumeroEmplacamento(String numero) {
        Action.setText(txtNumeroEmplacamento, numero);
    }

    public void preencherUfEmplacamento(String uf) {
        Action.clickOnElement(comboUfEmplacamento);
        Util.selecionarItemMatOption(uf);
    }

    public void preencherTelefoneEmplacamento(String telefone) {
        Verifications.verifyElementIsVisible(txtTelefoneEmplacamento);
        Action.setText(txtTelefoneEmplacamento, telefone);
    }

    //QUADRO EXECUTIVO
    public void selecionarSocioDiretorQuadroExecutivo() {
        Action.clickOnElement(chkboxSocioDiretor);
    }

    public void selecionarRepLegalQuadroExecutivo() {
        Action.clickOnElement(chkboxRepresentanteLegal);
    }

    public void selecionarProcuradorQuadroExecutivo() {
        Action.clickOnElement(chkboxProcurador);
    }

    public void preencherCpfCnpjQuadroExecutivo(String cpfCnpj) {
        Action.setText(txtCpfCnpjQuadroExecutivo, Util.formatarSomenteNumeros(cpfCnpj));
        getDriver().findElement(txtCpfCnpjQuadroExecutivo).sendKeys(Keys.TAB);
    }

    public void preencherNomeRazaoQuadroExecutivo(String nomeRazao) {
        Action.setText(txtNomeRazaoQuadroExecutivo, nomeRazao.toUpperCase());
    }

    public void preencherParticipacaoQuadroExecutivo(String participacao) {
        Action.setText(txtParitipacaoQuadroExecutivo, Util.formatarSomenteNumeros(participacao));
    }

    public void preencherCargoQuadroExecutivo(String cargo) {
        Action.setText(txtCargoQuadroExecutivo, cargo.toUpperCase());
    }

    public void clicarIncluirAlterarQuadroExecutivo() {
        //Report.takeScreenShot();
        Action.clickOnElement(linkIncluirAlterar);
    }

    public void preencherCelularQuadroExecutivo(String celular) {
        Action.setText(txtCelularQuadroExecutivo, Util.formatarSomenteNumeros(celular));
    }

    public void preencherEmailQuadroExecutivo(String email) {
        Action.setText(txtEmailQuadroExecutivo, email.toUpperCase());
    }

    //BENEFICIARIO FINAL
    public void informarBeneficiarioFinal(String cpf, String nome) {
        Util.preencherCampoTexto(txtCpfBeneficiarioFinal, Util.formatarSomenteNumeros(cpf));
        Util.preencherCampoTexto(txtNomeBeneficiarioFinal, Util.formatarSomenteNumeros(nome.toUpperCase()));
    }

    //RENDAS IMOBILIZADO
    public void preencherFaturamentoMensal(String faturamento) {
        Action.setText(txtFaturamentoEmpresa, Util.formatarSomenteNumeros(faturamento));
    }

    //BENS
    public void selecionarVeiculoBens() {
        Action.clickOnElement(radioBensVeiculo);
    }

    public void preencherMarcaVeiculoBens(String marca) {
        Action.setText(txtMarcaBens, marca.toUpperCase());
    }

    public void preencherModeloVeiculoBens(String modelo) {
        Action.setText(txtModeloBens, modelo.toUpperCase());
    }

    public void preencherPlacaVeiculoBens(String placa) {
        Action.setText(txtPlacaBens, placa.toUpperCase());
    }

    //DADOS BANCARIOS
    public void preencherBanco(String banco) {
        Action.clickOnElement(comboBancoInput);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void preencherAgencia(String agencia) {
        Action.setText(txtAgencia, agencia);
        getDriver().findElement(txtAgencia).sendKeys(Keys.TAB);
    }

    public void preencherContaCorrente(String conta) {
        Action.setText(txtConta, conta);
    }

    //OUTROS
    public void clicarBotaoProximo() {
        Util.scrollDown(250);
        Verifications.verifyElementIsClickable(btnProximoAtivo);
        Report.takeScreenShot();
        Action.clickOnElement(btnProximoAtivo);
        log.info("Clicado no botao Proximo da tela de Ficha Cadastral PJ");
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
        Util.scrollDown(300);
        Report.takeScreenShot();
    }

    public void gerarFichaProponentePj() {
        gerarFichaProponentePj(1, 1, 0, 0, 0, 0);
    }

    public void gerarFichaProponentePj(int qntSocios, int qntRepLegal, int qntProcurador) {
        gerarFichaProponentePj(qntSocios, qntRepLegal, qntProcurador, 0, 0, 0);
    }

    public void gerarFichaProponentePj(int qntSocios, int qntRepLegal, int qntProcurador, int qntSocioRep, int qntSocioProcurador, int qntRepProcurador) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String cnpjGerado = Documents.getCnpj(false);

        //DADOS BASICOS
        preencherCnpjProponente(cnpjGerado);
        Report.info("CNPJ PROPONENTE: " + cnpjGerado);
        preencherRazaoSocialProponente("DIRECT " + faker.name().lastName() + " LTDA");
        preencherNomeFantasiaProponente("DIRECT GERADOR");
        preencherRamoDeAtividadeProponente("PRIVADO - OUTROS");
        preencherSetorDeAtividadeProponente(" Cultivo de arroz ");
        preencherDataFundacaoProponente("20/05/1990");
        //CONTATO
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherOutroTelefone("27" + faker.number().numberBetween(11111111, 99999999));
        preencherEmail("fabio.dantas@gft.com");
        Report.takeScreenShot();
        //ENDERECO
        preencherCepEmpresa("29045-402");
        preencherNumeroEmpresa("2255");
        //ENDERECO EMPLACAMENTO
        preencherCepEmplacamento("29045-402");
        preencherNumeroEmplacamento("2255");
        Report.takeScreenShot();
        //QUADRO EXECUTIVO
        //SOCIO(s)
        for (int socio = 0; socio < qntSocios; socio++) {
            selecionarSocioDiretorQuadroExecutivo();
            //Randomiza se é PF ou PJ
            int random = faker.number().numberBetween(1, 2);
            if (random == 1) {
                preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
                preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            } else {
                preencherCpfCnpjQuadroExecutivo(Documents.getCnpj(false));
                preencherNomeRazaoQuadroExecutivo("BANCO "+faker.name().lastName()+" SA");
            }
            preencherParticipacaoQuadroExecutivo("10.00");
            preencherCargoQuadroExecutivo("SOCIO " + socio + 1);
            clicarIncluirAlterarQuadroExecutivo();
            Report.takeScreenShot();
        }
        //REP LEGAL(is)
        for (int repLegal = 0; repLegal < qntRepLegal; repLegal++) {
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            Report.takeScreenShot();
        }
        //PROCURADOR
        for (int procurador = 0; procurador < qntProcurador; procurador++) {
            selecionarProcuradorQuadroExecutivo();
            //Randomiza se é PF ou PJ
            int random = faker.number().numberBetween(1, 2);
            if (random == 1) {
                preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
                preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            } else {
                preencherCpfCnpjQuadroExecutivo(Documents.getCnpj(false));
                preencherNomeRazaoQuadroExecutivo("BANCO "+faker.name().lastName()+" SA");
            }
            clicarIncluirAlterarQuadroExecutivo();
            Report.takeScreenShot();
        }
        //SOCIO(s) e REP LEGAL(is)
        for (int socioRep = 0; socioRep < qntSocioRep; socioRep++) {
            selecionarSocioDiretorQuadroExecutivo();
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherParticipacaoQuadroExecutivo("10.00");
            preencherCargoQuadroExecutivo("SOCIO " + socioRep + 1);
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            Report.takeScreenShot();
        }
        //SOCIO(s) e PROCURADOR
        for (int socioProcurador = 0; socioProcurador < qntSocioProcurador; socioProcurador++) {
            selecionarSocioDiretorQuadroExecutivo();
            selecionarProcuradorQuadroExecutivo();
            //Randomiza se é PF ou PJ
            int random = faker.number().numberBetween(1, 2);
            if (random == 1) {
                preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
                preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            } else {
                preencherCpfCnpjQuadroExecutivo(Documents.getCnpj(false));
                preencherNomeRazaoQuadroExecutivo("BANCO "+faker.name().lastName()+" SA");
            }
            preencherParticipacaoQuadroExecutivo("10.00");
            preencherCargoQuadroExecutivo("SOCIO " + socioProcurador + 1);
            clicarIncluirAlterarQuadroExecutivo();
            Report.takeScreenShot();
        }
        //REP LEGAL(is) e PROCURADOR
        for (int repProcurador = 0; repProcurador < qntRepProcurador; repProcurador++) {
            selecionarRepLegalQuadroExecutivo();
            selecionarProcuradorQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            Report.takeScreenShot();
        }
        //RENDAS IMOBILIZADO
        preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //BENS
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //DADOS BANCARIOS
        preencherBanco("0075 - ABN Amro");
        preencherAgencia("0");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        Util.scrollDown(50);
        Report.takeScreenShot();
        Util.scrollDown(250);
    }
}
