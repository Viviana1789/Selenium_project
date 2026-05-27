package SeleniumClass;

import org.junit.Assert;
import org.junit.Test;

import SeleniumClass.Pages.BaseTest;
import SeleniumClass.Pages.HomePage;
import SeleniumClass.Pages.LoginPage;

public class TestLogin extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void LogInSucessful() throws InterruptedException{

        loginPage =new LoginPage(driver);      
        loginPage.logIn("admin","123456");

        Assert.assertTrue(loginPage.msgLoginSuccess.isDisplayed());
        String loginSucess = loginPage.msgLoginSuccess.getText();
        Assert.assertTrue(loginSucess.contains("Login realizado! Redirecionando..."));

        Thread.sleep(3000);

        homePage =new HomePage(driver);  
  
        Assert.assertTrue(homePage.homePage.isDisplayed());
        Assert.assertTrue(homePage.titleHome.isDisplayed());
        String titleDashboard = homePage.titleHome.getText();
        Assert.assertTrue(titleDashboard.contains("Dashboard do PetShop"));

    }


    @Test
    public void LogInFailed(){

        loginPage =new LoginPage(driver);      
        loginPage.logIn("admin","aaaa");

        Assert.assertTrue(loginPage.msgLoginFailed.isDisplayed());
        String loginFailed = loginPage.msgLoginFailed.getText();
        Assert.assertTrue(loginFailed.contains("Usuário ou senha inválidos. Use admin / 123456"));

    }
    
}
