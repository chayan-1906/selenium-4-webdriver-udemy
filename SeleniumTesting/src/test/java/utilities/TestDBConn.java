package utilities;

import java.sql.SQLException;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DbManager.setMysqlDbConnection ( );
		System.out.println ( DbManager.getMysqlQuery ( "Select tutorial_author from Selenium where tutorial_id = 2" ) );
	}
}
