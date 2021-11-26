package support.report;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import support.browser.BrowserManager;



@Log4j2
public class Report  {



    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] takeScreenShot() {
        log.info("Tirando print screen da tela");
        return BrowserManager.getPage().screenshot();
    }

}
