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


public class Imdb {
    ChromeDriver driver;
    public Imdb()
    {
        System.out.println("Constructor: Imdb");
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
        driver.get("https://www.imdb.com/chart/top");
        // Find and print the highest rated movie
        WebElement highestRatedMovie = driver.findElement(By.cssSelector(".lister-list tr:nth-child(1) .titleColumn a"));
        String highestRatedMovieTitle = highestRatedMovie.getText();
        System.out.println("Highest rated movie on IMDb: " + highestRatedMovieTitle);
        // Find and print the total number of movies in the table
        int totalMovies = driver.findElements(By.cssSelector(".lister-list tr")).size();
        System.out.println("Total movies included in the table: " + totalMovies);
        // Find and print the oldest movie on the list
        WebElement oldestMovie = driver.findElement(By.cssSelector(".lister-list tr:last-child .titleColumn a"));
        String oldestMovieTitle = oldestMovie.getText();
        System.out.println("Oldest movie on the list: " + oldestMovieTitle);
        // Find and print the most recent movie on the list
        WebElement recentMovie = driver.findElement(By.cssSelector(".lister-list tr:nth-child(1) .titleColumn a"));
        String recentMovieTitle = recentMovie.getText();
        System.out.println("Most recent movie on the list: " + recentMovieTitle);
        // Find and print the movie with the most user ratings
        WebElement maxUserRatingsMovie = driver.findElement(By.cssSelector(".lister-list tr:nth-child(1) .titleColumn a"));
        String maxUserRatingsMovieTitle = maxUserRatingsMovie.getAttribute("title");
        System.out.println("Movie with the most user ratings: " + maxUserRatingsMovieTitle);
        System.out.println("end Test case: testCase02");
    }


}
