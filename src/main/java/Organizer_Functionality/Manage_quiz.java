// importing all necessary dependencies and packages
package Organizer_Functionality;

import Utilities.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Utilities.DriverFetch.getDriver;

// Declaring the class Organizer_Functionality.Manage_quiz
public class Manage_quiz {

    WebDriver driver;

    //Constructor for calling web driver
    public Manage_quiz(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Testng annotation FindBy used to finding the xpath

    //Xpath of Manage Quiz Button
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[3]/a")
    WebElement manageQuizButton;

    //Xpath of add Quiz Button
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[3]/div/a[1]/div/div[2]")
    WebElement addQuiz;

    //Xpath of list quizzes button
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[3]/div/a[2]/div/div[2]")
    WebElement listQuizzes;

    // Making string as global variable for validation
    String checkAddQuizText = "Add Quiz";
    String checkListQuizzesText = "List Quizzes";

    // To check whether the Manage Quiz Button is clickable or not.
    public boolean isManageQuizButtonCLicked(){
        try{
           manageQuizButton.click();
           Thread.sleep(2000);
           boolean isPresentAddQuizText = checkAddQuizOption();
           boolean isPresentListQuizzesText = checkListQuizzesOption();
           if(isPresentAddQuizText && isPresentListQuizzesText){
               System.out.println(checkAddQuizText+" button "+" and "+ checkListQuizzesText+" button are Present. So Manage Quiz button is working.");
           }
            ScreenShot.Shot(getDriver());
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    // To check whether Add Quiz Option is present or not.
    public boolean checkAddQuizOption(){
        try {
            String addQuizText = addQuiz.getText();
            Assert.assertEquals(addQuizText, checkAddQuizText,"Add Quiz Text does not match.");
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    // To check whether list Quiz option is present or not.
    public boolean checkListQuizzesOption(){
        try {
            String listQuizzesText = listQuizzes.getText();
            Assert.assertEquals(listQuizzesText,checkListQuizzesText,"List Quizzes Text does not match.");
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

}
