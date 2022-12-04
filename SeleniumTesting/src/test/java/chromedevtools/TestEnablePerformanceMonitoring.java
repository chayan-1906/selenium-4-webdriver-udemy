package chromedevtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.Performance.EnableTimeDomain;
import org.openqa.selenium.devtools.v85.performance.model.Metric;

import java.util.List;
import java.util.Optional;

public class TestEnablePerformanceMonitoring {

	public static void main(String[] args) {

		WebDriverManager.chromedriver ( ).setup ( );
		WebDriver webDriver = new ChromeDriver ( );
//		webDriver.manage ( ).window ( ).maximize ( );

		DevTools devTools = ((ChromeDriver) webDriver).getDevTools ( );
		devTools.createSession ( );

		devTools.send ( Performance.enable ( Optional.of ( EnableTimeDomain.TIMETICKS ) ) );

		webDriver.get ( "https://google.com" );

		List<Metric> metrics = devTools.send ( Performance.getMetrics ( ) );

		metrics.forEach ( metric -> {
			System.out.println ( metric.getName ( ) + " " + metric.getValue ( ) );
		} );
	}
}
