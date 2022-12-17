package regression;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {

	@Test
	public void validateTitles() {
		String expectedTitle = "Yahoo.com"; // excel
		String actualTitle = "Gmail.com"; // selenium

		/*
		 * if (expectedTitle.equals(actualTitle)) {
		 * System.out.println("Test case passes"); } else {
		 * System.out.println("Test case fails"); }
		 */
		Assert.assertEquals ( actualTitle, expectedTitle );
	}

}
