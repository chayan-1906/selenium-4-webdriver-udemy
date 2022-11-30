package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabsAndPopups {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
		webDriver.get ( "http://hdfcbank.com/" );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		System.out.println ( "----Generating window ids from first window----" );
		Set<String> winids = webDriver.getWindowHandles ( );
		Iterator<String> iterate = winids.iterator ( );
		String first_window = iterate.next ( );
		System.out.println ( first_window );

		webDriver.findElement ( By.id ( "loginsubmit" ) ).click ( );

		// 2nd window
		System.out.println ( "----Generating window ids from Second window----" );
		winids = webDriver.getWindowHandles ( );
		iterate = winids.iterator ( );
		System.out.println ( iterate.next ( ) ); // first window
		String second_window = iterate.next ( ); // second window
		System.out.println ( second_window );
		webDriver.switchTo ( ).window ( second_window );
		webDriver.findElement ( By.xpath ( "/html/body/div[4]/div[3]/div/div/div[1]/div/a" ) ).click ( );
		webDriver.findElement ( By.xpath ( "/html/body/div[1]/div[2]/div[2]/p[3]/a" ) ).click ( );

		// 3rd window
		System.out.println ( "----Generating window ids from third window----" );
		winids = webDriver.getWindowHandles ( );
		iterate = winids.iterator ( );
		System.out.println ( iterate.next ( ) ); // first window
		System.out.println ( iterate.next ( ) ); // second window
		String third_window = iterate.next ( ); //3rd window
		/*while(iterate.hasNext()) {
			iterate.next();
		}*/
		System.out.println ( third_window );
		webDriver.switchTo ( ).window ( third_window );

		System.out.println ( webDriver.getTitle ( ).contains ( "JetPrivilege HDFC Bank Signature" ) );
	}
}
