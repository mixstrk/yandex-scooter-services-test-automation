import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.OrderPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class OrderScooterNegativeTest extends BaseTest{

    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private HomePage homePage;
    private OrderPage orderPage;

    @BeforeEach
    public void openWebSiteAndOrderPageTest() {
        homePage = open(BASE_URL, HomePage.class);
        homePage.clickToOrderInHeaderButton();
        orderPage = new OrderPage();
    }
    @Test
    public void enterInvalidNameTest() {
        orderPage.fillInUserDataFields("123", "Гладкий", "ул Ленина 20",
                "Красные ворота", "+79001234567");
        orderPage.getErrorMessageName().shouldBe(visible);
        Assertions.assertEquals("Введите корректное имя",
                orderPage.getErrorMessageName().getText());
    }

    @Test
    public void enterInvalidSurnameTest() {
        orderPage.fillInUserDataFields("Иван", "123", "ул Ленина 20",
                "Красные ворота", "+79001234567");
        orderPage.getErrorMessageSurname().shouldBe(visible);
        Assertions.assertEquals("Введите корректную фамилию",
                orderPage.getErrorMessageSurname().getText());
    }

    @Test
    public void enterInvalidAddressTest() {
        orderPage.fillInUserDataFields("Иван", "Гладкий", "333",
                "Красные ворота", "+79001234567");
        orderPage.getErrorMessageAddress().shouldBe(visible);
        Assertions.assertEquals("Введите корректный адрес",
                orderPage.getErrorMessageAddress().getText());
    }

    @Test
    public void enterInvalidPhoneNumberTest() {
        orderPage.fillInUserDataFields("Иван", "Гладкий", "ул Ленина 20",
                "Красные ворота", "Иван");
        orderPage.clickNextButton();
        orderPage.getErrorMessagePhoneNumber().shouldBe(visible);
        Assertions.assertEquals("Введите корректный номер",
                orderPage.getErrorMessagePhoneNumber().getText());
    }

    @Test
    public void allUserFieldsAreEmptyTest() {
        orderPage.clickNextButton();
        orderPage.getErrorMessageName().shouldBe(visible);
        orderPage.getErrorMessageSurname().shouldBe(visible);
        // this field must be required, but actually it works
        orderPage.getErrorMessageAddress().shouldBe(visible);
        orderPage.getErrorMessageSubwayStation().shouldBe(visible);
        orderPage.getErrorMessagePhoneNumber().shouldBe(visible);
    }

    @Test
    public void allUserFieldsInEnglishTest() {
        orderPage.fillInUserDataFieldsForEnglishChars("Max", "Johnson", "Tumanyan st 18",
                "Frunzenskaya", "one two three four");
        orderPage.clickNextButton();
        orderPage.getErrorMessageName().shouldBe(visible);
        orderPage.getErrorMessageSurname().shouldBe(visible);
        orderPage.getErrorMessageAddress().shouldBe(visible);
        orderPage.getErrorMessageSubwayStation().shouldBe(visible);
        orderPage.getErrorMessagePhoneNumber().shouldBe(visible);
    }

    @Test
    public void enterSubwayStationIsNotInTheListAndPressEnterTest() {
        orderPage.enterSubwayStationIsNotInTheList("Зеленая");
        orderPage.getErrorMessageSubwayStation().shouldBe(visible);
    }

    /**
     *  All tests are below not playable with chrome correctly. Chrome has a mistake. "yes" button can't be clicked.
     *  So this test will not work in chrome.
     *  If you want to check in another browser,
     *  for example Edge, open BaseTest class and delete "//" before "Configuration.browser = "edge";"
     *  You can replace "edge" with "firefox" or "ie" or "safari".
     */
    @Test
    public void allUserFieldsOrderIsEmptyTest() {
        orderPage.allUserFieldsPositive();
        orderPage.clickNextButton();
        orderPage.clickToOrderFinalButton();
        Assertions.assertFalse(orderPage.getToOrderFinalYesButton().isDisplayed());
    }

    @Test
    public void onlyFirstOrderDataFieldFillInTest() {
        orderPage.allUserFieldsPositive();
        orderPage.clickNextButton();
        orderPage.setDateWhenBringScooter("20.12.2022");
        orderPage.clickToOrderFinalButton();
        Assertions.assertFalse(orderPage.getToOrderFinalYesButton().isDisplayed());
    }

    @Test
    public void onlySecondOrderDataFieldFillInTest() {
        orderPage.allUserFieldsPositive();
        orderPage.clickNextButton();
        orderPage.clickRentTimeAndClickAmountRentDays(1);
        orderPage.clickToOrderFinalButton();
        Assertions.assertFalse(orderPage.getToOrderFinalYesButton().isDisplayed());
    }

    @Test
    public void checkOrderDataCannotBeEarlierThanCurrentDateTest() {
        orderPage.allUserFieldsPositive();
        orderPage.clickNextButton();
        orderPage.fillInOrderDataFields("31.12.2020", 2, "black", "");
        // if entered date earlier than the current day and test work this is bug.
        Assertions.assertTrue(orderPage.getOrderSuccess().should(appear).isDisplayed());
    }
}
