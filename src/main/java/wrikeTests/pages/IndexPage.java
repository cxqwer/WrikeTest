package wrikeTests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import wrikeTests.enums.SimpleWrikeTestData;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertTrue;

@Feature("Home page")
@Story("Start Free trial")

public class IndexPage {

    private SelenideElement getStartedFreeButton = $x("//div[@class='wg-header__sticky-mainmenu']//button");

    private SelenideElement accountField = $x("//input[@class='wg-input modal-form-trial__input']");

    private SelenideElement createAccountButton = $x("//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']");

    public void open(SimpleWrikeTestData url) {
        getWebDriver().get(url.value);
    }

    public void clickGetStartedForFree() {
        getStartedFreeButton.click();
    }

    public void fillEmailField(String email) {
        assertTrue(accountField.isDisplayed());
        accountField.sendKeys(email);
    }

    public void clickCreateWrikeAccountButton() {
        assertTrue(createAccountButton.isDisplayed());
        createAccountButton.click();
    }
}
