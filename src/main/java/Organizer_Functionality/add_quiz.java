// importing all necessary dependencies and packages
package Organizer_Functionality;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


// Declaring the class Organizer_Functionality.add_quiz
public class add_quiz {

    WebDriver driver;

    //Constructor for calling web driver
    public add_quiz(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Xpath of add Quiz Button
    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[3]/div/a[1]")
    WebElement addQuizButton;


    //Xpath of name input
    @FindBy(xpath = "//*[@id=\"id_name\"]")
    WebElement name;

    //Xpath of select type of interest
    @FindBy(xpath = "//*[@id=\"id_interest\"]")
    WebElement typeOfInterest;

    //Xpath of save button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/form/div/button")
    WebElement saveButton;


    //Xpath of add question Button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/div/div[3]/a")
    WebElement addQuestionButton;

    //Xpath of cancel button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/form/div/a")
    WebElement cancelButton;

    //Xpath of add question input
    @FindBy(xpath = "//*[@id=\"id_text\"]")
    WebElement addQuestionInput;

    //Xpath of save option button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/form/div[3]/button")
    WebElement saveOptionButton;

    //Xpath of tick option
    @FindBy(xpath = "//*[@id=\"id_answers-1-is_correct\"]")
    WebElement tickOption;

    //Xpath of second input field of options
    @FindBy(xpath = "//*[@id=\"id_answers-1-text\"]")
    WebElement secondInputField;

    //Xpath of first input field of options
    @FindBy(xpath = "//*[@id=\"id_answers-0-text\"]")
    WebElement firstInputField;

    //Xpath of delete button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/form/div/a[2]")
    WebElement deleteButton;

    //Xpath of yes i'm sure button
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/div/form/button")
    WebElement yesIAmSure;

    //Xpath of never mind
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div[2]/div/form/a")
    WebElement neverMind;

    // To check whether Add button is clickable
    public boolean isAddQuizButtonClickable(){
        try {
            addQuizButton.click();
            Thread.sleep(2000);
            Assert.assertTrue(isCancelButtonClickable(),"Cancel Button is not Clickable");
            Thread.sleep(2000);
            Assert.assertTrue(isQuizAddedWithoutEnteringTheDetails(),"Quiz has not been created.");
            Thread.sleep(2000);
            Assert.assertTrue(isQuizAddedWithoutEnteringTheDropdown(),"Quiz has not been created.");
            Thread.sleep(2000);
            Assert.assertTrue(isQuizAddedWithEnteringAllTheDetails(),"Quiz has not been created.");
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether is Quiz Added Without Entering the Details
    public boolean isQuizAddedWithoutEnteringTheDetails(){
        try {
            saveButton.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether is Quiz Added Without Entering the Dropdown
    public boolean isQuizAddedWithoutEnteringTheDropdown(){
        try {
            name.click();
            Thread.sleep(2000);
            name.sendKeys("Football");
            Thread.sleep(2000);
            saveButton.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether is Quiz Added With entering all the details
    public boolean isQuizAddedWithEnteringAllTheDetails(){
        try {
            Actions actions = new Actions(driver);
            actions.click(typeOfInterest).perform();
            Thread.sleep(2000);
            actions.sendKeys(typeOfInterest, Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);
            actions.click(saveButton).perform();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether add question button is clickable
    public boolean isAddQuestionButtonClickable(){
        try {
            addQuestionButton.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether cancel button is clickable
    public boolean isCancelButtonClickable(){
        try {
            cancelButton.click();
            Thread.sleep(2000);
            Manage_quiz mangeQuizPage = new Manage_quiz(driver);
            mangeQuizPage.isManageQuizButtonCLicked();
            addQuizButton.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether add question is working
    public boolean isAddQuestionWorking(){
        try {
            addQuestionInput.click();
            Thread.sleep(2000);
            addQuestionInput.sendKeys("Who is Famous FootBall Player?");
            Thread.sleep(2000);
            saveButton.click();
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To verify that without entering any option and without mark the correct option is the options are saved.
    public boolean isOptionSaveWithoutEnteringOptions(){
        try {
            saveOptionButton.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To verify that without entering any option and mark the correct option is the options are saved.
    public boolean isOptionSaveWithMarkOptions(){
        try {
            tickOption.click();
            Thread.sleep(2000);
            saveOptionButton.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To verify that mark options without entering the first field
    public boolean isOptionSaveWithoutEnterFirstField(){
        try {
            secondInputField.click();
            Thread.sleep(2000);
            secondInputField.sendKeys("Ronaldo");
            Thread.sleep(2000);
            tickOption.click();
            Thread.sleep(2000);
            saveOptionButton.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To verify that mark options with entering in proper format
    public boolean isOptionSaveInProperFormat(){
        try {
            firstInputField.click();
            Thread.sleep(2000);
            firstInputField.sendKeys("Messi");
            Thread.sleep(2000);
            tickOption.click();
            Thread.sleep(2000);
            saveOptionButton.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether delete button is working
    public boolean isDeleteButtonClickable(){
        try {
            deleteButton.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether never mind button clickable
    public boolean isNeverMindButtonClickable(){
        try {
            neverMind.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }

    //To check whether I am sure button clickable
    public boolean isIAmSureButtonClickable(){
        try {
            isDeleteButtonClickable();
            Thread.sleep(2000);
            yesIAmSure.click();
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            e.fillInStackTrace();
            return false;
        }
    }


}
