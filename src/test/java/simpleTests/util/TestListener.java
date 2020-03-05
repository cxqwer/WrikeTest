package simpleTests.util;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

public class TestListener {

    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    public static void makeScreenshot() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
    }

    public static void makePageSource() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
    }
}
