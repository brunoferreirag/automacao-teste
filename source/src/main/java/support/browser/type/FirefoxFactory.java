package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import support.browser.BrowserFactory;

public class FirefoxFactory extends BrowserFactory {
    public static void createInstance() {
        setBrowser(Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(headLess)));
        setContext(getBrowser().newContext());
    }
}
