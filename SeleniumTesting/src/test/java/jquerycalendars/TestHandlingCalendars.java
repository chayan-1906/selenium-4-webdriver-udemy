package jquerycalendars;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class TestHandlingCalendars {

	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int currentDay = 0, currentMonth = 0, currentYear = 0;

	static int jumpMonthBy = 0;

	static Calendar currentCalendar;

	static Calendar targetCalendar;

	static boolean increment = true;

	public static void getCurrentDateMonthYear() {
		Calendar calendar = Calendar.getInstance ( );
		currentDay = calendar.get ( Calendar.DAY_OF_MONTH );
		currentMonth = calendar.get ( Calendar.MONTH ) + 1;
		currentYear = calendar.get ( Calendar.YEAR );

		currentCalendar = Calendar.getInstance ( );
		currentCalendar.set ( Calendar.DATE, currentDay );
		currentCalendar.set ( Calendar.MONTH, currentMonth );
		currentCalendar.set ( Calendar.YEAR, currentYear );
	}

	public static void getTargetDateMonthYear(String dateString) {
		int firstIndex = dateString.indexOf ( "/" );
		int lastIndex = dateString.lastIndexOf ( "/" );

		String day = dateString.substring ( 0, firstIndex );
		targetDay = Integer.parseInt ( day );

		String month = dateString.substring ( firstIndex + 1, lastIndex );
		targetMonth = Integer.parseInt ( month );

		String year = dateString.substring ( lastIndex + 1 );
		targetYear = Integer.parseInt ( year );

		targetCalendar = Calendar.getInstance ( );
		targetCalendar.set ( Calendar.DATE, targetDay );
		targetCalendar.set ( Calendar.MONTH, targetMonth );
		targetCalendar.set ( Calendar.YEAR, targetYear );
	}

	public static void calculateMonthsToJump() {
		Date currentDate = currentCalendar.getTime ( );
		Date targetDate = targetCalendar.getTime ( );
		if (targetDate.after ( currentDate )) {
			jumpMonthBy =
					(targetCalendar.get ( Calendar.YEAR ) - currentCalendar.get ( Calendar.YEAR )) * 12 +
							(targetCalendar.get ( Calendar.MONTH ) - currentCalendar.get ( Calendar.MONTH )) % 12;
		} else {
			jumpMonthBy =
					(currentCalendar.get ( Calendar.YEAR ) - targetCalendar.get ( Calendar.YEAR )) * 12 +
							(currentCalendar.get ( Calendar.MONTH ) - targetCalendar.get ( Calendar.MONTH )) % 12;
			increment = false;
		}
//		System.out.println ( "jump month by: " + jumpMonthBy );
	}

	public static void main(String[] args) throws InterruptedException {

		String dateToSet = "14/12/2025";

		// get current date
		getCurrentDateMonthYear ( );
		System.out.println ( currentDay + "/" + currentMonth + "/" + currentYear );

		// get target date
		getTargetDateMonthYear ( dateToSet );
		System.out.println ( targetDay + "/" + targetMonth + "/" + targetYear );

		// get jump month
		calculateMonthsToJump ( );
		System.out.println ( jumpMonthBy );

		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://www.way2automation.com/way2auto_jquery/datepicker.php#load_box" );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );

		webDriver.switchTo ( ).frame ( 0 );
		WebElement datepickerInput = webDriver.findElement ( By.id ( "datepicker" ) );
		datepickerInput.click ( );

		for (int i = 0; i < jumpMonthBy; i++) {
			if (increment) {
				// click next button
				webDriver.findElement ( By.xpath ( "//a[@title='Next']" ) ).click ( );
			} else {
				// click previous button
				webDriver.findElement ( By.xpath ( "//a[@title='Prev']" ) ).click ( );
			}
		}
		webDriver.findElement ( By.linkText ( Integer.toString ( targetDay ) ) ).click ( );
	}
}
