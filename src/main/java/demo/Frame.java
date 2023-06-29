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


public class Frame {
    ChromeDriver driver;
    public Frame()
    {
        System.out.println("Constructor: Frame");
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
        //Navigate to the url "https://the-internet.herokuapp.com/nested_frames"
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Switch To Top Frame | name='frame-top'
        driver.switchTo().frame("frame-top");
        //Switch To Left Frame | name='frame-left'
        driver.switchTo().frame("frame-left");
        //Locate the text and print it | getText();
        WebElement text1=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String textOfLeft=text1.getText();
        System.out.println(textOfLeft);
        //Switch Back To Parent Frame
        driver.switchTo().parentFrame();
        //Switch To Middle Frame | name='frame-middle'
        driver.switchTo().frame("frame-middle");
        //Locate the text and print it | getText();
        WebElement text2=driver.findElement(By.xpath("//div[text()='MIDDLE']"));
        String textOfMiddle=text2.getText();
        System.out.println(textOfMiddle);
        ////Switch Back To Parent Frame
        driver.switchTo().parentFrame();
        //Switch to Right Frame | name='frame-right'
        driver.switchTo().frame("frame-right");
        //Locate the text and print it | getText();
        WebElement text3=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String textOfRight=text3.getText();
        System.out.println(textOfRight);
        //Switch Back To Main frame
        driver.switchTo().defaultContent();
        //Switch To Bottom Frame | name='frame-bottom'
        driver.switchTo().frame("frame-bottom");
        WebElement text4=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
         //Locate the text and print it | getText();
        String textOfBottom=text4.getText();
        System.out.println(textOfBottom);
        driver.switchTo().defaultContent();

        


        System.out.println("end Test case: testCase02");
    }


}
