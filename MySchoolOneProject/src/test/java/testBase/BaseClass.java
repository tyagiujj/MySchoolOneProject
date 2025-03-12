package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.MySchoolOneLogin;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void Setup() {
        driver = new ChromeDriver();
        driver.get("https://dev.myschoolone.com/bf");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void LoginDetails() {
        MySchoolOneLogin mlo = new MySchoolOneLogin(driver);
        mlo.enterTheUserName("andrew@gmail.com");
        mlo.enterThePassword("12345");
        mlo.ClickonRobot();
        mlo.Login();
    }

    // Capture screenshot for failed test cases
    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                captureScreen(result.getName());
            } catch (IOException e) {
                System.out.println("Screenshot capture failed: " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreen(String tname) throws IOException {
        if (driver == null) {
            System.out.println("Driver is null, cannot capture screenshot.");
            return null;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String targetFilePath = System.getProperty("user.dir") +"\\screenshot\\"+ tname + "_" + timeStamp +".png";
            File targetFile = new File(targetFilePath);
            sourceFile.renameTo(targetFile);
            System.out.println("Screenshot saved at: " + targetFilePath);
            return targetFilePath;
        } catch (ClassCastException e) {
            System.out.println("Failed to cast driver to TakesScreenshot. Ensure the browser is initialized properly.");
            return null;
        }
    }
}
