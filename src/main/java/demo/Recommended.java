package demo;

import java.util.List;
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


public class Recommended {
    ChromeDriver driver;
    public Recommended()
    {
        System.out.println("Constructor: Recommended");
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
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Find the image URLs for all the "Recommended Movies"
        List<WebElement> recommendedMovies = driver.findElements(By.xpath("(//div[contains(@class,'hCzkOF')])[1]//img"));

        System.out.println("Recommended Movies Image URLs:");
        for (WebElement movie : recommendedMovies) {
            String imageURL = movie.getAttribute("src");
            System.out.println(imageURL);
        }

        // Find the Name & Language of the 2nd item in the "Premiere" list
        WebElement premiereItem = driver.findElement(By.xpath("(//img[@alt='I See You']"));
        WebElement premiereLanguage = driver.findElement(By.xpath("(//div[text()='English'])[1]"));

        System.out.println("Name of the 2nd item in Premiere list: " + premiereItem.getText());
        System.out.println("Language of the 2nd item in Premiere list: " + premiereLanguage.getText());

        System.out.println("end Test case: testCase02");
    }


}
