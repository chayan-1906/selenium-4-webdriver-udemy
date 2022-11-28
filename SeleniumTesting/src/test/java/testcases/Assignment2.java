package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
 * Navigate to qa.way2automation.com or https://way2automation.com/way2auto_jquery/index.php
 * on the registration form enter name and click on submit
 */

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( );
		driver.manage ( ).window ( ).maximize ( );
		driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		driver.get ( "https://way2automation.com/way2auto_jquery/index.php" );
		driver.findElement ( By.xpath ( "//input[@name='name']" ) ).sendKeys ( "Padmanabha Das" );
		driver.findElement ( By.xpath (
						"//div[@id='load_box']//input[@value='Submit']" ) )
				.click ( );
	}

}
