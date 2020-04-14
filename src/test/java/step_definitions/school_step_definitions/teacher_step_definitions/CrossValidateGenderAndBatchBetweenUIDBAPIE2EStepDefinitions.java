package step_definitions.school_step_definitions.teacher_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.school_pages.teacher_pages.AllTeachersPage;
import pojo.teacher.Teacher;
import utilities.APIUtility;
import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CrossValidateGenderAndBatchBetweenUIDBAPIE2EStepDefinitions {

AllTeachersPage allTeachersPage= new AllTeachersPage();

    List<Map<Object, Object>> dataBase=null;

    List<WebElement> dataUI= null;

    Integer numberOfMaleFromDB =0;

    Integer numberOfBatch10FromDB =0;

    Integer numberOfMaleFromAPI=0;
    Integer numberOfBatch10FromAPI=0;

    Integer numberOfMessiFromUI=0;


    Integer numberOfBatch10FromUI=0;



    @When("user gets all teachers from Data Base")
    public void user_gets_all_teachers_from_Data_Base() throws SQLException {

        dataBase= DBUtility.executeQuery("select batch,gender from teacher");
    }


    @When("user gets the numbers of male and batch {int} teachers from Data Base")
    public void user_gets_the_numbers_of_male_and_batch_teachers_from_Data_Base(Integer batchNumber) {


       // System.out.println(dataBase);


        for (int i = 0; i <dataBase.size() ; i++) {

            if (dataBase.get(i).get("GENDER").toString().equals("Male")){
                numberOfMaleFromDB++;
            }

            if (dataBase.get(i).get("BATCH").toString().equals(String.valueOf(batchNumber))){
                numberOfBatch10FromDB++;
            }
        }

        System.out.println("Number of Male from DB: " + numberOfMaleFromDB);
        System.out.println("number of Batch 10 from DB: " + numberOfBatch10FromDB);

    }

    @Given("user gets all number of male and batch {int} teachers from API")
    public void user_gets_all_number_of_male_and_batch_teachers_from_API(int batchNumber) {

        for (Teacher teachers: APIUtility.getResponseBody().getTeachers()) {


            if (teachers.getGender().trim().equals("Male")){
                numberOfMaleFromAPI++;
            }

            if (teachers.getBatch()==batchNumber){
               // System.out.println("Bathes should be 10 from API"+ teachers.getBatch());
                numberOfBatch10FromAPI++;
            }
        }

        System.out.println("Number of Male from API: " + numberOfMaleFromAPI);
        System.out.println("number of Batch 10 from API: " + numberOfBatch10FromAPI);


    }


    @When("user gets all teachers from UI")
    public void user_gets_all_teachers_from_UI() {

        dataUI=allTeachersPage.listOfTeachers;

    }
    @When("user gets the number of male and batch {int} teachers from UI")
    public void user_gets_the_number_of_male_and_batch_teachers_from_UI(int batchNumber) {

        for (WebElement listOfTeachersFromUI: dataUI) {

            if (listOfTeachersFromUI.getText().equals("Lionel")){
                numberOfMessiFromUI++;
            }
        }
        System.out.println("Number of Messi on UI:  " + numberOfMessiFromUI);

    }

    @Then("user cross validates number of male and batch {int} teachers between UI - DB - API")
    public void user_cross_validates_number_of_male_and_batch_teachers_between_UI_DB_API(int batchNumber) {

        Assert.assertTrue(numberOfBatch10FromAPI.toString().equals(numberOfBatch10FromDB.toString()));

        Assert.assertTrue(numberOfMaleFromAPI.toString().trim().equals(numberOfMaleFromDB.toString().trim()));

        System.out.println("ALL ASSERTIONS PASSED");

    }




}
