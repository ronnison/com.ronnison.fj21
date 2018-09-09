package com.ronnison.jf11;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	Connection con;
	
	public Connection getConnection () {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21db", "root", "12345");
//			System.out.println("Connectado");
//			con.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return con;
	}
}
