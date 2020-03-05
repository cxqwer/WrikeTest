package wrikeTests.steps;

import io.cucumber.java.ru.Когда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wrikeTests.runner.RunnerTest;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps extends RunnerTest {
    private static Logger logger = LoggerFactory.getLogger(BaseSteps.class);

    @Когда("открываем сайт {string}")
    public void openURL(String url){
        open(url);
    }

}
