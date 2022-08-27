package site.nomoreparties.stellarburgers;

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

    public boolean isPageLoaded() {
        return userInfo.isDisplayed();
    }
}
