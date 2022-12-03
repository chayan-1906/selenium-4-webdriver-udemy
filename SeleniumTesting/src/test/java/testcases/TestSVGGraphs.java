package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class TestSVGGraphs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		webDriver.get ( "https://www.covid19india.org/" );
		List<WebElement> graphPoints = webDriver.findElements ( By.xpath ( "(//*[name()='svg' and @preserveAspectRatio='xMidYMid meet'])[6]//*[name()='circle']" ) );
		Actions actions = new Actions ( webDriver );
		for (WebElement point : graphPoints) {
			actions.moveToElement ( point ).perform ( );
			System.out.println ( webDriver.findElement ( By.xpath ( "//div[@class='stats is-confirmed']/h5[2]" ) ).getText ( ) );
		}
	}
}
