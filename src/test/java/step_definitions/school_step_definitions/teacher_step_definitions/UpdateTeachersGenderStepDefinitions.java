package step_definitions.school_step_definitions.teacher_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pojo.RequestBody;
import pojo.teacher.Teacher;
import utilities.APIUtility;

public class UpdateTeachersGenderStepDefinitions {

      static int numberOfFemaleTeacher;
      static int numberOfUpdatedFemaleTeacher;


    @Given("user hits and GETs the teacher at {string}")
    public void user_hits_and_GETs_the_teacher_at(String resource) {

        APIUtility.hitGET(resource);
        System.out.println("Total Teachers on API: "+APIUtility.getResponseBody().getTeachers().size());

    }

    @When("user checks the number of male teacher")
    public void user_checks_the_number_of_male_teacher() {



        for (int i = 0; i <APIUtility.getResponseBody().getTeachers().size() ; i++) {

            if (APIUtility.getResponseBody().getTeachers().get(i).getGender().equals("female")) {
                numberOfFemaleTeacher++;
            }
        }

        System.out.println("number of female teachers: " + numberOfFemaleTeacher);

    }

    @Then("user updates the number of male teachers gender to female")
    public void user_updates_the_number_of_male_teachers_gender_to_female() {
        RequestBody requestBody = new RequestBody();

        for (Teacher teachers: APIUtility.getResponseBody().getTeachers()) {

            if (teachers.getGender().equals("female")){

                requestBody.setEmailAddress("lionel.messi@gmail.com");
                requestBody.setFirstName("Lionel");
                requestBody.setJoinDate("02/01/2010");
                requestBody.setLastName("MD");
                requestBody.setSalary(100000);
                requestBody.setSection("Succer");
                requestBody.setBatch(13);
                requestBody.setDepartment("Sports");
                requestBody.setSubject("Football");
                requestBody.setGender("Male");
                requestBody.setPhone("132-122-1322");
                requestBody.setBirthDate("01/01/1990");
                requestBody.setPassword("123");
                requestBody.setPremanentAddress("2134 W Huron");
                requestBody.setTeacherId(teachers.getTeacherId());
                APIUtility.hitPUT("/teacher/update",requestBody);


                numberOfUpdatedFemaleTeacher++;

            }
        }

        System.out.println("number of UPDATED/PUT female teacher on API: "+ numberOfUpdatedFemaleTeacher);
    }

}
