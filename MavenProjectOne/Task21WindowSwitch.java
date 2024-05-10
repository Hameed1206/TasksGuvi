package MavenFirst.MavenProjectOne;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 21 2nd QUE
public class Task21WindowSwitch {

	public static void main(String[] args) throws InterruptedException {
		
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to internet webPage
        driver.get("https://the-internet.herokuapp.com/windows");
        // Maximize the browser window
        driver.manage().window().maximize();
        //wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // locate and click, click here link
        driver.findElement(By.xpath("//a[text() = 'Click Here']")).click();
        // get all window IDS and switch between them
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles) {
			driver.switchTo().window(string);
			System.out.println(string);
			// print text, URL and title from both windows
			String textFromNewWindow = driver.findElement(By.tagName("h3")).getText();
	        System.out.println(textFromNewWindow);
	        System.out.println(driver.getCurrentUrl());
	        System.out.println("Title of the page is "+driver.getTitle());
	        System.out.println("");
		}
        //close browser and quit instance
        driver.close();
        Thread.sleep(2000);
        driver.quit();
        
		

	}

}
