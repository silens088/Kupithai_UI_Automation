package autotests.tests;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Microservice;
import autotests.helpers.DriverUtils;
import autotests.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("vvelichko")
@Story("MainPageTests")
@Tags({@Tag("Web"), @Tag("UI")})
@JiraIssues({@JiraIssue("HOMEWORK-356")})

public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.BLOCKER)
    @Microservice("Главная страница")
    @Feature("Главная страница сайта")
    @Story("Проверка текста основных блоков")
    @Description("Тест для главной страницы")
    @DisplayName("Проверяем заголовок главной страницы")
    void mainPageTitleTest() {
        step("Открываем главную страницу сайта " + mainPage.MAIN_PAGE_URL, () ->
                mainPage.openPage());

        String actualTitle = title();

        step("Проверяем что заголовок содержит текст: " + mainPage.mainTitle, () ->
                assertThat(actualTitle).isEqualTo(mainPage.mainTitle));
    }

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.NORMAL)
    @Microservice("Главная страница")
    @Feature("Главная страница сайта")
    @Story("Проверка текста основных блоков")
    @Description("Тест для главной страницы")
    @DisplayName("На странице отображается главная форма")
    void mainPageMainFormVisibleTest() {
        step("Открыть главную страницу " + mainPage.MAIN_PAGE_URL, () ->
                mainPage.openPage());

        step("Проверяем что отображается главная форма", () ->
                mainPage.checkVisibleMainForm());
    }

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.CRITICAL)
    @Microservice("Главная страница")
    @Feature("Главная страница сайта")
    @Story("Проверка текста основных блоков")
    @Description("Тест для главной страницы")
    @DisplayName("На странице отображается главный заголовок")
    void mainPageHaveTitleTest() {
        step("Открыть главную страницу " + mainPage.MAIN_PAGE_URL, () ->
                mainPage.openPage());

        step("Проверяем что заголовок страницы видимый", () ->
                $(".us-main-shop-title").shouldBe(visible));

        step("Заголовок страницы содержит текст: " + mainPage.trueTextMainPage, () ->
                mainPage.checkTrueTextForMainPage());
    }

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.TRIVIAL)
    @Microservice("Главная страница")
    @Feature("Главная страница сайта")
    @Story("Проверка текста основных блоков")
    @Description("Тест для главной страницы")
    @DisplayName("Негативный кейс. Заголовок содержит неверный текст")
    void negativeMainPageHaveTitleTest() {
        step("Открыть главную страницу " + mainPage.MAIN_PAGE_URL, () ->
                mainPage.openPage());

        step("Проверяем что заголовок страницы видимый", () ->
                $(".us-main-shop-title").shouldBe(visible));

        step("Проверяем что заголовок страницы содержит неверный текст", () ->
                mainPage.checkBadTextForMainPage());
    }

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.NORMAL)
    @Microservice("Главная страница")
    @Feature("Главная страница сайта")
    @Story("Проверка текста основных блоков")
    @Description("Тест для главной страницы")
    @DisplayName("Проверяем основные элементы меню")
    public void checkMenuItemsTest() {
        step("Открываем главную страницу " + mainPage.MAIN_PAGE_URL, () ->
                mainPage.openPage());

        step("Проверяем основные элементы меню и их видимость", () ->
                $("#oct-megamenu").shouldHave
                        (text(mainPage.paymentDelivery),
                                (text(mainPage.guarantees)),
                                (text(mainPage.getOrder)),
                                (text(mainPage.presents)),
                                (text(mainPage.productDay))));

        step("Проверяем что элемент" + mainPage.wishlist + "невидим", () ->
                $(".vi-oct-megamenu-wishlist-link").shouldNot(visible));
    }

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.MINOR)
    @Microservice("Главная страница")
    @Feature("Главная страница сайта")
    @Story("Проверка текста основных блоков")
    @Description("Тест для главной страницы")
    @DisplayName("Консоль логов не содержит ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть главную страницу " + mainPage.MAIN_PAGE_URL, () -> {
            mainPage.openPage();

            step("Проверяем что консоль логов не содержит ошибок 'SEVERE'", () -> {
                String consoleLogs = DriverUtils.getConsoleLogs();
                String errorText = "SEVERE";
                assertThat(consoleLogs).doesNotContain(errorText);
            });
        });
    }
}