package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PersonalAccountTest {

    private PersonalAccountPage personalAccountPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private Header header;
    private WebDriver driver;
    private User user;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        // === Replace the first two lines with these for testing in firebox ===
        /*
        System.setProperty("webdriver.firefox.driver", ConfProperties.getProperty("geckodriver"));
        driver = new FirefoxDriver();
        */
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        header = new Header(driver);
        user = new User();
        user.setEmail("howdoyoudo@email.com");
        user.setPassword("qwerty12");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.login(user);
    }

    @Test
    @DisplayName("Open Personal Account from Main Page")
    public void openPersonalAccountFromMainPageTest() {
        header.clickOnPersonalAccountLink();
        Assert.assertTrue(personalAccountPage.isPageLoaded());
        System.out.println("The personal account page has opened");
    }

    @Test
    @DisplayName("Open constructor by click on constructor link")
    public void openConstructorByClickOnConstructorLinkTest() {
        driver.get(ConfProperties.getProperty("accountpage"));
        System.out.println("The personal account page has opened");
        header.clickOnConstructorLink();
        Assert.assertTrue(mainPage.isConstructorLoaded());
        System.out.println("The constructor is displayed on the page");
    }

    @Test
    @DisplayName("Open constructor by click on logo")
    public void openConstructorByClickOnLogoTest() {
        driver.get(ConfProperties.getProperty("accountpage"));
        System.out.println("The personal account page has opened");
        header.clickOnStellarsBurgersLogo();
        Assert.assertTrue(mainPage.isConstructorLoaded());
        System.out.println("The constructor is displayed on the page");
    }

    @Test
    @DisplayName("Logout")
    public void logoutTest() {
        header.clickOnPersonalAccountLink();
        personalAccountPage.logout();
        driver.get(ConfProperties.getProperty("mainpage"));
        Assert.assertTrue(mainPage.isLoggedIn());
        System.out.println("The user is logged out");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
