package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver driver = new ChromeDriver ( );
		driver.get ( "https://money.rediff.com/gainers/bsc/daily/groupa" );
		driver.manage ( ).window ( ).maximize ( );
		driver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		List<WebElement> rowNum = driver.findElements ( By.xpath ( "//table[@class='dataTable']/tbody/tr" ) );
		System.out.println ( "Total rows are: " + rowNum.size ( ) );

		List<WebElement> colNum = driver.findElements ( By.xpath ( "//table[@class='dataTable']/tbody/tr[1]/td" ) );
		System.out.println ( "Total columns are: " + colNum.size ( ) );

		for (int row = 1; row <= rowNum.size ( ); row++) {
			for (int col = 1; col <= colNum.size ( ); col++) {
				System.out.print ( driver.findElement ( By.xpath ( "//table[@class='dataTable']/tbody/tr[" + row + "]/td[" + col + "]" ) ).getText ( ) );
			}
			System.out.println ( );
		}

	}

}
