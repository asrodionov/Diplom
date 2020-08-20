package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SuccessAlertPage {
    private SelenideElement successAlert = $(".heading");

    public SuccessAlertPage() {
        successAlert.shouldBe(visible);
    }

}
