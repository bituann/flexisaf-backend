package com.flexisaf.weeksix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	String url = "jdbc:postgres://localhost:5432";
	String username = "postgres";
	String password = "P0$tgreSQL";

	{
		try (Connection con = DriverManager.getConnection(url, username, password)){
			Statement st = con.createStatement();
			st.execute("CREATE ")
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
