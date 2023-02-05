import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.OrderPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ClickOnLogoInHeaderOpenCorrectPageTest extends BaseTest{

    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private HomePage homePage;

    @BeforeEach
    public void openHomePage() {
        homePage = open(BASE_URL, HomePage.class);
    }
    @Test
    public void clickOnLogoScooterInHeaderFromOrderPageTest() {
        homePage.clickToOrderInHeaderButton();
        OrderPage orderPage = new OrderPage();
        orderPage.clickOnLogoScooterInHeader();
        Assertions.assertEquals(BASE_URL, url());
    }

    @Test
    public void clickOnLogoYandexInHeaderFromHomePageTest() {
        homePage.clickOnLogoYandexInHeader();
        switchTo().window(1);
        Assertions.assertTrue(url().startsWith("https://dzen.ru/") ||
                url().startsWith("https://yandex.ru"));
    }

}
