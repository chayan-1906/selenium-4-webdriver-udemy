package screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class TestScrollScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.get ( "https://www.selenium.dev/" );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		WebElement webElement = webDriver.findElement ( By.xpath ( "/html/body/div/main/div[4]" ) );
		AShot aShot = new AShot ( ).shootingStrategy ( ShootingStrategies.viewportPasting ( 1000 ) );
		Screenshot screenshot = aShot.takeScreenshot ( webDriver, webElement );
		ImageIO.write ( screenshot.getImage ( ), "png",
				new File ( "./screenshot/" + LocalDateTime.now ( ) + "_scrollScreenshot.png" ) );
	}
}
