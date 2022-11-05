package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

	private static Connection con = null; // sql

	private static Connection conn = null; // mysql

	// SQL Server
	public static void setDbConnection()
			throws SQLException, ClassNotFoundException {
		try {
			Class.forName(TestConfig.driver);
			con = DriverManager.getConnection(TestConfig.dbConnectionUrl, TestConfig.dbUserName, TestConfig.dbPassword);

			if (!con.isClosed())
				System.out.println("Successfully connected to SQL server");

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}

	public static void setMysqlDbConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(TestConfig.mysqldriver);
			conn = DriverManager.getConnection(TestConfig.mysqlurl, TestConfig.mysqluserName, TestConfig.mysqlpassword);
			if (!conn.isClosed())
				System.out.println("Successfully connected to MySQL server");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
		}
	}

	public static List<String> getQuery(String query) throws SQLException {
		Statement St = con.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values = new ArrayList<String>();
		while (rs.next()) {
			values.add(rs.getString(1));
		}
		return values;
	}

	public static List<String> getMysqlQuery(String query) throws SQLException {
		Statement St = conn.createStatement();
		ResultSet rs = St.executeQuery(query);
		List<String> values1 = new ArrayList<String>();
		while (rs.next()) {
			values1.add(rs.getString(1));
		}
		return values1;
	}

	public static Connection getConnection() {
		return con;
	}
}
