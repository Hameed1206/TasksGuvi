package MavenFirst.MavenProjectOne;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
//TASK 18 QUE 2-->
public class Task18DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to jQueryUI webPage
        driver.get("https://jqueryui.com/droppable/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Switch to the iframe containing the droppable element
        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        // Find the droppable element
        WebElement dropElement = driver.findElement(By.cssSelector("div[id='droppable']"));
        // Get the color and text of the droppable element before drag and drop
        String colorBefore = dropElement.getCssValue("background");
        System.out.println("Color property BEFORE drag and drop operation : : : : "+colorBefore);
        
        String textBefore = dropElement.getText();
        System.out.println("Text in drop box BEFORE drag and drop operation : : : "+textBefore);
        
        // Find the draggable element
        WebElement dragElement = driver.findElement(By.cssSelector("div[id='draggable']"));
        // Instantiate Actions class to Perform drag and drop action
        Actions act = new Actions(driver);
        act.dragAndDrop(dragElement, dropElement).perform();
        // Get the color and text of the droppable element after drag and drop
        String colorAfter = dropElement.getCssValue("background");
        System.out.println("Color property AFTER drag and drop operation  : : : : "+colorAfter);
        
        String textAfter = dropElement.getText();
        System.out.println("Text in drop box AFTER drag and drop operation  : : : "+textAfter);
        
        // Check if the color of the drop element is changed
        if (!colorBefore.equals(colorAfter)) {
			System.out.println("Color of the drop element is changed");
		}else { System.out.println("Color remains unchanged");     }
        // Print the change in text of the drop box
        System.out.println("Text in the drop box is changed from ("+textBefore+") -> to -> ("+textAfter+ ") once drag and drop operation is performed");
        // Close the WebDriver instance
        driver.close();
        
	}

}
