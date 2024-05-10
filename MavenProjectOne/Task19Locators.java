package MavenFirst.MavenProjectOne;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 19 QUE 1 ->
public class Task19Locators {
	static WebDriver driver;
	//Assigning values to variables
	static String name = "Hameed Hussain";
	static String email = "hameed@gmail.com";
	static String password = "hameed1";
	static String mobNo = "7897897890";
	public Task19Locators() {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        driver = new ChromeDriver();
        // Navigate to Guvi webPage
        driver.get("https://www.guvi.in/register");
        // Maximize the browser window
        driver.manage().window().maximize();
	}
	// Method to fill registration form using ID 
	public void usingID() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 secs
		driver.findElement(By.id("name")).sendKeys(name);                  // enter name
		driver.findElement(By.id("email")).sendKeys(email);                // enter email
		driver.findElement(By.id("password")).sendKeys(password);          // enter password
		driver.findElement(By.id("mobileNumber")).sendKeys(mobNo);         // enter mobile number
		driver.findElement(By.id("signup-btn")).click();                   // click submit
		Thread.sleep(5000);                                                // wait 
        String text = driver.findElement(By.className("sub-head")).getText(); // validate the regirtration and print
        System.out.println("using ID : : : "+text);
        System.out.println("");
	}
	// Method to fill registration form using CSS selector ID
	public void usingCSSID() throws InterruptedException {
		Task19Locators run1 = new Task19Locators();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#name")).sendKeys(name);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#mobileNumber")).sendKeys(mobNo);
		driver.findElement(By.id("signup-btn")).click();
		Thread.sleep(5000);
        String text = driver.findElement(By.className("sub-head")).getText();
        System.out.println("using CSSID : : : "+text);
        System.out.println("");
	}
	// Method to fill registration form using Xpath with text
	public void usingTextXpath() throws InterruptedException {
		Task19Locators run1 = new Task19Locators();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//label[text() = 'Full Name']/parent::div/input")).sendKeys(name);
		driver.findElement(By.xpath("//label[text() = 'Email Address']/parent::div/input")).sendKeys(email);
		driver.findElement(By.xpath("//label[text() = 'Password']/parent::div/input")).sendKeys(password);
		driver.findElement(By.xpath("//label[text() = 'Mobile number']/parent::div//input")).sendKeys(mobNo);
		driver.findElement(By.xpath("(//a[text() = 'Sign Up'])[1]")).click();
		Thread.sleep(5000);
        String text = driver.findElement(By.className("sub-head")).getText();
        System.out.println("using xpath with text : : : "+text);
        System.out.println("");
	}
	// Method to fill registration form using Xpath with class name
	public void usingClassXpath() throws InterruptedException {
		Task19Locators run1 = new Task19Locators();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//input[contains(@class , 'form-control')])[1]")).sendKeys(name);
		driver.findElement(By.xpath("(//input[contains(@class , 'form-control')])[2]")).sendKeys(email);
		driver.findElement(By.xpath("(//input[contains(@class , 'form-control')])[3]")).sendKeys(password);
		driver.findElement(By.xpath("(//input[contains(@class , 'form-control')])[4]")).sendKeys(mobNo);
	    driver.findElement(By.xpath("//a[@class = 'btn signup-btn']")).click();
	    Thread.sleep(5000);
        String text = driver.findElement(By.className("sub-head")).getText();
        System.out.println("using xpath with class : : : "+text);
        System.out.println("");
	}
	// Method to fill registration form using Xpath with Tagname
	public void usingTagnameXpath() throws InterruptedException {
		Task19Locators run1 = new Task19Locators();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//input)[1]")).sendKeys(name);
		driver.findElement(By.xpath("(//input)[2]")).sendKeys(email);
		driver.findElement(By.xpath("(//input)[3]")).sendKeys(password);
		driver.findElement(By.xpath("(//input)[4]")).sendKeys(mobNo);
		driver.findElement(By.xpath("(//form//a)[1]")).click();
		Thread.sleep(5000);
        String text = driver.findElement(By.className("sub-head")).getText();
        System.out.println("using xpath with tagname : : : "+text);
        System.out.println("");
	}
	// Method to fill registration form using custom CSS selectors
	public void usingCustomizedCSSselector() throws InterruptedException {
		Task19Locators run1 = new Task19Locators();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("form>div.form-group:nth-child(1)>input")).sendKeys(name);
		driver.findElement(By.cssSelector("form>div.form-group:nth-child(2)>input")).sendKeys(email);
		driver.findElement(By.cssSelector("form>div.form-group:nth-child(3)>input")).sendKeys(password);
		driver.findElement(By.cssSelector("form:nth-last-of-type(1) div div input")).sendKeys(mobNo);
		driver.findElement(By.cssSelector("form>a")).click();
		Thread.sleep(5000);
        String text = driver.findElement(By.className("sub-head")).getText();
        System.out.println("using CSS Selector with customized class : : : "+text);
        System.out.println("");
	}
     // Main method to trigger execution
	public static void main(String[] args) throws InterruptedException {
        //Instantiated the class and calling all the methods
		Task19Locators run1 = new Task19Locators();
		run1.usingID();
		run1.usingCSSID();
		run1.usingTextXpath();
		run1.usingClassXpath();
		run1.usingTagnameXpath();
		run1.usingCustomizedCSSselector();
        
        

	}

}
