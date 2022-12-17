package testcases;

import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {

	@Test(priority = 1, groups = {"functional", "snoke"})
	public void doUserReg() {
		System.out.println ( "Executing User Reg test" );
//		Assert.fail ( "User not registered successfully" );
	}

	@Test(priority = 2, dependsOnMethods = "doUserReg", groups = {"functional", "smoke"})
	public void doLogin() {
		System.out.println ( "Executing login test" );
	}

	@Test(priority = 3, alwaysRun = true, groups = {"functional", "smoke"})
	public void thirdTest() {
		System.out.println ( "Executing third test" );
	}

	@Test(priority = 4, groups = "bvt")
	public void fourthTest() {
		System.out.println ( "Executing fourth test" );
	}

}
