package hooks;

import com.microsoft.playwright.*;
import lombok.extern.log4j.Log4j2;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aeonbits.owner.ConfigFactory;
import support.browser.BrowserFactory;
import support.browser.BrowserManager;



@Log4j2
public class Hook  extends BrowserManager {

    @Before
    public void init(Scenario scenario) {
        log.info(String.format("TESTE INICIADO: %s", scenario.getName()));
        ConfigFactory.setProperty("env", System.getProperty("env"));
        BrowserFactory.getInstance(System.getProperty("browser"));


        //if(DriverManager.getContext().pages().size() < 1)
        BrowserManager.createNewPage();

    }


    @After
    public void end(Scenario scenario) {
        BrowserManager.finishScenario(scenario);
        log.info(String.format("TESTE FINALIZADO: %s", scenario.getName()));
        log.info(String.format("TESTE STATUS: %s", scenario.getStatus()));
    }

    //@AfterClass
    //public static void tearDownAll(){
    //    DriverManager.quit();
    //}



}









