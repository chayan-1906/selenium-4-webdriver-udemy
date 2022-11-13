package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.withMessage("Time out as condition didn't meet")
				.ignoring(NoSuchElementException.class);
		driver.get("http://gmail.com");
		WebElement userName = driver.findElement(By.id("identifierId"));
		userName.sendKeys("padmanabhadas9647@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("abcd");
		// explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).sendKeys("password");
		driver.quit();
	}

}
