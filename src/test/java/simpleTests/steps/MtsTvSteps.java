package simpleTests.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;
import static simpleTests.steps.RunnerTest.mtsTvHomePage;
import static simpleTests.util.Constance.BASE_TIMEOUT;
import static simpleTests.util.TestListener.makeScreenshot;

public class MtsTvSteps {

    @Тогда("открыто окно рекламной акции")
    public void открытоОкноРекламнойАкции() {
        mtsTvHomePage.promoCard.waitUntil(visible, BASE_TIMEOUT);
        makeScreenshot();
    }

    @Когда("выполняем поиск фильма {string}")
    public void выполняемПоискФильма(String text) {
        mtsTvHomePage.searchButton.waitUntil(visible, BASE_TIMEOUT).click();
        mtsTvHomePage.searchInput.waitUntil(visible, BASE_TIMEOUT).sendKeys(text);
        makeScreenshot();
        mtsTvHomePage.searchInput.sendKeys(System.getProperty("line.separator"));
        sleep(2000);
    }

    @Когда("закрываем окно рекламной акции")
    public void закрываемОкноРекламнойАкции() {
        makeScreenshot();
        mtsTvHomePage.promoCloseButton.waitUntil(visible, BASE_TIMEOUT).click();
        sleep(2000);
    }

    @Тогда("найден фильм {string}")
    public void найденФильм(String text) {
        assertTrue(mtsTvHomePage.searchedTitle.waitUntil(visible, BASE_TIMEOUT).getText().contains(text));
        makeScreenshot();
    }
}
