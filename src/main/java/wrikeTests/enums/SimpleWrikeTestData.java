package wrikeTests.enums;

public enum SimpleWrikeTestData {
    SITE_URL("https://www.wrike.com/"),
    RESEND_TITLE ("Thank you for choosing Wrike!"),
    COMMENTS("I don't know..."),
    CHROM_WEB_DRIVER("webdriver.chrome.driver"),
    CHROM_WEB_DRIVER_PATH("src\\main\\resources\\chromedriver.exe"),
    ;

    public String value;

    SimpleWrikeTestData(String value) {
        this.value = value;
    }
}
