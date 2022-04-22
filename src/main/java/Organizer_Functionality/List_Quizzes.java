// importing all necessary dependencies and packages
package Organizer_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Declaring the class Organizer_Functionality.List_Quizzes
public class List_Quizzes {

    WebDriver driver;

    //Constructor for calling web driver
    public List_Quizzes(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Xpath of List Quizzes Button
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[3]/div/a[2]")
    WebElement listQuizzes;

    //Xpath of Quiz Name Link
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/table/tbody/tr[2]/td[1]/a")
    WebElement quizNameLink;

    //Xpath of View Result Button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/table/tbody/tr[1]/td[5]/a")
    WebElement viewResultButton;

    //To check List Quiz Button is clickable
    public boolean isListQuizButtonClickable(){
        try {
            Manage_quiz manageQuiz = new Manage_quiz(driver);
            manageQuiz.isManageQuizButtonCLicked();
            listQuizzes.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check Quiz Name is clickable or not for update
    public boolean isQuizNameClickable(){
        try {
            quizNameLink.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check View Result Button is working or not
    public boolean isViewResultButtonClickable(){
        try {
            viewResultButton.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }
}
