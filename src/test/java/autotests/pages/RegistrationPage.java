package autotests.pages;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public final String REGISTRATION_PAGE_URL = "https://kupithai.ru/signup";

    public void openPage() {
        open(REGISTRATION_PAGE_URL);
    }
}
