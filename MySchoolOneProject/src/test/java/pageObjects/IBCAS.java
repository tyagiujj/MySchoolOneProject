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

public class IBCAS extends BasePageMySchool {

    public IBCAS(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Create Experience']")
    WebElement CreateExp;

    @FindBy(xpath = "//input[@id='Experience_Name']")
    WebElement Exp_Name;

    @FindBy(xpath = "//input[@id='Activity_Type_Creativityradio']")
    WebElement ActivityType;

    @FindBy(xpath = "//input[@id='Approachesbtn1']")
    WebElement Approach;

    @FindBy(xpath = "//input[@id='StartDate']")
    WebElement StartDate;

    @FindBy(xpath = "//input[@id='EndDate']")
    WebElement EndDate;

    @FindBy(xpath = "//select[@id='SupervisorName']")
    WebElement Super;

    @FindBy(xpath = "//textarea[@id='DescriptionGoals']")
    WebElement Description;

    @FindBy(xpath = "//input[@id='LearningOutcomes1']")
    WebElement OutCome;

    @FindBy(xpath = "//input[@id='ATL1']")
    WebElement ATL;

    @FindBy(xpath = "//input[@id='LP1']")
    WebElement LP1;

    @FindBy(xpath = "//input[@id='createexperience']")
    WebElement experience;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions actions = new Actions(driver);

    private void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        actions.moveToElement(element).perform();
    }

    public void ClickOnCASExperience() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateExp));
        scrollToElement(CreateExp);
        CreateExp.click();
    }

    public void EnterTheExperience(String Exp) {
        scrollToElement(Exp_Name);
        Exp_Name.sendKeys(Exp);
    }

    public void ClickOnActivity() {
        scrollToElement(ActivityType);
        ActivityType.click();
    }

    public void Approaches() {
        wait.until(ExpectedConditions.elementToBeClickable(Approach));
        scrollToElement(Approach);
        Approach.click();

        if (!Approach.isSelected()) {
            js.executeScript("arguments[0].click();", Approach);
        }
    }

    public void SelectStartDate(String S_Date) {
        scrollToElement(StartDate);
        js.executeScript("arguments[0].value='" + S_Date + "';", StartDate);
    }

    public void SelectEndDate(String E_Date) {
        scrollToElement(EndDate);
        js.executeScript("arguments[0].value='" + E_Date + "';", EndDate);
    }

    public void SelectTheSupervisorName(String supername) {
        scrollToElement(Super);
        Select sup = new Select(Super);
        sup.selectByVisibleText(supername);
    }

    public void EnterTheDescription(String Des) {
        scrollToElement(Description);
        Description.sendKeys(Des);
    }

    public void SelectTheLearningOutcomes() {
        scrollToElement(OutCome);
        OutCome.click();
    }

    public void SelectTheATL() {
        scrollToElement(ATL);
        ATL.click();
    }

    public void SelectTheLearnerProfile() {
        scrollToElement(LP1);
        LP1.click();
    }

    public void ClickOnCreateExperienceButton() {
        scrollToElement(experience);
        experience.click();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
    }
}
