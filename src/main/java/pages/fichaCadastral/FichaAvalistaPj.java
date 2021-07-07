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
public class FichaAvalistaPj extends DriverManager implements CommonTestingType {

    //DADOS BASICOS
    private By txtCnpj = By.xpath("//*[@class='avalista']//app-dado-basico//*[@id='cpf-cnpj']");
    private By txtRazaoSocial = By.xpath("//*[@class='avalista']//app-dado-basico//*[@id='razao-social']");
    private By txtNomeFantasia = By.xpath("//*[@class='avalista']//app-dado-basico//*[@id='nome-fantasia']");
    private By comboRamoAtividade = By.xpath("//*[@class='avalista']//app-dado-basico//*[@id='ramo-atividade']//input");
    private By comboSetorAtividade = By.xpath("//*[@class='avalista']//app-dado-basico//*[@id='setor-atividade']//input");
    private By txtDataFundacao = By.xpath("//*[@class='avalista']//app-dado-basico//*[@id='data-fundacao']");
    //CONTATO
    private By txtTelefoneFixo = By.xpath("//*[@class='avalista']//app-contato//*[@id='tel-fixo']");
    private By txtOutroTelefone = By.xpath("//*[@class='avalista']//app-contato//*[@id='outro-tel-fixo']");
    private By txtEmail = By.xpath("//*[@class='avalista']//app-contato//*[@id='email']");
    //ENDERECO
    private By txtCepEmpresa = By.xpath("//*[@class='avalista']//app-endereco//*[@id='cep']");
    private By txtNumeroEmpresa = By.xpath("//*[@class='avalista']//app-endereco//*[@id='numero']");
    //QUADRO EXECUTIVO
    private By chkboxSocioDiretor = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='tipo-executivo-socio-diretor-avalista-pessoa-juridica']");
    private By chkboxRepresentanteLegal = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='tipo-executivo-rep-legal-avalista-pessoa-juridica']");
    private By chkboxProcurador = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='tipo-executivo-procurador-avalista-pessoa-juridica']");
    private By txtCpfCnpjQuadroExecutivo = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='cpf-cnpj']");
    private By txtNomeRazaoQuadroExecutivo = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='nome-razao-social']");
    private By txtParitipacaoQuadroExecutivo = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='percentual-participacao']");
    private By txtCargoQuadroExecutivo = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='cargo']");
    private By txtCelularQuadroExecutivo = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='celular']");
    private By txtEmailQuadroExecutivo = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='email']");
    private By linkIncluirAlterar = By.xpath("//*[@class='avalista']//app-quadro-executivo//*[@id='link-incluir-alterar']");
    //RENDAS IMOBILIZADO
    private By txtFaturamentoEmpresa = By.xpath("//*[@class='avalista']//app-renda//*[@id='faturamento-mensal']");
    //BENS
    private By radioBensVeiculo = By.xpath("//*[@class='avalista']//app-bem//*[@id='veiculo-selecionado-avalista-pessoa-juridica']");
    private By txtMarcaBens = By.xpath("//*[@class='avalista']//app-bem//*[@id='marca']");
    private By txtModeloBens = By.xpath("//*[@class='avalista']//app-bem//*[@id='modelo']");
    private By txtPlacaBens = By.xpath("//*[@class='avalista']//app-bem//*[@id='placa']");
    //DADOS BANCARIOS
    private By comboBancoInput = By.xpath("//*[@class='avalista']//app-dado-bancario//*[@id='banco']//input");
    private By txtAgencia = By.xpath("//*[@class='avalista']//app-dado-bancario//*[@id='agencia']");
    private By lblValidandoAgencia = By.xpath("//*[@class='avalista']//app-dado-bancario//*[@class='area-inconsistente']//*[text()='Validando...']");
    private By txtConta = By.xpath("//*[@class='avalista']//app-dado-bancario//*[@id='conta']");
    //OUTROS
    //COMUNS EM FICHA DO AVALISTA
    private By radioInserirAvalistaPj = By.xpath("//*[@id='adicionar-avalista-pj'] | //*[@id='adicionar-outro-avalista-pj']");
    private By btnSalvarAvalista = By.xpath("//*[@class='avalista']//*[@id='salvar-avalista']");


    @Override
    public boolean isPresent() {
        Util.aguardarLoaderDirect();
        return Verifications.verifyElementIsVisible(radioInserirAvalistaPj);
    }

    //DADOS BASICOS
    public void preencherCnpjProponente(String cnpj) {
        Action.setText(txtCnpj, Util.formatarSomenteNumeros(cnpj));
        getDriver().findElement(txtCnpj).sendKeys(Keys.TAB);
        Util.aguardarLoaderDirect();
    }

    public void preencherRazaoSocialProponente(String razaoSocial) {
        Action.setText(txtRazaoSocial, razaoSocial.toUpperCase());
    }

    public void preencherNomeFantasiaProponente(String nomeFantasia) {
        Action.setText(txtNomeFantasia, nomeFantasia.toUpperCase());
    }

    public void preencherRamoDeAtividadeProponente(String ramoAtividade) {
        Action.clickOnElement(comboRamoAtividade);
        Util.selecionarItemDropdownPanel(ramoAtividade);
    }

    public void preencherSetorDeAtividadeProponente(String setorAtividade) {
        Action.clickOnElement(comboSetorAtividade);
        Util.selecionarItemDropdownPanel(setorAtividade);
    }

    public void preencherDataFundacaoProponente(String data) {
        Action.setText(txtDataFundacao, Util.formatarSomenteNumeros(data));
    }

    //CONTATO
    public void preencherTelFixo(String telefone) {
        Action.setText(txtTelefoneFixo, Util.formatarSomenteNumeros(telefone));
    }

    public void preencherOutroTelefone(String telefone) {
        Action.setText(txtOutroTelefone, Util.formatarSomenteNumeros(telefone));
    }

    public void preencherEmail(String email) {
        Action.setText(txtEmail, email.toUpperCase());
    }

    //ENDERECO
    public void preencherCepEmpresa(String cep) {
        Util.aguardarLoaderDirect();
        Action.setText(txtCepEmpresa, Util.formatarSomenteNumeros(cep));
        getDriver().findElement(txtCepEmpresa).sendKeys(Keys.TAB);
        Util.aguardarLoaderDirect();
    }

    public void preencherNumeroEmpresa(String numero) {
        Action.setText(txtNumeroEmpresa, Util.formatarSomenteNumeros(numero));
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
        Verifications.wait(2);
        Verifications.verifyElementDoesNotExist(lblValidandoAgencia);
    }

    public void preencherContaCorrente(String conta) {
        Action.setText(txtConta, conta);
    }

    public void inserirAvalista() {
        Action.clickOnElement(radioInserirAvalistaPj);
        Report.takeScreenShot();
    }

    public void botaoSalvarAvalista() {
        Action.clickOnElement(btnSalvarAvalista);
        Report.takeScreenShot();

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

    public void gerarFichaAvalistaPj() {
        gerarFichaAvalistaPj(1, 1, 0, 0, 0, 0);
    }

    public void gerarFichaAvalistaPj(int qntSocios, int qntRepLegal, int qntProcurador) {
        gerarFichaAvalistaPj(qntSocios, qntRepLegal, qntProcurador, 0, 0, 0);
    }

    public void gerarFichaAvalistaPj(int qntSocios, int qntRepLegal, int qntProcurador, int qntSocioRep, int qntSocioProcurador, int qntRepProcurador) {
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
