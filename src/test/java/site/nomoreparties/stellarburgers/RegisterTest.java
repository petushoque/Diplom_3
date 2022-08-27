package site.nomoreparties.stellarburgers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class RegisterTest {

    private RegisterPage registerPage;
    private User user;
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("registerpage"));
    }

    @Test
    public void registerTest() {
        user = new User();
        user.setRandom();
        System.out.println(user.getUsername());
        registerPage.register(user);
        System.out.println("The user is successfully logged in");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
