package MavenFirst.MavenProjectOne;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.id("browse")).click();
        Runtime.getRuntime().exec("C:\\Users\\91936\\Desktop\\Git clone JAT file\\JATMarch2023\\Upload.exe");

	}

}
