package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TravelItemPage {
    private SelenideElement heading = $(".heading");
    private SelenideElement byButton = $$("button").find((exactText("Купить")));
    private SelenideElement byInCreditButton = $$("button").find((exactText("Купить в кредит")));

    public TravelItemPage() {
        heading.shouldBe(visible);
    }

    public ByTravelPage byInCash() {
        byButton.click();
        return new ByTravelPage();
    }

    public void byInCredit() {
        byInCreditButton.click();
    }
}
