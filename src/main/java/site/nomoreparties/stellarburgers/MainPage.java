package site.nomoreparties.stellarburgers;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//@Data
public class MainPage {

    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[text() = 'Войти в аккаунт']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Оформить заказ']")
    private WebElement orderButton;

    @FindBy(how = How.XPATH, using = "//p[text() = 'Личный Кабинет']")
    private WebElement personalAccountLink;

    public boolean isLoggedIn() {
        return orderButton.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnPersonalAccountLink() {
        personalAccountLink.click();
    }
}