package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TravelItemPage {
    private SelenideElement heading = $(".heading");
    //private SelenideElement byButton = $("button").find(String.valueOf(exactText("Купить")));
    private SelenideElement byButton = $("button").lastChild();
    private SelenideElement byInCreditButton = $("button").find(String.valueOf(exactText("Купить")));

    public TravelItemPage() {
        heading.shouldBe(visible);
    }

    public ByTravelPage byInCash(){
        byButton.click();
        return new ByTravelPage();
    }

    public void byInCredit(){
        byInCreditButton.click();
    }
}
