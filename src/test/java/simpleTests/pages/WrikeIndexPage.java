package simpleTests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class WrikeIndexPage {

    private SelenideElement getStartedFreeButton = $x("//div[@class='wg-header__sticky-mainmenu']//button");

    private SelenideElement accountField = $x("//input[@class='wg-input modal-form-trial__input']");

    private SelenideElement createAccountButton = $x("//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']");

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
