package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestIFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		webDriver.get ( "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get" );
		System.out.println ( webDriver.findElements ( By.tagName ( "iframe" ) ).size ( ) );
		webDriver.switchTo ( ).frame ( "iframeResult" );
//		webDriver.findElement ( By.xpath ( "/html/body/button" ) ).click ( );
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
		javascriptExecutor.executeScript ( "myFunction()" );
		javascriptExecutor.executeScript ( "arguments[0].style.border='2px solid red'",
				webDriver.findElement ( By.xpath ( "//input[@id='mySubmit']" ) ) );

		// System.out.println(webDriver.findElements(By.tagName("iframe")).size());
	}
}
