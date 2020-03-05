package wrikeTests.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static Logger logger = LoggerFactory.getLogger(BaseSteps.class);

    @Когда("открываем сайт {string}")
    public void openURL(String url){
        open(url);
    }


}
