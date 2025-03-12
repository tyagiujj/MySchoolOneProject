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

public class IBPersonalProject extends BasePageMySchool {

	public IBPersonalProject(WebDriver driver) {
		super(driver);
		   PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[normalize-space()='Create PP Activity']")
	WebElement CreatePP;
	
	@FindBy(xpath="//textarea[@id='learning_goal']")
	WebElement LearningGoal;
	
	@FindBy(xpath="//textarea[@id='product_goal']")
	WebElement ProductGoal;
	
	@FindBy(xpath="//select[@id='SupervisorName']")
	WebElement Supervisor;
	
	@FindBy(xpath="//input[@id='LearningOutcomes1']")
	WebElement LearningOutComes;
	
	@FindBy(xpath="//input[@id='ATL1']")
	WebElement ATL1;
	
	@FindBy(xpath="//input[@id='createactivity']")
	WebElement CreateActivity;
	
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Actions actions = new Actions(driver);

	    private void scrollToElement(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	        actions.moveToElement(element).perform();
	    }
	    public void ClikonCreatePP() {
	    	wait.until(ExpectedConditions.elementToBeClickable(CreatePP));
	    	scrollToElement(CreatePP);
	    	CreatePP.click();
	    }
	    public void EnterLearningGoals(String LG) {
	    	scrollToElement(LearningGoal);
	    	LearningGoal.sendKeys(LG);
	    }
	    public void EnterTheProductGoal(String PG) {
	    	scrollToElement(ProductGoal);
	    	ProductGoal.sendKeys(PG);
	    }
	    public void SelectTheSupervisor(String Supr) {
	    	scrollToElement(Supervisor);
	    	Select sup= new Select(Supervisor);
	    	sup.selectByVisibleText(Supr);
	    }
	    public void SelectLearningOutComes() {
	    	wait.until(ExpectedConditions.elementToBeClickable(LearningOutComes));
	    	LearningOutComes.click();
	    }
	    public void SelectApproachToLearning() {
	    	wait.until(ExpectedConditions.elementToBeClickable(ATL1));
	    	ATL1.click();
	    }
	    public void ClickOnAddPP() {
	    	wait.until(ExpectedConditions.elementToBeClickable(CreateActivity));
	    	CreateActivity.click();
	    	
	    }
	    public void acceptAlert() {
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert Text: " + alert.getText());
	        alert.accept();
}}
