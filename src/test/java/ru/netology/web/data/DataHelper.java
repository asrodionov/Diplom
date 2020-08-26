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
        String month;
        int year;
        String name;
        String cvc;
    }

    public static CardInfo generateCardInfo() {
        Faker faker = new Faker(new Locale("en"));
        return new CardInfo(
                String.valueOf(faker.number().numberBetween(10, 12)),
                faker.number().numberBetween(20, 25),
                faker.name().fullName(),
                faker.number().digits(3)
        );
    }

    public static CardInfo validCardInfo(int numberScenario) {
        if (numberScenario==1){
            return new CardInfo("06",21,"ANDREI RODIONOV","691");
        } else if (numberScenario==2){
            return new CardInfo("01",21,"ANDREI RODIONOV","999");
        } else if (numberScenario==3){
            return new CardInfo("12",20,"ANDREI RODIONOV","691");
        } else if (numberScenario==4){
            return new CardInfo("09",25,"ANDREI RODIONOV","111");
        }
        return null;
    }

    public static CardInfo notValidCardInfo(int numberScenario) {
        if (numberScenario==5){
            return new CardInfo("07",21,"ANDREI RODIONOV","691");
        } else if (numberScenario==6){
            return new CardInfo("00",21,"ANDREI RODIONOV","691");
        } else if (numberScenario==7){
            return new CardInfo("13",21,"ANDREI RODIONOV","691");
        } else if (numberScenario==8){
            return new CardInfo("06",19,"ANDREI RODIONOV","691");
        } else if (numberScenario==9){
            return new CardInfo("06",28,"ANDREI RODIONOV","691");
        } else if (numberScenario==10){
            return new CardInfo("06",21,"АНДРЕЙ РОДИОНОВ","691");
        } else if (numberScenario==11){
            return new CardInfo("06",21,"123","691");
        } else if (numberScenario==12){
            return new CardInfo("06",21,"%&$","691");
        }
        return null;
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

    public static String getStatusLastCreditTransaction() {
        String status = null;
        try {
            val codeSQL = "SELECT status FROM credit_request_entity ORDER BY id DESC LIMIT 1;";
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

    public static int getPriceLastTransaction() {
        int price = 0;
        try {
            val codeSQL = "SELECT amount FROM payment_entity ORDER BY id DESC LIMIT 1;";
            val runner = new QueryRunner();
            val conn = DriverManager
                    .getConnection(getDataBaseConn().url, getDataBaseConn().user, getDataBaseConn().password);
            val amount = runner.query(conn, codeSQL, new ScalarHandler<>());
            price = (int) amount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
}
