package com.mindtree.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*This class is used to establish connection to database*/
public class DaoConnection {
	public static Connection Connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FOOTBALL_MATCH_DB", "root",
					"Welcome123");
			return con;
	}
}
