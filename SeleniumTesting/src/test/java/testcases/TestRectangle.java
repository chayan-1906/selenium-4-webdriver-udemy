package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestRectangle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( );
//		driver.manage ( ).window ( ).maximize ( );
		driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		driver.get ( "http://gmail.com" );
		WebElement gmailLogo = driver.findElement ( By.xpath ( "//div[@id='logo']" ) );
		Rectangle rectangle = gmailLogo.getRect ( );
		System.out.println ( "Height: " + rectangle.getHeight ( ) );
		System.out.println ( "Width: " + rectangle.getWidth ( ) );
		System.out.println ( "X Coord: " + rectangle.getX ( ) );
		System.out.println ( "Y Coord: " + rectangle.getY ( ) );
	}
}
