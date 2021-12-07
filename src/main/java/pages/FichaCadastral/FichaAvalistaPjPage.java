package pages.FichaCadastral;

import com.github.javafaker.Faker;
import support.browser.BrowserManager;
import support.data.DataYaml;
import support.documents.Documents;
import support.Utils.Util;
import java.util.Locale;

public class FichaAvalistaPjPage extends BrowserManager {


    //DADOS BASICOS
    private String txtCnpj = "//*[@class='avalista']//app-dado-basico//*[@id='cpf-cnpj']";
    private String txtRazaoSocial = "//*[@class='avalista']//app-dado-basico//*[@id='razao-social']";
    private String txtNomeFantasia = "//*[@class='avalista']//app-dado-basico//*[@id='nome-fantasia']";
    private String comboRamoAtividade = "//*[@class='avalista']//app-dado-basico//*[@id='ramo-atividade']//input";
    private String comboSetorAtividade = "//*[@class='avalista']//app-dado-basico//*[@id='setor-atividade']//input";
    private String txtDataFundacao = "//*[@class='avalista']//app-dado-basico//*[@id='data-fundacao']";
    //CONTATO
    private String txtTelefoneFixo = "//*[@class='avalista']//app-contato//*[@id='tel-fixo']";
    private String txtOutroTelefone = "//*[@class='avalista']//app-contato//*[@id='outro-tel-fixo']";
    private String txtEmail = "//*[@class='avalista']//app-contato//*[@id='email']";
    //ENDERECO
    private String txtCepEmpresa = "//*[@class='avalista']//app-endereco//*[@id='cep']";
    private String txtNumeroEmpresa = "//*[@class='avalista']//app-endereco//*[@id='numero']";
    //QUADRO EXECUTIVO
    private String chkboxSocioDiretor = "//*[@class='avalista']//app-quadro-executivo//*[@id='tipo-executivo-socio-diretor-avalista-pessoa-juridica']";
    private String chkboxRepresentanteLegal = "//*[@class='avalista']//app-quadro-executivo//*[@id='tipo-executivo-rep-legal-avalista-pessoa-juridica']";
    private String chkboxProcurador = "//*[@class='avalista']//app-quadro-executivo//*[@id='tipo-executivo-procurador-avalista-pessoa-juridica']";
    private String txtCpfCnpjQuadroExecutivo = "//*[@class='avalista']//app-quadro-executivo//*[@id='cpf-cnpj']";
    private String txtNomeRazaoQuadroExecutivo = "//*[@class='avalista']//app-quadro-executivo//*[@id='nome-razao-social']";
    private String txtParitipacaoQuadroExecutivo = "//*[@class='avalista']//app-quadro-executivo//*[@id='percentual-participacao']";
    private String txtCargoQuadroExecutivo = "//*[@class='avalista']//app-quadro-executivo//*[@id='cargo']";
    private String txtCelularQuadroExecutivo = "//*[@class='avalista']//app-quadro-executivo//*[@id='celular']";
    private String txtEmailQuadroExecutivo = "//*[@class='avalista']//app-quadro-executivo//*[@id='email']";
    private String linkIncluirAlterar = "//*[@class='avalista']//app-quadro-executivo//*[@id='link-incluir-alterar']";
    //RENDAS IMOBILIZADO
    private String txtFaturamentoEmpresa = "//*[@class='avalista']//app-renda//*[@id='faturamento-mensal']";
    //BENS
    private String radioBensVeiculo = "//*[@class='avalista']//app-bem//*[@id='veiculo-selecionado-avalista-pessoa-juridica']";
    private String txtMarcaBens = "//*[@class='avalista']//app-bem//*[@id='marca']";
    private String txtModeloBens = "//*[@class='avalista']//app-bem//*[@id='modelo']";
    private String txtPlacaBens = "//*[@class='avalista']//app-bem//*[@id='placa']";
    //DADOS BANCARIOS
    private String comboBancoInput = "//*[@class='avalista']//app-dado-bancario//*[@id='banco']//input";
    private String txtAgencia = "//*[@class='avalista']//app-dado-bancario//*[@id='agencia']";
    private String lblValidandoAgencia = "//*[@class='avalista']//app-dado-bancario//*[@class='area-inconsistente']//*[text()='Validando...']";
    private String txtConta = "//*[@class='avalista']//app-dado-bancario//*[@id='conta']";
    //OUTROS
    //COMUNS EM FICHA DO AVALISTA
    private String radioInserirAvalistaPj = "//*[@id='adicionar-avalista-pj'] | //*[@id='adicionar-outro-avalista-pj']";
    private String btnSalvarAvalista = "//*[@class='avalista']//*[@id='salvar-avalista']";


    //DADOS BASICOS
    public void preencherCnpjProponente(String cnpj) {
        page.fill(txtCnpj, cnpj);
        page.press(txtCnpj, "Tab");
        //Util.aguardarLoaderDirect();
    }

    public void preencherRazaoSocialProponente(String razaoSocial) {
        page.type(txtRazaoSocial, razaoSocial);
    }

    public void preencherNomeFantasiaProponente(String nomeFantasia) {
        page.type(txtNomeFantasia, nomeFantasia);
    }

    public void preencherRamoDeAtividadeProponente(String ramoAtividade) {
        page.click(comboRamoAtividade);
        Util.selecionarItemDropdownPanel(ramoAtividade);
    }

    public void preencherSetorDeAtividadeProponente(String setorAtividade) {
        page.click(comboSetorAtividade);
        Util.selecionarItemDropdownPanel(setorAtividade);
    }

    public void preencherDataFundacaoProponente(String data) {
        page.type(txtDataFundacao, data);
    }

    //CONTATO
    public void preencherTelFixo(String telefone) {
        page.type(txtTelefoneFixo, telefone);
    }

    public void preencherOutroTelefone(String telefone) {
        page.type(txtOutroTelefone, telefone);
    }

    public void preencherEmail(String email) {

        page.type(txtEmail, email);
    }

    //ENDERECO
    public void preencherCepEmpresa(String cep) {
        //Util.aguardarLoaderDirect();
        page.type(txtCepEmpresa, cep);
        page.press(txtCepEmpresa, "Tab");
        //Util.aguardarLoaderDirect();
    }

    public void preencherNumeroEmpresa(String numero) {
        page.type(txtNumeroEmpresa, numero);
    }

    //QUADRO EXECUTIVO
    public void selecionarSocioDiretorQuadroExecutivo() {
        page.click(chkboxSocioDiretor);
    }

    public void selecionarRepLegalQuadroExecutivo() {
        page.click(chkboxRepresentanteLegal);
    }

    public void selecionarProcuradorQuadroExecutivo() {
        page.click(chkboxProcurador);
    }

    public void preencherCpfCnpjQuadroExecutivo(String cpfCnpj) {
        page.type(txtCpfCnpjQuadroExecutivo, cpfCnpj);
        page.press(txtCpfCnpjQuadroExecutivo, "Tab");
    }

    public void preencherNomeRazaoQuadroExecutivo(String nomeRazao) {
        page.type(txtNomeRazaoQuadroExecutivo, nomeRazao);
    }

    public void preencherParticipacaoQuadroExecutivo(String participacao) {
        page.type(txtParitipacaoQuadroExecutivo, participacao);
    }

    public void preencherCargoQuadroExecutivo(String cargo) {
        page.type(txtCargoQuadroExecutivo, cargo);
    }

    public void clicarIncluirAlterarQuadroExecutivo() {
        //Report.takeScreenShot();
        page.click(linkIncluirAlterar);
    }

    public void preencherCelularQuadroExecutivo(String celular) {
        page.type(txtCelularQuadroExecutivo, celular);
    }

    public void preencherEmailQuadroExecutivo(String email) {
        page.type(txtEmailQuadroExecutivo, email);
    }

    //RENDAS IMOBILIZADO
    public void preencherFaturamentoMensal(String faturamento) {
        page.type(txtFaturamentoEmpresa, faturamento);
    }

    //BENS
    public void selecionarVeiculoBens() {
        page.click(radioBensVeiculo);
    }

    public void preencherMarcaVeiculoBens(String marca) {
        page.waitForTimeout(2000);
        page.type(txtMarcaBens, marca);
    }

    public void preencherModeloVeiculoBens(String modelo) {
        page.type(txtModeloBens, modelo);
    }

    public void preencherPlacaVeiculoBens(String placa) {
        page.type(txtPlacaBens, placa);
    }

    //DADOS BANCARIOS
    public void preencherBanco(String banco) {
        page.click(comboBancoInput);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void preencherAgencia(String agencia) {
        page.type(txtAgencia, agencia);
        page.press(txtAgencia, "Tab");
        page.waitForTimeout(2000);
    }

    public void preencherContaCorrente(String conta) {
        page.type(txtConta, conta);
    }


    public void clicarInserirAvalista() {
        page.click(radioInserirAvalistaPj);
        //Report.takeScreenShot();
    }

    public void clicarSalvarAvalista() {
        page.waitForTimeout(3000);
        page.click(btnSalvarAvalista);
    }

    public void preencherFichaAvalistaPj(int qntSocios, int qntRepLegal, int qntProcurador, int qntSocioRep, int qntSocioProcurador, int qntRepProcurador) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String cnpjGerado = Documents.getCnpj(false);

        //DADOS BASICOS
        preencherCnpjProponente(cnpjGerado);
        //Report.info("CNPJ PROPONENTE: " + cnpjGerado);
        preencherRazaoSocialProponente("DIRECT " + faker.name().lastName() + " LTDA");
        preencherNomeFantasiaProponente("DIRECT GERADOR");
        preencherRamoDeAtividadeProponente("PRIVADO - OUTROS");
        preencherSetorDeAtividadeProponente(" Cultivo de arroz ");
        preencherDataFundacaoProponente("20/05/1990");
        //CONTATO
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherOutroTelefone("27" + faker.number().numberBetween(11111111, 99999999));
        preencherEmail("fabio.dantas@gft.com");
        //Report.takeScreenShot();
        //ENDERECO
        preencherCepEmpresa("29045-402");
        page.waitForTimeout(3000);
        preencherNumeroEmpresa("2255");
        //Report.takeScreenShot();
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
            //Report.takeScreenShot();
        }
        //REP LEGAL(is)
        for (int repLegal = 0; repLegal < qntRepLegal; repLegal++) {
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
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
            //Report.takeScreenShot();
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
            //Report.takeScreenShot();
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
            //Report.takeScreenShot();
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
            //Report.takeScreenShot();
        }
        //RENDAS IMOBILIZADO
        preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //BENS
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //DADOS BANCARIOS
        preencherBanco("0479 - BCO ITAUBANK S.A.");
        preencherAgencia("060");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        //Util.scrollDown(50);
        //Report.takeScreenShot();
        //Util.scrollDown(250);
    }

    public void preencherFichaAvalistaPj(String tipo) {
        Faker faker = new Faker(new Locale("pt-BR"));

        //DADOS BASICOS
        preencherCnpjProponente(DataYaml.getMapYamlValues("Massa", "massa PJ").get(tipo));
        //Report.info("CNPJ PROPONENTE: " + cnpjGerado);
        //preencherRazaoSocialProponente("DIRECT " + faker.name().lastName() + " LTDA");
        //preencherNomeFantasiaProponente("DIRECT GERADOR");
        //preencherRamoDeAtividadeProponente("PRIVADO - OUTROS");
        //preencherSetorDeAtividadeProponente(" Cultivo de arroz ");
        //preencherDataFundacaoProponente("20/05/1990");
        //CONTATO
        //preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        //preencherOutroTelefone("27" + faker.number().numberBetween(11111111, 99999999));
        //preencherEmail("fabio.dantas@gft.com");
        //Report.takeScreenShot();
        //ENDERECO
        //preencherCepEmpresa("29045-402");
        //preencherNumeroEmpresa("2255");
        //Report.takeScreenShot();
        //QUADRO EXECUTIVO
        //SOCIO(s)
        //RENDAS IMOBILIZADO
        //preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //BENS
        //selecionarVeiculoBens();
        //preencherMarcaVeiculoBens("TOYOTA");
        //preencherModeloVeiculoBens("ETIOS");
        //preencherPlacaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //DADOS BANCARIOS
        //preencherBanco("0075 - ABN Amro");
        //preencherAgencia("0");
        //preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        //Util.scrollDown(50);
        //Report.takeScreenShot();
        //Util.scrollDown(250);
    }

    public void preencherFichaAvalistaRepAvalista(int qntRepAvalista, int qntRepLegal) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String cnpjGerado = Documents.getCnpj(false);

        //DADOS BASICOS
        preencherCnpjProponente(cnpjGerado);
        //Report.info("CNPJ PROPONENTE: " + cnpjGerado);
        preencherRazaoSocialProponente("DIRECT " + faker.name().lastName() + " LTDA");
        preencherNomeFantasiaProponente("DIRECT GERADOR");
        preencherRamoDeAtividadeProponente("PRIVADO - OUTROS");
        preencherSetorDeAtividadeProponente(" Cultivo de arroz ");
        preencherDataFundacaoProponente("20/05/1990");
        //CONTATO
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherOutroTelefone("27" + faker.number().numberBetween(11111111, 99999999));
        preencherEmail("fabio.dantas@gft.com");
        //Report.takeScreenShot();
        //ENDERECO
        preencherCepEmpresa("29045-402");
        page.waitForTimeout(3000);
        preencherNumeroEmpresa("2255");
        //Report.takeScreenShot();
        //QUADRO EXECUTIVO
        //SOCIO(s)
        for (int repAvalista = 0; repAvalista < qntRepAvalista; repAvalista++) {
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(DataYaml.getMapYamlValues("Massa", "massa PJ").get("repAvalista"+repAvalista));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
        }

        for (int repLegal = 0; repLegal < qntRepLegal; repLegal++) {
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
        }
        //RENDAS IMOBILIZADO
        preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //BENS
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //DADOS BANCARIOS
        preencherBanco("0479 - BCO ITAUBANK S.A.");
        preencherAgencia("060");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
    }

    public void preencherFichaAvalistaSocioAvalista(int qntsocioAvalista, int qntRepLegal) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String cnpjGerado = Documents.getCnpj(false);

        //DADOS BASICOS
        preencherCnpjProponente(cnpjGerado);
        //Report.info("CNPJ PROPONENTE: " + cnpjGerado);
        preencherRazaoSocialProponente("DIRECT " + faker.name().lastName() + " LTDA");
        preencherNomeFantasiaProponente("DIRECT GERADOR");
        preencherRamoDeAtividadeProponente("PRIVADO - OUTROS");
        preencherSetorDeAtividadeProponente(" Cultivo de arroz ");
        preencherDataFundacaoProponente("20/05/1990");
        //CONTATO
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherOutroTelefone("27" + faker.number().numberBetween(11111111, 99999999));
        preencherEmail("fabio.dantas@gft.com");
        //Report.takeScreenShot();
        //ENDERECO
        preencherCepEmpresa("29045-402");
        page.waitForTimeout(3000);
        preencherNumeroEmpresa("2255");
        //Report.takeScreenShot();
        //QUADRO EXECUTIVO
        //SOCIO(s)
        for (int socioAvalista = 0; socioAvalista < qntsocioAvalista; socioAvalista++) {
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(DataYaml.getMapYamlValues("Massa", "massa PJ").get("socioAvalista"+socioAvalista));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
        }

        for (int repLegal = 0; repLegal < qntRepLegal; repLegal++) {
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
        }
        //RENDAS IMOBILIZADO
        preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //BENS
        selecionarVeiculoBens();
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //DADOS BANCARIOS
        preencherBanco("0479 - BCO ITAUBANK S.A.");
        preencherAgencia("060");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));

    }
}
