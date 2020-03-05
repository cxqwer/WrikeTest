package wrikeTests.hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static wrikeTests.runner.TestListener.makePageSource;

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
        testCounter++;
        makePageSource();
        getWebDriver().quit();
    }

}
