package autotests.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    //вынести в овнера
    public static final String MAIN_PAGE_URL = "https://kupithai.ru/";

    public String mainTitle = "Тайская косметика купить в интернет магазине в Москве | Товары из Тайланда";
    public String badTextMainPage = "Тайская косметика и товары Тайланда";
    public String trueTextMainPage = "Тайская косметика и товары из Тайланда";

    public String oplataDostavka = "Оплата и доставка";
    public String garantii = "Гарантии";
    public String oformZakaz = "Как оформить заказ";
    public String podarki = "Подарки";
    public String tovarDay = "Товар дня";

    public static void openPage() {
        open(MAIN_PAGE_URL);
    }

    public MainPage checkBadTextForMainPage() {
        $("#common-home").$(".us-main-shop-title").shouldHave(text(badTextMainPage));
        return this;
    }

    public MainPage checkTrueTextForMainPage() {
        $("#common-home").$(".us-main-shop-title").shouldHave(text(trueTextMainPage));
        return this;
    }

    public MainPage checkVisibleMainForm() {
        $("#common-home").shouldBe(visible);
        return this;
    }
}
