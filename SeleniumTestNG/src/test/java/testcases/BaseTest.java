package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	@BeforeMethod
	@BeforeSuite
	public void setUp() {
		System.out.println ( "Initializing Everything" );
	}

	@AfterMethod
	@AfterSuite
	public void tearDown() {
		System.out.println ( "Quitting Everything" );
	}
}
