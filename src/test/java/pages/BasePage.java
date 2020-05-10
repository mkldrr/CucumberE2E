package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class BasePage extends GoToYoutube  implements Login {


    public BasePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }





    public void getSchoolHomePage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("UICybertekTrainingURL"));
    }


    @Override
    public void goToGoogle() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Override
    public void goToYoutube() {
        Driver.getDriver().get("https://www.youtube.com");
    }
}
