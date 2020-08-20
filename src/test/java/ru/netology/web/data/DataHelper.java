package ru.netology.web.data;

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
        int month;
        int year;
        String name;
        String cvc;
    }

    public static CardInfo generateCardInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new CardInfo(
                faker.number().numberBetween(1,12),
                faker.number().numberBetween(20,25),
                faker.name().fullName(),
                faker.number().digits(3)
        );
    }

    @Value
    public static class DataBaseConn {
        String url;
        String user;
        String password;
    }

    public static DataBaseConn getDataBaseConn() {
        return new DataBaseConn("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
    }
}
