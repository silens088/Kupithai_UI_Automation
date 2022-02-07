package autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public final String MAIN_PAGE_URL = "https://kupithai.ru/";

    public String mainTitle = "Тайская косметика купить в интернет магазине в Москве | Товары из Тайланда";

    public void openMainPage() {
        open(MAIN_PAGE_URL);
    }
}
