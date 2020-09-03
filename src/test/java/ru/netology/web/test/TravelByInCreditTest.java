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
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setGenerateCardInfo();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario1() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario1();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario2() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario2();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario3() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario3();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldSuccessCreditPurchaseWithDataScenario4() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario4();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario5() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setNotValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario5();
        byTravelPage.errorAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "DECLINED");
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario6() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario6();
        byTravelPage.errorAlert();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario7() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario7();
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario8() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario8();
        byTravelPage.validityYearCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario9() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario9();
        byTravelPage.validityCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario10() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario6();
        byTravelPage.errorAlert();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario11() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario11();
        byTravelPage.errorAlert();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataScenario12() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setNotValidCardInfoScenario12();
        byTravelPage.errorAlert();
    }

    @Test
    void shouldRightCreditIdInDb() throws SQLException {
        val travelItemPage = open("http://localhost:8080", TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setValidCardInfoScenario1();
        byTravelPage.successAlert();
        assertEquals(SqlDataHelper.getCreditId(), SqlDataHelper.getIdInCreditTable());
    }
}

