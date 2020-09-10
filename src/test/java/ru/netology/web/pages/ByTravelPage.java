package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ByTravelPage {

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

    public void setValidNumberCard() {
        numberCard.setValue(DataHelper.getValidCardNumber().getNumber());
    }

    public void setNotValidNumberCard() {
        numberCard.setValue(DataHelper.getNotValidCardNumber().getNumber());
    }

    public void setRandomGenerateCardInfo() {
        monthCard.setValue(DataHelper.generateRandomCardInfo().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.generateRandomCardInfo().getYear()));
        ownerCard.setValue(DataHelper.generateRandomCardInfo().getName());
        cvcCard.setValue(DataHelper.generateRandomCardInfo().getCvc());
        proceedButton.click();
    }

    public void setCardInfo(DataHelper.CardInfo cardInfo) {
        monthCard.setValue(cardInfo.getMonth());
        yearCard.setValue(String.valueOf(cardInfo.getYear()));
        ownerCard.setValue(cardInfo.getName());
        cvcCard.setValue(cardInfo.getCvc());
        proceedButton.click();
    }

    public void checkSuccessAlert() {
        successAlert.waitUntil(visible, 40000);
    }

    public void checkErrorAlert() {
        errorAlert.waitUntil(visible, 40000);
    }

    public void checkValidityCardError() {
        validityError.shouldBe(visible);
    }

    public void checkValidityYearCardError() { validityYearError.shouldBe(visible); }

    public void checkOwnerCardError() { ownerCardError.shouldBe(visible); }
}
