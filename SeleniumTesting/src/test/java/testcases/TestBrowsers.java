package testcases;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://way2automation.com");
	}
	
}
