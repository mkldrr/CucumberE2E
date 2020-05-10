package step_definitions.school_step_definitions.teacher_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.school_pages.teacher_pages.AllTeachersPage;
import pojo.RequestBody;
import utilities.APIUtility;
import utilities.SeleniumUtils;

import java.util.HashMap;
import java.util.Map;

public class CreateTeacherOnAPIAndCompareWithUIStepDefinitions {

    AllTeachersPage allTeachersPage= new AllTeachersPage();

    BasePage basePage = new BasePage();

    Map<String, String > mapData = new HashMap<>();

    int teacherIdfromAPI=0;
    @Given("user hits and POST a teacher on API {string}")
    public void user_hits_and_POST_a_teacher_on_API(String resource, io.cucumber.datatable.DataTable dataTable) {

        mapData=dataTable.asMap(String.class,String.class);

        RequestBody requestBody = new RequestBody();

        requestBody.setFirstName(mapData.get("firstName"));
        requestBody.setGender(mapData.get("gender"));
        requestBody.setBatch(Integer.parseInt(mapData.get("batch")));
        requestBody.setBirthDate(mapData.get("birthDate"));
        requestBody.setDepartment(mapData.get("department"));
        requestBody.setJoinDate(mapData.get("joinDate"));
        requestBody.setEmailAddress(mapData.get("emailAddress"));
        requestBody.setLastName(mapData.get("lastName"));
        requestBody.setPassword(mapData.get("password"));
        requestBody.setPhone(mapData.get("phone"));
        requestBody.setPremanentAddress(mapData.get("premanentAddress"));
        requestBody.setSalary(Integer.parseInt(mapData.get("salary")));
        requestBody.setSection(mapData.get("section"));
        requestBody.setSubject(mapData.get("subject"));


        APIUtility.hitPOST(resource, requestBody);






    }

    @When("user search teacher by {int}")
    public void user_search_teacher_by(Integer teacherId) {

        teacherIdfromAPI = APIUtility.getResponseBody().getTeacherId();
        teacherId = teacherIdfromAPI;
        System.out.println("teacher id which is sent to UI after we reassign with API : "+ teacherId);
        System.out.println("teacher ID from APi:  "+teacherIdfromAPI);
        SeleniumUtils.waitFor(2);
        allTeachersPage.teacherModule.click();
        SeleniumUtils.waitFor(2);
        allTeachersPage.allTeachersModule.click();
        SeleniumUtils.waitFor(2);
        allTeachersPage.searchtecaherIDBtnInput.click();
        SeleniumUtils.waitFor(2);
        allTeachersPage.searchtecaherIDBtnInput.sendKeys("" + teacherId);
        SeleniumUtils.waitForVisibility(allTeachersPage.searchBtn, 10);
        allTeachersPage.searchBtn.click();
        SeleniumUtils.waitFor(4);
    }

    @When("user click on the teacher profile")
    public void user_click_on_the_teacher_profile() {

        SeleniumUtils.waitFor(4);
        allTeachersPage.teacherProfile.click();
        SeleniumUtils.waitFor(4);


    }

    @Then("user compares UI information and API information")
    public void user_compares_UI_information_and_API_information() {


        SeleniumUtils.waitFor(3);
        System.out.println(allTeachersPage.fullName.getText());
        // APIUtility.hitGET("/teacher/"+APIUtility.getResponseBody().getTeacherId());
        Assert.assertTrue(APIUtility.getResponseBody().getGender().equals(allTeachersPage.gender.getText()));
        Assert.assertTrue(APIUtility.getResponseBody().getBirthDate().equals(allTeachersPage.birthday.getText()));
        //Assert.assertTrue(fullnameFromAPI.trim().equals(allTeachersPage.fullName.getText().trim()));
        Assert.assertEquals(APIUtility.getResponseBody().getBatch()+"".trim(),allTeachersPage.batch.getText().trim());
        Assert.assertEquals(allTeachersPage.teacherID.getText().trim(),String.valueOf(APIUtility.getResponseBody().getTeacherId()));


    }




    @Test


   public void goToGoogle(){

        basePage.goToGoogle();
    }


    @Test


    public void goToYoutube(){

        basePage.goToYoutube();
    }



}
