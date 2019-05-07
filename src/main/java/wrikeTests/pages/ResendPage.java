package wrikeTests.pages;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrikeTests.enums.QASectionElements;
import wrikeTests.enums.SimpleWrikeTestData;
import wrikeTests.enums.SocialMedias;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static wrikeTests.enums.SimpleWrikeTestData.RESEND_TITLE;

@Feature("Resend page")
@Story("Fill Q&A section and check interface")

public class ResendPage {
    @FindBy(xpath = "//div[@data-code='interest_in_solution']//button[@class='switch__button']")
    private List<WebElement> interestInSolutions;

    @FindBy(xpath = "//div[@data-code='team_members']//button[@class='switch__button']")
    private List<WebElement> teamMembers;

    @FindBy(xpath = "//div[@data-code='primary_business']//button[@class='switch__button']")
    private List<WebElement> manageWorks;

    @FindBy(xpath = "//button[@class='submit wg-btn wg-btn--navy js-survey-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@class='wg-btn wg-btn--white wg-btn--hollow button js-button']")
    private WebElement resendButton;

    @FindBy(xpath = "//li[@class='wg-footer__social-item']//a")
    private List<WebElement> socialButtonsUrls;

    @FindBy(css = "[class='wg-footer__social-icon'] > use")
    private List<WebElement> socialButtonsIcons;

    @FindBy(xpath = "//span[@class='switch__additional']//input")
    private WebElement otherTextField;

    @FindBy(xpath = "//p[@class='h4 subtitle']//span[@class='again']")
    private WebElement againField;


    private WebDriver driver;

    public ResendPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Assertion that you are moved to the next page")
    public void checkMovedResendPage() {
        WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='wg-cell wg-cell--md-6 wg-cell--lg-7']")));
        assertTrue(element.isDisplayed());
        assertEquals(RESEND_TITLE.value, driver.getTitle());
    }

    @Step("Check and click 'Resend email'")
    public void ResendEmail() {
        assertTrue(resendButton.isDisplayed());
        resendButton.click();
        againField.isDisplayed();
    }

    @Step("Check that 'Follow us' contains the Media button that leads to the correct url and has the correct icon")
    public void checkFooterContainElement(SocialMedias socialMedia) {
        int indexUrl = -1;
        int indexIcon = -1;
        for (int i = 0; i < socialButtonsUrls.size(); i++) {
            if (socialButtonsUrls.get(i).getAttribute("href").equals(socialMedia.url)) {
                indexUrl = i;
                break;
            }
        }
        for (int i = 0; i < socialButtonsIcons.size(); i++) {
            if (socialButtonsIcons.get(i).getAttribute("xlink:href").contains(socialMedia.icon)) {
                indexIcon = i;
                break;
            }
        }
        assertTrue(indexUrl >= 0);
        assertTrue(indexIcon >= 0);
        assertEquals(indexIcon, indexUrl);
    }

    @Step("Fill Q&A section with answer 'Yes' or 'No' in field 'managing work'")
    public void fillForm(QASectionElements interestInSolution, QASectionElements teamMember,
                         QASectionElements manageWork) {
        interestInSolutions.get(interestInSolution.number).click();
        teamMembers.get(teamMember.number).click();
        manageWorks.get(manageWork.number).click();
    }

    @Step("Fill Q&A section with answer 'Other' in field 'managing work'")
    public void fillForm(QASectionElements interestInSolution, QASectionElements teamMember,
                         QASectionElements manageWork, SimpleWrikeTestData comment) {
        fillForm(interestInSolution, teamMember, manageWork);
        otherTextField.sendKeys(comment.value);
    }

    @Step("Check that answers are submitted and click 'submit")
    public void submit() {
        assertTrue(submitButton.isEnabled());
        submitButton.click();
    }
}
