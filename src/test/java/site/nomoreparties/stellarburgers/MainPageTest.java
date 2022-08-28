package site.nomoreparties.stellarburgers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
    }

    @Test
    public void isBreadsDisplayedTest() {
        mainPage.isBreadsLoaded();
    }

    @Test
    public void isSaucesDisplayedTest() {
        mainPage.openTab("Соусы");
        mainPage.isSaucesLoaded();
    }

    @Test
    public void isFillingsDisplayedTest() {
        mainPage.openTab("Начинки");
        mainPage.isFillingsLoaded();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
