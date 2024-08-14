package com.ravi.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con;

	public static Connection getConnection() {
		try {
			if (con == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "harshit", "harshit");
			}

		} catch (Exception e) {
			System.out.println("Connection failed");
		}
		return con;
	}
}
