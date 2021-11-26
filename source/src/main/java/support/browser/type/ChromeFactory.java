package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import support.browser.BrowserFactory;


public class ChromeFactory extends BrowserFactory {
    public static void createInstance() {
        setBrowser(Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headLess)));
        setContext(getBrowser().newContext());
    }
}
