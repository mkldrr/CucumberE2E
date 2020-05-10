package pages.vyTrack_pages;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class VyTrackLoginPage extends BasePage {



    public VyTrackLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement loginButton;

    public void goToGoogle(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytractUrl"));
        SeleniumUtils.waitFor(2);
        usernameInput.sendKeys(ConfigurationReader.getProperty("vytrackUsername"));
        SeleniumUtils.waitFor(2);
        passwordInput.sendKeys(ConfigurationReader.getProperty("vytrackPassword"));
        SeleniumUtils.waitFor(2);
        loginButton.click();
        SeleniumUtils.waitFor(5);

    }







}
