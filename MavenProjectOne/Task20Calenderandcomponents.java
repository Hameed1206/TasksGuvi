package MavenFirst.MavenProjectOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 20 1st QUE
public class Task20Calenderandcomponents {

	public static void main(String[] args) {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to jQueryUI webPage
        driver.get("https://jqueryui.com/datepicker/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find the frame element by class name
        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        // Switch to the frame
        driver.switchTo().frame(frameElement);
        // Find the datepicker element by ID
        WebElement dateBox = driver.findElement(By.id("datepicker"));
        // Click on the datepicker to open it
        dateBox.click();
        // Click on the "Next" button to navigate to the next month
        driver.findElement(By.xpath("//span[text() = 'Next']")).click();
        // Click on the date 22
        driver.findElement(By.xpath("//a[@data-date = '22']")).click();
        // Get the selected date from the datepicker
        String date = dateBox.getAttribute("value");
        System.out.println("Selected date is " + date);
        // Close the browser
        driver.close();

        
        

	}

}
