package MavenFirst.MavenProjectOne;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 21 3rd QUE
public class Task21MultipleFrames {

	public static void main(String[] args) {
		
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to internet webPage
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Locate and switch top and left frame and print the value
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name = 'frame-left']")));
        String text1 = driver.findElement(By.xpath("(//body)[1]")).getText();
        System.out.println(text1);
        //Come to default and Locate and switch top and middle frame and print the value
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name = 'frame-middle']")));
        String text2 = driver.findElement(By.id("content")).getText();
        System.out.println(text2);
        //Come to default and Locate and switch top and right frame and print the value
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name = 'frame-right']")));
        String text3 = driver.findElement(By.xpath("//body[contains(text() , 'RIGHT')]")).getText();
        System.out.println(text3);
        //Come to default and Locate switch and bottom frame and print the value
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name= 'frame-bottom']")));
        String text4 = driver.findElement(By.xpath("//body[contains(text() , 'BOTTOM')]")).getText();
        System.out.println(text4);    
        //quit the instance
        driver.quit();

	}

}
