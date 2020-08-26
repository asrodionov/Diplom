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

public class TravelByInCreditTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessCreditPurchaseWithGenerateData() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.generateCardInfo();
        byTravelInCreditPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario1() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.validCardInfo(1);
        byTravelInCreditPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario2() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.validCardInfo(2);
        byTravelInCreditPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario3() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.validCardInfo(3);
        byTravelInCreditPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario4() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.validCardInfo(4);
        byTravelInCreditPage.SuccessAlert();
        assertEquals(DataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario5() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.notValidNumberCard();
        byTravelInCreditPage.notValidCardInfo(5);
        byTravelInCreditPage.ErrorAlert();
        assertEquals(DataHelper.getStatusLastCreditTransaction(), "DECLINED");
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario6() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(6);
        byTravelInCreditPage.ErrorAlert();
        byTravelInCreditPage.validityCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario7() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(7);
        byTravelInCreditPage.validityCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario8() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(8);
        byTravelInCreditPage.validityYearCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario9() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(9);
        byTravelInCreditPage.validityCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario10() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(10);
        byTravelInCreditPage.ownerCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario11() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(11);
        byTravelInCreditPage.ownerCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario12() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelInCreditPage = travelItemPage.byInCredit();
        byTravelInCreditPage.validNumberCard();
        byTravelInCreditPage.notValidCardInfo(12);
        byTravelInCreditPage.ownerCardError();
    }
}

