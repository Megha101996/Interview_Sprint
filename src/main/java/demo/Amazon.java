package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Amazon {
    ChromeDriver driver;
    public Amazon()
    {
        System.out.println("Constructor: Amazon");
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
        driver.get("https://www.google.com");
        WebElement searchBoxElement=driver.findElement(By.id("APjFqb"));
        searchBoxElement.sendKeys("Amazon");
        WebElement googleSearchElement=driver.findElement(By.xpath("(//input[@value='Google Search'])[1]"));
        googleSearchElement.click();
        WebElement searchResultElement=driver.findElement(By.xpath("(//span[contains(text(),'Amazon.in')])[1]"));
        String searchResult=searchResultElement.getText();
        System.out.println(searchResult);
        System.out.println("end Test case: testCase02");
        
        
    }


}
