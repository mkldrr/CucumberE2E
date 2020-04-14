package step_definitions.school_step_definitions.student_step_definitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.junit.Test;
import pages.school_pages.student_pages.AllStudentsPage;
import pojo.RequestBody;
import pojo.student.Address;
import pojo.student.Company;
import pojo.student.Contact;
import utilities.APIUtility;
import utilities.DBUtility;
import utilities.SeleniumUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UpdateAStudentAndValidateE2EStepDefinitions {

    AllStudentsPage allStudentsPage = new AllStudentsPage();

    //this is for DataTable and we convert MAP
    Map<String, String> dataMap;

    //this is for DB, from data table we will have maps in the list
    List<Map<Object, Object>> dbData;




    @Given("user hits and PUT - Update a student on API {string}")
    public void user_hits_and_PUT_Update_a_student_on_API(String resource, DataTable dataTable) {

       dataMap = dataTable.asMap(String.class, String.class);

        RequestBody requestBody = new RequestBody();

        requestBody.setFirstName(dataMap.get("firstName"));
        requestBody.setLastName(dataMap.get("lastName"));
        requestBody.setMajor(dataMap.get("major"));
        requestBody.setSubject(dataMap.get("subject"));
        requestBody.setAdmissionNo(dataMap.get("admissionNo"));
        requestBody.setBatch(Integer.parseInt(dataMap.get("batch")));
        requestBody.setGender(dataMap.get("gender"));
        requestBody.setBirthDate(dataMap.get("birthDate"));
        requestBody.setJoinDate(dataMap.get("joinDate"));
        requestBody.setPassword(dataMap.get("password"));
        requestBody.setSection(dataMap.get("section"));
        requestBody.setStudentId(Integer.parseInt(dataMap.get("studentId")));

        Contact contact=new Contact();

        contact.setPhone(dataMap.get("phone"));
        contact.setEmailAddress(dataMap.get("emailAddress"));
        contact.setPremanentAddress(dataMap.get("premanentAddress"));

        requestBody.setContact(contact);

        Company company=new Company();
        company.setCompanyName(dataMap.get("companyName"));
        company.setStartDate(dataMap.get("startDate"));
        company.setTitle(dataMap.get("title"));



        Address address=new Address();
        address.setStreet(dataMap.get("street"));
        address.setCity(dataMap.get("city"));
        address.setState(dataMap.get("state"));
        address.setZipCode(Integer.parseInt(dataMap.get("zipCode")));

        company.setAddress(address);

        requestBody.setCompany(company);

        APIUtility.hitPUT(resource, requestBody);

    }
//-------




    @When("user is on the all students page")
    public void user_is_on_the_all_students_page() {
        SeleniumUtils.waitFor(2);
        allStudentsPage.studentsBtn.click();
        SeleniumUtils.waitFor(2);
        allStudentsPage.allStudentsButton.click();
    }

    @When("user searches student by {int}")
    public void user_searches_student_by(Integer studentIDFromAPI) {

        studentIDFromAPI=APIUtility.getResponseBody().getStudentId();

        SeleniumUtils.waitForVisibility(allStudentsPage.searchStudentById,10);
        allStudentsPage.searchStudentById.click();
        SeleniumUtils.waitFor(2);
        allStudentsPage.searchStudentById.sendKeys(studentIDFromAPI+"");
        SeleniumUtils.waitForVisibility(allStudentsPage.searchBtn,10);
        allStudentsPage.searchBtn.click();
        SeleniumUtils.waitFor(1);
    }
    @When("user click on the student profile")
    public void user_click_on_the_student_profile() {
        SeleniumUtils.waitFor(2);

        allStudentsPage.clickOnStudentProfile.click();
        SeleniumUtils.waitFor(3);

    }


    @When("user validates UI and API info about updated student")
    public void user_validates_UI_and_API_info_about_updated_student() {

        Assert.assertTrue(allStudentsPage.studentID.getText().trim().equals(APIUtility.getResponseBody().getStudentId()+""));
        Assert.assertTrue(APIUtility.getResponseBody().getContact().getEmailAddress().trim().equals(allStudentsPage.newEmail.getText().trim()));
        Assert.assertTrue(APIUtility.getResponseBody().getMajor().trim().equals(allStudentsPage.majorUpdate.getText().trim()));
        SeleniumUtils.waitFor(4);


    }

    @When("user connects to DB")
    public void user_connects_to_DB() throws SQLException {

        DBUtility.createConnection();

    }

    @When("user writes query about updated student")
    public void user_writes_query_about_updated_student() throws SQLException {

       dbData= DBUtility.executeQuery("select * from student where student_id="+APIUtility.getResponseBody().getStudentId());

    }

    @Then("user validates with DB, API and UI")
    public void user_validates_with_DB_API_and_UI() {

        Assert.assertTrue(APIUtility.getResponseBody().getMajor().trim().toLowerCase().equals(dbData.get(0).get("MAJOR").toString().trim().toLowerCase()));
        Assert.assertTrue(String.valueOf(APIUtility.getResponseBody().getStudentId()).equals(dbData.get(0).get("STUDENT_ID").toString().trim()));
        Assert.assertTrue(allStudentsPage.newSubject.getText().trim().toLowerCase().equals(dbData.get(0).get("SUBJECT").toString().toLowerCase()));
        Assert.assertTrue(APIUtility.getResponseBody().getAdmissionNo().trim().toLowerCase().equals(dbData.get(0).get("ADMISSION_NO").toString().toLowerCase().trim()));

    }








    @Test
    public void test21332() throws SQLException {


        APIUtility.hitGET("/teacher/all");
        System.out.println("JOIN date from API:   "+ APIUtility.getResponseBody().getTeachers().get(0).getJoinDate());
        DBUtility.createConnection();
        List<Map<Object, Object>>  database=  DBUtility.executeQuery("select JOIN_DATE from teacher");
        System.out.println("Join date from DB:   "+database.get(0).get("JOIN_DATE"));




    }








}
