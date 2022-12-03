package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class TestMocGeoLocation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );

		devTools.send ( Emulation.setGeolocationOverride ( Optional.of ( 51.509865 ), Optional.of ( -0.118092 ),
				Optional.of ( 100 ) ) );

		webDriver.get ( "https://mycurrentlocation.net/" );
	}
}
