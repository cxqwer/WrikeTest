package simpleTests.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertTrue;
import static simpleTests.steps.RunnerTest.yandexMainPage;
import static simpleTests.util.Constance.BASE_TIMEOUT;
import static simpleTests.util.TestListener.makeScreenshot;

public class YandexSteps {


    @Тогда("открыт сайт яндекса. Отображается поле поиска")
    public void открытСайтЯндексаОтображаетсяПолеПоиска() {
        yandexMainPage.searchInputField.waitUntil(visible, BASE_TIMEOUT);
        makeScreenshot();
    }

    @Когда("в поле поиска вводим {string}")
    public void вПолеПоискаВводим(String text) {
        yandexMainPage.searchInputField.waitUntil(visible, BASE_TIMEOUT).sendKeys(text);
        makeScreenshot();
    }

    @И("нажимаем кнопку поиска")
    public void нажимаемКнопкуПоиска() {
        makeScreenshot();
        yandexMainPage.searchButton.waitUntil(visible, BASE_TIMEOUT).click();
    }

    @Тогда("по запросу найдена информация")
    public void поЗапросуНайденаИнформация() {
        sleep(2000);
        assertTrue(yandexMainPage.searchedTitleList.size()>0);
        makeScreenshot();
    }
}
