package support.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.Getter;
import lombok.Setter;
import org.aeonbits.owner.ConfigCache;
import support.browser.type.ChromeFactory;
import support.browser.type.FirefoxFactory;
import support.browser.type.RemoteFactory;
import support.browser.type.WebKitFactory;
import support.config.Configuration;

public class BrowserFactory {

    @Getter
    @Setter
    public static Playwright playwright;
    @Getter @Setter
    public static Browser browser;
    @Getter @Setter
    public static BrowserContext context;
    @Getter @Setter
    public static Page page;
    @Getter @Setter
    public static boolean headLess = Boolean.parseBoolean(System.getProperty("headless"));
    public static final Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

    public static void getInstance(String browserType) {
        if(browser != null) return;
        try (Playwright playwright = Playwright.create()) {
            switch (browserType.toUpperCase()) {
                case "CHROME":
                    ChromeFactory.createInstance();
                    break;
                case "FIREFOX":
                    FirefoxFactory.createInstance();
                    break;
                case "WEBKIT":
                    WebKitFactory.createInstance();
                    break;
                case "REMOTE":
                    RemoteFactory.createInstance();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browserType);
            }
        }
    }
}
