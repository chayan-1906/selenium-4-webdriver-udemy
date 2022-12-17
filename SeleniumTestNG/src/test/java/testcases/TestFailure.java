package testcases;

import org.testng.Assert;

public class TestFailure extends BaseTest {

	public void doLogin() {
		Assert.fail ( "Failing " );
	}
}
