package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
	
	private static final String URL = "jdbc:postgresql://localhost:5433/escolaabc";
	private static final String USER = "postgres";
	private static final String password = "***";
	
	public static Connection getConnection() {
		try{
			return DriverManager.getConnection(URL, USER, password);
			
		}catch(SQLException e) {
			System.err.println("Erro na conexão");
			throw new RuntimeException(e);
		}
	}
	
}
