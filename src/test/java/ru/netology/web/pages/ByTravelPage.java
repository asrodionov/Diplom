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

    public void setGenerateCardInfo() {
        monthCard.setValue(DataHelper.generateCardInfo().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.generateCardInfo().getYear()));
        ownerCard.setValue(DataHelper.generateCardInfo().getName());
        cvcCard.setValue(DataHelper.generateCardInfo().getCvc());
        proceedButton.click();
    }

    public void setValidCardInfoScenario1() {
        monthCard.setValue(DataHelper.getValidCardInfoScenario1().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getValidCardInfoScenario1().getYear()));
        ownerCard.setValue(DataHelper.getValidCardInfoScenario1().getName());
        cvcCard.setValue(DataHelper.getValidCardInfoScenario1().getCvc());
        proceedButton.click();
    }

    public void setValidCardInfoScenario2() {
        monthCard.setValue(DataHelper.getValidCardInfoScenario2().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getValidCardInfoScenario2().getYear()));
        ownerCard.setValue(DataHelper.getValidCardInfoScenario2().getName());
        cvcCard.setValue(DataHelper.getValidCardInfoScenario2().getCvc());
        proceedButton.click();
    }

    public void setValidCardInfoScenario3() {
        monthCard.setValue(DataHelper.getValidCardInfoScenario3().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getValidCardInfoScenario3().getYear()));
        ownerCard.setValue(DataHelper.getValidCardInfoScenario3().getName());
        cvcCard.setValue(DataHelper.getValidCardInfoScenario3().getCvc());
        proceedButton.click();
    }

    public void setValidCardInfoScenario4() {
        monthCard.setValue(DataHelper.getValidCardInfoScenario4().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getValidCardInfoScenario4().getYear()));
        ownerCard.setValue(DataHelper.getValidCardInfoScenario4().getName());
        cvcCard.setValue(DataHelper.getValidCardInfoScenario4().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario5() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario5().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario5().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario5().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario5().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario6() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario6().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario6().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario6().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario6().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario7() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario7().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario7().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario7().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario7().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario8() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario8().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario8().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario8().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario8().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario9() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario9().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario9().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario9().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario9().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario10() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario10().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario10().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario10().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario10().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario11() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario11().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario11().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario11().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario11().getCvc());
        proceedButton.click();
    }

    public void setNotValidCardInfoScenario12() {
        monthCard.setValue(DataHelper.getNotValidCardInfoScenario12().getMonth());
        yearCard.setValue(String.valueOf(DataHelper.getNotValidCardInfoScenario12().getYear()));
        ownerCard.setValue(DataHelper.getNotValidCardInfoScenario12().getName());
        cvcCard.setValue(DataHelper.getNotValidCardInfoScenario12().getCvc());
        proceedButton.click();
    }

    public void successAlert() {
        successAlert.waitUntil(visible, 40000);
    }

    public void errorAlert() {
        errorAlert.waitUntil(visible, 40000);
    }

    public void validityCardError() {
        validityError.shouldBe(visible);
    }

    public void validityYearCardError() { validityYearError.shouldBe(visible); }

    public void ownerCardError() { ownerCardError.shouldBe(visible); }
}
