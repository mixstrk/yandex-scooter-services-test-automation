package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    // Accordion buttons "Questions about important"
    private final ElementsCollection ACCORDION_BUTTONS = $$(byClassName("accordion__button"));
    // Accordion answers to questions
    private final ElementsCollection ACCORDION_ANSWERS = $$(byClassName("accordion__panel"));
     //To order button from top right (header)
    private final SelenideElement ORDER_HEADER_BUTTON =
            $x("//button[@class='Button_Button__ra12g']");
    // To order button from down center after subheader "How does this work"
    private final SelenideElement ORDER_FINISH_BUTTON = $x(
            "//div[@class='Home_FinishButton__1_cWm']/button");
    private final SelenideElement LOGO_IN_HEADER_YANDEX = $x("//img[@alt='Yandex']");
    private final SelenideElement ORDER_STATUS_BUTTON = $(byClassName("Header_Link__1TAG7"));
    private final SelenideElement ENTER_ORDER_NUMBER_INPUT = $(byClassName("Header_Input__xIoUq"));
    private final SelenideElement GO_BUTTON = $x("//button[text()='Go!']");

    public void clickAccordionButton(int index) {
        ACCORDION_BUTTONS.get(index).scrollTo().click();
    }

    public SelenideElement getAccordionAnswer(int index) {
        return ACCORDION_ANSWERS.get(index);
    }

    public void clickToOrderInHeaderButton() {
        ORDER_HEADER_BUTTON.click();
    }

    public void clickSecondToOrderButton() {
        ORDER_FINISH_BUTTON.scrollTo().click();
    }

    public void clickOnLogoYandexInHeader() {
        LOGO_IN_HEADER_YANDEX.scrollTo().click();
    }

    public void enterOrderNumberAndSearch(String orderNumber) {
        ORDER_STATUS_BUTTON.click();
        ENTER_ORDER_NUMBER_INPUT.setValue(orderNumber);
        GO_BUTTON.click();
    }
}
