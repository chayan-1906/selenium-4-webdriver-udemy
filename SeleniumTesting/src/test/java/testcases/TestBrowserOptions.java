package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestBrowserOptions {

	public static void main(String[] args) {
		Map<String, String> mobileEm = new HashMap<> ( );
		mobileEm.put ( "deviceName", "iPhone X" );

		ChromeOptions chromeOptions = new ChromeOptions ( );
//		chromeOptions.addArguments ( "--headless" );
		chromeOptions.setAcceptInsecureCerts ( true );
//		chromeOptions.addArguments ( "window-size=1400,1000" );
		chromeOptions.addArguments ( "incognito" );
		chromeOptions.setExperimentalOption ( "excludeSwitches", Collections.singletonList ( "enable-automation" ) );
		chromeOptions.setExperimentalOption ( "mobileEmulation", mobileEm );

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( chromeOptions );
		webDriver.get ( "http://selenium.dev" );
		System.out.println ( webDriver.getTitle ( ) );
	}

}
