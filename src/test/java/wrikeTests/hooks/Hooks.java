package wrikeTests.hooks;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static wrikeTests.runner.AllureSelenide.makeScreenshot;

public class Hooks {

    private static Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static int testCounter = 1;

    @Before
    public void startScenario(Scenario scenario) {
        logger.info("Тест № " + testCounter);
        logger.info("------------------------------------------------------------");
        logger.info("Сценарий - '" + scenario.getName() + "'");
        logger.info("------------------------------------------------------------");
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Сценарий '" + scenario.getName() + "' - " + scenario.getStatus());
        logger.info("------------------------------------------------------------");
        getWebDriver().quit();
    }

    @AfterStep
    public void afterStep(){
        makeScreenshot();
    }

}
