package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

// TODO: Switch To an Unnamed iframe. Section 18 Video 174.
public class TestSwitchToUnnamedIFrame {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		webDriver.switchTo ( ).frame ( "iframeResult" );
		webDriver.findElement ( By.xpath ( "/html/body/button" ) ).click ( );

		webDriver.switchTo ( ).defaultContent ( );

		List<WebElement> iframes = webDriver.findElements ( By.tagName ( "iframe" ) );
		System.out.println ( iframes.size ( ) );
		for (WebElement iframe : iframes) {
			System.out.println ( "iframe ------------> " + iframe.getAttribute ( "name" ) );
		}
	}
}
