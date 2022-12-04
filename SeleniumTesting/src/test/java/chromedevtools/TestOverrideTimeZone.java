package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class TestOverrideTimeZone {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.get ( "https://webbrowsertools.com/timezone/" );
		Thread.sleep ( 5000 );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );
		devTools.send ( Emulation.setTimezoneOverride ( "EST" ) );
		webDriver.get ( "https://webbrowsertools.com/timezone/" );

	}
}
