package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBrowsers {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		if (browser.equals ( "chrome" )) {
			WebDriverManager.chromedriver ( ).setup ( );
			driver = new ChromeDriver ( );
		} else if (browser.equals ( "firefox" )) {
			WebDriverManager.firefoxdriver ( ).setup ( );
			driver = new FirefoxDriver ( );
		} else if (browser.equals ( "ie" )) {
			WebDriverManager.iedriver ( ).setup ( );
			driver = new InternetExplorerDriver ( );
		} else if (browser.equals ( "safari" )) {
			WebDriverManager.safaridriver ( ).setup ( );
			driver = new SafariDriver ( );
		}

		driver.get ( "http://way2automation.com" );
		String title = driver.getTitle ( );
		System.out.println ( title.length ( ) );
		System.out.println ( title );
		driver.close ( );    // current browser window
		driver.quit ( );    // current browser window + all related browser in the same session
	}

}
