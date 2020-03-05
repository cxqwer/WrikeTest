package simpleTests.util;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static util.ResizeImager.resize;
import static util.ResizeImager.toByteArrayAutoClosable;

public class TestListener {

    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    private static File getScreenshotFile() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
    }

    public static void makeScreenshot() {
        byte[] fileContent = new byte[0];
        try {
            fileContent = toByteArrayAutoClosable(resize(getScreenshotFile(), 3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", fileContent);
    }

    public static void makePageSource() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
    }
}
