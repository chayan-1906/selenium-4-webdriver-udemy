package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) {
		System.out.println ( username + " --- " + password );
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[ 3 ][ 2 ];

		data[ 0 ][ 0 ] = "padmanabhadas9647@gmail.com";
		data[ 0 ][ 1 ] = "padma2022#";

		data[ 1 ][ 0 ] = "padmanabhadas7319@gmail.com";
		data[ 1 ][ 1 ] = "padma2010#";

		data[ 2 ][ 0 ] = "chayan19062000@gmail.com";
		data[ 2 ][ 1 ] = "padma2016#";

		return data;
	}
}
