package MavenFirst.MavenProjectOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 21 1st QUE
public class Task21Frames {

	public static void main(String[] args) {
		
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to internet webPage
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Maximize the browser window
        driver.manage().window().maximize();
        //wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // locate and switch frame
        WebElement frame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe"));
        driver.switchTo().frame(frame);
        // locate paragraph box and enter value
        WebElement paragraph = driver.findElement(By.tagName("p"));
        paragraph.clear();
        paragraph.sendKeys("Hello People");
        driver.close();

        		
	}

}
