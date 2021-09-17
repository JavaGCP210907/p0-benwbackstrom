package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		// Here we're just testing whether our Connection is successful
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Hello, connection was successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Create our menu object
		Menu menu = new Menu();

		// Use the Menu's displayMenu() method to use the menu
		menu.displayMenu();
	}
}
