package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestDeviceMetrics {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );

		devTools.send ( Emulation.setDeviceMetricsOverride ( 375, 812, 50, true, Optional.empty ( ), Optional.empty ( ),
				Optional.empty ( ), Optional.empty ( ), Optional.empty ( ), Optional.empty ( ), Optional.empty ( ), Optional.empty ( ) ) );

		Map<String, Object> deviceMetrics = new HashMap<String, Object> ( ) {
			{
				put ( "width", 372 );
				put ( "height", 812 );
				put ( "mobile", true );
				put ( "deviceScaleFactor", 50 );
			}
		};
		((ChromeDriver) webDriver).executeCdpCommand ( "Emulation.setDeviceMetricsOverride", deviceMetrics );
		webDriver.get ( "https://selenium.dev/" );
	}
}
