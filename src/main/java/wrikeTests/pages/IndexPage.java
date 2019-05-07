package wrikeTests.pages;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrikeTests.enums.SimpleWrikeTestData;

import static org.testng.Assert.assertTrue;

@Feature("Home page")
@Story("Start Free trial")

public class IndexPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='wg-header__sticky-mainmenu']//button")
    private WebElement getStartedFreeButton;

    @FindBy(xpath = "//input[@class='wg-input modal-form-trial__input']")
    private WebElement accountField;

    @FindBy(xpath = "//button[@class='wg-btn wg-btn--blue modal-form-trial__submit']")
    private WebElement createAccountButton;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open site by URL")
    public void open(SimpleWrikeTestData url){
        driver.get(url.value);
    }

    @Step("Click 'Get started for free'")
    public void clickGetStartedForFree() {
        getStartedFreeButton.click();
    }

    @Step("Fill in the email field")
    public void fillEmailField(String email){
        assertTrue(accountField.isDisplayed());
        accountField.sendKeys(email);
    }

    @Step("Click and check 'Create Wrike Account'")
    public void clickCreateWrikeAccountButton(){
        assertTrue(createAccountButton.isDisplayed());
        createAccountButton.click();
    }
}
