package pages.vyTrack_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

public class VytTackHomePage {



        public VytTackHomePage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }


    public void navigateToModule(String tab, String module) {
            SeleniumUtils.waitFor(4);
        String tabLocatorXpath = "//span[contains(text(), '"+ tab +"') and @class = 'title title-level-1']";
        String moduleLocatorXpath = "//span[.= '"+module+"']";
        SeleniumUtils.waitFor(2);
        Driver.getDriver().findElement(By.xpath(tabLocatorXpath)).click();
        SeleniumUtils.waitFor(2);
        Driver.getDriver().findElement(By.xpath(moduleLocatorXpath)).click();
        SeleniumUtils.waitFor(2);
    }
}
