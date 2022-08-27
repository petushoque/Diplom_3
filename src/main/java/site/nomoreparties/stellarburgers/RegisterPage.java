package site.nomoreparties.stellarburgers;

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

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private WebElement invalidPasswordErrorMessage;

    public void inputName(String name) {
        nameField.sendKeys(name);
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void register(User user) {
        inputName(user.getUsername());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        registerButton.click();
    }

    public boolean isErrorMessageVisible() {
        return invalidPasswordErrorMessage.isDisplayed();
    }
}
