package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Driver {


    private static WebDriver driver;

    public static final String sauceUserName = "mikail.drr";
    public static final String sauceAccessKey = "0abfaca5-db8a-4108-94e5-5aa5833f93af";
    public static final String url = "https://mikail.drr:0abfaca5-db8a-4108-94e5-5aa5833f93af@ondemand.saucelabs.com:443/wd/hub";
    public  static final String URL = "http://localhost:4444/wd/hub";
    //singleton pattern here is used
    private Driver(){
    }
    public static WebDriver getReference(){
        return driver;
    }
    //setting the driver
    public static WebDriver getDriver(){
        if(driver ==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
//below is optional
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.setHeadless(true);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                case "safari":
                    if(System.getProperty("os.name").toLowerCase().contains("windows")){
                        throw new WebDriverException("Windows OS does not support safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;

                case "remotechrome":

                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities().chrome();
                    desiredCapabilities.setPlatform(Platform.ANY);
                    try {
                        driver = new RemoteWebDriver(new URL("URL"),desiredCapabilities);
                        // optional cybertek VM node IP address: 3.87.139.247
                        // optional ip address to run grid :70.166.39.41
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "saucelabs":
                    /**
                     * In this section, we will configure our SauceLabs credentials in order to run our tests on saucelabs.com
                     */
                   // String sauceUserName = "mikail.drr";
                   // String sauceAccessKey ="0abfaca5-db8a-4108-94e5-5aa5833f93af";
                    /**
                     * In this section, we will configure our test to run on some specific
                     * browser/os combination in Sauce Labs
                     */
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    //set your user name and access key to run tests in Sauce
                    capabilities.setCapability("username", sauceUserName);
                    //set your sauce labs access key
                    capabilities.setCapability("accessKey", sauceAccessKey);
                    //set browser to Safari
                    capabilities.setCapability("browserName", "Safari");
                    //set operating system to macOS version 10.13
                    capabilities.setCapability("platform", "macOS 10.13");
                    //set the browser version to 11.1
                    capabilities.setCapability("version", "11.1");
                    //set your test case name so that it shows up in Sauce Labs
                  //  capabilities.setCapability("name", testInfo.getDisplayName());
                    try {
                        driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    //navigate to the url of the Sauce Labs Sample app
                    driver.navigate().to("https://www.saucedemo.com");
                    //Create an instance of a Selenium explicit wait so that we can dynamically wait for an element
                    WebDriverWait wait = new WebDriverWait(driver, 5);
                    //wait for the user name field to be visible and store that element into a variable
                    By userNameFieldLocator = By.cssSelector("[type='text']");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFieldLocator));
                    //type the user name string into the user name field
                    driver.findElement(userNameFieldLocator).sendKeys("standard_user");
                    //type the password into the password field
                    driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");
                    //hit Login button
                    driver.findElement(By.cssSelector("[type='submit']")).click();
                    //Synchronize on the next page and make sure it loads
                    By inventoryPageLocator = By.id("inventory_container");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPageLocator));
                    //Assert that the inventory page displayed appropriately
                    Boolean result = driver.findElements(inventoryPageLocator).size() > 0;
                    assertTrue(result);
                    /**
                     * Here we teardown the driver session and send the results to Sauce Labs
                     */
                    if (result){
                        ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
                    }
                    else {
                        ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
                    }
                    break;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
    //quiting the driver
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver =null;
        }
    }
}
