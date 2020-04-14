package pages.vyTrack_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class AllVehiclesPage {


    public AllVehiclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tr[@class='grid-header-row']/th")
   public List<WebElement> tableHeaders;



    @FindBy(xpath = "//tbody[@class='grid-body']/tr")
    public List<WebElement> tableRowsAndColumnList;


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement allVehiclesModelHeader;

    @FindBy(xpath = "//tbody[@class='grid-body']/tr/td[2]")
    public List<WebElement> modelNameList;






}
