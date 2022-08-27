package site.nomoreparties.stellarburgers;

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

    @FindBy(how = How.NAME, using = "name")
    private WebElement emailField;

    @FindBy(how = How.NAME, using = "Пароль")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private WebElement loginButton;


    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        loginButton.click();
    }
}