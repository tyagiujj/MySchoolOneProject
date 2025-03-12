package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySchoolOneLogin extends BasePageMySchool{
	public  MySchoolOneLogin (WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='user_names']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='imrobot']")
	WebElement Imrobot;
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement Sign;
	
	public void enterTheUserName(String u_name) {
		Username.sendKeys(u_name);
	}
	public void enterThePassword(String pwd) {
	Password.sendKeys(pwd);
	}
	public void ClickonRobot() {
		Imrobot.click();
	}
	public void Login() {
		Sign.click();
	}

}
