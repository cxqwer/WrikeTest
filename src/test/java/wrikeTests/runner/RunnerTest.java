package wrikeTests.runner;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wrikeTests.pages.IndexPage;
import wrikeTests.pages.ResendPage;

@RunWith(Cucumber.class)

@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/"},
        tags = "@all",
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        glue = {"steps", "hooks"})

public class RunnerTest {
    private static Logger logger = LoggerFactory.getLogger(RunnerTest.class);
    public static IndexPage indexPage = new IndexPage();
    public static ResendPage resendPage = new ResendPage();

    @BeforeClass
    public static void initSettings() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = Browsers.CHROME;
        Configuration.browserVersion = "80.0";
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities.setCapability("LANGUAGE", "ru:en");
        Configuration.driverManagerEnabled = false;
//        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.startMaximized = true;
    }

}