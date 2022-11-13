package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.way2automation.com/way2auto_jquery/index.php");

		/*
		 * WebElement aboveInput =
		 * driver.findElement(with(By.tagName("input"))
		 * .above(By.tagName("select")));
		 * aboveInput.sendKeys("padmanabhadas9647@gmail.com");
		 * WebElement belowInput = driver
		 * .findElement(with(By.tagName("input"))
		 * .below(By.tagName("select"))); belowInput.
		 * sendKeys("Ayyappa Society, Madhapur, Telengana, 500081");
		 * 
		 * // WebElement near = driver.findElement( //
		 * RelativeLocator.with(By.partialLinkText("THE")).near(By.
		 * linkText("Signin"))); // near.click();
		 * 
		 * WebElement rightOf = driver.findElement(with(
		 * By.xpath("//input[@type='password']"))
		 * .toRightOf(By.tagName("label"))); rightOf.sendKeys("123456");
		 * 
		 * WebElement leftOf = driver.findElement(
		 * with(By.linkText("Signin")).toLeftOf(By.xpath(
		 * "(//*[@id=\"load_form\"]/div[1]/div[2]/input)[2]")));
		 * leftOf.click(); System.out.println("clicked");
		 */

		driver.findElement(with(By.tagName("input"))
				.above(By.linkText("Signin"))
				.below(By.xpath("(//*[@id=\"load_form\"]/fieldset[6]/input)[1]")))
				.sendKeys("password");
		// Thread.sleep(10);
		// driver.quit();
	}
}
