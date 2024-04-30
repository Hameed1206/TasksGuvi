package MavenFirst.MavenProjectOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Wikipedia3rdQue {
//Task 16 3rd QUE
	public static void main(String[] args) throws InterruptedException {
		 // Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to wikipedia homepage
        driver.get("https://www.wikipedia.org/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Find the search input field by its id and enter text "Artificial Intelligence"
        driver.findElement(By.id("searchInput")).sendKeys("Artificial Intelligence");
        // Wait for 2 seconds
        Thread.sleep(2000);
        // Click the search button using XPath
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        // Wait for 2 seconds
        Thread.sleep(2000);
        // Click the "View history" link by its id
        driver.findElement(By.id("ca-history")).click();
        // Wait for 2 seconds
        Thread.sleep(2000);
        // Get the text of the first heading (title of the section)
        String text = driver.findElement(By.id("firstHeading")).getText();
        System.out.println("Title of section is " + text);
        // Get the title of the current page
        String title = driver.getTitle();
        System.out.println("Title of the page is " + title);
        // Close the browser
        driver.close();   
	}
}
