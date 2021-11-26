package support.Utils;


import com.microsoft.playwright.Page;
import support.browser.BrowserManager;
import support.data.DataYaml;
import java.util.HashMap;
import java.util.Map;
import static com.microsoft.playwright.options.WaitForSelectorState.*;


public class Util extends BrowserManager {


    String modalLoading = ("//*[contains(@class, 'loading-text')] | //*[contains(@class, 'loading ng')]");

    public static void selecionarItemMatOption(String nomeItem){
        //page.waitForSelector("//mat-option//*[text()='" + nomeItem + "' or text()=' " + nomeItem + " ']").isVisible();
        String item = "//mat-option//*[text()='" + nomeItem + "' or text()=' " + nomeItem + " ']";
        page.click(item);
        page.waitForTimeout(1500);
    }

    public static void selecionarItemDropdownPanel(String nomeItem) {
        //page.waitForSelector("//ng-dropdown-panel//*[text()='" + nomeItem + "' or text()=' " + nomeItem + " ']").isVisible();
        String item = ("//ng-dropdown-panel//*[text()='" + nomeItem + "' or text()=' " + nomeItem + " ']");
        page.click(item);
        page.waitForTimeout(1500);
    }

    public static String salvarMassa(String fileName, String titulo, String tipo, String dados) {
        Map dataMap = new HashMap();
        dataMap.put(tipo, dados);
        DataYaml.setMapYamlValues(fileName, titulo, dataMap);
        return dados;

    }

    public static void mudarAba(int aba){
        changeFocusPage(aba);
    }

    public static void aguardarLoader(){
        Boolean visible = page.isVisible("//*[contains(@class, 'loading-text')] | //*[contains(@class, 'loading ng')]");
        if (visible == true) {
            page.waitForSelector("//*[contains(@class, 'loading-text')] | //*[contains(@class, 'loading ng')]",
                    new Page.WaitForSelectorOptions().setState(HIDDEN).setTimeout(50000));
        }

    }
    //page.waitForSelector("//*[contains(@class, 'loading-text')] | //*[contains(@class, 'loading ng')]",
    //        new Page.WaitForSelectorOptions().setState(HIDDEN).setTimeout(50000));

}
