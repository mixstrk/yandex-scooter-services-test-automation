import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.HomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class CorrectAnswersToQuestionsWhenClickAccordionButtonsTest extends BaseTest {

    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private HomePage homePage;

    @BeforeEach
    public void openWebSite() {
        homePage = open(BASE_URL, HomePage.class);
    }
    @Test
    public void checkCorrectAnswerWhenClickOnFirstAccordionButton() {

        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        homePage.clickAccordionButton(0);
        homePage.getAccordionAnswer(0).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnSecondAccordionButton() {

        String expectedAnswer = "Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, " +
                "можете просто сделать несколько заказов — один за другим.";
        homePage.clickAccordionButton(1);
        homePage.getAccordionAnswer(1).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnThirdAccordionButton() {

        String expectedAnswer = "Допустим, вы оформляете заказ на 8 мая. " +
                "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды " +
                "начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли " +
                "самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        homePage.clickAccordionButton(2);
        homePage.getAccordionAnswer(2).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnFourthAccordionButton() {

        String expectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        homePage.clickAccordionButton(3);
        homePage.getAccordionAnswer(3).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnFifthAccordionButton() {

        String expectedAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                "в поддержку по красивому номеру 1010.";
        homePage.clickAccordionButton(4);
        homePage.getAccordionAnswer(4).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnSixthAccordionButton() {

        String expectedAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на " +
                "восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        homePage.clickAccordionButton(5);
        homePage.getAccordionAnswer(5).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnSeventhAccordionButton() {

        String expectedAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
                "записки тоже не попросим. Все же свои.";
        homePage.clickAccordionButton(6);
        homePage.getAccordionAnswer(6).shouldHave(exactText(expectedAnswer));
    }

    @Test
    public void checkCorrectAnswerWhenClickOnEighthAccordionButton() {

        String expectedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        homePage.clickAccordionButton(7);
        homePage.getAccordionAnswer(7).shouldHave(exactText(expectedAnswer));
    }
}
