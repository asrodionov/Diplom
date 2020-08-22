package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class SuccessAlertPage {
    private SelenideElement successAlert = $$(".notification__title").find((exactText("Успешно")));

    public SuccessAlertPage() {
        successAlert.waitUntil(visible, 20000);
    }

}
