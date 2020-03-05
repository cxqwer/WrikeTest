package simpleTests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexMainPage {

    public SelenideElement searchInputField = $(".input__control");

    public SelenideElement searchButton = $(".search2__button");

    public ElementsCollection searchedTitleList = $$(".needsclick");

}
