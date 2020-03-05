package simpleTests.util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;

import static com.codeborne.selenide.Browsers.*;
import static simpleTests.util.AdditionalCapability.*;
import static simpleTests.util.Constance.BASE_TIMEOUT;
import static simpleTests.util.Constance.RUN_TYPE;
import static simpleTests.util.configLoader.*;

public abstract class DriverProvider implements WebDriverProvider {

    public static void createChromeDriver(String runType) {
        switch (runType) {
            case LOCAL:
                System.setProperty(WEBDRIVER_CHROME_DRIVER, getWebDriverPath(CHROME));
                Configuration.browser = CHROME;
                break;
            case DOCKER:
                Configuration.remote = getRemoteURL(DOCKER);
                break;
            default:
                throw new IllegalArgumentException("Unable to start " + CHROME + " on " + runType + "!");
        }
    }

    public static void createFirefoxDriver(String runType) {
        switch (runType) {
            case LOCAL:
                System.setProperty(WEBDRIVER_FIREFOX_DRIVER, getWebDriverPath(FIREFOX));
                Configuration.browser = FIREFOX;
                break;
            case DOCKER:
                Configuration.remote = getRemoteURL(DOCKER);
                break;
            default:
                throw new IllegalArgumentException("Unable to start " + FIREFOX + " on " + runType + "!");
        }
    }

    public static void createEdgeDriver(String runType) {
        switch (runType) {
            case LOCAL:
                System.setProperty(WEBDRIVER_EDGE_DRIVER, getWebDriverPath(EDGE));
                Configuration.browser = EDGE;
                break;
            case DOCKER:
                Configuration.remote = getRemoteURL(DOCKER);
                break;
            default:
                throw new IllegalArgumentException("Unable to start " + EDGE + " on " + runType + "!");
        }
    }

    public static void createOperaDriver(String runType) {
        switch (runType) {
            case LOCAL:
                System.setProperty(WEBDRIVER_OPERA_DRIVER, getWebDriverPath(OPERA));
                Configuration.browser = OPERA;
                break;
            case DOCKER:
                Configuration.remote = getRemoteURL(DOCKER);
                break;
            default:
                throw new IllegalArgumentException("Unable to start " + OPERA + " on " + runType + "!");
        }
    }

    public static void createDriver(String browser, String runType) {
        switch (browser) {
            case CHROME:
                createChromeDriver(runType);
                break;
            case FIREFOX:
                createFirefoxDriver(runType);
                break;
            case EDGE:
                createEdgeDriver(runType);
                break;
            case OPERA:
                createOperaDriver(runType);
                break;
            default:
                throw new IllegalArgumentException("Unable to start test on " + browser + "!");
        }
        if (RUN_TYPE.equals(DOCKER))
            Configuration.timeout = getRemoteTimeout(DOCKER);
        else Configuration.timeout = BASE_TIMEOUT;
    }

    public static void enableProxy(){
        Configuration.proxyEnabled = true;
        Configuration.proxyHost = getProxyHost();
        Configuration.proxyPort = getProxyPort();
    }
}
