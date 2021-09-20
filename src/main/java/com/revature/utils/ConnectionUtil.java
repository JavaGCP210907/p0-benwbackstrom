package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// this method will eventually return an object of type Connection, which we'll use to connect to our database
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver"); // searching for the postgres driver, which we have as a dependency
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Use our database credentials to establish a database connection

		// credentials as Strings, use these strings in a method that gets connections
		String url = System.getenv("URL");
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");

		// This return statement is what returns our actual database Connection object

		return DriverManager.getConnection(url, username, password);

	}
}
