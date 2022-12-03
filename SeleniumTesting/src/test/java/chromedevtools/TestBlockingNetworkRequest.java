package chromedevtools;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.Optional;

public class TestBlockingNetworkRequest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );

		devTools.send ( Network.enable ( Optional.empty ( ), Optional.empty ( ), Optional.empty ( ) ) );
		devTools.send ( Network.setBlockedURLs ( ImmutableList.of ( ".png", ".jpg", ".jpeg" ) ) );

		webDriver.get ( "http://makemytrip.com" );
	}
}
