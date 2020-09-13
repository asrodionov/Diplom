package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SqlDataHelper;
import ru.netology.web.pages.TravelItemPage;

import java.util.stream.Stream;

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
    void shouldSuccessCreditPurchaseWithGenerateData() {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setRandomGenerateCardInfo();
        byTravelPage.checkSuccessAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    public static Stream<DataHelper.CardInfo> getValidCardData() {
        return Stream.of(
                new DataHelper.CardInfo("06", DataHelper.getYearCard(1), "ANDREI RODIONOV", "691"),
                new DataHelper.CardInfo("01", DataHelper.getYearCard(1), "ANDREI RODIONOV", "999"),
                new DataHelper.CardInfo("12", DataHelper.getYearCard(0), "ANDREI RODIONOV", "691"),
                new DataHelper.CardInfo("09", DataHelper.getYearCard(0), "ANDREI RODIONOV", "111"));
    }

    @ParameterizedTest
    @MethodSource("getValidCardData")
    void shouldSuccessCreditPurchaseWithData(DataHelper.CardInfo cardInfo) {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setCardInfo(cardInfo);
        byTravelPage.checkSuccessAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "APPROVED");
    }

    @Test
    void shouldErrorCreditPurchaseWithNotValidNumberCard() {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setNotValidNumberCard();
        byTravelPage.setCardInfo(new DataHelper.CardInfo("07", DataHelper.getYearCard(1), "ANDREI RODIONOV", "691"));
        byTravelPage.checkErrorAlert();
        assertEquals(SqlDataHelper.getStatusLastCreditTransaction(), "DECLINED");
    }

    public static Stream<DataHelper.CardInfo> getNotValidCardDataForValidityCardError() {
        return Stream.of(
                new DataHelper.CardInfo("00", DataHelper.getYearCard(1), "ANDREI RODIONOV", "691"),
                new DataHelper.CardInfo("13", DataHelper.getYearCard(1), "ANDREI RODIONOV", "691"),
                new DataHelper.CardInfo("06", DataHelper.getYearCard(8), "ANDREI RODIONOV", "691"));
    }

    @ParameterizedTest
    @MethodSource("getNotValidCardDataForValidityCardError")
    void shouldErrorCreditPurchaseWithDataValidityCardError(DataHelper.CardInfo cardInfo) {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setCardInfo(cardInfo);
        byTravelPage.checkValidityCardError();
    }

    @Test
    void shouldErrorCreditPurchaseWithDataValidityYearCardError() {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setCardInfo(new DataHelper.CardInfo("06", DataHelper.getYearCard(-1), "ANDREI RODIONOV", "691"));
        byTravelPage.checkValidityYearCardError();
    }

    public static Stream<DataHelper.CardInfo> getNotValidCardDataForOwnerCardError() {
        return Stream.of(
                new DataHelper.CardInfo("06", DataHelper.getYearCard(1), "АНДРЕЙ РОДИОНОВ", "691"),
                new DataHelper.CardInfo("06", DataHelper.getYearCard(1), "123", "691"),
                new DataHelper.CardInfo("06", DataHelper.getYearCard(1), "%&$", "691"));
    }

    @ParameterizedTest
    @MethodSource("getNotValidCardDataForOwnerCardError")
    void shouldErrorCreditPurchaseWithDataOwnerCardError(DataHelper.CardInfo cardInfo) {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setCardInfo(cardInfo);
        byTravelPage.checkOwnerCardError();
    }

    @Test
    void shouldRightCreditIdInDb() {
        val travelItemPage = open(System.getProperty("sut.url"), TravelItemPage.class);
        val byTravelPage = travelItemPage.byInCredit();
        byTravelPage.setValidNumberCard();
        byTravelPage.setRandomGenerateCardInfo();
        byTravelPage.checkSuccessAlert();
        assertEquals(SqlDataHelper.getCreditId(), SqlDataHelper.getIdInCreditTable());
    }
}

