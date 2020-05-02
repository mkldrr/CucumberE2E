package pages.excel_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GasMileageCalculatorPage {

     public GasMileageCalculatorPage(){
         PageFactory.initElements(Driver.getDriver(),this);
     }
    @FindBy(xpath ="//input[contains(@name,'uscodreading')]")
    public WebElement curentOdo;
    @FindBy(id="uspodreading")
    public WebElement previousOdo;
    @FindBy(id = "usgasputin")
    public WebElement gasInput;
    @FindBy(xpath = "//input[@alt='Calculate'][1]")
    public WebElement calculateButton;
    @FindBy(xpath = "//b[contains(text(),'mpg')]")
    public WebElement resultInGas;

}
