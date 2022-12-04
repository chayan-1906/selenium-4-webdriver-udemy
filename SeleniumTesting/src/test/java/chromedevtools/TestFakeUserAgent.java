package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.util.Optional;

public class TestFakeUserAgent {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
//		webDriver.manage ( ).window ( ).maximize ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );
		devTools.send ( Network.emulateNetworkConditions ( false, 100, 20000, 10000, Optional.of ( ConnectionType.CELLULAR4G ) ) );

		String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36";
		devTools.send ( Network.setUserAgentOverride ( userAgent, Optional.empty ( ), Optional.empty ( ), Optional.empty ( ) ) );

		webDriver.get ( "https://www.whatismybrowser.com/detect/what-is-my-user-agent/" );
	}
}
