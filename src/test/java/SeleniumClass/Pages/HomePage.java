package SeleniumClass.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    
    public WebDriver driver;

    @FindBy(id = "home-page")
    public WebElement homePage;

    @FindBy(xpath = "//h2[@class='title'][contains(text(),'Dashboard do PetShop')]")
    public WebElement titleHome;   
   
    @FindBy(id = "logout-button")
    public WebElement buttonLogOut;

    @FindBy(id = "promotion-button")
    public WebElement buttonPromotion;

    @FindBy(id = "open-register-page")
    public WebElement buttonOpenRegister;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logOut(){
        
         buttonLogOut.click();
    }

    public void viewPromotion(){
        
         buttonPromotion.click();
    }

    public void openRegistrer(){
        
         buttonOpenRegister.click();
    }

}
