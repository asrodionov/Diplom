package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.TravelItemPage;
import io.qameta.allure.selenide.AllureSelenide;

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
        byTravelPage.validNumberCard();
        byTravelPage.generateCardInfo();
        byTravelPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldRightPriceInDb() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.generateCardInfo();
        byTravelPage.SuccessAlert();
        assertEquals(DataHelper.getPriceLastTransaction(), "45000");

    }

    @Test
    void shouldSuccessPurchaseWithDataScenario1() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.validCardInfo(1);
        byTravelPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario2() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.validCardInfo(2);
        byTravelPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario3() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.validCardInfo(3);
        byTravelPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessPurchaseWithDataScenario4() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.validCardInfo(4);
        byTravelPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastTransaction(), "APPROVED");
    }

    @Test
    void shouldErrorPurchaseWithDataScenario5() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.notValidNumberCard();
        byTravelPage.notValidCardInfo(5);
        byTravelPage.ErrorAlert();
        assertEquals(DataHelper.getStatusLastTransaction(), "DECLINED");
    }

    @Test
    void shouldErrorPurchaseWithDataScenario6() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(6);
        byTravelPage.ErrorAlert();
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario7() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(7);
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario8() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(8);
        byTravelPage.validityYearCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario9() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(9);
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario10() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(10);
        byTravelPage.ownerCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario11() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(11);
        byTravelPage.ownerCardError();
    }

    @Test
    void shouldErrorPurchaseWithDataScenario12() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCash();
        byTravelPage.validNumberCard();
        byTravelPage.notValidCardInfo(12);
        byTravelPage.ownerCardError();
    }
}
