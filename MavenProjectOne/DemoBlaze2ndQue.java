package MavenFirst.MavenProjectOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Task 16 2nd QUE
public class DemoBlaze2ndQue {

	public static void main(String[] args) throws InterruptedException {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to demoblaze homepage
        driver.get("https://www.demoblaze.com/");
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Wait for 2 seconds
        Thread.sleep(2000);
        // Get the title of the current page
        String title = driver.getTitle();
        
        // Check if the title equals "STORE"
        if (title.equals("STORE")) {
            System.out.println("Page landed on correct website");
        } else {
            System.out.println("Page not landed on correct website");
        }
        // Close the browser
        driver.close();

	}

}
