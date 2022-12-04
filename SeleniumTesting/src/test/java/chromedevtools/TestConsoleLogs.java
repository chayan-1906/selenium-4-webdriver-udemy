package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.console.Console;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.util.Optional;

public class TestConsoleLogs {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
//		webDriver.manage ( ).window ( ).maximize ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );
		devTools.send ( Network.emulateNetworkConditions ( false, 100, 20000, 10000,
				Optional.of ( ConnectionType.CELLULAR4G ) ) );

		devTools.send ( Log.enable ( ) );
		devTools.send ( Console.enable ( ) );
		devTools.addListener ( Log.entryAdded ( ), logEntry -> {
			System.out.println ( "Text is: " + logEntry.getText ( ) );
			System.out.println ( "Timestamp is: " + logEntry.getTimestamp ( ) );
			System.out.println ( "Source is: " + logEntry.getSource ( ) );
			System.out.println ( "Level is: " + logEntry.getLevel ( ) );
		} );
		devTools.addListener ( Console.messageAdded ( ), messageText -> {
			System.out.println ( "Message text is: " + messageText.getText ( ) );
		} );
		webDriver.get ( "http://flipkart.com" );
		((JavascriptExecutor) webDriver).executeScript ( "console.log('This is a sample log')" );
	}
}
