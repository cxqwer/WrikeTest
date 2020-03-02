import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import wrikeTests.utilities.GeneratedEmail;

import static com.codeborne.selenide.Selenide.open;
import static util.AllureSelenide.makeScreenshot;
import static wrikeTests.enums.QASectionElements.*;
import static wrikeTests.enums.SimpleWrikeTestData.COMMENTS;
import static wrikeTests.enums.SimpleWrikeTestData.SITE_URL;
import static wrikeTests.enums.SocialMedias.TWITER;

public class SimpleWrikeTest extends BaseTest{

    @Story("Simple Wrike Test (Test Case: 1)")
    @Test
    public void tests() {
        step("Open url: wrike.com;", ()->open(SITE_URL.value));
        step("Click \"Get started for free\" button near \"Login\" button", ()->indexPage.clickGetStartedForFree());
        step("Fill in the email field with random generated number of email", ()->indexPage.fillEmailField(GeneratedEmail.createRandomEmail()));
        step("Click on \"Create my Wrike account\" button + check with assertion that you are moved to the next page", ()->indexPage.clickCreateWrikeAccountButton());
        step("Check Moved Resend Page", ()->resendPage.checkMovedResendPage());
        step("Fill in the Q&A section at the left part of page + check with assertion that your answers are submitted", ()->resendPage.fillForm(VERY_INTERESTED, SIX_TO_FIFTEEN, OTHER, COMMENTS));
        step("Click submit", ()->resendPage.submit());
        step("Click and check \"Resend email\"", ()->resendPage.ResendEmail());
        step("Check that section \"Follow us\"", ()->resendPage.checkFooterContainElement(TWITER));
    }

    @Step("{0}")
    public void step(String title, Runnable code) {
        System.out.println(title);
        code.run();
        makeScreenshot();
    }
}
