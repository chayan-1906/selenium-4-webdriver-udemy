package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

// TODO: Select All
public class TestSelectAll {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.get ( "https://www.youtube.com/" );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		WebElement page = webDriver.findElement ( By.xpath ( "//*[@id='page-manager']" ) );
		System.out.println ( page.isEnabled ( ) + "          " + page.isDisplayed ( ) );

		Actions actions = new Actions ( webDriver );
		actions.click ( page ).perform ( );
		actions.sendKeys ( page, Keys.chord ( Keys.CONTROL + "a" ) ).perform ();
//		actions.keyDown ( Keys.CONTROL ).sendKeys ( "a" ).perform ( );
	}
}
