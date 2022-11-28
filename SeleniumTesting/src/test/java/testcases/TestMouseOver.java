package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestMouseOver {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "http://google.com" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		/* Google Search input field */
		webDriver.findElement ( By.name ( "q" ) ).sendKeys ( "Way2Automation" );
		/* google search button */
		WebDriverWait webDriverWait = new WebDriverWait ( webDriver, Duration.ofSeconds ( 5 ) );
		webDriverWait.until ( ExpectedConditions.visibilityOfElementLocated ( By.xpath ( "//div[@class='FPdoLc " +
				"lJ9FBc']//input[@name='btnK']" ) ) ).click ( );
//		webDriver.findElement ( By.xpath ( "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']" ) ).click ( );
		/* Way2Automation: Get Online Selenium Certification Course */
		webDriver.findElement ( By.xpath ( "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1" +
				"]/a/h3" ) ).click ( );
		WebElement menu = webDriver.findElement ( By.xpath ( "//li[@id='menu-item-27617']/a/span[@class='menu-text' and text()='Resources']" ) );
		Actions actions = new Actions ( webDriver );
		actions.moveToElement ( menu ).perform ( );
		webDriverWait.until ( ExpectedConditions.visibilityOfElementLocated ( By.xpath ( "//li" +
				"[@id='menu-item-27618']/a/span[@class='menu-text' and text()='Practice Site 1']" ) ) ).click ( );
//		webDriver.findElement ( By.linkText ( "Practice Site 1" ) ).click ( );

//		Thread.sleep ( 4000 );
//		webDriver.quit ( );
	}
}
