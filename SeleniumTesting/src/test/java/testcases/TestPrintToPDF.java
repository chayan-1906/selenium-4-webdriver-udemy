package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class TestPrintToPDF {

	public static void main(String[] args) throws IOException {

		ChromeOptions chromeOptions = new ChromeOptions ( );
		chromeOptions.addArguments ( "headless" );

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( chromeOptions );
		driver.manage ( ).window ( ).maximize ( );
		driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		driver.get ( "https://selenium.dev" );
		Pdf pdf = ((PrintsPage) driver).print ( new PrintOptions ( ) );
		Files.write ( Paths.get ( "./selenium.pdf" ), OutputType.BYTES.convertFromBase64Png ( pdf.getContent ( ) ) );
	}

}
