package autotests.tests;

import autotests.pages.MainPage;
import autotests.pages.RegistrationPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

@Owner("vvelichko")
@Story("RegistrationTests")

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем поля формы регистрации")
    void checkRegistrationFormFields() {

        step("Открыть главную страницу " + MainPage.MAIN_PAGE_URL, () ->
                registrationPage.openPage());
        step("Проверяем URL " + MainPage.MAIN_PAGE_URL, () ->
                webdriver().shouldHave(url(MainPage.MAIN_PAGE_URL)));

        step("Нажимаем на кнопку регистрация", () -> {
            $(".btn-link.h-100.hidden-md.top-register-link").shouldHave(text("Регистрация"));
            $(".btn-link.h-100.hidden-md.top-register-link").click();
        });

        step("Проверяем что страница содержит заголовок Регистрация", () -> {
            $(".vi-checkout-heading-title").shouldHave(text("Регистрация"));
        });

        step("Проверяем наличие текста описания полей");
        step("Проверяем наличие кнопки зарегистрироваться");
    }
}
