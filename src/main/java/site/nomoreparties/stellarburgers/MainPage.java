package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(how = How.XPATH, using = "//*[text() = 'Войти в аккаунт']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Оформить заказ']")
    private WebElement orderButton;

    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__1N8v2")
    private WebElement constructorSection;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Булки']")
    private WebElement breadsTab;

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Булки']")
    private WebElement breadsTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__Xu3Mo')]/ul[1]")
    private WebElement breadsSection;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Соусы']")
    private WebElement saucesTab;

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Соусы']")
    private WebElement saucesTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__Xu3Mo')]/ul[2]")
    private WebElement saucesSection;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Начинки']")
    private WebElement fillingsTab;

    @FindBy(how = How.XPATH, using = "//h2[text() = 'Начинки']")
    private WebElement fillingsTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__Xu3Mo')]/ul[3]")
    private WebElement fillingsSection;

    @Step("Breads is loaded")
    public boolean isBreadsLoaded() {
        new Actions(driver)
                .scrollToElement(breadsTitle)
                .perform();
        return this.breadsSection.isDisplayed();
    }

    @Step("Sauces is loaded")
    public boolean isSaucesLoaded() {
        new Actions(driver)
                .scrollToElement(saucesTitle)
                .perform();
        return this.saucesSection.isDisplayed();
    }

    @Step("Fillings is loaded")
    public boolean isFillingsLoaded() {
        new Actions(driver)
                .scrollToElement(fillingsSection)
                .perform();
        return this.fillingsSection.isDisplayed();
    }

    @Step("User is logged in")
    public boolean isLoggedIn() {
        return orderButton.isDisplayed();
    }

    @Step("Constructor is loaded")
    public boolean isConstructorLoaded() {
        return constructorSection.isDisplayed();
    }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Step("Open tab")
    public void openTab(String tab) {
        if (tab.contains("Булки")) {
            breadsTab.click();
        }
        else if (tab.contains("Соусы")) {
            saucesTab.click();
        }
        else if (tab.contains("Начинки")) {
            fillingsTab.click();
        }
    }
}