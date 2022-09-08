package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public WebDriver driver;
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//label[text() = 'Имя']/following-sibling::input")
    private WebElement nameField;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']/following-sibling::input")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']/following-sibling::input")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private WebElement registerButton;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private WebElement loginLink;

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private WebElement invalidPasswordErrorMessage;

    @Step("Input name")
    public void inputName(String name) {
        nameField.sendKeys(name);
    }

    @Step("Input email")
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step("Input password")
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Register")
    public void register(User user) {
        inputName(user.getUsername());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        registerButton.click();
    }

    @Step("Error message is visible")
    public boolean isErrorMessageVisible() {
        return invalidPasswordErrorMessage.isDisplayed();
    }

    @Step("Click on login link")
    public void clickOnLoginLink() {
        loginLink.click();
    }
}
