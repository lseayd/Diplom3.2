import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SwitchTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private final String email = "qwerty@gmail.com";
    private final String password = "Qwerty123!";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }
    @DisplayName("Клик по кнопке Конструктор находясь в Личном кабинете")
    @Test
    public void clickOnConstructorFromAccount() {
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickConstructorButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }
    @DisplayName("Клик по кнопке логотип находясь в Личном кабинете")
    @Test
    public void clickOnLogoFromAccount() {
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickLogo();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = homePage.getTextHeaderConstructor();
        assertEquals("Соберите бургер", result);
    }
    @DisplayName("Выход из аккаунта")
    @Test
    public void exitFromAccount() {
        homePage.openHomePage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        loginPage.fillingEmailPassword(email, password);
        loginPage.clickSignInButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage.clickButtonAccount();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        accountPage.clickExitButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String result = loginPage.getTextSignInButton();
        assertEquals("Войти", result);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
