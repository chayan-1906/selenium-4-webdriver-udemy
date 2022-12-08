package screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class TestScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );
		webDriver.get ( "https://www.selenium.dev/documentation/webdriver/elements/" );

		File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs ( OutputType.FILE );
		FileUtils.copyFile ( screenshot, new File ( "./screenshot/" + LocalDateTime.now ( ) + ".png" ) );
	}
}
