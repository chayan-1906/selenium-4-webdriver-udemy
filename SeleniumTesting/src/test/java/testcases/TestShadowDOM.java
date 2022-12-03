package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestShadowDOM {

	public static void main(String[] args) {
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		webDriver.get ( "chrome://downloads/" );
		/*WebElement root1 = webDriver.findElement ( By.cssSelector ( "downloads-manager" ) );
		WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor) webDriver).executeScript ( "return arguments[0]" +
				".shadowRoot", root1 );

		WebElement root2 = shadowRoot1.findElement ( By.cssSelector ( "downloads-toolbar" ) );
		WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor) webDriver).executeScript ( "return arguments[0]" +
				".shadowRoot", root2 );

		WebElement root3 = shadowRoot2.findElement ( By.cssSelector ( "cr-toolbar" ) );
		WebElement shadowRoot3 = (WebElement) ((JavascriptExecutor) webDriver).executeScript ( "return arguments[0]" +
				".shadowRoot", root3 );

		WebElement root4 = shadowRoot3.findElement ( By.cssSelector ( "cr-toolbar-search-field" ) );
		WebElement shadowRoot4 = (WebElement) ((JavascriptExecutor) webDriver).executeScript ( "return arguments[0]" +
				".shadowRoot", root4 );

		shadowRoot4.findElement ( By.id ( "searchInput" ) ).sendKeys ( "Hello" );*/

		WebElement input = (WebElement) ((JavascriptExecutor) webDriver).executeScript ( "return document.querySelector" +
				"('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar')" +
				".shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('#searchInput')" );
		input.sendKeys ( "hello" );
	}
}
