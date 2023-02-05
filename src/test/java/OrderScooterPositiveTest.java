import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.OrderPage;

import static com.codeborne.selenide.Selenide.open;

public class OrderScooterPositiveTest extends BaseTest{
    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private HomePage homePage;
    private OrderPage orderPage;

    @BeforeEach
    public void openWebSite() {
        homePage = open(BASE_URL, HomePage.class);
        orderPage = new OrderPage();
    }

    /**
     * chrome has a mistake. "yes" button can't be clicked. If you want to check in another browser,
     *  for example Edge, open BaseTest class and delete "//" before "Configuration.browser = "edge";"
     */
    @Test
    public void orderScooterWithFirstButtonTest() {
        homePage.clickToOrderInHeaderButton();
        //Enter name, surname, address, subway station, phone number
        //date, amount rent days, color with lower case, comment
        orderPage.orderAScooter("Олеся", "Иванова",
                "улица Ленина 17", "Черкизовская", "+79001234567", "03.02.2023",
                1, "black", "entrance 6");

        Assertions.assertTrue(orderPage.getOrderSuccess().getText().startsWith("Заказ оформлен"));
    }

    @Test
    public void orderScooterWithSecondButtonTest() {
        homePage.clickSecondToOrderButton();
        //Enter name, surname, address, subway station, phone number, date,
        // amount rent days, color with lower case, comment
        orderPage.orderAScooter("Игорь", "Дураков",
                "улица Мира 22", "Лубянка", "+79001234567", "05.02.2023",
                7, "grey", "entrance 1");
        Assertions.assertTrue(orderPage.getOrderSuccess().getText().startsWith("Заказ оформлен"));
    }


}
