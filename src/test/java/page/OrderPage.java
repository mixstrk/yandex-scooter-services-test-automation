package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class OrderPage {

    private final ElementsCollection INPUT_RESPONSIBLE = $$(byClassName("Input_Responsible__1jDKN"));
    private final SelenideElement INPUT_SUBWAY_ST = $(byClassName("select-search__input"));
    private final SelenideElement NEXT_BUTTON = $(By.className("Button_Middle__1CSJM"));
    private final SelenideElement DATE_WHEN_BRING_SCOOTER_INPUT = $x("//div[@class='react-datepicker__input-container']/input");
    private final SelenideElement RENT_TIME = $(byClassName("Dropdown-root"));
    private final ElementsCollection CHOOSE_AMOUNT_RENT_DAYS = $$(byClassName("Dropdown-option"));
    private final ElementsCollection COLOR_OF_SCOOTER_CHECKBOX = $$(byClassName("Checkbox_Input__14A2w"));
    private final SelenideElement COMMENT = $x("//input[@placeholder='Комментарий для курьера']");
    private final SelenideElement TO_ORDER_FINAL_BUTTON = $x("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final SelenideElement TO_ORDER_FINAL_YES_BUTTON = $x("//button[text()='Да']");
    private final SelenideElement ORDER_SUCCESS = $x("//div[contains(text(), 'Заказ оформлен')]");
    private final SelenideElement LOGO_SCOOTER_IN_HEADER = $x("//img[@alt='Scooter']");
    private final SelenideElement ERROR_MESSAGE_NAME = $x("//div[contains(text(), 'имя')]");
    private final SelenideElement ERROR_MESSAGE_SURNAME = $x("//div[contains(text(), 'фамилию')]");
    private final SelenideElement ERROR_MESSAGE_ADDRESS = $x("//div[contains(text(), 'адрес')]");
    private final SelenideElement ERROR_MESSAGE_SUBWAY_STATION = $x("//div[text()='Выберите станцию']");
    private final SelenideElement ERROR_MESSAGE_PHONE_NUMBER = $x("//div[contains(text(), 'номер')]");
    public void fillInUserDataFields(String name, String surname, String address, String subwaySt, String phoneNumber) {
        INPUT_RESPONSIBLE.get(0).setValue(name);
        INPUT_RESPONSIBLE.get(1).setValue(surname);
        INPUT_RESPONSIBLE.get(2).setValue(address);
        INPUT_SUBWAY_ST.sendKeys(subwaySt, Keys.ARROW_DOWN, Keys.ENTER);
        INPUT_RESPONSIBLE.get(3).sendKeys(phoneNumber);
    }

    public void enterSubwayStationIsNotInTheList(String subwaySt) {

        INPUT_SUBWAY_ST.sendKeys(subwaySt, Keys.ENTER);
    }

    public void fillInUserDataFieldsForEnglishChars(String name, String surname, String address, String subwaySt, String phoneNumber) {
        INPUT_RESPONSIBLE.get(0).setValue(name);
        INPUT_RESPONSIBLE.get(1).setValue(surname);
        INPUT_RESPONSIBLE.get(2).setValue(address);
        INPUT_SUBWAY_ST.setValue(subwaySt);
        INPUT_RESPONSIBLE.get(3).sendKeys(phoneNumber);
    }

    public void allUserFieldsPositive() {
        fillInUserDataFields("Юля", "Филатова", "Московский проспект",
                "Фрунзенская", "+79218339944");
    }

    public void fillInOrderDataFields(String date, int amountRentDays, String color, String comment) {
        DATE_WHEN_BRING_SCOOTER_INPUT.sendKeys(date, Keys.ENTER);
        RENT_TIME.click();
        CHOOSE_AMOUNT_RENT_DAYS.get(amountRentDays-1).click();
        chooseOfColorScooter(color);
        COMMENT.setValue(comment);
        TO_ORDER_FINAL_BUTTON.click();
        TO_ORDER_FINAL_YES_BUTTON.click();
    }

    public void orderAScooter(String name, String surname, String address, String subwaySt, String phoneNumber,
    String date, int amountRentDays, String color, String comment) {
        fillInUserDataFields(name, surname, address, subwaySt, phoneNumber);
        NEXT_BUTTON.click();
        fillInOrderDataFields(date, amountRentDays, color, comment);
    }

    public void chooseOfColorScooter(String color) {
        if(color == "black") {
           COLOR_OF_SCOOTER_CHECKBOX.get(0).click();
        }
        if(color == "grey") {
            COLOR_OF_SCOOTER_CHECKBOX.get(1).click();
        }
    }

    public SelenideElement getOrderSuccess() {
        return ORDER_SUCCESS;
    }

    public void clickOnLogoScooterInHeader() {
        LOGO_SCOOTER_IN_HEADER.click();
    }

    public SelenideElement getErrorMessageName() {
        return ERROR_MESSAGE_NAME;
    }

    public SelenideElement getErrorMessageSurname() {
        return ERROR_MESSAGE_SURNAME;
    }

    public SelenideElement getErrorMessageAddress() {
        return ERROR_MESSAGE_ADDRESS;
    }

    public SelenideElement getErrorMessageSubwayStation() {
        return ERROR_MESSAGE_SUBWAY_STATION;
    }

    public SelenideElement getErrorMessagePhoneNumber() {
        return ERROR_MESSAGE_PHONE_NUMBER;
    }

    public void clickNextButton() {
        NEXT_BUTTON.click();
    }

    public void clickToOrderFinalButton() {
        TO_ORDER_FINAL_BUTTON.click();
    }

    public SelenideElement getToOrderFinalYesButton() {
        return TO_ORDER_FINAL_YES_BUTTON;
    }

    public void setDateWhenBringScooter(String date) {
        DATE_WHEN_BRING_SCOOTER_INPUT.sendKeys(date, Keys.ENTER);
    }

    public void clickRentTimeAndClickAmountRentDays(int amountRentDays) {
        RENT_TIME.click();
        CHOOSE_AMOUNT_RENT_DAYS.get(amountRentDays-1).click();
    }

}
