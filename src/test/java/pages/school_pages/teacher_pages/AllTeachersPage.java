package pages.school_pages.teacher_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.Driver;

import java.util.List;

public class AllTeachersPage extends BasePage {

   public AllTeachersPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }


    @FindBy(linkText = "Teachers")
    public WebElement teacherModule;
    @FindBy(xpath = "//ul[@class='list-unstyled']/li[1]")
    public WebElement allTeachersModule;
    @FindBy(xpath = "//a[@class='action-icon dropdown-toggle']")
    public WebElement threeDotsign;
    @FindBy(xpath = "(//a[@data-toggle='modal'])[1]")
    public WebElement deleteOption;
    @FindBy(xpath = "(//div[@class='modal-body card-box']/p)")
    public WebElement confirmMessage;
    @FindBy(xpath = "(//button[@type='submit'])")
    public WebElement deleteSubmit;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement teachernamesearchInput;
    @FindBy(xpath = "(//div[@class='col-sm-6 col-md-3']/a)")
    public WebElement searchBtn;
    @FindBy(linkText = "R")
    public WebElement teacherProfile;
    @FindBy(xpath = "(//*[contains(text(), 'Profile')])[5]")
    public WebElement myProfileHeader;
    @FindBy(xpath = "(//span[@class='text']/a)[1]")
    public WebElement teacherId;
    @FindBy(xpath = "(//div[@class='form-group custom-mt-form-group'])/input")
    public WebElement searchtecaherIDBtnInput;


    //teacher profile

    @FindBy(xpath = "(//h4)[1]")
    public WebElement nameOfUser;
    @FindBy(xpath = "(//h3)[2]")
    public WebElement fullName;
    @FindBy(xpath = "//span[contains(text(), 'Phone')]/following-sibling::*/a")
    public  WebElement phoneNumber;
    @FindBy(xpath = "//span[contains(text(), 'Teacher ID:')]/following-sibling::*/a")
    public WebElement teacherID;
    @FindBy(xpath = "//span[contains(text(), 'Email')]/following-sibling::*/a")
    public  WebElement email;
    @FindBy(xpath = "//span[contains(text(), 'Batch')]/following-sibling::*/a")
    public  WebElement batch;
    @FindBy(xpath = "//span[contains(text(), 'Birthday:')]/following-sibling::*")
    public WebElement birthday;
    @FindBy(xpath = "//span[contains(text(), 'Join Date:')]/following-sibling::*")
    public WebElement joinDate;
    @FindBy(xpath = "//span[contains(text(), 'Address:')]/following-sibling::*")
    public WebElement address;
    @FindBy(xpath = "//span[contains(text(), 'Gender:')]/following-sibling::*")
    public WebElement gender;
    @FindBy(xpath = "//span[contains(text(), 'Section:')]/following-sibling::*")
    public WebElement section;
    @FindBy(xpath = "//span[contains(text(), 'Salary:')]/following-sibling::*")
    public WebElement salary;
    @FindBy(xpath = "//span[contains(text(), 'Subject:')]/following-sibling::*")
    public WebElement subject;


    @FindBy(xpath = "//div[@class='row staff-grid-row']//h4")

    public List<WebElement> listOfTeachers;







}
