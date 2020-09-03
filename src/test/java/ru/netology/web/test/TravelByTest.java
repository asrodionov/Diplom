package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.SqlDataHelper;
import ru.netology.web.pages.TravelItemPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelByTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessPurchaseWithGenerateData() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setGenerateCardInfo();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario1() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario1();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario2() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario2();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario3() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario3();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario4() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario4();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldErrorPurchaseWithDataScenario5() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setNotValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario5();
        byTravelPage.errorAlert();
        assertEquals(SqlDataHelper.getStatusLastTransaction(), "DECLINED");
    }

    @Test
    void shouldErrorPurchaseWithDataScenario6() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario6();
        byTravelPage.errorAlert();
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario7() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario7();
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario8() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario8();
        byTravelPage.validityYearCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario9() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario9();
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario10() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario10();
        byTravelPage.ownerCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario11() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario11();
        byTravelPage.ownerCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario12() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario12();
        byTravelPage.ownerCardError();
    }

    @Test
    void shouldRightPriceInDb() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario1();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getPriceLastTransaction(), "45000");
    }

    @Test
    void shouldRightPaymentIdInDb() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario1();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getPaymentId(), SqlDataHelper.getTransactionId());
    }
}
