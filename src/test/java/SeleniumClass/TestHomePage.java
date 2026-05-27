package SeleniumClass;

import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import SeleniumClass.Pages.BaseTest;
import SeleniumClass.Pages.HomePage;
import SeleniumClass.Pages.LoginPage;

public class TestHomePage extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    
    @Test
    public void LogOutSucessful() throws InterruptedException{

        loginPage =new LoginPage(driver);      
        loginPage.logIn("admin","123456");

        Thread.sleep(3000);

        homePage =new HomePage(driver);  
        homePage.logOut();
  
        Assert.assertTrue(loginPage.loginHomePage.isDisplayed());
        Assert.assertTrue(loginPage.titleLogin.isDisplayed());
        String titleLogin = loginPage.titleLogin.getText();
        Assert.assertTrue(titleLogin.contains("Acesso ao Sistema"));

    }

    @Test
    public void validateViewPromotion() throws InterruptedException{

        loginPage =new LoginPage(driver);      
        loginPage.logIn("admin","123456");

        Thread.sleep(3000);

        homePage =new HomePage(driver);  
        homePage.viewPromotion();

        Alert alert= driver.switchTo().alert();
        String promotion = alert.getText();

        Assert.assertTrue(promotion.contains("Promoção liberada: 20% OFF em banho completo!"));

    }
}
