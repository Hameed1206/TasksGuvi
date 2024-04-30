package MavenFirst.MavenProjectOne;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
//Task 18 QUE 1 -->
public class Task18Facebook {

	public static void main(String[] args) throws InterruptedException {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to Facebook homepage
        driver.get("https://www.facebook.com/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Get the title of the webpage and print it
        String title = driver.getTitle();
        System.out.println(title);
        // Check if landed on Facebook login page
        if (title.equals("Facebook – log in or sign up")) {
        	System.out.println("Landed in Facebook login page");
		} else {
        	System.out.println("Landed in incorrect webpage, Kindly check your URL");
        }
        // Click on the "Create New Account" link
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(3000);
        // Fill in the registration form
        driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("Hamd");
        driver.findElement(By.name("lastname")).sendKeys("Husn");
        driver.findElement(By.name("reg_email__")).sendKeys("letsdoautotesting@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("resu@tset26");
        // Select date of birth
        WebElement enterDate = driver.findElement(By.id("day"));
        WebElement enterMonth = driver.findElement(By.id("month"));
        WebElement enterYear = driver.findElement(By.id("year"));
        // Instantiate select class to perform drop down selection
        Select sd = new Select(enterDate);
        sd.selectByValue("11");
        Select sm = new Select(enterMonth);
        sm.selectByIndex(4);
        Select sy = new Select(enterYear);
        sy.selectByVisibleText("1985");
        // Select gender
        driver.findElement(By.xpath("//label[text() = 'Male']")).click();
        // Confirm email
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("letsdoautotesting@gmail.com");
        // Click on the "Sign Up" button
        driver.findElement(By.name("websubmit")).click();
        // Wait until the page navigates to next page and print the user name
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = driver.findElement(By.xpath("(//div[@aria-label = 'Account controls and settings'] //span[contains(@class, 'x1lliihq')])[1]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText();
        System.out.println(text);
        // Close the browser
        driver.close();
        

	}

}
