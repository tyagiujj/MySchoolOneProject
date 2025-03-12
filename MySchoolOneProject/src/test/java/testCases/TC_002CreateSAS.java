package testCases;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pageObjects.IBSAS;
import testBase.BaseClass;

public class TC_002CreateSAS extends BaseClass {
	@Test(priority=2)
	public void NavigateToSASpage() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		driver.get("https://dev.myschoolone.com/Web/LearningManagement/SA_Experience_ListView.php");
	}
	@Test(priority=3)
	public void CreateSASExperience() {
		IBSAS sas= new IBSAS(driver);
		sas.ClickonCreateSAS();
		sas.EnterTheExperience("\"Community Care Initiative\"");
		sas.ClickonLocation();
		sas.EnterTheHours("1");
		sas.SelectStartDate("09/03/2025");
		sas.SelectEndDate("10/03/2025");
		sas.SelectTheSupervisorName("Rekha");
		sas.EnterTheDescription("Testing");
		sas.EnterTheOrgnization("Stuti");
		sas.EnterTheActivtiyAim("Software Testing");
		sas.SelectTheLearningOutComes();
		sas.SelectTheGlobalContext();
		sas.ClickonAddActivity();
		sas.acceptAlert();
	}}
