package step_definitions.school_step_definitions.student_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.school_pages.student_pages.AllStudentsPage;
import pojo.student.Student;
import utilities.APIUtility;
import utilities.DBUtility;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetAllStudentsAndCrossValidateInformationE2EStepDefinitions {

    AllStudentsPage allStudentsPage = new AllStudentsPage();

    List<Map<Object, Object>> dataBase;

    List<WebElement> listOfFirstNameOfStudentsUI;

    List<WebElement> listOfMajorOfStudentsUI;

    List<Map<Object, Object>> emailAddressFromDB;

    List<Map<Object, Object>> companyNameFromDB;


    @Given("user hits and GETs all students from API at {string}")
    public void user_hits_and_GETs_all_students_from_API_at(String resource) {

        APIUtility.hitGET(resource);

    }

    @Given("user gets all students from DB")
    public void user_gets_all_students_from_DB() throws SQLException {

            dataBase = DBUtility.executeQuery("select * from student");

    }

    @When("user stores the list of students from UI")
    public void user_stores_the_list_of_students_from_UI() {


        listOfFirstNameOfStudentsUI  =  allStudentsPage.listOfNamesStudents;

        listOfMajorOfStudentsUI = allStudentsPage.listOfMajorStudents;


    }

    @Then("user cross validates firstNames and Major between UI-DB-API")
    public void user_cross_validates_firstNames_and_Major_between_UI_DB_API() {

        System.out.println("size of API " + APIUtility.getResponseBody().getStudents().size());

        System.out.println("size of DB: " +dataBase.size());

        for (int i = 0; i <APIUtility.getResponseBody().getStudents().size() ; i++) {

                for (int j=0; j< dataBase.size(); j++){
                   // System.out.println("\n order of major from API : " + APIUtility.getResponseBody().getStudents().get(i).getMajor());

                    //System.out.println("\n order of firstName from DB: " + dataBase.get(j).get("FIRST_NAME").toString());

                    if (dataBase.get(j).get("FIRST_NAME").toString()
                            .equals(APIUtility.getResponseBody().getStudents().get(i).getFirstName())
                            && dataBase.get(j).get("FIRST_NAME").toString()
                            .equals(allStudentsPage.listOfNamesStudents.get(i).getText())) {

                       // System.out.println("first name from DB : " + dataBase.get(j).get("FIRST_NAME").toString());

                       // System.out.println("first name from API: "+ APIUtility.getResponseBody().getStudents().get(i).getFirstName());

                        Assert.assertTrue(dataBase.get(j).get("FIRST_NAME").toString()
                                .equals(APIUtility.getResponseBody().getStudents().get(i).getFirstName()));

                        Assert.assertTrue(dataBase.get(j).get("FIRST_NAME").toString().
                                equals(allStudentsPage.listOfNamesStudents.get(i).getText()));

                    }
                }
        }
    }

    @Given("user gets companyName and emailAddress from DB")
    public void user_gets_companyName_and_emailAddress_from_DB() throws SQLException {

        emailAddressFromDB= DBUtility.executeQuery("select contact.email_address from student  inner join  contact on student.student_id=contact.student_id");

        companyNameFromDB= DBUtility.executeQuery("select company.company_name from student inner join company on student.student_id=company.student_id");




    }

    @Then("user cross validates CompanyName and check how many EmailAddress has @ sign")
    public void user_cross_validates_CompanyName_and_check_how_many_EmailAddress_has_sign() {

        int count=0;

        for (int i=0; i< APIUtility.getResponseBody().getStudents().size(); i++){

            for (int j=0; j< emailAddressFromDB.size();j++){

                if (emailAddressFromDB.get(j).get("EMAIL_ADDRESS").toString().contains("@")
                        && APIUtility.getResponseBody().getStudents().get(i).getContact().getEmailAddress().contains("@")) {
                    count++;
                }
            }
        }


        System.out.println(count + " number of email address has @ sign");

        int count2=0;

        for (int i=0; i< APIUtility.getResponseBody().getStudents().size(); i++){

            for (int j=0; j< companyNameFromDB.size();j++){

                if (companyNameFromDB.get(j).get("COMPANY_NAME").toString()
                        .equals(APIUtility.getResponseBody().getStudents().get(i).getCompany().getCompanyName())) {
                    count2++;
                }
            }
        }

        System.out.println(count + " number of email address address compared");
        System.out.println(count2+ " number of company name compared");

    }

    @Then("user cross validates major and first between DB-UI-API")
    public void user_cross_validates_major_and_first_between_DB_UI_API() {


        int numberOfMathMajorFromAPI = 0;
        List<String> nameOfStudentsAPI = new ArrayList<>();
        for (Student students : APIUtility.getResponseBody().getStudents()) {

            if (students.getMajor().equals("Math"))
                numberOfMathMajorFromAPI++;
            nameOfStudentsAPI.add(students.getFirstName());

        }

        List<String> listOFNamesFromDB = new ArrayList<>();
        int numberOfMathMajorFromDB = 0;
        for (int i = 0; i < dataBase.size(); i++) {

            if (dataBase.get(i).get("MAJOR").toString().equals("Math"))
                numberOfMathMajorFromDB++;
            listOFNamesFromDB.add(dataBase.get(i).get("FIRST_NAME").toString());

        }

        int numberOfMathMajorFromUI = 0;
        List<String> listNamesFromUI = new ArrayList<>();
        for (int i = 0; i < allStudentsPage.listOfMajorStudents.size(); i++) {

            if (allStudentsPage.listOfMajorStudents.get(i).getText().equals("Math"))
                numberOfMathMajorFromUI++;
            listNamesFromUI.add(allStudentsPage.listOfNamesStudents.get(i).getText());

        }

        System.out.println("List of names from UI:  "+ listNamesFromUI   +
                "   and number of math major is: " + numberOfMathMajorFromUI);

        System.out.println("List of names from DB:  "+ listOFNamesFromDB +
                "   and number of math major is: " + numberOfMathMajorFromDB);

        System.out.println("List of names from API: "+ nameOfStudentsAPI +
                "   and number of math major is: " + numberOfMathMajorFromAPI);

        Assert.assertTrue(numberOfMathMajorFromAPI==numberOfMathMajorFromDB);





    }




















//    @Test
//
//    public void test22345() throws SQLException {
//
//
//        DBUtility.createConnection();
//
//       List<Map<Object, Object>>  data= DBUtility.executeQuery("select contact.email_address from student  inner join  contact on student.student_id=contact.student_id");
//
//        for (int i = 0; i <data.size() ; i++) {
//
//            System.out.println("data from DB: "+  data.get(i).get("EMAIL_ADDRESS"));
//
//
//        }
//
//        APIUtility.hitGET("/student/all");
//
//
//        for (int i = 0; i <APIUtility.getResponseBody().getStudents().size(); i++) {
//
//            System.out.println("data from API: "+  APIUtility.getResponseBody().getStudents().get(i).getContact().getEmailAddress());
//
//
//        }
//
//    }

@Test


    public void test123(){

        APIUtility.hitGET("/student/all");
  //  System.out.println(  APIUtility.getResponseBody().getStudents().get(0));


}



}
