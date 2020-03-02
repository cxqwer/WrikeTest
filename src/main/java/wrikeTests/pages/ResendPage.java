package wrikeTests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrikeTests.enums.QASectionElements;
import wrikeTests.enums.SimpleWrikeTestData;
import wrikeTests.enums.SocialMedias;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static wrikeTests.enums.SimpleWrikeTestData.RESEND_TITLE;

@Feature("Resend page")
@Story("Fill Q&A section and check interface")

public class ResendPage {
    private ElementsCollection interestInSolutions = $$x("//div[@data-code='interest_in_solution']//button[@class='switch__button']");

    private ElementsCollection teamMembers = $$x("//div[@data-code='team_members']//button[@class='switch__button']");

    private ElementsCollection manageWorks = $$x("//div[@data-code='primary_business']//button[@class='switch__button']");

    private SelenideElement submitButton = $x("//button[@class='submit wg-btn wg-btn--navy js-survey-submit']");

    private SelenideElement resendButton = $x("//button[@class='wg-btn wg-btn--white wg-btn--hollow button js-button']");

    private ElementsCollection socialButtonsUrls = $$x("//li[@class='wg-footer__social-item']//a");

    private ElementsCollection socialButtonsIcons = $$("[class='wg-footer__social-icon'] > use");

    private SelenideElement otherTextField = $x("//span[@class='switch__additional']//input");

    private SelenideElement againField = $x("//p[@class='h4 subtitle']//span[@class='again']");

    public void checkMovedResendPage() {
        WebElement element = (new WebDriverWait(getWebDriver(), 10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='wg-cell wg-cell--md-6 wg-cell--lg-7']")));
        assertTrue(element.isDisplayed());
        assertEquals(RESEND_TITLE.value, getWebDriver().getTitle());
    }

    public void ResendEmail() {
        assertTrue(resendButton.isDisplayed());
        resendButton.click();
        againField.isDisplayed();
    }

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

    public void fillForm(QASectionElements interestInSolution, QASectionElements teamMember,
                         QASectionElements manageWork) {
        interestInSolutions.get(interestInSolution.number).click();
        teamMembers.get(teamMember.number).click();
        manageWorks.get(manageWork.number).click();
    }

    public void fillForm(QASectionElements interestInSolution, QASectionElements teamMember,
                         QASectionElements manageWork, SimpleWrikeTestData comment) {
        fillForm(interestInSolution, teamMember, manageWork);
        otherTextField.sendKeys(comment.value);
    }

    public void submit() {
        assertTrue(submitButton.isEnabled());
        submitButton.click();
    }
}
