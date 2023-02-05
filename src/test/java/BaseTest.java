import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class BaseTest {

    @BeforeEach
    public void setUp() {
        //Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void tearDown() {
        //Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

}
