package site.nomoreparties.stellarburgers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {

    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
    }

    @Test
    public void loginTest() {
        mainPage.loginViaLoginButtonOnMainPage();
        loginPage.login("howdoyoudo@email.com", "qwerty12");
        Assert.assertTrue(mainPage.isLoggedIn());
        System.out.println("The user is successfully logged in");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}