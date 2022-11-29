package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.get ( "https://mail.rediff.com/cgi-bin/login.cgi" );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		webDriver.findElement ( By.name ( "proceed" ) ).click ( );
		/*Alert alert = webDriver.switchTo ( ).alert ( );
		System.out.println ( alert.getText ( ) );
		alert.accept ( );*/
		WebDriverWait webDriverWait = new WebDriverWait ( webDriver, Duration.ofSeconds ( 10 ) );
		Alert alert = webDriverWait.until ( ExpectedConditions.alertIsPresent ( ) );
		System.out.println ( alert.getText ( ) );
		alert.accept ( );
	}
}
