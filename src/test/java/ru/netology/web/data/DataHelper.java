package ru.netology.web.data;
import ru.netology.web.data.CardYear;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardNumber {
        String number;
    }

    public static CardNumber getValidCardNumber() {
        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getNotValidCardNumber() {
        return new CardNumber("4444 4444 4444 4442");
    }

    @Value
    public static class CardInfo {
        String month;
        int year;
        String name;
        String cvc;
    }

    public static CardInfo generateCardInfo() {
        Faker faker = new Faker(new Locale("en"));
        return new CardInfo(
                String.valueOf(faker.number().numberBetween(10, 12)),
                faker.number().numberBetween(CardYear.getYearCard(0), CardYear.getYearCard(5)),
                faker.name().fullName(),
                faker.number().digits(3)
        );
    }

    public static CardInfo getValidCardInfoScenario1() {
        return new CardInfo("06", CardYear.getYearCard(1), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getValidCardInfoScenario2() {
        return new CardInfo("01", CardYear.getYearCard(1), "ANDREI RODIONOV", "999");
    }

    public static CardInfo getValidCardInfoScenario3() {
        return new CardInfo("12", CardYear.getYearCard(0), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getValidCardInfoScenario4() {
        return new CardInfo("09", CardYear.getYearCard(0), "ANDREI RODIONOV", "111");
    }

    public static CardInfo getNotValidCardInfoScenario5() {
        return new CardInfo("07", CardYear.getYearCard(1), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getNotValidCardInfoScenario6() {
        return new CardInfo("00", CardYear.getYearCard(1), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getNotValidCardInfoScenario7() {
        return new CardInfo("13", CardYear.getYearCard(1), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getNotValidCardInfoScenario8() {
        return new CardInfo("06", CardYear.getYearCard(-1), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getNotValidCardInfoScenario9() {
        return new CardInfo("06", CardYear.getYearCard(8), "ANDREI RODIONOV", "691");
    }

    public static CardInfo getNotValidCardInfoScenario10() {
        return new CardInfo("06", CardYear.getYearCard(1), "АНДРЕЙ РОДИОНОВ", "691");
    }

    public static CardInfo getNotValidCardInfoScenario11() {
        return new CardInfo("06", CardYear.getYearCard(1), "123", "691");
    }

    public static CardInfo getNotValidCardInfoScenario12() {
        return new CardInfo("06", CardYear.getYearCard(1), "%&$", "691");
    }

}
