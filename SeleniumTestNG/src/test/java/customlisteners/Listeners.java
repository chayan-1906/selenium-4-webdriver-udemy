package customlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {
	/**
	 * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	 * filled with the references to class, method, start millis and status.
	 *
	 * @param result the partially filled <code>ITestResult</code>
	 * @see ITestResult#STARTED
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart ( result );
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SUCCESS
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println ( "Passed test -- " + result.getName ( ) );
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#FAILURE
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty ( "org.uncommons.reportng.escape-output", "false" );
		Reporter.log ( "<a href=\"/Users/padmanabhadas/Downloads/Padmanabha Das.jpg\" target=\"_blank\">Screenshot link</a>" );
		System.out.println ( "Capturing Screenshot for the failed test -- " + result.getName ( ) );
	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SKIP
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped ( result );
	}

	/**
	 * Invoked each time a method fails but has been annotated with successPercentage and this failure
	 * still keeps it within the success percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage ( result );
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout ( result );
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	 * tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart ( context );
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	 * run and all their Configuration methods have been called.
	 *
	 * @param context The test context
	 */
	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish ( context );
	}
}
