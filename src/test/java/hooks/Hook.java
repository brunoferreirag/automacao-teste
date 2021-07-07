package hooks;

import driver.DriverFactory;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import support.Proposta;


@Log4j2
public class Hook  {

    @Before
    public void init(Scenario scenario) {
        DriverManager.setScenario(scenario);
        log.info(String.format("TESTE INICIADO: %s",scenario.getName()));

        ConfigFactory.setProperty("env", System.getProperty("env"));


        WebDriver driver = DriverFactory.createInstance(System.getProperty("browser"));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1024,768));
        DriverManager.setDriver(driver);

        Proposta.resetarProposta();
    }

    @After
    public void end(Scenario scenario){
        DriverManager.quit(scenario);
        log.info(String.format("TESTE FINALIZADO: %s",scenario.getName()));
        log.info(String.format("TESTE STATUS: %s",scenario.getStatus()));
    }

}









