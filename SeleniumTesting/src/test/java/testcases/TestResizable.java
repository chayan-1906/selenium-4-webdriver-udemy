package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestResizable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://jqueryui.com/resources/demos/resizable/default.html" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		WebElement resizable = webDriver.findElement ( By.xpath ( "//*[@id='resizable']/div[3]" ) );
		Actions actions = new Actions ( webDriver );
		actions.dragAndDropBy ( resizable, 400, 400 ).perform ( );
	}
}
