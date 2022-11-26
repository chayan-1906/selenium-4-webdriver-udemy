package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
 * Navigate to https://timesofindia.indiatimes.com/poll.cms
 * Handle the text captcha
 * add the numbers
 * handle the operators +, - and *
 */

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( );
		driver.manage ( ).window ( ).maximize ( );
		driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		driver.get ( "https://timesofindia.indiatimes.com/poll.cms" );
	}

}
