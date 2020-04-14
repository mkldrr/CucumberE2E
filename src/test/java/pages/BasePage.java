package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class BasePage {


    public BasePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }





    public void getSchoolHomePage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("UICybertekTrainingURL"));
    }







}
