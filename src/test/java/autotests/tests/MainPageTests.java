package autotests.tests;

import autotests.helpers.DriverUtils;
import autotests.pages.MainPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import autotests.annotations.Microservice;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("vvelichko")
@Story("MainPageTests")

public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.CRITICAL)
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
    @Microservice("mainPage")
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
    @Tags({@Tag("web"), @Tag("UI")})
    @DisplayName("Проверяем основные элементы меню")
    public void checkMenuItemsTest() {
        step("Открыть главную страницу " + mainPage.MAIN_PAGE_URL, () -> {
            mainPage.openPage();

            step("Проверяем основные элементы меню и их видимость", () -> {
                $("#oct-megamenu").shouldHave(text("Оплата и доставка")).shouldBe(visible);
                $("#oct-megamenu").shouldHave(text("Гарантии")).shouldBe(visible);
                $("#oct-megamenu").shouldHave(text("Как оформить заказ")).shouldBe(visible);
                $("#oct-megamenu").shouldHave(text("Подарки")).shouldBe(visible);
                $("#oct-megamenu").shouldHave(text("Товар дня")).shouldBe(visible);
            });
            step("Проверяем что элемент Список желаний невидим", () ->
                    $(".vi-oct-megamenu-wishlist-link").shouldNot(Condition.visible));
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
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