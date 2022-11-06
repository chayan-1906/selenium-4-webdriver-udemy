package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://gmail.com");
		WebElement userName = driver.findElement(By.id("identifierId"));
		userName.sendKeys("padmanabhadas9647@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("abcd");
		driver.quit();
	}

}
