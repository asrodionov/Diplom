package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TravelItemPage {
    private SelenideElement heading = $(".heading");
    private SelenideElement byButton = $$("button").find((exactText("Купить")));
    private SelenideElement byInCreditButton = $$("button").find((exactText("Купить в кредит")));

    private SelenideElement headingCash = $$("h3").find((exactText("Оплата по карте")));
    private SelenideElement headingCredit = $$("h3").find((exactText("Кредит по данным карты")));

    public TravelItemPage() {
        heading.shouldBe(visible);
    }

    public ByTravelPage byInCash() {
        byButton.click();
        headingCash.shouldBe(visible);
        return new ByTravelPage();
    }

    public ByTravelPage byInCredit() {
        byInCreditButton.click();
        headingCredit.shouldBe(visible);
        return new ByTravelPage();
    }
}
