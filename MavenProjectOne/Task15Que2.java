package MavenFirst.MavenProjectOne;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Task 15 2nd Que
public class Task15Que2 {
	public static void main(String[] args) throws InterruptedException {
		
		 // Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Navigate to Google homepage
        driver.get("https://www.google.com/");
        // Wait for 2 seconds
        Thread.sleep(2000);
        
        // Find the search input field by its name and enter text "Selenium Browser Driver", then press Enter
        driver.findElement(By.name("q")).sendKeys("Selenium Browser Driver", Keys.ENTER);
        
        // Wait for 2 seconds
        Thread.sleep(2000);
       // Close the browser
        driver.close();
		

	}

}
