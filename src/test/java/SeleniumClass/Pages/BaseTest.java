package SeleniumClass.Pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class BaseTest {
    private final String URL = "file:///C:/Users/User/Downloads/desafio_final_selenium_java.html";
    protected WebDriver driver;
    private LoginPage loginPage;

    @Before
    public final void start(){
        driver = new ChromeDriver();
        driver.get(URL);

        loginPage =new LoginPage(driver);          
        Assert.assertTrue(loginPage.loginHomePage.isDisplayed());
    }

    @After
    public void close() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

}
