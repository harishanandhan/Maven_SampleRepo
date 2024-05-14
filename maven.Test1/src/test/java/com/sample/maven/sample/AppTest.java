package com.sample.maven.sample;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void example(){
            // Set system property to indicate the location of the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "D:\\GridConfig\\GridConfig\\chromedriver-win64\\chromedriver.exe");

            // Instantiate a WebDriver object (in this case, ChromeDriver)
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.amazon.in");

            // Cast the WebDriver instance to WebDriver.Options
            //WebDriver.Options options = (WebDriver.Options) driver;

            // Now you can call the manage() method
            
            // Other WebDriver operations...
            driver.manage().window().maximize();
            // Close the browser
            driver.quit();	
        
    }
}
