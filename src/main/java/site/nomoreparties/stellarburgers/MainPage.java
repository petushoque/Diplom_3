package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //private final By loginToAccountButton = By.className("button_button__33qZ0");

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement loginToAccountButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadMainPage() {
        // ждем 8 секунд, пока появится веб-элемент с нужным текстом
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated((By) loginToAccountButton));
    }

    public void loginViaLoginButtonOnMainPage() {
        this.loginToAccountButton.click();
    }
}
