package site.nomoreparties.stellarburgers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__Xu3Mo')]/ul[2]")
    private WebElement saucesSection;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Начинки']")
    private WebElement fillingsTab;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer__Xu3Mo')]/ul[3]")
    private WebElement fillingsSection;

    public boolean isBreadsLoaded() {
        //new Actions(driver)
        //        .scrollToElement(breadsTitle)
        //        .perform();
        return this.breadsSection.isDisplayed();
    }

    public boolean isSaucesLoaded() {
        return this.saucesSection.isDisplayed();
    }

    public boolean isFillingsLoaded() {
        return this.fillingsSection.isDisplayed();
    }

    public boolean isLoggedIn() {
        return orderButton.isDisplayed();
    }

    public boolean isConstructorLoaded() {
        return constructorSection.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

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