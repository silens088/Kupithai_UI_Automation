package autotests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public final String REGISTRATION_PAGE_URL = "https://kupithai.ru/signup";
    public String registrationTitle = "Регистрация";

    public void openPage() {
        open(REGISTRATION_PAGE_URL);
    }

    public RegistrationPage checkRegistrationButton() {
        $(".btn-link.h-100.hidden-md.top-register-link").shouldHave(text(registrationTitle));
        return this;
    }

    public RegistrationPage clickRegistrationButton() {
        $(".btn-link.h-100.hidden-md.top-register-link").click();
        return this;
    }

    public RegistrationPage checkRegistrationTitle() {
        $(".vi-checkout-heading-title").shouldHave(text(registrationTitle));
        return this;
    }
}
