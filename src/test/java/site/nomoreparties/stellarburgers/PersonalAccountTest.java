package site.nomoreparties.stellarburgers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PersonalAccountTest {

    private PersonalAccountPage personalAccountPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private WebDriver driver;
    private User user;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
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
        mainPage.clickOnPersonalAccountLink();
        Assert.assertTrue(personalAccountPage.isPageLoaded());
        System.out.println("The personal account page has opened");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
