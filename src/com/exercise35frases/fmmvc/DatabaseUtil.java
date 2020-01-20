package com.exercise35frases.fmmvc;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String URL_FORMAT = "jdbc:%s://%s:%s/%s?useUnicode=true&"
			+ "serverTimezone=UTC&useJDBCCompliantTimezoneShift=true"
			+ "&userLegacyDatetimeCode=false";
	
	public static Connection getConnection()
	{
		String dbms = "mysql";
		String host = "localhost";
		String port = "3306";
		String databaseName = "frases_matonas";
		String username = "root";
		String password = "mysqlr00t";
		
		
		String url = String.format(URL_FORMAT, dbms, host, port, databaseName);
		
		Connection connection = null;
		
		try 
		{	
			// Creando instancia del driver en memoria
			// Para poder ser accedida
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Obtener la conexion a la base de datos
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return connection;	
	}
	
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
