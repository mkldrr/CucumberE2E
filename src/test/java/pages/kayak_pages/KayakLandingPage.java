package pages.kayak_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KayakLandingPage {




    public KayakLandingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[@class='_iac _irF _Hk _h-8'][1]")
    public WebElement currentCityRemove;


    @FindBy(xpath = "(//div[@class='_kaD _kaC _iac _iad _iaa _iab _iai'])[1]")
    public WebElement originAirportInputBoxBefore;
    @FindBy(xpath = "//input[@placeholder='From?'][1]")
    public WebElement originAirportInputBoxAfter;

    @FindBy(name = "origin")
    public WebElement originBox;



    @FindBy(xpath="//div[@aria-label='Flight destination input'][1]")
    public WebElement destinationAirportInputBox;

    @FindBy(xpath = "//input[@placeholder='To?'][1]")
    public WebElement destinationAirportInputBoxAfter;


    @FindBy(xpath="(//div[contains(@id,'dateRangeInput-display-star')])[1]/div")
    public WebElement departureDateInputBox;

    @FindBy(xpath = "(//div[contains(@id,'depart')])[2]")
    public WebElement departureDateInputBox2;

    @FindBy(xpath = "(//div[@aria-label='Return date input']/div)[1]")
    public WebElement returnDateBox;

    @FindBy(xpath = "(//div[contains(@id,'return')])[2]")
    public WebElement returnDateInputBox;



    @FindBy(xpath = "//div[@id='stl-jam-cal-202005']/div/div")
    public WebElement destinationMothHeader;


    @FindBy(xpath = "//div[@aria-label='May 12']")
    public WebElement may12;

    @FindBy(id = "stl-jam-cal-nextMonth")
    public WebElement nextMonthArrow;

    @FindBy(xpath = "//div[@aria-label='June 13']")
    public WebElement June13;


    @FindBy(xpath = "//button[@aria-label='Search flights']/span")
    public WebElement searchBox;

    @FindBy(xpath = "(//button[contains(@id,'submit')])[3]")
    public WebElement submitAlertButton;




    @FindBy(css="#c6_uB-dialog-close > svg")
    public WebElement alertX;

    @FindBy(xpath = "(//a[contains(@id,'c5KnW-bestflight_aTab')])")
    public WebElement bestFlightBtn;











}
