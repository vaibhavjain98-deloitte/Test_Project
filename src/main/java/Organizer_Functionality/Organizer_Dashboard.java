// importing all necessary dependencies and packages
package Organizer_Functionality;

import Utilities.ScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utilities.DriverFetch.getDriver;

// Declaring the class Organizer_Functionality.Organizer_Dashboard
public class Organizer_Dashboard {

    WebDriver driver;

    //Constructor for calling web driver
    public Organizer_Dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Testng annotation for finding organizer dashboard
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[2]/a/div/div[2]")
    WebElement organizerDashboard;

    // Testng annotation for finding organizer name
    @FindBy(xpath = "//div[@class = 'welcome']/h3")
    WebElement organizerName;

    // Testng annotation for finding profile Icon
    @FindBy(xpath = "//*[@id=\"dropdown\"]/img")
    WebElement profileIcon;

    //Testng annotation for profile detail
    @FindBy(xpath = "/html/body/nav/div[2]/div/a[1]")
    WebElement profile_Detail_Button;


    //Testng annotation for count number of employees
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div/div[2]/div/div[1]")
    WebElement employees;

    //Testng notation for count number of users
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div/div[4]/div/div[1]")
    WebElement users;

    //Testng annotation for organizer count
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div/div[3]/div/div[1]")
    WebElement organizers;

    //Testng annotation for admin count
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/div/div/div[1]")
    WebElement admin;


    //To check whether organizer dashboard is clickable or not.
    public boolean isOrganizerDashboardClickable(){
        try {
            organizerDashboard.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }



    //To check whether name of organizer is correct or not
    public boolean isNameOfOrganizerIsCorrect(){
        try {
            String textHeader = organizerName.getText();
            String[] textHeaderDivision = textHeader.split(", ");
            String organiserName = textHeaderDivision[1];
            if(organiserName.equals("lohithvarma")) {
                ScreenShot.Shot(getDriver());
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether number of interest and employees is equal to user
    public boolean equalUser(){
        try {
            int employeesUser = Integer.parseInt(employees.getText());
            int organizerUser = Integer.parseInt(organizers.getText());
            int totalUser = Integer.parseInt(users.getText());
            int adminUser = Integer.parseInt(admin.getText());
            if(employeesUser + organizerUser + adminUser == totalUser) {
                ScreenShot.Shot(getDriver());
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether the profile icon is clickable or not
    public boolean profileIconClickable(){
        try {
            profileIcon.click();
            Thread.sleep(2000);
            ScreenShot.Shot(getDriver());
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether the profile detail button is clickable
    public boolean profileDetailButton(){
        try {
            profile_Detail_Button.click();
            Thread.sleep(2000);
            ScreenShot.Shot(getDriver());
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether the profile details are same for the login organizer
    public boolean profileDetail(){
        try {
            String username = driver.findElement(By.xpath("//*[@id=\"tbox\"]/tbody/tr[1]/td[2]")).getText();
            if(username.equals("lohithvarma")){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

}
