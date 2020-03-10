package simpleTests.util;

public abstract class Constance {

    /**
     * Params
     */
    public static final String BASE_BROWSER = System.getProperty("browser");
    public static final String RUN_TYPE = System.getProperty("runType");
    public static final String BROWSER_VERSION = System.getProperty("browserVersion");
    public static long BASE_TIMEOUT = 15000;

//    public static final String BASE_BROWSER = "chrome";
//    public static final String RUN_TYPE = "docker";  //local docker
//    public static final String BROWSER_VERSION = "79.0";

    /**
     * SimpleWrikeTestData
     */
    public static final String SITE_URL = "https://www.wrike.com/";
    public static final String RESEND_TITLE = "Thank you for choosing Wrike!";
    public static final String COMMENTS = "I don't know...";

}
