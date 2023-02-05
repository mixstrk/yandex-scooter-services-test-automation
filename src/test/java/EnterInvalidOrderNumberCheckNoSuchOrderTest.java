import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.TrackPage;

import static com.codeborne.selenide.Selenide.open;

public class EnterInvalidOrderNumberCheckNoSuchOrderTest extends BaseTest{
    private final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    @Test
    public void enterInvalidOrderNumberCheckNoSuchOrderTest() {
        HomePage homePage = open(BASE_URL, HomePage.class);
        homePage.enterOrderNumberAndSearch("111111");
        TrackPage trackPage = new TrackPage();
        trackPage.getOrderNotFound().shouldBe(Condition.visible);
    }
}
