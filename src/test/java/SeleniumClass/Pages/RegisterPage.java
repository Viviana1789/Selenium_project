package SeleniumClass.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    public WebDriver driver;

    @FindBy(id = "register-page")
    public WebElement registerHomePage;

    @FindBy(xpath = "//h2[@class='title'][contains(text(),'Cadastro de Pets')]")
    public WebElement titleRegister;      

    @FindBy(id = "pet-name")
    public WebElement namePet;

    @FindBy(id = "pet-owner")
    public WebElement ownerPet;

    @FindBy(id = "pet-species")
    public WebElement speciesPet;

    @FindBy(id = "pet-age")
    public WebElement agePet;

    @FindBy(id = "pet-notes")
    public WebElement notesPet;

    @FindBy(id = "pet-vaccinated")
    public WebElement vaccinatedPed;

    @FindBy(id = "pet-photo")
    public WebElement photoPet;

    @FindBy(id = "save-pet-button")
    public WebElement buttonSave;

    @FindBy(id = "pets-table")
    public WebElement tablePets;


    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillRegister(String name, String owner, String age, String notes, String species, Boolean vaccinated){
        namePet.sendKeys(name);
        ownerPet.sendKeys(owner);
        agePet.sendKeys(age);
        notesPet.sendKeys(notes);

        Select select = new Select(speciesPet);
        select.selectByValue(species);

        if(vaccinated.booleanValue()) 
            vaccinatedPed.click();
    }

    public void uploadFile(String photo){
        
         photoPet.sendKeys(photo);
    }


    public void saveRegistrer(){
        
         buttonSave.click();
    }

    public List<WebElement> getLastRowCellsPets(){
        
       List<WebElement> rows = tablePets.findElements(By.tagName("tr"));
       Integer size= rows.size();
       List<WebElement> cells = rows.get(size-1).findElements(By.tagName("td"));

       return cells;
    }

}