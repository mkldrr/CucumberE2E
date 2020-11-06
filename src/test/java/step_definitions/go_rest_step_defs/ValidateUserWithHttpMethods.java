package step_definitions.go_rest_step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apiguardian.api.API;
import org.junit.Test;
import pojo.RequestBody;
import pojo.ResponseBody;
import pojo.users.*;
import utilities.APIUtility;





public class ValidateUserWithHttpMethods {


    static ResponseBody responseBody = null;
    static Response response =null;

    static String url= "https://gorest.co.in/public-api/users";


    static String accessToken= "?access-token="+"B1eq8RWO7bdVy2oD3IsWdNaglvFaHwHXlIck";

    static String uri = url+accessToken;
    static String toBeDeleted = "/38274";


    @Given("user gets all clients from {string}")
    public void user_gets_all_clients_from(String resource) {

        resource= this.uri;
        try{
            response = RestAssured.get(url+accessToken);

            String data=  response.body().toString();
            System.out.println(response.statusCode());
            System.out.println(response.prettyPrint());
            System.out.println(data);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    @When("user validate that specific {string} is not on API")
    public void user_validate_that_specific_is_not_on_API(String id) {

        // con not deserialize



    }

    @When("user creates a client on given {string}")
    public void user_creates_a_client_on_given(String uri) {
        // RequestBody jsonBody = new RequestBody();

        try {

            Users users = new Users();
            Links links = new Links();

//
//        Avatar avatar = new Avatar();
//        avatar.setHref("https://gorest.co.in/public-api/users");
//
//        Self self = new Self();
//        self.setHref("https://gorest.co.in/public-api/users");
//        Edit edit = new Edit();
//        edit.setHref("https://gorest.co.in/public-api/users");
//
//        links.setAvatar(avatar);
//        links.setEdit(edit);
//        links.setEdit(edit);


            users.setFirst_name("Lionel");
            users.setLast_name("Messi");
            users.setAddress("000 Chicago Ave");
            users.setDob("1954-04-17");
            users.setEmail("example@nashville.com");
            users.setGender("male");
            users.setStatus("active");
            users.setWebsite("https://www.google.com");
            users.setPhone("34687234892");


            response = RestAssured.given().contentType(ContentType.JSON).body(users).when().post(uri);
            System.out.println(response.prettyPrint());
            System.out.println(response.statusCode());


        }catch (Exception e){

            e.printStackTrace();

        }
    }

    @Then("user deletes the already created client {string} on API and validate")
    public void user_deletes_the_already_created_client_on_API_and_validate(String uri) {

        try {
            response = RestAssured.delete(url + toBeDeleted + accessToken);

            if (response.statusCode()== 200) System.out.println("User successfully deleted!");

        }catch (Exception e){

            e.printStackTrace();
        }

    }



    @Test

    public void hitGet(){

        try{
            response = RestAssured.get(url+ accessToken);

            String data=  response.body().toString();
            System.out.println(response.statusCode());
            System.out.println(response.prettyPrint());
            System.out.println(data);
        }catch (Exception e){
            e.printStackTrace();
        }


      //APIUtility.hitGET(url+accessToken);





    }




    @Test

    public void hitPost(){

       // RequestBody jsonBody = new RequestBody();

        try {

            Users users = new Users();
            Links links = new Links();

//
//        Avatar avatar = new Avatar();
//        avatar.setHref("https://gorest.co.in/public-api/users");
//
//        Self self = new Self();
//        self.setHref("https://gorest.co.in/public-api/users");
//        Edit edit = new Edit();
//        edit.setHref("https://gorest.co.in/public-api/users");
//
//        links.setAvatar(avatar);
//        links.setEdit(edit);
//        links.setEdit(edit);


            users.setFirst_name("Lionel");
            users.setLast_name("Messi");
            users.setAddress("000 Chicago Ave");
            users.setDob("1954-04-17");
            users.setEmail("example@sdkjbjksdhbcjhds.com");
            users.setGender("male");
            users.setStatus("active");
            users.setWebsite("https://www.google.com");
            users.setPhone("34687234892");


            response = RestAssured.given().contentType(ContentType.JSON).body(users).when().post(uri);
            System.out.println(response.prettyPrint());
            System.out.println(response.statusCode());


        }catch (Exception e){

            e.printStackTrace();

        }
    }




    @Test
    public void hitDelete(){


        try {
            response = RestAssured.delete(url + toBeDeleted + accessToken);

            if (response.statusCode()== 200) System.out.println("User successfully deleted!");

        }catch (Exception e){

            e.printStackTrace();
        }

    }



}
