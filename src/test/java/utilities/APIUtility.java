package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.response.Response;
import org.apache.http.client.ResponseHandler;
import pojo.RequestBody;
import pojo.ResponseBody;

import java.io.IOException;

public class APIUtility {

    private static ResponseHandler responseHandler;

  static String baseURL= ConfigurationReader.getProperty("baseURL");

  static String accessToken= "?access-token="+"uC7Bd5lENEAq7kNmd3cSeHrbQNL5vIb41Rid";




    static ResponseBody responseBody = null;
    static Response response =null;




    //CRUD Operation. One  method for each operation.
    //One method should handle any APis are hitting.
    public static void hitGET(String resource) {
        String uri =  baseURL+ resource ;



        response = RestAssured.given().get(uri);
        System.out.print(response.prettyPrint());
        // Assert.assertEquals("Get API hit failed", 200, response.statusCode());
        System.out.println("\nSTATUS CODE: "+response.statusCode());
        ObjectMapper mapper = new ObjectMapper();

        try {
            responseBody = mapper.readValue(response.asString(), ResponseBody.class);
        } catch (IOException e) {
            System.out.println("JSON WAS NOT MAPPED PROPERLY");
        }



    }








    public static void hitPOST(String resource, RequestBody jsonBody) {
        String uri = baseURL + resource;

        response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).when().post(uri);
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());


        try {
            responseBody = response.as(ResponseBody.class);
        } catch (Exception j) {
            j.printStackTrace();
            System.err.println("Response could not map properly with RestAssured Library");
        }




    }
    public static void hitDELETE(String resource,Integer ID){
        String uri = baseURL + resource+""+ID+"";


        response = RestAssured.delete(uri);



        if (response.getStatusCode()==200) System.out.println("The StatusCode is: " +response.getStatusCode()
                + "\nThe user with "+ ID +" ID number is successfully DELETED from API");
        else System.out.println("Either Resource: "  + resource + "\n OR  ID: " + ID + " is INVALID"  );

        System.out.println("STATUS CODE:" +response.statusCode());


        try {
            responseBody = response.as(ResponseBody.class);
        } catch (Exception j) {
            j.printStackTrace();
            System.err.println("Response could not map properly with RestAssured Library");
        }



    }
    public static void hitPUT(String resource, RequestBody body)  {
        String uri = baseURL+resource;

        response = RestAssured.given().contentType(ContentType.JSON).body(body).when().put(uri);



        System.out.println(response.prettyPrint());
        //Assert.assertEquals("Get API hit failed", 200, response.statusCode());
        System.out.println("STATUS CODE: "+response.statusCode());

        try {
            responseBody = response.as( ResponseBody.class);
        } catch (Exception j) {
            j.printStackTrace();
            System.err.println("Response could not map properly with RestAssured Library");
        }

    }

    public static ResponseBody getResponseBody() {

        return responseBody;
    }











}
