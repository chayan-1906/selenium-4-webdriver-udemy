package screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class TestElementScreenshot {

	public static WebDriver webDriver;

	public static void captureScreenshot(WebDriver webDriver) throws IOException {
		File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs ( OutputType.FILE );
		FileUtils.copyFile ( screenshot, new File ( "./screenshot/" + LocalDateTime.now ( ) + "_fullPage.png" ) );
	}

	public static void captureElementScreenshot(WebDriver webDriver) throws IOException {
		WebElement webElement = webDriver.findElement ( By.xpath ( "//img[@alt='Google']" ) );
		File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs ( OutputType.FILE );
		BufferedImage fullImg = ImageIO.read ( screenshot );
		Point point = webElement.getLocation ( );
		int eleWidth = webElement.getSize ( ).getWidth ( );
		int eleHeight = webElement.getSize ( ).getHeight ( );
		BufferedImage elementScreenshot = fullImg.getSubimage ( point.getX ( ), point.getY ( ), eleWidth, eleHeight );
		ImageIO.write ( elementScreenshot, "png", screenshot );
		File screenshotLocation = new File ( "./screenshot/" + LocalDateTime.now ( ) + "_element.png" );
		FileUtils.copyFile ( screenshot, screenshotLocation );
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );
		webDriver.get ( "http://google.com" );

		captureScreenshot ( webDriver );
		captureElementScreenshot ( webDriver );
	}
}
