package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement title;

    @FindBy(how = How.NAME, using = "name")
    private WebElement emailField;

    @FindBy(how = How.NAME, using = "Пароль")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private WebElement loginButton;

    @Step("Input email")
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step("Input password")
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Login")
    public void login(User user) {
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        loginButton.click();
    }

    @Step("Page is loaded")
    public boolean isPageLoaded() {
        return title.isDisplayed();
    }
}