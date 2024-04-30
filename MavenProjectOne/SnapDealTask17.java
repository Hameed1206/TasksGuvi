package MavenFirst.MavenProjectOne;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 17 QUE 1
public class SnapDealTask17 {

	public static void main(String[] args) throws InterruptedException {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to snapdeal homepage
        driver.get("https://www.snapdeal.com/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Get the initial URL
        String initialURL = driver.getCurrentUrl();
        // Using Actions class Mouse hover to the account icon
        Actions a = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[contains(@class , 'accountUserName')]"));
        String beforeLogin = element.getText();
        a.moveToElement(element).perform();
        Thread.sleep(3000);
        // Click on the login link  
        driver.findElement(By.xpath("//a[text() = 'login']")).click();
        Thread.sleep(3000);
        // Switch to the login iframe
        driver.switchTo().frame("loginIframe");
        // Enter the username
        driver.findElement(By.id("userName")).sendKeys("testingmehameed@gmail.com");
        // Click on the Continue button
        driver.findElement(By.xpath("//button[@id='checkUser']")).click();
        Thread.sleep(12000);
        // Enter OTP and Click on the "Continue" button
        driver.findElement(By.xpath("//form[@id='loginOtpUC']//button[contains(@class , 'continueBtn')]")).click();
        Thread.sleep(5000);
        // Get the URL after signing in
        String URLafterSignIn = driver.getCurrentUrl();
        System.out.println("URL Before signing in "+initialURL);
        System.out.println("URL After signing in "+URLafterSignIn);
        // Check if the user is successfully logged in
        if (URLafterSignIn.contains("success")) {
        	System.out.println("User successfully logged In");
		} else {
			System.out.println("log In attempt failed");
		}
        // Wait for the account username element to be visible and print it, also handle exception if occurs
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element1 = driver.findElement(By.xpath("//span[contains(@class , 'accountUserName')]"));
            wait.until(ExpectedConditions.visibilityOf(element1));
            String afterLogin = element1.getText();
            System.out.println("Before login $ "+beforeLogin+" $ is mentioned near profile icon");
            System.out.println("After login user $ "+afterLogin+" $ profile name is visible");
		} catch (NoSuchElementException e) {
		      e.printStackTrace();
			  System.out.println(e.getMessage());
			  System.out.println(e.getClass());
		}
        // Close the browser
        driver.close();
	}
}
