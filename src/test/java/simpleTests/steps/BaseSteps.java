package simpleTests.steps;

import io.cucumber.java.ru.Когда;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps extends RunnerTest {

    @Когда("открываем сайт {string}")
    public void openURL(String url){
        open(url);
    }

}
