package simpleTests.hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static simpleTests.util.TestListener.makePageSource;
import static util.MyScreenRecorder.startRecording;
import static util.MyScreenRecorder.stopRecording;

public class Hooks {

    private static Logger logger = LoggerFactory.getLogger(Hooks.class);
    private static int testCounter = 1;

    @Before
    public void startScenario(Scenario scenario) {
        logger.info("Тест № " + testCounter);
        logger.info("------------------------------------------------------------");
        logger.info("Сценарий - '" + scenario.getName() + "'");
        logger.info("------------------------------------------------------------");
    }

    @Before("@video")
    public void startVideoRecording(Scenario scenario) throws Exception{
        logger.info("Start video recording the test video " + scenario.getName());
        startRecording(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.info("------------------------------------------------------------");
        logger.info("Сценарий '" + scenario.getName() + "' - " + scenario.getStatus());
        logger.info("------------------------------------------------------------");
        testCounter++;
        makePageSource();
        clearBrowserLocalStorage();
        clearBrowserCookies();
        getWebDriver().quit();
    }

    @After("@video")
    public void stopVideoRecording(Scenario scenario) throws Exception{
        stopRecording();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
            File file = new File("target/recordings/" + scenario.getName() + ".avi");
            byte[] fileContent = Files.readAllBytes(file.toPath());
            Allure.getLifecycle().addAttachment(scenario.getName() + "-" + dateFormat.format(new Date()), "video/avi", "avi", fileContent);
            logger.info("The video was successfully attached to the report");
    }

}
