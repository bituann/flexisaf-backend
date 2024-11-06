package com.flexisaf.weeksix;

import java.sql.*;
import java.time.LocalDate;

public class Database {

	private static final String url = "jdbc:postgresql://localhost:5432/";
	private static final String username = "postgres";
	private static final String password = "P0$tgreSQL";

	public static void main (String[] args) {
		try (Connection con = DriverManager.getConnection(url, username, password)){
			createDB(con);
			insert(con);
			update(con);
//				delete(con);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void createDB (Connection con) throws SQLException {
		String create = "CREATE TABLE IF NOT EXISTS flexi (" +
				"id SERIAL PRIMARY KEY," +
				"firstname VARCHAR(45) NOT NULL," +
				"lastname VARCHAR(45) NOT NULL," +
				"address VARCHAR(100) NOT NULL," +
				"occupation VARCHAR(30) NOT NULL," +
				"date DATE NOT NULL" +
				")";
		Statement statement = con.createStatement();
		statement.execute(create);
	}
	public static void insert (Connection con) throws SQLException {
		String insert = "INSERT INTO flexi (firstname, lastname, address, occupation, date) " +
				"VALUES ('tobi', 'awanebi', 'Lagos', 'Student', ?)";

		PreparedStatement preparedStatement = con.prepareStatement(insert);
		preparedStatement.setObject(1, LocalDate.now());
		preparedStatement.execute();
	}

	public static void update (Connection con) throws SQLException {
		String update = "UPDATE flexi SET firstname = 'timi' WHERE id = 2";

		Statement statement = con.createStatement();
		statement.executeUpdate(update);
	}

	public static void delete (Connection con) throws SQLException {
		String delete = "DELETE FROM flexi WHERE id = 1";

		Statement statement = con.createStatement();
		statement.execute(delete);
	}
}








//String insert = "INSERT INTO flexi (firstname, lastname, address, occupation, date) " +
//		"SELECT 'tobi', 'awanebi', '3, Eskay Ade Street, Ibiye, Lagos State', 'Student', ? " +
//		"WHERE NOT EXISTS (SELECT id FROM flexi WHERE id = 1)";