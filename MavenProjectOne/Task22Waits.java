package MavenFirst.MavenProjectOne;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
//Task 22 QUE 1
public class Task22Waits {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to PHP webPage
        driver.get("https://phptravels.com/demo/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Instantiating WebDriver wait to wait for particular element
        WebDriverWait w = new WebDriverWait(driver , Duration.ofSeconds(10));
        // Entering values in registration form
        WebElement fName = driver.findElement(By.name("first_name"));
        w.until(ExpectedConditions.visibilityOf(fName));
        fName.sendKeys("Hameed");
        
        WebElement lName = driver.findElement(By.name("last_name"));
        w.until(ExpectedConditions.visibilityOf(lName));
        lName.sendKeys("Hussain");
        
        WebElement bName = driver.findElement(By.name("business_name"));
        w.until(ExpectedConditions.visibilityOf(bName));
        bName.sendKeys("Information&Technology");
        
        WebElement eMail = driver.findElement(By.cssSelector("input[placeholder = 'Email']"));
        w.until(ExpectedConditions.visibilityOf(eMail));
        eMail.sendKeys("Hameed12@gmail.com");
        //Taking the sum values for web page
        WebElement sum = driver.findElement(By.xpath("//div//h4[contains(text() , ' ')]"));
        w.until(ExpectedConditions.visibilityOf(sum));
        String text = sum.getText();
        System.out.println("Sum text "+text);
        
        WebElement num1 = driver.findElement(By.id("numb1"));
        w.until(ExpectedConditions.visibilityOf(num1));
        String value1 = num1.getText();
        
        WebElement num2 = driver.findElement(By.id("numb2"));
        w.until(ExpectedConditions.visibilityOf(num2));
        String value2 = num2.getText();
        //Convert String to Int
        int int1 = Integer.parseInt(value1);
        int int2 = Integer.parseInt(value2);
        int result = int1+int2;
        System.out.println("Sum output "+result);
        //Convert Int to String
        String string = Integer.toString(result);
        WebElement numbR = driver.findElement(By.id("number"));
        w.until(ExpectedConditions.visibilityOf(numbR));
        numbR.sendKeys(string);
        //Click submit button
        WebElement button = driver.findElement(By.id("demo"));
        w.until(ExpectedConditions.visibilityOf(button));
        button.click();
        Thread.sleep(3000);
        //Get the Title of page and use it as file name
        String title = driver.getTitle();
        String path = "C:\\Users\\91936\\eclipse-workspace\\MavenProjectOne\\src\\test\\java\\MavenFirst\\MavenProjectOne\\Task 22\\"+title+".jpg";
        //Take screenshot and save it in a particular location
        TakesScreenshot tk = (TakesScreenshot)driver;  
        File file = tk.getScreenshotAs(OutputType.FILE);
        Files.copy(file, new File(path));
        //Close the webdriver instance
        driver.quit();
	}

}
