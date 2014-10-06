package com.blue.databaseManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author pratyushatiruveedhula
 * 
 */
public class DatabaseManager {
	Connection connection = null;
	/**
	 * 
	 */
	public DatabaseManager() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("org.sqlite.JDBC");
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:dat/HadoopMetrics.sqlite");
			connection.setAutoCommit(false);
			return connection;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}

	public void fetchData() throws SQLException {
		try{
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from JobConfig");
		while (rs.next()) {
			System.out.println("id = " + rs.getString("JobId"));
		}
		}catch (SQLException e) {
			// connection close failed.
			System.err.println(e);
			throw e;
		}
	}
}
