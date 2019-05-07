
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import wrikeTests.pages.*;
import wrikeTests.utilities.GeneratedEmail;
import org.testng.annotations.*;
import static java.lang.System.setProperty;
import static wrikeTests.enums.QASectionElements.*;
import static wrikeTests.enums.SimpleWrikeTestData.*;
import static wrikeTests.enums.SocialMedias.TWITER;

public class SimpleWrikeTest {
    private WebDriver driver;
    private IndexPage indexPage;
    private ResendPage resendPage;

    @BeforeSuite
    public void beforeSuite() {
        setProperty(CHROM_WEB_DRIVER.value, CHROM_WEB_DRIVER_PATH.value);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        resendPage = PageFactory.initElements(driver, ResendPage.class);
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test
    public void tests() {
        //1 Open url: wrike.com;

        indexPage.open(SITE_URL);

        //2 Click "Get started for free" button near "Login" button;
        indexPage.clickGetStartedForFree();

        //3 Fill in the email field with random generated number of email;
        indexPage.fillEmailField(GeneratedEmail.createRandomEmail());

        //4 Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
        indexPage.clickCreateWrikeAccountButton();
        resendPage.checkMovedResendPage();

        //5 Fill in the Q&A section at the left part of page + check with assertion that your answers are submitted;
        resendPage.fillForm(VERY_INTERESTED, SIX_TO_FIFTEEN, OTHER, COMMENTS);
        resendPage.submit();

        //6 Click and check "Resend email";
        resendPage.ResendEmail();

        //7 Check that section "Follow us";
        resendPage.checkFooterContainElement(TWITER);
    }
}
