package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Window {
    ChromeDriver driver;
    public Window()
    {
        System.out.println("Constructor: Window");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get(" https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        //Switch to the iframe containing the "Try it" button
        driver.switchTo().frame("iframeResult");
        WebElement buttonElement=driver.findElement(By.xpath("//button[text()='Try it']"));
        buttonElement.click();
        // Get the handle of the original window
        String originalWindowHandle = driver.getWindowHandle();
        // Get all the window handles
        Set<String> windowHandles = driver.getWindowHandles();
        // Switch to the new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Take a screenshot of the new window
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("screenshots/"+"screenshot.png");
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Close the new window
        driver.close();

        // Switch back to the original window
        driver.switchTo().window(originalWindowHandle);


        System.out.println("end Test case: testCase02");
    }


}
