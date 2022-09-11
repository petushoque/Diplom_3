package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public WebDriver driver;
    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//p[text() = 'Личный Кабинет']")
    private WebElement personalAccountLink;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private WebElement constructorLink;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private WebElement stellarsBurgersLogo;

    @Step("Click on constructor link")
    public void clickOnConstructorLink() {
        constructorLink.click();
    }

    @Step("Click on personal account link")
    public void clickOnPersonalAccountLink() {
        personalAccountLink.click();
    }

    @Step("Click on logo")
    public void clickOnStellarsBurgersLogo() {
        stellarsBurgersLogo.click();
    }
}
