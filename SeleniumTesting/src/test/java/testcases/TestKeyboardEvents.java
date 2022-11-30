package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

// TODO: Click issue outside input field. Section 18 Video 172.
public class TestKeyboardEvents {

	public static void main(String[] args) {
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.get ( "http://gmail.com" );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		WebElement emailInput = webDriver.findElement ( By.id ( "identifierId" ) );
		emailInput.sendKeys ( "padmanabhadas9647@gmail.com" );

		WebElement outsideGmailInput = webDriver.findElement ( By.className ( "rhhJr" ) );
		System.out.printf ( outsideGmailInput.getText ( ) );

		Actions actions = new Actions ( webDriver );
		actions.keyDown ( outsideGmailInput, Keys.CONTROL ).sendKeys ( "a" ).sendKeys ( "c" ).perform ( );
		actions.keyDown ( emailInput, Keys.CONTROL ).sendKeys ( "v" ).perform ( );

//		actions.click ( outsideGmailInput ).perform ( );
//		actions.sendKeys ( Keys.chord ( Keys.CONTROL + "a" ) ).sendKeys ( Keys.chord ( Keys.CONTROL + "c" ) ).perform ( );
//		emailInput.click ( );
//		actions.sendKeys ( Keys.chord ( Keys.CONTROL + "v" ) ).perform ( );
//		actions.sendKeys ( Keys.ENTER ).perform ( );
	}
}
