package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)           //This line forces CukesRunner class to run with Cucumber
@CucumberOptions(
        plugin = {"html:target/cucumber-reports", "json:target/cucumber-reports2.json"},
        features = "@target/rerun.txt",    //you DO NOT want to change this; it will look into features directory and it will be recognized by tags
        glue = "step_definitions"
)


   public class ReRunFailed {


}
