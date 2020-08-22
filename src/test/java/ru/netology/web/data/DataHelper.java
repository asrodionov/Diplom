package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;
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
        Faker faker = new Faker(new Locale("en"));
        return new CardInfo(
                faker.number().numberBetween(10, 12),
                faker.number().numberBetween(20, 25),
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

    public static String getStatusLastTransaction() {
        String status = null;
        try {
            val codeSQL = "SELECT status FROM payment_entity ORDER BY id DESC LIMIT 1;";
            val runner = new QueryRunner();
            val conn = DriverManager
                    .getConnection(getDataBaseConn().url, getDataBaseConn().user, getDataBaseConn().password);
            val statusTransaction = runner.query(conn, codeSQL, new ScalarHandler<>());
            status = (String) statusTransaction;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
