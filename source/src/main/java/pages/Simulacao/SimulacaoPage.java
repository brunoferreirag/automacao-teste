package pages.Simulacao;

import com.github.javafaker.Faker;
import com.microsoft.playwright.ElementHandle;
import support.Utils.Proposta;
import support.Utils.Util;
import support.browser.BrowserManager;
import support.documents.Documents;

import java.util.Locale;

import static org.junit.Assert.*;
import static support.report.Report.takeScreenShot;


public class SimulacaoPage extends BrowserManager {

    Faker faker = new Faker(new Locale("pt-BR"));

    String abaParcela = "//div[@class='mat-tab-label-content'][text()='PARCELA']";
    String abaResidual = "//div[@class='mat-tab-label-content'][text()='RESIDUAL']";
    String abaPrazo = "//div[@class='mat-tab-label-content'][text()='PRAZO']";

    String txtValorVeiculo = "#valor-bem";
    String txtValorEntrada = "#valor-entrada";
    String txtValorParcela = "#valor-parcela";
    String txtValorResidual = "#valor-residual";
    String comboPrazo = "#prazo-desejado";
    String radioSubsidioTaxa = "#subsidio-tipo-taxa";
    String radioSubsidioValor = "#subsidio-tipo-valor";
    String txtValorSubsidio = "#subsidio-valor";
    String txtTaxaSubsidio = "#subsidio-taxa";
    String comboPrazoSubsidio = "#subsidio-prazo";
    String btnCalcularInativo = "//button[@disabled][text()='CALCULAR']";
    String comboPlanoDeFinanciamento = "#prazo";
    String btnProximoSimulacaoAtivo = "//button[contains(@class, 'ativo')][text()='PRÓXIMO']";
    String stepConfiguracaoVeiculo = "div[class='drag-scroll-content']>div:nth-child(2)>img";
    String stepConfiguracao = "div[class='drag-scroll-content']>div:nth-child(1)>img";
    //ITENS FINANCIAVEIS
    String comboItemFinanciavel = "mat-select[name='item-financiavel']";
    String btnAddItemFinanciavel = "#adicionar-itens-financiaveis";
    String btnAdicionartemFinanciavel = "button[class='adicionar']";
    String btnExcluirItemFinanciavel = "img[class='icone-exclusao']";
    String btnEditarItemFinanciavel = "img[class='item-edicao']";
    String txtValorItemFinanciavel = "input[name='valor-item']";
    String carrinhoItensFinanciaveis = "#abas-carrinho>div>mat-tab-body>div>mat-accordion>mat-expansion-panel:nth-child(3)";
    //SEGURO PRESTAMISTA
    String carrinhoSeguroPrestamista = "#abas-carrinho>div>mat-tab-body>div>mat-accordion>mat-expansion-panel:nth-child(2)";
    //String carrinhoSeguroPrestamista = "#lista-seguro-prestamista";
    String carrinhoSeguroSPF = "#lista-seguro-prestamista>div>div>div>div>span";
    String abaEditarItemFinanciavel = "div[class='simulador']>form>div:nth-child(3)>div>div";
    String valorItemFinanciavel;
    String itemFinanciavel;
    String btnExcluirPrestamista = "#excluir-SPF";
    //SEGURO AUTO INTEGRADO
    String btnAdicionarSeguroAuto = "#adicionar-seguro-auto";
    String comboTipoSeguroAuto = "mat-select[id='tipo'][placeholder='Tipo de seguro']";
    String txtCpfSeguroAuto = "//app-seguro-auto-integrado//input[contains(@id, 'cpf-cnpj')]";
    String txtNomeSeguroAuto = "//app-seguro-auto-integrado//input[contains(@id, 'nome')]";
    String txtDataNascimentoSeguroAuto = "//app-seguro-auto-integrado//input[contains(@id, 'data-nascimento')]";
    String txtCepSeguroAuto = "//app-seguro-auto-integrado//input[contains(@id, 'cep-pernoite')]";
    String btnContinuarSeguroAuto = "//*[contains(@class, 'row botao-opcao')]//button[contains(text(), 'Continuar')]";
    String btnCancelarSeguroAuto = "//*[contains(@class, 'row botao-opcao')]//button[contains(text(), 'Cancelar')]";
    String radioSexoFemininoSeguroAuto = "//mat-radio-group[@formcontrolname='sexo']//mat-radio-button[@value='F']";
    String radioSexoMasculinhoSeguroAuto = "//mat-radio-group[@formcontrolname='sexo']//mat-radio-button[@value='M']";
    String radioCondutorEntre18e25AnosSimSeguroAuto = "//mat-radio-group[@formcontrolname='condutor-menor-25-anos']//mat-radio-button[@value='true']";
    String radioCondutorEntre18e25AnosNaoSeguroAuto = "//mat-radio-group[@formcontrolname='condutor-menor-25-anos']//mat-radio-button[@value='false']";
    String radioVeiculoUsoComercialSimSeguroAuto = "//mat-radio-group[@formcontrolname='uso-comercial']//mat-radio-button[@value='true']";
    String radioVeiculoUsoComercialNaoSeguroAuto = "//mat-radio-group[@formcontrolname='uso-comercial']//mat-radio-button[@value='false']";
    String radioTaxiOuFrotaSimSeguroAuto = "//mat-radio-group[@formcontrolname='uso-comercial-com-cobranca-de-passagem']//mat-radio-button[@value='true']";
    String radioTaxiOuFrotaNaoSeguroAuto = "//mat-radio-group[@formcontrolname='uso-comercial-com-cobranca-de-passagem']//mat-radio-button[@value='false']";
    String areaTipodeVigencia = "#mat-chip-list-0>div>mat-chip>div";
    String planoFinanciamento;
    String lnkDetalhesCoberturaSeguroAuto = "detalhesSeguro-0";
    String modalDetalhesSeguroAuto = "app-modal-seguro-auto-integrado-cobertura";
    String lblCoberturaSeguro = "cobertura-seguro";


    private boolean habilitaTaxiFrota = false;

    public void clicarAbaParcela() {
        page.click(abaParcela);
    }

    public void clicarAbaResidual() {
        page.click(abaResidual);
    }

    public void clicarAbaPrazo() {
        page.waitForTimeout(3000);
        page.click(abaPrazo);
    }

    private void selecionarSubsidioTaxa() {
        page.click(radioSubsidioTaxa);
    }

    private void selecionarSubsidioValor() {
        page.click(radioSubsidioValor);
    }

    public void inserirValorVeiculo(String valorVeiculo) {
        page.dblclick(txtValorVeiculo);
        page.type(txtValorVeiculo, valorVeiculo);
    }

    public void selecionarPlanoFinanciamento(String item) {
        page.click(comboPlanoDeFinanciamento);
        page.click("#plano-financiamento-" + item + "");
    }

    public void inserirValorEntrada(String valorEntrada) {
        page.dblclick(txtValorEntrada);
        page.type(txtValorEntrada, valorEntrada);

    }

    public void inserirValorParcela(String valorParcela) {
        if (valorParcela != null) {
            page.dblclick(txtValorParcela);
            page.type(txtValorParcela, valorParcela);
        }
    }

    public void inserirValorResidual(String valorResidual) {
        if (valorResidual != null) {
            page.dblclick(txtValorResidual);
            page.type(txtValorResidual, valorResidual);
        }
    }

    public void inserirPrazo(String prazo) {
        if (prazo != null) {
            page.click(comboPrazo);
            Util.selecionarItemMatOption(prazo);
        }
    }

    public void inserirTaxaSubsidio(String taxaSubsidio) {
        if (taxaSubsidio != null) {
            selecionarSubsidioTaxa();
            page.type(txtTaxaSubsidio, taxaSubsidio);
            page.press(txtTaxaSubsidio, "Tab");
        }
    }

    public void inserirValorSubsidio(String valorSubsidio) {
        if (valorSubsidio != null) {
            selecionarSubsidioValor();
            page.type(txtValorSubsidio, valorSubsidio);
            page.press(txtValorSubsidio, "Tab");
        }
    }

    public void inserirPrazoSubsidio(String prazoSubsidio) {
        if (prazoSubsidio != null) {
            page.click(comboPrazoSubsidio);
            Util.selecionarItemMatOption(prazoSubsidio);
        }
    }

    public void preencherCpfSeguroAuto(String cpf) {
        page.type(txtCpfSeguroAuto, cpf);
        page.waitForTimeout(3000);
        page.press(txtCpfSeguroAuto, "Tab");

    }

    public void preencherNomeSeguroAuto(String nome) {
        page.type(txtNomeSeguroAuto, nome);
    }

    public void preencherSexoSeguroAuto(String sexo) {
        if (sexo.equalsIgnoreCase("MASCULINO") || sexo.equalsIgnoreCase("M")) {
            page.click(radioSexoMasculinhoSeguroAuto);
        } else if (sexo.equalsIgnoreCase("FEMININO") || sexo.equalsIgnoreCase("F")) {
            page.click(radioSexoFemininoSeguroAuto);
        }
    }

    public void selecionarTaxiOuFrota(String s) {
        if (habilitaTaxiFrota) {
            if (s.equalsIgnoreCase("SIM")) {
                page.click(radioTaxiOuFrotaSimSeguroAuto);
            } else {
                page.click(radioTaxiOuFrotaNaoSeguroAuto);
            }
        }
    }


    public void clicarBtnProximoSimulacao() {
        page.click(btnProximoSimulacaoAtivo);
    }

    public void addItemFinanciavel() {
        page.click(btnAddItemFinanciavel);
    }

    public void selecionarItemFinanciavel(String item) {
        page.click(comboItemFinanciavel);
        Util.selecionarItemMatOption(item);
        itemFinanciavel = item;
    }

    public void inserirValorItem(String valorItem) {
        page.dblclick(txtValorItemFinanciavel);
        page.type(txtValorItemFinanciavel, valorItem);
        valorItemFinanciavel = valorItem;
    }

    public void EditarvalorItem() {
        page.click(abaEditarItemFinanciavel);
        page.click(btnEditarItemFinanciavel);
    }

    public void adicionartemFinanciavel() {
        page.click(btnAdicionartemFinanciavel);
        page.waitForTimeout(2000);
    }

    public void validarItemCarrinho() {
        page.click(carrinhoItensFinanciaveis);
        String itemInformado = page.textContent("#lista-itens-financiaveis>div>div>div>div:nth-child(1)>div>span");
        String valorInformado = page.textContent("#lista-itens-financiaveis>div>div>div>div:nth-child(3)>div>span");
        assertEquals(itemInformado, itemFinanciavel);
        assertEquals(valorInformado.substring(3, 11), valorItemFinanciavel);
        page.waitForTimeout(1000);
        takeScreenShot();
    }

    public void validarItensNaoListados(String item) {
        page.click(comboItemFinanciavel);
        boolean visible = page.isVisible("//mat-option//*[text()='" + item + "' or text()=' " + item + " ']");
        assertFalse(visible);
        takeScreenShot();
    }

    public void excluirItemFinanciavel() {
        page.click(carrinhoItensFinanciaveis);
        page.click(btnExcluirItemFinanciavel);
    }

    public void validarMensagem(String msg) {
        String content = page.textContent("//app-snackbar//*[text()='" + msg + "' or text()=' " + msg + " ']");
        assertEquals(msg, content);
        takeScreenShot();
    }

    public void validarPrestamistaPJ() {
        Boolean visible = page.isVisible(carrinhoSeguroPrestamista);
        assertFalse(visible);
        takeScreenShot();
    }

    public void expandirSeguroPrestamistaCarrinho() {
        page.click(carrinhoSeguroPrestamista);
    }

    public void validarInclusaoPrestamista(String seguro) {
        String seguroCarrinho = page.textContent(carrinhoSeguroSPF);
        assertEquals(seguroCarrinho.trim(), seguro);
        takeScreenShot();
    }

    public void validarRemocaoTrue() {
        Boolean visible = page.isVisible(btnExcluirPrestamista);
        assertTrue(visible);
        takeScreenShot();
    }

    public void validarRemocaoFalse() {
        Boolean visible = page.isVisible(btnExcluirPrestamista);
        assertFalse(visible);
        takeScreenShot();
    }

    public void removerSeguroPrestamista() {
        page.click(btnExcluirPrestamista);
    }

    public void clicarBtnAdicionarSeguroAuto() {
        page.click(btnAdicionarSeguroAuto);
        page.waitForTimeout(2000);
    }

    public void selecionarTipoSeguro(String item) {
        page.click(comboTipoSeguroAuto);
        Util.selecionarItemMatOption(item);
    }

    public void preencherCpfSeguroAuto() {
        String cpfGerado = Documents.getCpf(false);
        Proposta.setCpfCnpjProponente(cpfGerado);
        page.type(txtCpfSeguroAuto, Proposta.getCpfCnpjProponente());
        page.press(txtCpfSeguroAuto, "Tab");
    }

    public void preencherCpfSeguroAutoEnriquecido(String cpf){
        Proposta.setCpfCnpjProponente(cpf);
        page.type(txtCpfSeguroAuto, Proposta.getCpfCnpjProponente());
        page.press(txtCpfSeguroAuto, "Tab");
    }

    public void preencherNomeSeguroAuto() {
        page.type(txtNomeSeguroAuto, faker.name().fullName().toUpperCase());
    }

    public void preencherSexoSeguroAuto() {
        page.click(radioSexoMasculinhoSeguroAuto);
    }

    public void preencherDataSeguroAuto(String data) {
        page.type(txtDataNascimentoSeguroAuto, data);
    }

    public void preencherCepSeguroAuto(String cep) {
        page.type(txtCepSeguroAuto, cep);
    }

    public void selecionarCondutorEntre18e25Anos(String opcao) {
        if (opcao == null) {
            page.click(radioCondutorEntre18e25AnosNaoSeguroAuto);
        } else if (opcao.equalsIgnoreCase("SIM")) {
            page.click(radioCondutorEntre18e25AnosSimSeguroAuto);
        } else {
            page.click(radioCondutorEntre18e25AnosNaoSeguroAuto);
        }
    }

    public void selecionarVeiculoUsoComercial(String usoComercial) {
        if (usoComercial == null) {
            page.click(radioVeiculoUsoComercialNaoSeguroAuto);
            habilitaTaxiFrota = false;
        } else if (usoComercial.equalsIgnoreCase("SIM")) {
            page.click(radioVeiculoUsoComercialSimSeguroAuto);
            habilitaTaxiFrota = true;
        } else {
            page.click(radioVeiculoUsoComercialNaoSeguroAuto);
            habilitaTaxiFrota = false;
        }
    }

    public void selecionarCobrancaDePassagem(String cobrancaPassagem) {
        if (cobrancaPassagem.equalsIgnoreCase("SIM")) {
            page.click(radioTaxiOuFrotaSimSeguroAuto);
        } else if(cobrancaPassagem.equalsIgnoreCase("NAO")){
            page.click(radioTaxiOuFrotaNaoSeguroAuto);
            }
        }

    public void clicarStepVeiculo() {
        page.click(stepConfiguracaoVeiculo);
    }

    public void clickContinuarSeguroAuto() {
        page.click(btnContinuarSeguroAuto);
    }

    public void selecionarParcelasPlanoFinanciamento(String item) {
        selecionarPlanoFinanciamento(item);
        planoFinanciamento = item;
    }

    public void validarSegurosTipos() {
        page.waitForTimeout(5000);
        Boolean tem12meses = false;
        Boolean diferente12meses = false;

        for(ElementHandle chip:page.querySelectorAll("[id^='chipSeguro']")) {
            String labelCobertura = chip.textContent();

            if (labelCobertura.equals("Cobertura 12 meses")) {
                tem12meses = true;
            } else if (!labelCobertura.equals("Cobertura 12 meses")) {
                diferente12meses = true;
            }
        }
        assertTrue(tem12meses);
        assertTrue(diferente12meses);
        takeScreenShot();
    }

    public void validarSeguro12meses() {
        page.waitForTimeout(5000);
        Boolean tem12meses = false;
        Boolean diferente12meses = false;

        for(ElementHandle chip:page.querySelectorAll("[id^='chipSeguro']")) {
            String labelCobertura = chip.textContent();

            if (labelCobertura.equals("Cobertura 12 meses")) {
                tem12meses = true;
            } else if (!labelCobertura.equals("Cobertura 12 meses")) {
                diferente12meses = true;
            }
        }
        assertTrue(tem12meses);
        assertFalse(diferente12meses);
        takeScreenShot();
    }

    public void abrirDetalhesCobertura(){
        for(ElementHandle chip:page.querySelectorAll("[id^='chipSeguro']")) {
            chip.click();
         break;
        }
        //page.click(lnkDetalhesCoberturaSeguroAuto);
    }

    public void validarModalDetalhesSeguro(){
        page.waitForTimeout(2000);
        Boolean visible = page.isVisible(modalDetalhesSeguroAuto);
        assertTrue(visible);
        takeScreenShot();
    }

    public void validarDetalhesModalSeguroAuto(){
        Boolean visible = page.isVisible(lblCoberturaSeguro);
        assertTrue(visible);
        takeScreenShot();
    }

    public void clicarStepConfiguracao(){
        page.click(stepConfiguracao);
    }

    public void ValidarSeguroAutoParaPJ(String item){
        page.click(comboTipoSeguroAuto);
        boolean visible = page.isVisible("//mat-select//*[text()='" + item + "' or text()=' " + item + " ']");
        assertFalse(visible);
        takeScreenShot();
    }
}
