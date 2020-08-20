package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ByTravelPage {
    private SelenideElement heading = $("h3").find(String.valueOf(exactText("Оплата по карте")));

    private SelenideElement numberCard = $("[data-test-id=login] input");
    private SelenideElement monthCard = $("[data-test-id=password] input");
    private SelenideElement yearCard = $("[data-test-id=password] input");
    private SelenideElement ownerCard = $("[data-test-id=action-login]");
    private SelenideElement cvcCard = $("[data-test-id=action-login]");

    private SelenideElement proceedButton = $("button").find(String.valueOf(exactText("Продолжить")));

    private SelenideElement successAlert = $("button").find(String.valueOf(exactText("Продолжить")));

    public ByTravelPage() {
        heading.shouldBe(visible);
    }

    public SuccessAlertPage validNumberCard() {
        numberCard.setValue(DataHelper.getValidCardNumber().getNumber());
        monthCard.setValue(String.valueOf(DataHelper.generateCardInfo().getMonth()));
        yearCard.setValue(String.valueOf(DataHelper.generateCardInfo().getYear()));
        ownerCard.setValue(DataHelper.generateCardInfo().getName());
        cvcCard.setValue(DataHelper.generateCardInfo().getCvc());
        proceedButton.click();
        return new SuccessAlertPage();
    }
}
