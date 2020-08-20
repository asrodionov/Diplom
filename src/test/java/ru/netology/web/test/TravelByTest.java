package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.ByTravelPage;
import ru.netology.web.page.TravelItemPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;


public class TravelByTest {

    @Test
    void shouldSuccessPurchase() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
//        val authInfo = getAuthInfo();
//        val verificationPage = loginPage.validLogin(authInfo);
//        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
//        verificationPage.validVerify(verificationCode);
    }
}
