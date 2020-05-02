package step_definitions.kayak_step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import pages.kayak_pages.KayakLandingPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.security.Key;

public class KayakAirportSearchStepDefs {

    KayakLandingPage kayakLandingPage = new KayakLandingPage();




    @Given("user is on the Kayak Landing Page")
    public void user_is_on_the_Kayak_Landing_Page() {

        Driver.getDriver().get("https://www.kayak.com/");

    }

    @When("user enters {string} by adding nearby airports and enters {string} cities")
    public void user_enters_by_adding_nearby_airports_and_enters_cities(String originCity, String destinationCity) {

        SeleniumUtils.waitFor(1);
        kayakLandingPage.originAirportInputBoxBefore.click();
        SeleniumUtils.waitFor(1);
        kayakLandingPage.originAirportInputBoxAfter.sendKeys(originCity);
        SeleniumUtils.waitFor(1);
        kayakLandingPage.originAirportInputBoxAfter.sendKeys(Keys.ENTER);

        SeleniumUtils.waitFor(1);
        kayakLandingPage.destinationAirportInputBox.click();
        SeleniumUtils.waitFor(1);
        kayakLandingPage.destinationAirportInputBoxAfter.sendKeys(destinationCity);
        SeleniumUtils.waitFor(1);
        kayakLandingPage.destinationAirportInputBoxAfter.sendKeys(Keys.ENTER);

    }

    @When("user selects {string} and {string} dates")
    public void user_selects_and_dates(String departureDate, String returnDate) {

        SeleniumUtils.waitFor(1);

        kayakLandingPage.departureDateInputBox.click();
        SeleniumUtils.waitFor(3);
        kayakLandingPage.departureDateInputBox2.sendKeys(Keys.CLEAR);


        kayakLandingPage.departureDateInputBox2.sendKeys(departureDate);
       // kayakLandingPage.may12.click();
        SeleniumUtils.waitFor(1);
        kayakLandingPage.departureDateInputBox2.sendKeys(Keys.ENTER);
        SeleniumUtils.waitFor(3);
        kayakLandingPage.returnDateInputBox.click();
        SeleniumUtils.waitFor(2);
       // kayakLandingPage.returnDateInputBox.click();
        SeleniumUtils.waitFor(2);
        kayakLandingPage.returnDateInputBox.sendKeys(Keys.CLEAR);
        SeleniumUtils.waitFor(2);
        kayakLandingPage.returnDateInputBox.sendKeys(returnDate);

        kayakLandingPage.returnDateInputBox.sendKeys(Keys.ENTER);
       // kayakLandingPage.nextMonthArrow.click();
        SeleniumUtils.waitFor(1);
       // kayakLandingPage.June13.click();

    }

    @When("user clicks search button")
    public void user_clicks_search_button() {

        SeleniumUtils.waitFor(1);
        kayakLandingPage.searchBox.click();

    }

    @Then("user validates origin and destination details are same as entered in the main screen")
    public void user_validates_origin_and_destination_details_are_same_as_entered_in_the_main_screen() {


       String mainWindow= Driver.getDriver().getWindowHandle();

        System.out.println("Main Window id:   "+  mainWindow);
        System.out.println("Main window title "+Driver.getDriver().getTitle());


        for (String handle: Driver.getDriver().getWindowHandles()) {
            if(!handle.equals(mainWindow))
                Driver.getDriver().switchTo().window(handle);
        }


        SeleniumUtils.waitFor(1);
        System.out.println("New window title "+Driver.getDriver().getTitle());
      //  kayakLandingPage.alertX.click();














    }




//    @Test
//
//    public void test(){
//
//        Driver.getDriver().get("https://www.kayak.com/");
//        Driver.getDriver().findElement(By.name("origin")).click();
//        Driver.getDriver().findElement(By.name("origin")).sendKeys("Nashville");
//    }
//



}
