package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalAccountPage {

    public WebDriver driver;
    public PersonalAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.CLASS_NAME, using = "Profile_profile__3dzvr")
    private WebElement userInfo;

    @FindBy(how = How.XPATH, using = "//button[text() = 'Выход']")
    private WebElement logoutButton;

    @Step("Page is loaded")
    public boolean isPageLoaded() {
        return userInfo.isDisplayed();
    }

    @Step("Logout")
    public void logout() {
        logoutButton.click();
    }
}
