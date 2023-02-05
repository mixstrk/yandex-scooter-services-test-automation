package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TrackPage {

    private final SelenideElement ORDER_NOT_FOUND_IMG = $x("//img[@alt='Not found']");

    public SelenideElement getOrderNotFound() {
        return ORDER_NOT_FOUND_IMG;
    }

}
