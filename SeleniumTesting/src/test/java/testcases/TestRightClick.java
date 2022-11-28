package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestRightClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://deluxe-menu.com/popup-mode-sample.html" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		WebElement img = webDriver.findElement ( By.xpath ( "/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img" ) );

		Actions actions = new Actions ( webDriver );
		actions.contextClick ( img ).perform ( );
		Thread.sleep ( 3000 );

		WebElement productInfo =
				webDriver.findElement ( By.xpath ( "//td[@id='dm2m1i1tdT' and text()='Product Info']" ) );
		productInfo.click ( );
		Thread.sleep ( 3000 );

		WebElement installation = webDriver.findElement ( By.xpath ( "//td[@id='dm2m2i1tdT' and text()='Installation']" ) );
		installation.click ( );
		Thread.sleep ( 3000 );

		WebElement howToSetup = webDriver.findElement ( By.xpath ( "//td[@id='dm2m3i1tdT' and text()='How To Setup']" ) );
		howToSetup.click ( );

	}
}
