package test;

import org.apache.poi.ss.formula.functions.Now;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.SeleniumUtils;

public class ColorTest {





    @Test

    public void colorTest (){
//    Steps:
//        First of all, we have to get the value of colour using getCssValue method provided by Selenium Webdriver.
//
//        We can do it by using the below code:
//
//        String color = driver.findElement(By.xpath(“//div[contains(@class, ‘logo-subtext’)]”)).getCssValue(“color”);
//
//        In the above code, CSS attribute ‘color’ is stored in a String variable ‘color’.
//
//        The above code will return value in RGB format such as “rgba(36, 93, 193, 1)”.
//
//        Now we will convert it into hexadecimal code using Java as shown below:

        Driver.getDriver().get("https://login.salesforce.com/");
        //fontSize
        SeleniumUtils.waitFor(10);
        String  fontSize = Driver.getDriver().findElement(By.linkText("Forgot Your Password?")).getCssValue("font-size");
        System.out.println("Font size: "+fontSize );

        //print color:

        String  color = Driver.getDriver().findElement(By.linkText("Forgot Your Password?")).getCssValue("color");
        System.out.println("color: "+ color);

        //print backgroundColor

        String  backgroundColor = Driver.getDriver().findElement(By.linkText("Forgot Your Password?")).getCssValue("background-color");
        System.out.println("backgroundColor size: "+backgroundColor );

    }
}
