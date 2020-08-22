package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ByTravelPage {
    private SelenideElement heading = $$("h3").find((exactText("Оплата по карте")));

    private SelenideElement numberCard = $$("input.input__control").get(0);
    private SelenideElement monthCard = $$("input.input__control").get(1);
    private SelenideElement yearCard = $$("input.input__control").get(2);
    private SelenideElement ownerCard = $$("input.input__control").get(3);
    private SelenideElement cvcCard = $$("input.input__control").get(4);

    private SelenideElement proceedButton = $$("button").find((exactText("Продолжить")));

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
