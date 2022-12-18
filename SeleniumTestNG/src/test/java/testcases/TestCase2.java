package testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest {

	@Test(groups = "smoke")
	public void validateTitles() {
		String expectedTitle = "Yahoo.com"; // excel
		String actualTitle = "Gmail.com"; // selenium

		/*
		 * if (expectedTitle.equals(actualTitle)) {
		 * System.out.println("Test case passes"); } else {
		 * System.out.println("Test case fails"); }
		 */
		AssertJUnit.assertEquals ( actualTitle, expectedTitle );
	}

}
