package support;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Random;

@Log4j2
public class Util extends DriverManager {

    private static By modalLoading = By.xpath("//*[contains(@class, 'loading-text')] | //*[contains(@class, 'loading ng')]");

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    private static boolean IS_MAC = (OS.indexOf("mac") >= 0);

    /**
     * Seleciona um item no modal de //mat-option
     *
     * @param nomeItem nome do item a ser selecionado
     */
    public static void selecionarItemMatOption(String nomeItem) {
        if (nomeItem.equalsIgnoreCase("RANDOM") || nomeItem.equalsIgnoreCase("SELECIONAR RANDOM")) {
            int qntDeItens = getDriver().findElements(By.xpath("//mat-option")).size();
            Random rn = new Random();
            int itemSelecao = rn.nextInt((qntDeItens+1) - 1) + 1;
            By xpath = By.xpath("//mat-option["+itemSelecao+"]");
            Action.clickOnElement(xpath);
            log.info("Selecionado item aleatório do combo na posição " + itemSelecao);
        } else {
            By xpath = By.xpath("//mat-option//*[text()='" + nomeItem + "' or text()=' " + nomeItem + " ']");
            Verifications.verifyElementExists(xpath);
            Action.clickOnElement(xpath);
            Verifications.wait(1);
            log.info("Selecionado o item " + nomeItem);
        }
    }

    /**
     * Seleciona um item no modal de //ng-dropdown-panel
     *
     * @param nomeItem nome do item a ser selecionado
     */
    public static void selecionarItemDropdownPanel(String nomeItem) {
        By xpath = By.xpath("//ng-dropdown-panel//*[text()='" + nomeItem + "' or text()=' " + nomeItem + " ']");
        Verifications.verifyElementExists(xpath);
        Action.clickOnElement(xpath);
        Verifications.wait(1);
        log.info("Selecionado o item " + nomeItem);
    }

    /**
     * Aguarda o modal de loading do Direct
     */
    public static void aguardarLoaderDirect() {
        Verifications.verifyElementDoesNotExist(modalLoading);
    }

    /**
     * Realiza o scroll pra cima
     *
     * @param pixels
     */
    public static void scrollUp(int pixels) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();

        jse.executeScript("window.scrollBy(0,-" + "" + pixels + ")", "");
    }

    /**
     * Realiza o scroll pra baixo
     *
     * @param pixels pixels
     */
    public static void scrollDown(int pixels) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0," + "" + pixels + ")", "");
    }

    /**
     * Retorna somentes os caracteres numericos [0-9]
     *
     * @param valor qualquer string que contenha numeros
     * @return somente os numeros [0-9]
     */
    public static String formatarSomenteNumeros(String valor) {
        return valor.replaceAll("[^0-9]", "");
    }

    /**
     * Apagar o texto do campo preencher com novo teste
     *
     * @param element By
     * @param texto   String
     */
    public static void preencherCampoTexto(By element, String texto) {
        Verifications.verifyElementIsClickable(element);
        Action.clickOnElement(element);
        if (IS_WINDOWS) {
            getDriver().findElement(element).sendKeys(Keys.CONTROL + "a");
        } else if (IS_MAC) {
            getDriver().findElement(element).sendKeys(Keys.COMMAND + "a");
        }
        getDriver().findElement(element).sendKeys(texto);
    }

}
