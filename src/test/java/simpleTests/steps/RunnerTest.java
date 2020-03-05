package simpleTests.steps;

import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import simpleTests.pages.MtsTvHomePage;
import simpleTests.pages.WrikeIndexPage;
import simpleTests.pages.WrikeResendPage;
import simpleTests.pages.YandexMainPage;
import simpleTests.util.DriverProvider;

import static simpleTests.util.AdditionalCapability.LANGUAGE;
import static simpleTests.util.AdditionalCapability.VNC;
import static simpleTests.util.Constance.*;

@RunWith(Cucumber.class)

@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/"},
        tags = "@searchTest",
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        glue = {"simpleTests/steps", "simpleTests/hooks"})

public class RunnerTest {
    public static WrikeIndexPage indexPage = new WrikeIndexPage();
    public static WrikeResendPage resendPage = new WrikeResendPage();
    public static YandexMainPage yandexMainPage = new YandexMainPage();
    public static MtsTvHomePage mtsTvHomePage = new MtsTvHomePage();

    @Video
    @BeforeClass
    public static void initSettings() {

        Configuration.browserVersion = BROWSER_VERSION;
        DriverProvider.createDriver(BASE_BROWSER, RUN_TYPE);
        DriverProvider.enableProxy();
        Configuration.browserCapabilities.setCapability(VNC, true);
        Configuration.browserCapabilities.setCapability(LANGUAGE, "ru:en");
        Configuration.driverManagerEnabled = false;
        Configuration.startMaximized = true;
    }

}