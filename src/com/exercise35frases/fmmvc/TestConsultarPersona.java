package com.exercise35frases.fmmvc;

import org.junit.Test;

import com.exercise35frases.fmmvc.db.DatabaseManager;
import com.exercise35frases.fmmvc.model.Persona;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.util.ArrayList;

public class TestConsultarPersona {
	
	@Test
	public void consultarPersona()
	{
		Connection conn = DatabaseUtil.getConnection();
		assertNotNull("La conexion es nula", conn);
		DatabaseManager dbManager = new DatabaseManager(conn);
		List<Persona> listPersona = dbManager.consultarPersonas();
		
		assertNotNull("No hay datos", listPersona);
		assertTrue("No hay datos!", listPersona.size() > 0);
		
		DatabaseUtil.closeConnection(conn);
		
		try 
		{
			assertTrue("No se cerro la conexion", conn.isClosed());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
