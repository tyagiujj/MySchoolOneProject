package pageObjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IBSAS   extends BasePageMySchool {

    public IBSAS(WebDriver driver) {
		super(driver);
	     PageFactory.initElements(driver, this);
	}
    @FindBy(xpath="//a[normalize-space()='Create SA Activity']")
    WebElement CreateSAactivity;
    
    @FindBy(xpath="//input[@id='activity_name']")
    WebElement ActivityName;
    
   @FindBy(xpath="//input[@id='In_School']")
   WebElement Location;
   
   @FindBy(xpath="//input[@id='Community_Service_Hours']")
   WebElement CH;
   
   @FindBy(xpath="//input[@id='start_date']")
   WebElement startDate;
   
   @FindBy(xpath="//input[@id='end_date']")
   WebElement endDate;
   
   @FindBy(xpath="//select[@id='SupervisorName']")
   WebElement SupervisorName;
   
   @FindBy(xpath="//textarea[@id='description']")
   WebElement Des;
   
   @FindBy(xpath="//input[@id='Organisation']")
   WebElement Org;
   
   @FindBy(xpath="//textarea[@id='activity_aim']")
   WebElement ActivityAim;
   
   @FindBy(xpath="//input[@id='LearningOutcomes1']")
   WebElement Learning;
   
   @FindBy(xpath="//input[@id='GlobalContext1']")
   WebElement GlobalContext;
   
   @FindBy(xpath="//input[@id='createactivity']")
   WebElement AddActivity;
   
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   JavascriptExecutor js = (JavascriptExecutor) driver;
   Actions actions = new Actions(driver);
   
   private void scrollToElement(WebElement element) {
       wait.until(ExpectedConditions.visibilityOf(element));
       js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
       actions.moveToElement(element).perform();
   }
   public void ClickonCreateSAS() {
	   wait.until(ExpectedConditions.elementToBeClickable(CreateSAactivity));
	   CreateSAactivity.click();
   }
   public void EnterTheExperience(String Exp) {
	   scrollToElement(ActivityName);
	   ActivityName.sendKeys(Exp);
   }
   public void ClickonLocation() {
	   scrollToElement(Location);
	   Location.click();
   }
   public void EnterTheHours(String Hs) {
	   scrollToElement(CH);
	   CH.sendKeys(Hs);
   }
   public void SelectStartDate(String S_Date) {
       scrollToElement(startDate);
       js.executeScript("arguments[0].value='" + S_Date + "';", startDate);
   }

   public void SelectEndDate(String E_Date) {
       scrollToElement(endDate);
       js.executeScript("arguments[0].value='" + E_Date + "';", endDate);
   }
   public void SelectTheSupervisorName(String supername) {
       scrollToElement(SupervisorName);
       Select sup = new Select(SupervisorName);
       sup.selectByVisibleText(supername);
   }
   public void EnterTheDescription(String Desp) {
       scrollToElement(Des);
       Des.sendKeys(Desp);
   }
   public void EnterTheOrgnization(String Orgni) {
	   scrollToElement(Org);
	   Org.sendKeys(Orgni);
   }
   public void EnterTheActivtiyAim(String AIM) {
	   scrollToElement(ActivityAim);
	   ActivityAim.sendKeys(AIM);
   }
   public void SelectTheLearningOutComes() {
	   wait.until(ExpectedConditions.elementToBeClickable(Learning));
	   scrollToElement(Learning);
	   Learning.click();   
   }
   public void SelectTheGlobalContext() {
	   wait.until(ExpectedConditions.elementToBeClickable(GlobalContext));
	   GlobalContext.click();
   }
   public void ClickonAddActivity() {
	   wait.until(ExpectedConditions.elementToBeClickable(AddActivity));
	   AddActivity.click();
   }
   public void acceptAlert() {
       wait.until(ExpectedConditions.alertIsPresent());
       Alert alert = driver.switchTo().alert();
       System.out.println("Alert Text: " + alert.getText());
       alert.accept();
   }
   }

    


