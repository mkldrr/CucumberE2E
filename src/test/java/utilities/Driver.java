package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {


    private static WebDriver driver;


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
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
                        // optional cybertek VM node IP address: 3.87.139.247
                        // optional ip address to run grid :70.166.39.41
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
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
