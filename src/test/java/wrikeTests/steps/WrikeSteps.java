package wrikeTests.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import utilities.GeneratedEmail;

import static wrikeTests.enums.QASectionElements.*;
import static wrikeTests.enums.SimpleWrikeTestData.COMMENTS;
import static wrikeTests.enums.SocialMedias.TWITER;
import static wrikeTests.runner.RunnerTest.indexPage;
import static wrikeTests.runner.RunnerTest.resendPage;

public class WrikeSteps extends BaseSteps {

    @И("нажимаем кнопку Get started for free возле кнопки авторизации")
    public void нажимаемКнопкуGetStartedForFreeВозлеКнопкиАвторизации() {
        indexPage.clickGetStartedForFree();
    }

    @И("генерируем email и заполняем поле email")
    public void генерируемEmailИЗаполняемПолеEmail() {
        indexPage.fillEmailField(GeneratedEmail.createRandomEmail());
    }

    @И("нажимаем кнопку Create my Wrike account")
    public void нажимаемКнопкуCreateMyWrikeAccount() {
        indexPage.clickCreateWrikeAccountButton();
    }

    @Тогда("присходит переход на следующую страницу")
    public void присходитПереходНаСледующуюСтраницу() {

    }

    @И("проверяем отправляемую страницу")
    public void проверяемОтправляемуюСтраницу() {
        resendPage.checkMovedResendPage();
    }

    @Когда("заполняем Q&A section в левой части страницы и проверяем что ответ подвержден")
    public void заполняемQASectionВЛевойЧастиСтраницыИПроверяемЧтоОтветПодвержден() {
        resendPage.fillForm(VERY_INTERESTED, SIX_TO_FIFTEEN, OTHER, COMMENTS);
    }

    @И("нажимаем подтвердить")
    public void нажимаемПодтвердить() {
        resendPage.submit();
    }

    @И("нажимаем и проверяем Resend email")
    public void нажимаемИПроверяемResendEmail() {
        resendPage.ResendEmail();
    }


    @Тогда("скеция Follow us корректна")
    public void скецияFollowUsКорректна() {
        resendPage.checkFooterContainElement(TWITER);
    }
}
