package testCases;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import pageObjects.IBPersonalProject;
import testBase.BaseClass;

public class TC_004PersonalProject extends BaseClass {
	@Test(priority=2)
	public void NavigateToPersonalProjectPage() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		driver.get("https://dev.myschoolone.com/Web/LearningManagement/pp_experience_list_view.php");
	}
	@Test(priority=3)
	public void CreatePersonalProject() {
		IBPersonalProject pp= new IBPersonalProject(driver);
		pp.ClikonCreatePP();
		pp.EnterLearningGoals("Automation");
		pp.EnterTheProductGoal("Testing");
		pp.SelectTheSupervisor("Rekha");
		pp.SelectLearningOutComes();
		pp.SelectApproachToLearning();
		pp.ClickOnAddPP();
		pp.acceptAlert();
	}
	

}
