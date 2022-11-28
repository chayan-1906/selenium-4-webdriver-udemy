package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://www.google.co.in/" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );
		Thread.sleep ( 5000 );
		webDriver.manage ( ).window ().setSize ( new Dimension ( 800, 800 ) );
	}
}
