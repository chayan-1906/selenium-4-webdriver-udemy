package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.util.Optional;

public class TestNetworkSpeed {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );

		devTools.send ( Network.enable ( Optional.empty ( ), Optional.empty ( ), Optional.empty ( ) ) );
		devTools.send ( Network.emulateNetworkConditions ( false, 100, 20000, 10000,
				Optional.of ( ConnectionType.CELLULAR2G ) ) );

		webDriver.get ( "http://way2automation.com" );
	}
}
