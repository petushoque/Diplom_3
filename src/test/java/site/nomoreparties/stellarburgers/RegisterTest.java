package site.nomoreparties.stellarburgers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class RegisterTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private User user;
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("registerpage"));
    }

    @Test
    public void correctDataRegisterTest() {
        user = new User();
        user.setRandom(true);
        registerPage.register(user);
        Assert.assertTrue(loginPage.isPageLoaded());
        System.out.println("New user has been successfully registered");
    }

    @Test
    public void invalidPasswordRegisterTest() {
        user = new User();
        user.setRandom(false);
        registerPage.register(user);
        Assert.assertTrue(registerPage.isErrorMessageVisible());
        System.out.println("Registration failed. An error message is displayed");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
