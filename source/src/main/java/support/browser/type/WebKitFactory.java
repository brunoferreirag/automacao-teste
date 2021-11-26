package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import support.browser.BrowserFactory;

public class WebKitFactory extends BrowserFactory {
    public static void createInstance() {
        setBrowser(Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(headLess)));
        setContext(getBrowser().newContext());
    }
}
