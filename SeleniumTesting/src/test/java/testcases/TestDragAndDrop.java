package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestDragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver ( ).setup ( );
		WebDriver webDriver = new FirefoxDriver ( );
		webDriver.get ( "https://jqueryui.com/resources/demos/droppable/default.html" );
		webDriver.manage ( ).window ( ).maximize ( );
		webDriver.manage ( ).timeouts ( ).implicitlyWait ( 10, TimeUnit.SECONDS );

		WebElement draggable = webDriver.findElement ( By.id ( "draggable" ) );
		WebElement droppable = webDriver.findElement ( By.id ( "droppable" ) );

		Actions actions = new Actions ( webDriver );
		actions.dragAndDrop ( draggable, droppable ).perform ( );
	}
}
