package testCases;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pageObjects.IBCAS;
import testBase.BaseClass;
public class TC_001CreateCAS extends  BaseClass{
    @Test(priority = 2)
    public void NavigateToCreateCASExperiencePage() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.navigate().to("https://dev.myschoolone.com/Web/LearningManagement/DP_CAS_Experience_ListView.php");
    }
    @Test(priority = 3)
    public void CreateCASExperience() {
        IBCAS cas = new IBCAS(driver);
        cas.ClickOnCASExperience();
        cas.EnterTheExperience("Experience in consulting or customer service.");
        cas.ClickOnActivity();
        cas.Approaches();
        cas.SelectStartDate("28/02/2025");
        cas.SelectEndDate("03/02/2025");
        cas.SelectTheSupervisorName("Rekha");
        cas.EnterTheDescription("Automation Testing");
        cas.SelectTheLearningOutcomes();
        cas.SelectTheATL();
        cas.SelectTheLearnerProfile();
        cas.ClickOnCreateExperienceButton();
        cas.acceptAlert();
    } }