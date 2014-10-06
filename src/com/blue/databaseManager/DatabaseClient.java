package com.blue.databaseManager;
import java.sql.SQLException;

/**
 * 
 */

/**
 * @author pratyushatiruveedhula
 *
 */
public class DatabaseClient {

	/**
	 * 
	 */
	public DatabaseClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatabaseManager dm = new DatabaseManager();
		try {
			dm.getConnection();
			dm.fetchData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
