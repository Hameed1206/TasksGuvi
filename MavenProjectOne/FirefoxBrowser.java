package MavenFirst.MavenProjectOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 16 que 1
public class FirefoxBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		 // Setup WebDriver using WebDriverManager for Firefox
        WebDriverManager.firefoxdriver().setup();
        // Initialize WebDriver instance for Firefox
        WebDriver driver = new FirefoxDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to Google homepage
        driver.get("https://www.google.com/");
        
        // Get the current URL of the page
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Refresh the page
        driver.navigate().refresh();
        
        // Close the browser
        driver.close();
	}

}
