package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Link {
    ChromeDriver driver;
    public Link()
    {
        System.out.println("Constructor: Link");
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

    
    public  void testCase01() throws InterruptedException{
       System.out.println("Start Test case: testCase01");
        driver.get("https://www.linkedin.com/home");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement emailElement = driver.findElement(By.xpath("//input[@id='session_key']"));
        emailElement.sendKeys("roymegha711@gmail.com");
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='session_password']"));
        passwordElement.sendKeys("Megharoy@10011996");
        WebElement signinButton = driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
        signinButton.click();
        WebElement photobutton = driver.findElement(By.xpath("//span[text()='Photo']"));
        photobutton.click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        String imagePath = "/home/user/Downloads/images.png";
        fileInput.sendKeys(imagePath);
        Thread.sleep(2000);
        //Click done button
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        System.out.println("end Test case: testCase02");
    }


}
