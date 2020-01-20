package com.exercise35frases.fmmvc;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import com.exercise35frases.fmmvc.model.Persona;
import com.exercise35frases.fmmvc.model.Frase;
import com.exercise35frases.fmmvc.db.DatabaseManager;

public class TestDatabaseConnection {
	
	@Test
	public void testConnection()
	{
		Connection connection = DatabaseUtil.getConnection();
		
		assertNotNull("No se realizo la conexion", connection);
		
		DatabaseUtil.closeConnection(connection);
	}
	
	@Test
	public void insertPersona()
	{
		Persona persona = new Persona();
		Connection connection = DatabaseUtil.getConnection();
		
		persona.setNombre("Leo");
		persona.setEdad((byte) 25);
		persona.setCarrera("Informatica");
		
		DatabaseManager db = new DatabaseManager(connection);
		
		db.crearPersona(persona);
		
	}
	
	@Test
	public void insertFrase()
	{
		
	}
}
