package simpleTests.util;

import org.openqa.selenium.remote.CapabilityType;

/**
 * addition capabilities
 **/
public interface AdditionalCapability extends CapabilityType {
    String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";
    String WEBDRIVER_FIREFOX_DRIVER = "webdriver.gecko.driver";
    String WEBDRIVER_EDGE_DRIVER = "webdriver.edge.driver";
    String WEBDRIVER_OPERA_DRIVER = "webdriver.opera.driver";
    String HANDLES_ALERTS = "handlesAlerts";
    String LANGUAGE = "LANGUAGE";
    String VNC = "enableVNC";
    String VERSION = "version";
    String MICROSOFT_EDGE = "MicrosoftEdge";
    String LOCAL = "local";
    String SERVER = "server";
    String DOCKER = "docker";
}
