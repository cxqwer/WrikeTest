import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import wrikeTests.pages.IndexPage;
import wrikeTests.pages.ResendPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public IndexPage indexPage = new IndexPage();
    public ResendPage resendPage = new ResendPage();

    @BeforeSuite
    public void beforeSuite() {

        Configuration.browser = Browsers.CHROME;
        Configuration.browserVersion = "80.0";
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities.setCapability("LANGUAGE", "ru:en");
        Configuration.driverManagerEnabled = false;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.startMaximized = true;
    }

    @AfterTest
    public void afterSuite() {
        getWebDriver().quit();
    }

}
