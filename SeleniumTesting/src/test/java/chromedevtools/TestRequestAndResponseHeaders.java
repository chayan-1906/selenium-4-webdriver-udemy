package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.devtools.v85.network.model.Headers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestRequestAndResponseHeaders {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
//		webDriver.manage ( ).window ( ).maximize ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );
		devTools.send ( Network.emulateNetworkConditions ( false, 100, 20000, 10000,
				Optional.of ( ConnectionType.CELLULAR4G ) ) );

		devTools.send ( Network.enable ( Optional.empty ( ), Optional.empty ( ), Optional.empty ( ) ) );

		devTools.addListener ( Network.requestWillBeSent ( ), requestWillBeSent -> {
			Headers headers = requestWillBeSent.getRequest ( ).getHeaders ( );
			if (!headers.isEmpty ( )) {
				System.out.println ( "Request headers: " );
				headers.forEach ( (key, value) -> {
					System.out.println ( " " + key + "= " + value );
				} );
			}
		} );

		devTools.addListener ( Network.responseReceived ( ), responseReceived -> {
			Headers headers = responseReceived.getResponse ( ).getHeaders ( );
			if (!headers.isEmpty ( )) {
				System.out.println ( "Response headers: " );
				headers.forEach ( (key, value) -> {
					System.out.println ( " " + key + "= " + value );
				} );
			}
			System.out.println ( "Response URL: " + responseReceived.getResponse ( ).getUrl ( ) + "status code: " + responseReceived.getResponse ( ).getStatus ( ) );
		} );

		Map<String, Object> headers = new HashMap<String, Object> ( );
		headers.put ( "customHeaderName", "custoHeaderValue" );
		headers.put ( "Padmanabha", "Automation Tester" );
		Headers head = new Headers ( headers );
		devTools.send ( Network.setExtraHTTPHeaders ( head ) );

		webDriver.get ( "https://reqres.in/api/users?page=2" );
	}
}
