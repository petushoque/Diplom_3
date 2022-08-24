package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    private WebDriver driver;
    //private MainPage mainPage;

    //@Test
    //public void LoginByLoginButtonOnMainPageTest() {
    //    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    //    mainPage.loginViaLoginButtonOnMainPage();
    //}

    @Test
    public void test() {
        ChromeDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.get("www.google.com");
    }
    //@Test
    //public void enterAccountButtonTest() {

        //mainPage.clickEnterAccountButtonMainPage();
        //assertTrue(loginPage.enterButtonLoginPageIsDisplayed());
        //loginPage.setEmailInputLoginPage("ds@gmail.com");
        //loginPage.setPasswordInputFieldLoginPage("Qwer1234");
        //loginPage.clickEnterButtonLoginPage();
        //assertTrue(mainPage.createOrderButtonMainPageIsDisplayed());
    //}

    @After
    public void tearDown() {
        driver.quit();
    }

}
