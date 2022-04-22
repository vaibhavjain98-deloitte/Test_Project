// importing all necessary dependencies and packages
package Test_Package;

import Organizer_Functionality.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static Utilities.DriverFetch.getDriver;
import static Utilities.DriverFetch.setDriver;

// Declaring the class Test_Package.Test
public class Test {

    String fetchUrlOfLoginPage = "https://hashedinfunzone-urtjok3rza-wl.a.run.app/";

    // Testng annotation Before Method  is used to start the driver
    @BeforeMethod
    void driverStart(){
        setDriver();
    }


    // Testng annotation test is used to test all the functionalities in Organizer Login are working fine or not
    @org.testng.annotations.Test

    // Function to test the functionalities in organizer Login
    void organizerLoginTest() throws IOException{
        getDriver().get(fetchUrlOfLoginPage);
        getDriver().manage().window().maximize();
        Organizer_Login OrganizerLoginPage = new Organizer_Login(getDriver());
        Assert.assertTrue(OrganizerLoginPage.login(),"Credentials are incorrect");
        organizerDashboardTest();
    }


    // Function to test the functionalities in organizer dashboard
    void organizerDashboardTest() throws IOException{
        Organizer_Dashboard OrganizerDashboardPage = new Organizer_Dashboard(getDriver());
        Assert.assertTrue(OrganizerDashboardPage.isOrganizerDashboardClickable(),"Organizer Dashboard Button is not clickable.");
        Assert.assertTrue(OrganizerDashboardPage.isNameOfOrganizerIsCorrect(),"Organizer name does not match with the login organizer");
        Assert.assertTrue(OrganizerDashboardPage.equalUser(),"Interest and Employees count is not equal to total users.");
        Assert.assertTrue(OrganizerDashboardPage.profileIconClickable(),"Profile Icon is not clickable.");
        Assert.assertTrue(OrganizerDashboardPage.profileDetailButton(),"Profile detail button is not clickable.");
        Assert.assertTrue(OrganizerDashboardPage.profileDetail(),"Profile details are not same for the login organizer");
        manageOrganizerTest();
    }


    // Function to test the functionalities in manage quiz section
     void manageOrganizerTest() throws IOException{
        Manage_quiz ManageQuizPage = new Manage_quiz(getDriver());
        Assert.assertTrue(ManageQuizPage.isManageQuizButtonCLicked(),"Manage Quiz Button is not clickable.");
         addQuizTest();
    }

    //Function to test the functionalities in add quiz section
    void addQuizTest() throws IOException{
        add_quiz addQuizPage = new add_quiz(getDriver());
        Assert.assertTrue(addQuizPage.isAddQuizButtonClickable(),"Add Quiz Button is Clickable.");
        Assert.assertTrue(addQuizPage.isAddQuestionButtonClickable(),"Add Question button is not clicking.");
        Assert.assertTrue(addQuizPage.isAddQuestionWorking(),"Question field is not working properly.");
        Assert.assertTrue(addQuizPage.isOptionSaveWithoutEnteringOptions(),"Please submit at least 2 forms.");
        Assert.assertTrue(addQuizPage.isOptionSaveWithMarkOptions(), "Please submit at least 2 forms.");
        Assert.assertTrue(addQuizPage.isOptionSaveWithoutEnterFirstField(),"This field is required");
        Assert.assertTrue(addQuizPage.isOptionSaveInProperFormat(),"The field is required.");
        Assert.assertTrue(addQuizPage.isDeleteButtonClickable(),"Delete button is not clickable.");
        Assert.assertTrue(addQuizPage.isNeverMindButtonClickable(),"Never Mind button is not clickable.");
        Assert.assertTrue(addQuizPage.isIAmSureButtonClickable(),"Yes I'm sure button is not clickable. ");
        listQuizzes();
    }

    //Function to test the functionalities of list quizzes
    void listQuizzes() throws IOException{
        List_Quizzes listQuizPage = new List_Quizzes(getDriver());
        Assert.assertTrue(listQuizPage.isListQuizButtonClickable(),"List Quizzes Button is not clickable.");
        Assert.assertTrue(listQuizPage.isQuizNameClickable(),"Quiz Name is not clickable.");
        Assert.assertTrue(listQuizPage.isViewResultButtonClickable(),"View Result is not clickable.");
    }

}
