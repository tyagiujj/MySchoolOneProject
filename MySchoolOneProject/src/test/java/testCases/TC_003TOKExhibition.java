package testCases;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pageObjects.IBTOKExhibition;
import testBase.BaseClass;

public class TC_003TOKExhibition extends BaseClass {
	@Test(priority=2)
	public void NavigateToTokExhibitonpage() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		driver.get("https://dev.myschoolone.com/Web/LearningManagement/TOKExhibitionStudentPromptList.php");
	}
	@Test(priority=3)
	public void SelectTheTokExhibition() throws InterruptedException {
IBTOKExhibition tok =new IBTOKExhibition(driver);
tok.ClickonCreate();
tok.SelectTok();
Thread.sleep(2000);
tok.ClickonAddButton();
tok.acceptAlert();
driver.navigate().back();
driver.navigate().refresh();
	}}
