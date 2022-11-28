package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/*
 * Navigate to Google
 * In google search type Way2Automation and click search, click on the very first link
 * print the links count and text from the page
 */

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( );
		driver.manage ( ).window ( ).maximize ( );
		driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		driver.get ( "http://www.google.com" );
		WebElement googleInputField = driver.findElement ( By.xpath ( "//input[@name='q']" ) );
		googleInputField.sendKeys ( "Way2Automation" );
		googleInputField.sendKeys ( Keys.ENTER );

		driver.findElement ( By.xpath ( "//a/h3[1]" ) ).click ( );
		List<WebElement> way2AutomationLinks = driver.findElements ( By.tagName ( "a" ) );
		System.out.println ( "No of links: " + way2AutomationLinks.size ( ) );
		System.out.println ( );
		int index = 0;
		for (WebElement way2AutomationLink : way2AutomationLinks) {
			String text = "";
			if (way2AutomationLink.getText ( ) != "") {
				text = way2AutomationLink.getText ( );
			} else {
				text = "---------------";
			}
			System.out.println ( (index + 1) + ". " + text );
			index++;
		}

	}

}
