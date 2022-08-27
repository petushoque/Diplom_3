package site.nomoreparties.stellarburgers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private WebDriver driver;
    private User user;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        user = new User();
        user.setEmail("howdoyoudo@email.com");
        user.setPassword("qwerty12");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginViaLoginButtonOnMainPageTest() {
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage.clickOnLoginButton();
        loginPage.login(user);
        Assert.assertTrue(mainPage.isLoggedIn());
        System.out.println("The user is successfully logged in");
    }

    @Test
    public void loginViaPersonalAccountTest() {
        driver.get(ConfProperties.getProperty("accountpage"));
        loginPage.login(user);
        Assert.assertTrue(mainPage.isLoggedIn());
        System.out.println("The user is successfully logged in");
    }

    @Test
    public void loginViaRegistrationPageTest() {
        driver.get(ConfProperties.getProperty("registerpage"));
        registerPage.clickOnLoginLink();
        loginPage.login(user);
        Assert.assertTrue(mainPage.isLoggedIn());
        System.out.println("The user is successfully logged in");
    }

    @Test
    public void loginViaForgotPasswordPageTest() {
        driver.get(ConfProperties.getProperty("forgotpasswordpage"));
        forgotPasswordPage.clickOnLoginLink();
        loginPage.login(user);
        Assert.assertTrue(mainPage.isLoggedIn());
        System.out.println("The user is successfully logged in");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}