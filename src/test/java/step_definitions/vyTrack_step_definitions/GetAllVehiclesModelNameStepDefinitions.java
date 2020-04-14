package step_definitions.vyTrack_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.vyTrack_pages.AllVehiclesPage;
import pages.vyTrack_pages.VyTrackLoginPage;
import pages.vyTrack_pages.VytTackHomePage;
import utilities.SeleniumUtils;

public class GetAllVehiclesModelNameStepDefinitions {


   AllVehiclesPage allVehiclesPage=new AllVehiclesPage();
   VytTackHomePage vytTackHomePage = new VytTackHomePage();
   VyTrackLoginPage loginPage = new VyTrackLoginPage();

    @Given("user login vyTrack Web Application")
    public void user_login_vyTrack_Web_Application() {
        loginPage.login();
        SeleniumUtils.waitFor(4);

    }

    @When("user is on the All Vehicles Module")
    public void user_is_on_the_All_Vehicles_Module() {
        SeleniumUtils.waitFor(4);
        vytTackHomePage.navigateToModule("Fleet","Vehicles Model");
        SeleniumUtils.waitForVisibility(allVehiclesPage.allVehiclesModelHeader,10);
        Assert.assertTrue("allVehiclesModelHeader DID NOT DISPLAY",allVehiclesPage.allVehiclesModelHeader.isDisplayed());

    }

    @Then("user gets all vehicles model name")
    public void user_gets_all_vehicles_model_name() {


       // Map<String, String>  allModelNameListOfMap =  new HashMap<>();
            SeleniumUtils.waitFor(5);

        for (WebElement tableHeaders: allVehiclesPage.tableHeaders){


            for (WebElement vehicleModelsNames: allVehiclesPage.modelNameList){

                 if (tableHeaders.getText().equals("MODEL NAME"))  {


                     if (!vehicleModelsNames.getText().isEmpty()){
                         System.out.println("Table Header is: "+tableHeaders.getText()+ "  and models are "+ vehicleModelsNames.getText());


                         //allModelNameListOfMap.put(tableHeaders.getText(),vehicleModelsNames.getText());
                     }

                 }
            }
        }



      //  System.out.println("map of all my vehicle models: "+ allModelNameListOfMap);










    }

}
