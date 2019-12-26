package com.sims.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconection {
	
	public Connection getConection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMSDB","root","root");
		
			return con;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
	
}
