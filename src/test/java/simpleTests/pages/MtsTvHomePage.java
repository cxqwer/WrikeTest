package simpleTests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class MtsTvHomePage {

    public SelenideElement promoCard = $(".mts-modal-body-wrapper");

    public SelenideElement promoCloseButton = $(".mts-modal-content .icon-close");

    public SelenideElement searchButton = $(".icon-search");

    public SelenideElement searchInput = $(byId("input-text-overflow"));

    public SelenideElement searchedTitle = $(".vod-name");

}
