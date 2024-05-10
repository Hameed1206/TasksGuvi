package MavenFirst.MavenProjectOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 20 QUE 2
public class Task20GuviRegisterAndLogin {

	static String name = "Hameed Hussain";
	static String email = "hameed@gmail.com";
	static String password = "ham1eed";
	static String mobNo = "7897897890";
	public static void main(String[] args) throws InterruptedException {
		
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to GUVI webPage
        driver.get("https://www.guvi.in/");
        // Maximize the browser window
        driver.manage().window().maximize();
        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //print title and URL
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("");
        //clcik sign up button
        driver.findElement(By.xpath("//li//a[text() = 'Sign up']")).click();
        //print title and URL
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("");
        // fill the registration form
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("form>div.form-group:nth-child(3)>input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text() = 'Mobile number']/parent::div//input")).sendKeys(mobNo);
        driver.findElement(By.xpath("//a[@class = 'btn signup-btn']")).click();
        Thread.sleep(5000);
        //vaerify the registration and print
        String text = driver.findElement(By.className("sub-head")).getText();
        System.out.println(text);
        System.out.println("");
        //print title and URL
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //navigate back
        driver.navigate().back();
        //cliack login button
        driver.findElement(By.xpath("//li//a[text() = 'Login']")).click();
        //login with valid credentials
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.id("login-btn")).click();
        // close the browser
        //driver.close();
 
	}

}
