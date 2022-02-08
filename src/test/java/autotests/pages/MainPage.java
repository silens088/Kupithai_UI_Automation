package autotests.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {


    public static final String MAIN_PAGE_URL = "https://kupithai.ru/";

    public String mainTitle = "Тайская косметика купить в интернет магазине в Москве | Товары из Тайланда";

    public static void openMainPage() {
        open(MAIN_PAGE_URL);
    }
}
