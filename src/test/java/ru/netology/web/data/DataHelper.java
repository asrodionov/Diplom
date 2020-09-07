package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Data;
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
    @Data
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
}
