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
import org.openqa.selenium.support.ui.WebDriverWait;

public class IBTOKExhibition extends BasePageMySchool {

	public IBTOKExhibition(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[normalize-space()='Create TOK Exhibition']")
	WebElement CreateTok;
	
	@FindBy(xpath="//label[contains(text(),'In what ways do values affect the production of kn')]")
	WebElement SelectExhibition;
	
	@FindBy(xpath="//input[@id='saveform']")
	WebElement CreateTokEx;
	

	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   Actions actions = new Actions(driver);
	   
	   private void scrollToElement(WebElement element) {
	       wait.until(ExpectedConditions.visibilityOf(element));
	       js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	       actions.moveToElement(element).perform();
	   }
	
	public void ClickonCreate() {
		wait.until(ExpectedConditions.elementToBeClickable(CreateTok));
		  scrollToElement(CreateTok);
		CreateTok.click();	
	}
	public void SelectTok() {
		wait.until(ExpectedConditions.elementToBeClickable(SelectExhibition));
		  scrollToElement(SelectExhibition);
		SelectExhibition.click();
	}
	public void ClickonAddButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CreateTokEx));
		  scrollToElement(CreateTokEx);
		CreateTokEx.click();
	}
	   public void acceptAlert() {
	       wait.until(ExpectedConditions.alertIsPresent());
	       Alert alert = driver.switchTo().alert();
	       System.out.println("Alert Text: " + alert.getText());
	       alert.accept();
	   }
}
