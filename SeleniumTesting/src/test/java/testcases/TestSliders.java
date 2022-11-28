package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestSliders {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://jqueryui.com/resources/demos/slider/default.html" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		WebElement slider = webDriver.findElement ( By.id ( "slider" ) );
		int width = slider.getSize ( ).width / 4;
		System.out.println ( slider.getSize ().width + " " + width );
		Thread.sleep ( 3000 );
		new Actions ( webDriver ).dragAndDropBy ( slider, width, 0 ).perform ( );
	}
}
