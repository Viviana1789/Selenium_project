package SeleniumClass.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(id = "login-page")
    public WebElement loginHomePage;

    @FindBy(xpath = "//h2[@class='title'][contains(text(),'Acesso ao Sistema')]")
    public WebElement titleLogin;  

    @FindBy(id = "login-username")
    public WebElement userLogin;

    @FindBy(id = "login-password")
    public WebElement passLogin;

    @FindBy(id = "login-submit")
    public WebElement buttonLogin;

    @FindBy(id = "login-success")
    public WebElement msgLoginSuccess;

    @FindBy(id = "login-error")
    public WebElement msgLoginFailed;
   


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn(String user, String pass){
        userLogin.sendKeys(user);
        passLogin.sendKeys(pass);
        buttonLogin.click();
    }

}