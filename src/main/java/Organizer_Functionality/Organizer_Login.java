// importing all dependencies and packages
package Organizer_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Creating class for organizer login
public class Organizer_Login {

    WebDriver driver;

    //Constructor for calling web driver
    public Organizer_Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Testng annotation for finding web element of email input
    @FindBy(xpath = "/html/body/div/form/input[2]")
    WebElement email;

    // Testng annotation for finding web element of password input
    @FindBy(xpath = "/html/body/div/form/input[3]")
    WebElement password;

    // Testng annotation for finding web element of login button
    @FindBy(xpath = "//*[@id=\"signin\"]")
    WebElement loginButton;


    //Login in Organizer Dashboard
    public boolean login() {
        try {
            Actions actions = new Actions(driver);
            actions.click(email).perform();
            actions.sendKeys(email,"lohithvarma").perform();
            actions.pause(2000).perform();
            actions.click(password).perform();
            actions.sendKeys(password,"12345@django").perform();
            actions.pause(2000).perform();
            actions.click(loginButton).perform();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

}
