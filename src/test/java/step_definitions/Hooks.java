package step_definitions;

import cucumber.api.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.*;

import java.sql.SQLException;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){

        //anything that you want to run before each scenario
        // Driver.getDriver().get(ConfigurationReader.getProperty("vytractUrl"));
        TempDataStorageUtils.clear();

        Log.start(scenario.getName());
        ExtentReport.startTest(scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario) throws SQLException {

        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());

        if(scenario.isFailed()&& Driver.getReference()!=null){
            byte[] screenshot = ( (TakesScreenshot) Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
            ExtentReport.fail();
        }
        else {
            ExtentReport.pass();
        }
        //after
        Driver.quitDriver();
        DBUtility.close();
    }
}
