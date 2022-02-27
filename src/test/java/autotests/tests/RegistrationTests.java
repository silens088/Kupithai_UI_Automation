package autotests.tests;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Microservice;
import autotests.pages.MainPage;
import autotests.pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

@Owner("vvelichko")
@Story("RegistrationTests")
@Tags({@Tag("Web"), @Tag("UI")})
@JiraIssues({@JiraIssue("HOMEWORK-356")})

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("UI")
    @Severity(SeverityLevel.CRITICAL)
    @Microservice("Регистрация пользователя")
    @Feature("Функцонал регистрации")
    @Story("Регистрация пользователя")
    @Description("Проверка формы регистрации")
    @DisplayName("Проверяем поля формы регистрации")
    void checkRegistrationFormFields() {

        step("Открыть главную страницу " + MainPage.MAIN_PAGE_URL, () ->
                registrationPage.openPage());
        step("Проверяем URL " + MainPage.MAIN_PAGE_URL, () ->
                webdriver().shouldHave(url(MainPage.MAIN_PAGE_URL)));

        step("На странице есть кнопка" + registrationPage.registrationTitle, () ->
                registrationPage.checkRegistrationButton());

        step("Нажимаем на кнопку" + registrationPage.registrationTitle, () ->
                registrationPage.clickRegistrationButton());

        step("Проверяем что страница содержит заголовок " + registrationPage.registrationTitle, () ->
                registrationPage.checkRegistrationTitle());
    }
}
