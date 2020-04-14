package step_definitions.school_step_definitions.teacher_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.school_pages.teacher_pages.AllTeachersPage;
import utilities.SeleniumUtils;

public class GetAllTeacherStepDefinitions {

AllTeachersPage allTeachersPage = new AllTeachersPage();

    @Given("user is on the school home page")
    public void user_is_on_the_school_home_page() {
          allTeachersPage.getSchoolHomePage();
    }

    @When("user is on the all teachers page")
    public void user_is_on_the_all_teachers_page() {

        SeleniumUtils.waitFor(2);
        allTeachersPage.teacherModule.click();
        SeleniumUtils.waitFor(2);
        allTeachersPage.allTeachersModule.click();
        SeleniumUtils.waitFor(2);




    }

    @Then("user gets all teachers")
    public void user_gets_all_teachers() {

        System.out.println(allTeachersPage.listOfTeachers.size());
        int count =0;
        for (int i = 0; i < allTeachersPage.listOfTeachers.size(); i++) {
            if (allTeachersPage.listOfTeachers.get(i).getText().equals("LIONEL")){
                System.out.println(allTeachersPage.listOfTeachers.get(i).getText().toLowerCase());

                count++;
                break;
            }
        }

        System.out.println("LIONEL is found and return statement is worked: "+count);


//        for (WebElement teacher : allTeachersPage.listOfTeachers) {
//
//            System.out.println(teacher.getText());
//
//        }

    }


}
