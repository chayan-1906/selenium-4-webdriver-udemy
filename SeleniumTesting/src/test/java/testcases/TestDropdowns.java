package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( );
		// driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
		driver.get ( "https://www.wikipedia.org/" );
		driver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		// driver.findElement(By.name("country")).sendKeys("germany");

		System.out.println ( "DROPDOWN" );
		WebElement dropdown = driver.findElement ( By.id ( "searchLanguage" ) );
		Select select = new Select ( dropdown );
		select.selectByValue ( "hi" );
		List<WebElement> values = driver.findElements ( By.tagName ( "option" ) );
		System.out.println ( values.size ( ) );
		for (int index = 0; index < values.size ( ); index++) {
			System.out.println ( values.get ( index ).getText ( ) );
		}
		;

		System.out.println ( "\n\n\n\nHYPERLINKS" );
		List<WebElement> hyperlinks = driver.findElements ( By.tagName ( "a" ) );
		for (WebElement hyperlink : hyperlinks) {
			System.out.println ( hyperlink.getText ( ) + " ----> "
					+ hyperlink.getAttribute ( "href" ) );
		}

	}

}
