package pages.FichaCadastral;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import support.Utils.Proposta;
import support.browser.BrowserManager;
import support.data.DataYaml;
import support.documents.Documents;
import support.Utils.Util;



import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static support.report.Report.takeScreenShot;

public class FichaProponentePjPage extends BrowserManager {

    //FICHA CADASTRAL
    private String lblFichaCadastral = "//h4[contains(text(),'Ficha Cadastral')]";
    //DADOS BASICOS
    private String txtCnpjProponenteProp = "//form[@id='ficha-cadastral-form']//*[@id='dados-empresa']//input[@id='cpf-cnpj']";
    private String txtRazaoSocialProp = "//form[@id='ficha-cadastral-form']//*[@id='dados-empresa']//input[@id='razao-social']";
    private String txtNomeFantasiaProp = "//form[@id='ficha-cadastral-form']//*[@id='dados-empresa']//input[@id='nome-fantasia']";
    private String comboRamoAtividadePropInput = "//form[@id='ficha-cadastral-form']//*[@id='dados-empresa']//*[@id='ramo-atividade']//input";
    private String comboSetorAtividadePropInput = "//form[@id='ficha-cadastral-form']//*[@id='dados-empresa']//*[@id='setor-atividade']//input";
    private String txtDataFundacaoProp = "//form[@id='ficha-cadastral-form']//*[@id='dados-empresa']//input[@id='data-fundacao']";
    //CONTATO
    private String txtTelefoneFixoProp = "//form[@id='ficha-cadastral-form']//*[@id='contato']//input[@id='tel-fixo']";
    private String txtOutroTelefoneProp = "//form[@id='ficha-cadastral-form']//*[@id='contato']//input[@id='outro-tel-fixo']";
    private String txtEmailProp = "//form[@id='ficha-cadastral-form']//*[@id='contato']//input[@id='email']";
    //ENDERECO
    private String txtCepEmpresa = "//form[@id='ficha-cadastral-form']//*[@id='endereco']//input[@id='cep']";
    private String txtNumeroEmpresa = "input[name='numero']";
    //ENDERECO EMPLACAMENTO
    private String txtCepEmplacamento = "//form[@id='ficha-cadastral-form']//*[@id='endereco-emplacamento']//input[@id='cep']";
    private String txtNumeroEmplacamento = "//form[@id='ficha-cadastral-form']//*[@id='endereco-emplacamento']//input[@id='numero']";
    private String comboUfEmplacamento = "//form[@id='ficha-cadastral-form']//*[@id='endereco-emplacamento']//*[@id='uf-emplacamento']";
    private String txtTelefoneEmplacamento = "//form[@id='ficha-cadastral-form']//*[@id='endereco-emplacamento']//input[@id='tel-emplacamento']";
    //QUADRO EXECUTIVO
    private String chkboxSocioDiretor = "//*[@id='tipo-executivo-socio-diretor-proponente-pessoa-juridica']";
    private String chkboxRepresentanteLegal = "//*[@id='tipo-executivo-rep-legal-proponente-pessoa-juridica']";
    private String chkboxProcurador = "//*[@id='tipo-executivo-procurador-proponente-pessoa-juridica']";
    private String txtCpfCnpjQuadroExecutivo = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//input[@id='cpf-cnpj']";
    private String txtNomeRazaoQuadroExecutivo = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//input[@id='nome-razao-social']";
    private String txtParitipacaoQuadroExecutivo = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//input[@id='percentual-participacao']";
    private String txtCargoQuadroExecutivo = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//input[@id='cargo']";
    private String txtCelularQuadroExecutivo = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//input[@id='celular']";
    private String txtEmailQuadroExecutivo = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//input[@id='email']";
    private String linkIncluirAlterar = "//form[@id='ficha-cadastral-form']//*[@id='quadro-executivo']//span[@id='link-incluir-alterar']";
    private String btnEditarSocio = "#integrantes-quadro-executivo>div>div:nth-child(2)>div>div>div:nth-child(2)>span:nth-child(1)>mat-icon";
    private String btnExcluirSocio = "#integrantes-quadro-executivo>div>div:nth-child(2)>div>div>div:nth-child(2)>span:nth-child(2)>mat-icon";
    private String frameQuadroExecutivo = "#integrantes-quadro-executivo";
    //BENEFICIARIO FINAL
    private String txtCpfBeneficiarioFinal = "//*[@id='cpf-cnpj-beneficiario-final']";
    private String txtNomeBeneficiarioFinal = "//*[@id='nome-beneficiario-final']";
    //RENDAS IMOBILIZADO
    private String txtFaturamentoEmpresa = "//form[@id='ficha-cadastral-form']//*[@id='rendas-imobilizado']//input[@id='faturamento-mensal']";
    //BENS
    private String radioBensVeiculo = "//form[@id='ficha-cadastral-form']//mat-expansion-panel-header//mat-checkbox[@id='veiculo-selecionado-proponente-pessoa-juridica']";
    private String txtMarcaBens = "//form[@id='ficha-cadastral-form']//input[@id='marca']";
    private String txtModeloBens = "//form[@id='ficha-cadastral-form']//input[@id='modelo']";
    private String txtPlacaBens = "//form[@id='ficha-cadastral-form']//input[@id='placa']";
    //DADOS BANCARIOS
    private String comboBancoInput = "//form[@id='ficha-cadastral-form']//*[@id='dados-bancarios']//*[@id='banco']//input";
    private String txtAgencia = "//form[@id='ficha-cadastral-form']//*[@id='dados-bancarios']//input[@id='agencia']";
    private String txtConta = "//form[@id='ficha-cadastral-form']//*[@id='dados-bancarios']//input[@id='conta']";
    //OUTROS
    private String btnProximoAtivo = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    private String btnProximoInativo = "//button[@class='btn ng-star-inserted'][text()='PRÓXIMO']";
    //EDITAR SOCIO
    private String nomeRazaoQuadroExecutivoEditado;
    private String participacaoRazaoQuadroExecutivoEditado;
    private String cargoRazaoQuadroExecutivoEditado;

    //DADOS BASICOS
    public void preencherCnpjProponente(String cnpj) {
        page.type(txtCnpjProponenteProp, cnpj);
        page.press(txtCnpjProponenteProp, "Tab");
        //Util.aguardarLoaderDirect();
    }

    public void preencherRazaoSocialProponente(String razaoSocial) {
        page.type(txtRazaoSocialProp, razaoSocial);
    }

    public void preencherNomeFantasiaProponente(String nomeFantasia) {
        page.type(txtNomeFantasiaProp, nomeFantasia);
    }

    public void preencherRamoDeAtividadeProponente(String ramoAtividade) {
        page.click(comboRamoAtividadePropInput);
        Util.selecionarItemDropdownPanel(ramoAtividade);
    }

    public void preencherSetorDeAtividadeProponente(String setorAtividade) {
        page.click(comboSetorAtividadePropInput);
        Util.selecionarItemDropdownPanel(setorAtividade);
    }

    public void preencherDataFundacaoProponente(String data) {
        page.type(txtDataFundacaoProp, data);
    }

    //CONTATO
    public void preencherTelFixo(String telefone) {
        page.type(txtTelefoneFixoProp, telefone);
    }

    public void preencherOutroTelefone(String telefone) {
        page.type(txtOutroTelefoneProp, telefone);
    }

    public void preencherEmail(String email) {
        page.type(txtEmailProp, email);
    }

    //ENDERECO
    public void preencherCepEmpresa(String cep) {
        page.waitForTimeout(2000);
        //Util.aguardarLoaderDirect();
        page.type(txtCepEmpresa, cep);
        page.press(txtCepEmpresa, "Tab");
        page.waitForTimeout(2000);
        //Util.aguardarLoaderDirect();
    }

    public void preencherNumeroEmpresa(String numero) {
        page.type(txtNumeroEmpresa, numero);
    }

    //ENDERECO EMPLACAMENTO
    public void preencherCepEmplacamento(String cep) {
        page.waitForTimeout(2000);
        //Util.aguardarLoaderDirect();
        page.type(txtCepEmplacamento, cep);
        page.press(txtCepEmplacamento, "Tab");
        page.waitForTimeout(2000);
        //Util.aguardarLoaderDirect();
    }

    public void preencherNumeroEmplacamento(String numero) {
        page.type(txtNumeroEmplacamento, numero);
    }

    public void preencherUfEmplacamento(String uf) {
        page.click(comboUfEmplacamento);
        Util.selecionarItemMatOption(uf);
    }

    public void preencherTelefoneEmplacamento(String telefone) {
        page.type(txtTelefoneEmplacamento, telefone);
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

        page.click(linkIncluirAlterar);
    }

    public void preencherCelularQuadroExecutivo(String celular) {

        page.type(txtCelularQuadroExecutivo, celular);
    }

    public void preencherEmailQuadroExecutivo(String email) {

        page.type(txtEmailQuadroExecutivo, email);
    }

    //BENEFICIARIO FINAL
    public void informarBeneficiarioFinal(String cpf, String nome) {
        page.press(txtCpfBeneficiarioFinal, "Control+a");
        page.type(txtCpfBeneficiarioFinal, cpf, new Page.TypeOptions().setDelay(300));
        page.press(txtNomeBeneficiarioFinal, "Control+a");
        page.type(txtNomeBeneficiarioFinal, nome, new Page.TypeOptions().setDelay(300));
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
        page.type(txtMarcaBens, marca, new Page.TypeOptions().setDelay(150));
    }

    public void preencherModeloVeiculoBens(String modelo) {
        page.type(txtModeloBens, modelo);
    }

    public void preencherPlacaVeiculoBens(String placa) {
        page.type(txtPlacaBens, placa);
        page.press(txtPlacaBens, "Control+c");
    }

    //DADOS BANCARIOS
    public void preencherBanco(String banco) {
        page.click(comboBancoInput);
        Util.selecionarItemDropdownPanel(banco);
    }

    public void preencherAgencia(String agencia) {
        page.type(txtAgencia, agencia);
        page.press(txtAgencia, "Tab");
    }

    public void preencherContaCorrente(String conta) {
        page.type(txtConta, conta);
    }


    public void preencherFichaProponentePj(int qntSocios, int qntRepLegal, int qntProcurador, int qntSocioRep, int qntSocioProcurador, int qntRepProcurador) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String cnpjGerado = Documents.getCnpj(false);
        Proposta.setCpfCnpjProponente(cnpjGerado);
        page.waitForTimeout(2000);
        //DADOS BASICOS
        preencherCnpjProponente(Proposta.getCpfCnpjProponente());
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
        takeScreenShot();
        //ENDERECO
        preencherCepEmpresa("29114-360");
        preencherNumeroEmpresa("2255");
        //ENDERECO EMPLACAMENTO
        //preencherCepEmplacamento("29045-402");
        //preencherNumeroEmplacamento("2255");
        //Report.takeScreenShot();
        takeScreenShot();
        //QUADRO EXECUTIVO
        //REP LEGAL(is)
        for (int repLegal = 0; repLegal < qntRepLegal; repLegal++) {
            page.waitForTimeout(2000);
            selecionarRepLegalQuadroExecutivo();
            String cpfGerado = Documents.getCpf(false);
            preencherCpfCnpjQuadroExecutivo(cpfGerado);
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            page.waitForTimeout(2000);
            clicarIncluirAlterarQuadroExecutivo();
            Util.salvarMassa("Massa", "massa PJ", "repAvalista"+repLegal, cpfGerado);
            //Report.takeScreenShot();
            takeScreenShot();
        }
        //PROCURADOR
        for (int procurador = 0; procurador < qntProcurador; procurador++) {
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
            takeScreenShot();
        }
        //SOCIO(s) e REP LEGAL(is)
        for (int socioRep = 0; socioRep < qntSocioRep; socioRep++) {
            page.waitForTimeout(2000);
            String cpfGerado = Documents.getCpf(false);
            selecionarSocioDiretorQuadroExecutivo();
            selecionarRepLegalQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(cpfGerado);
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherParticipacaoQuadroExecutivo("10.00");
            preencherCargoQuadroExecutivo("SOCIO " + socioRep + 1);
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            page.waitForTimeout(2000);
            clicarIncluirAlterarQuadroExecutivo();
            Util.salvarMassa("Massa", "massa PJ", "socioAvalista"+socioRep, cpfGerado);
            //Report.takeScreenShot();
            takeScreenShot();
        }
        //SOCIO(s) e PROCURADOR
        for (int socioProcurador = 0; socioProcurador < qntSocioProcurador; socioProcurador++) {
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
            takeScreenShot();
        }
        //REP LEGAL(is) e PROCURADOR
        for (int repProcurador = 0; repProcurador < qntRepProcurador; repProcurador++) {
            page.waitForTimeout(2000);
            selecionarRepLegalQuadroExecutivo();
            selecionarProcuradorQuadroExecutivo();
            preencherCpfCnpjQuadroExecutivo(Documents.getCpf(false));
            preencherNomeRazaoQuadroExecutivo(faker.name().fullName());
            preencherCelularQuadroExecutivo("11983915851");
            preencherEmailQuadroExecutivo("fabio.dantas@gft.com");
            page.waitForTimeout(2000);
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
            takeScreenShot();
        }
        //SOCIO(s)
        for (int socio = 0; socio < qntSocios; socio++) {
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
            clicarIncluirAlterarQuadroExecutivo();
            //Report.takeScreenShot();
            takeScreenShot();
        }
        // BENEFICIÁRIO FINAL
        informarBeneficiarioFinal("34800562880 ","LIDIA CUTRI");

        //RENDAS IMOBILIZADO
        preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //BENS
        selecionarVeiculoBens();
        page.waitForTimeout(1500);
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
        takeScreenShot();
    }

    public void preencherFichaProponentePjFarol(int qntSocios, int qntRepLegal, int qntProcurador, int qntSocioRep, int qntSocioProcurador, int qntRepProcurador) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String cnpjGerado = Documents.getCnpj(false);
        Proposta.setCpfCnpjProponente(cnpjGerado);
        page.waitForTimeout(2000);
        //DADOS BASICOS
        preencherCnpjProponente(Proposta.getCpfCnpjProponente());
        //Report.info("CNPJ PROPONENTE: " + cnpjGerado);
        preencherRazaoSocialProponente("DIRECT " + faker.name().lastName() + " LTDA");
        page.waitForTimeout(2000);
        preencherNomeFantasiaProponente("DIRECT GERADOR");
        preencherRamoDeAtividadeProponente("PRIVADO - OUTROS");
        preencherSetorDeAtividadeProponente(" Cultivo de arroz ");
        preencherDataFundacaoProponente("20/05/1990");
        //CONTATO
        preencherTelFixo("27" + faker.number().numberBetween(11111111, 99999999));
        preencherOutroTelefone("27" + faker.number().numberBetween(11111111, 99999999));
        page.press(txtEmailProp, "Control+a");
        preencherEmail("fabio.dantas@gft.com");
        //Report.takeScreenShot();
        //ENDERECO
        preencherCepEmpresa("29045-402");
        page.waitForTimeout(2000);
        preencherNumeroEmpresa("2255");
        //ENDERECO EMPLACAMENTO
        //preencherCepEmplacamento("29045-402");
        //preencherNumeroEmplacamento("2255");
        //Report.takeScreenShot();
        //QUADRO EXECUTIVO
        //SOCIO(s)
        for (int socio = 0; socio < qntSocios; socio++) {
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
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
            page.waitForTimeout(2000);
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
        page.waitForTimeout(1500);
        preencherMarcaVeiculoBens("TOYOTA");
        preencherModeloVeiculoBens("ETIOS");
        preencherPlacaVeiculoBens("AAA" + faker.number().numberBetween(1111, 9999));
        //DADOS BANCARIOS
        preencherBanco(" 0237 - BCO BRADESCO S.A. ");
        preencherAgencia("0897");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        //Util.scrollDown(50);
        //Report.takeScreenShot();
        //Util.scrollDown(250);
    }

    public void preencherFichaProponentePj(int qntSocios, int qntRepLegal, int qntProcurador, int qntSocioRep, int qntSocioProcurador, int qntRepProcurador, String tipo) {
        Faker faker = new Faker(new Locale("pt-BR"));
        page.waitForTimeout(5000);

        //DADOS BASICOS
        preencherCnpjProponente(DataYaml.getMapYamlValues("Massa", "massa PJ").get(tipo));
        page.waitForTimeout(5000);

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
        page.press(txtFaturamentoEmpresa, "Control+a");
        preencherFaturamentoMensal("" + faker.number().numberBetween(1000000, 100000000));
        //DADOS BANCARIOS
        preencherBanco(" 0075 - BCO ABN AMRO S.A. ");
        preencherAgencia("0");
        preencherContaCorrente("" + faker.number().numberBetween(1111, 999999));
        //Util.scrollDown(50);
        //Report.takeScreenShot();
        //Util.scrollDown(250);
    }

    public void gerarMassaPJ(String tipo){
        Util.salvarMassa("Massa", "massa PJ", tipo, Proposta.getCpfCnpjProponente());
    }

    public void editarQuadroExecutivo(String nome, String participacao, String cargo){
        page.click(btnEditarSocio);
        page.press(txtNomeRazaoQuadroExecutivo, "Control+a");
        page.type(txtNomeRazaoQuadroExecutivo,nome);
        page.press(txtParitipacaoQuadroExecutivo, "Control+a");
        page.type(txtParitipacaoQuadroExecutivo,participacao);
        page.press(txtCargoQuadroExecutivo, "Control+a");
        page.type(txtCargoQuadroExecutivo,cargo);
        nomeRazaoQuadroExecutivoEditado = nome;
        participacaoRazaoQuadroExecutivoEditado = participacao;
        cargoRazaoQuadroExecutivoEditado = cargo;
        clicarIncluirAlterarQuadroExecutivo();
    }

    public void validarSocioAlterado(){
        String nomeInformado = page.textContent("app-quadro-executivo>form>div>div>div:nth-child(2)>div>div>div:nth-child(1)");
        String participacaoInformado = page.textContent("app-quadro-executivo>form>div>div>div:nth-child(2)>div>div>div:nth-child(5)");
        String cargoInformado = page.textContent("app-quadro-executivo>form>div>div>div:nth-child(2)>div>div>div:nth-child(6)");
        assertEquals(nomeInformado.trim(),nomeRazaoQuadroExecutivoEditado);
        assertEquals(participacaoInformado.trim(),"Participação: " + participacaoRazaoQuadroExecutivoEditado);
        assertEquals(cargoInformado.trim(),"Cargo: " + cargoRazaoQuadroExecutivoEditado);
        page.waitForTimeout(1000);
        takeScreenShot();
    }

    public void excluirQuadroExecutivo(){
        page.click(btnExcluirSocio);
    }

    public void validarExclusaoSocio(){
        Boolean visible = page.isVisible(frameQuadroExecutivo);
        assertFalse(visible);
    }
}
