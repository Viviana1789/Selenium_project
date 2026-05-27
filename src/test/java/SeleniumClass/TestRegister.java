package SeleniumClass;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import SeleniumClass.Pages.BaseTest;
import SeleniumClass.Pages.HomePage;
import SeleniumClass.Pages.LoginPage;
import SeleniumClass.Pages.RegisterPage;

public class TestRegister extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private RegisterPage registerPage;

    @Test
    public void addRegister() throws InterruptedException{

        loginPage =new LoginPage(driver);      
        loginPage.logIn("admin","123456");

        Thread.sleep(3000);

        homePage =new HomePage(driver);  
        homePage.openRegistrer();

        Thread.sleep(3000);

        registerPage =new RegisterPage(driver);  

        Assert.assertTrue(registerPage.registerHomePage.isDisplayed());
        Assert.assertTrue(registerPage.titleRegister.isDisplayed());
        String titleLogin = registerPage.titleRegister.getText();
        Assert.assertTrue(titleLogin.contains("Cadastro de Pets"));

            
        registerPage.fillRegister("Blanquita",
                                  "BiBiana",
                                  "6 años",                                  
                                  "Sin alergias, tranquila",
                                  "Gato", 
                                  Boolean.TRUE);


        registerPage.uploadFile("C:\\Users\\User\\Downloads\\FIRMA.jpg");

        Assert.assertEquals(registerPage.photoPet.getAttribute("value"), "C:\\fakepath\\FIRMA.jpg");

        registerPage.saveRegistrer();

        List<WebElement> cells = registerPage.getLastRowCellsPets();

        Assert.assertTrue (cells.get(0).getText().equals("Blanquita") && cells.get(1).getText().equals("BiBiana") 
                           && cells.get(2).getText().equals("Gato") && cells.get(3).getText().equals("6 años") 
                           && cells.get(4).getText().equals("Sim"));

    }
}
