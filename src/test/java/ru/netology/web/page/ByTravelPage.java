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

    private SelenideElement successAlert = $$(".notification_status_ok .notification__title").find((exactText("Успешно")));
    private SelenideElement errorAlert = $$(".notification_status_error .notification__title").find((exactText("Ошибка")));
    private SelenideElement validityError = $$(".input_invalid .input__sub").find((exactText("Неверно указан срок действия карты")));
    private SelenideElement validityYearError = $$(".input_invalid .input__sub").find((exactText("Истёк срок действия карты")));
    private SelenideElement ownerCardError = $$(".input_invalid .input__sub").find((exactText("Неверно указан владелец карты")));

    public ByTravelPage() {
        heading.shouldBe(visible);
    }

    public void validNumberCard() {
        numberCard.setValue(DataHelper.getValidCardNumber().getNumber());
    }

    public void notValidNumberCard() {
        numberCard.setValue(DataHelper.getNotValidCardNumber().getNumber());
    }

    public void generateCardInfo() {
        monthCard.setValue(DataHelper.generateCardInfo().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.generateCardInfo().getYear()));
        ownerCard.setValue(DataHelper.generateCardInfo().getName());
        cvcCard.setValue(DataHelper.generateCardInfo().getCvc());
        proceedButton.click();
    }

    public void validCardInfo(int number) {
        monthCard.setValue(DataHelper.validCardInfo(number).getMonth());
        yearCard.setValue(String.valueOf(DataHelper.validCardInfo(number).getYear()));
        ownerCard.setValue(DataHelper.validCardInfo(number).getName());
        cvcCard.setValue(DataHelper.validCardInfo(number).getCvc());
        proceedButton.click();
    }

    public void notValidCardInfo(int number) {
        monthCard.setValue(DataHelper.notValidCardInfo(number).getMonth());
        yearCard.setValue(String.valueOf(DataHelper.notValidCardInfo(number).getYear()));
        ownerCard.setValue(DataHelper.notValidCardInfo(number).getName());
        cvcCard.setValue(DataHelper.notValidCardInfo(number).getCvc());
        proceedButton.click();
    }

    public void SuccessAlert() {
        successAlert.waitUntil(visible, 20000);
    }

    public void ErrorAlert() {
        errorAlert.waitUntil(visible, 20000);
    }

    public void validityCardError() {
        validityError.shouldBe(visible);
    }

    public void validityYearCardError() { validityYearError.shouldBe(visible); }

    public void ownerCardError() { ownerCardError.shouldBe(visible); }
}
