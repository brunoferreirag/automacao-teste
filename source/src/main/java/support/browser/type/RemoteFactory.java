package support.browser.type;

import com.microsoft.playwright.Playwright;
import support.browser.BrowserFactory;

public class RemoteFactory extends BrowserFactory {

    public static void createInstance(String urlConnect) {
        setBrowser(Playwright.create().chromium().connectOverCDP(urlConnect));
        setContext(getBrowser().newContext());
    }
    public static void createInstance() {
        setBrowser(Playwright.create().chromium().connectOverCDP(configuration.urlRemote()));
        setContext(getBrowser().newContext());
    }
}
