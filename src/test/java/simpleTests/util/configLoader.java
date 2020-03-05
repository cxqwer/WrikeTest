package simpleTests.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class configLoader {

    public static String getWebDriverPath(String browser) {
        Config config = ConfigFactory.load("browsers");
        return config.getString(browser + ".webDriverPath");
    }

    public static String getWebDriverVersion(String browser) {
        Config config = ConfigFactory.load("browsers");
        return config.getString(browser + ".browserVersion");
    }

    public static String getRemoteURL(String remote) {
        Config config = ConfigFactory.load("run");
        return config.getString(remote + ".url");
    }

    public static long getRemoteTimeout(String remote) {
        Config config = ConfigFactory.load("run");
        return config.getLong(remote + ".timeout");
    }

    public static String getProxyHost() {
        Config config = ConfigFactory.load("run");
        return config.getString("proxy.host");
    }

    public static int getProxyPort() {
        Config config = ConfigFactory.load("run");
        return config.getInt("proxy.port");
    }


}
