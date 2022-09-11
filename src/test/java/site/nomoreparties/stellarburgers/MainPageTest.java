package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private MainPage mainPage;
    private WebDriver driver;

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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
    }

    @Test
    @DisplayName("Breads are displayed")
    public void isBreadsDisplayedTest() {
        mainPage.isBreadsLoaded();
    }

    @Test
    @DisplayName("Sauces are displayed")
    public void isSaucesDisplayedTest() {
        //mainPage.openTab("Соусы");
        mainPage.isSaucesLoaded();
    }

    @Test
    @DisplayName("Fillings are displayed")
    public void isFillingsDisplayedTest() {
        //mainPage.openTab("Начинки");
        mainPage.isFillingsLoaded();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
