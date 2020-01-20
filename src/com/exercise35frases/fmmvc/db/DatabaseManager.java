package com.exercise35frases.fmmvc.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.exercise35frases.fmmvc.model.Frase;
import com.exercise35frases.fmmvc.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseManager {

		private Connection conn;
		
		public DatabaseManager(Connection conn)
		{
			this.conn = conn;
		}
		
		public void crearPersona(Persona persona)
		{
			String query = "insert into persona (nombre, edad, carrera) "
					+ "values (" + persona.toString() + ")";
			
			Statement stmnt = null;
			
			try {
				stmnt = conn.createStatement();
				
				stmnt.executeUpdate(query);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void crearFrase(Frase frase)
		{
			String query = "insert into frase (contenido, cantidad, fechaDesde)"
					+ "values (?, ?, ?)";
			
			PreparedStatement pstmnt = null;

			try {
				pstmnt = conn.prepareStatement(query);
				
				
				
				pstmnt.setString(1, frase.getContenido());
				pstmnt.setInt(2, frase.getCantidad());
				pstmnt.setDate(3, frase.getFechaDesde());
				
				pstmnt.executeUpdate(query);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void crearFrasePersona(int idPersona, int idFrase)
		{
			
		}
		
		public List<Persona> consultarPersonas()
		{
			String queryString = "select * from persona";
			
			Statement stmnt = null;
			ResultSet rs = null;
			List<Persona> listPersona = null;
			
			try 
			{			
				stmnt = conn.createStatement();
				rs = stmnt.executeQuery(queryString);
				listPersona = new ArrayList<Persona>();
				
				while(rs.next())
				{
					Persona persona = new Persona();
					persona.setId_Persona(rs.getInt("idPersona"));
					persona.setNombre(rs.getString("nombre"));
					persona.setEdad(rs.getByte("edad"));
					persona.setCarrera(rs.getString("carrera"));
					persona.setFecha(rs.getDate("fechaCreado"));
					
					listPersona.add(persona);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return listPersona;
		}
		
		public List<Frase> consultarFrases()
		{
			String query = "select * from frase";
			Statement stmnt = null;
			ResultSet rs = null;
			List<Frase> listFrase = null;
			
			try
			{
				stmnt = conn.createStatement();
				rs = stmnt.executeQuery(query);
				listFrase = new ArrayList<Frase>();
				
				while (rs.next())
				{
					Frase frase = new Frase();
					frase.setId_Frase(rs.getInt("idFrase"));
					frase.setContenido(rs.getString("contenido"));
					frase.setCantidad(rs.getInt("cantidad"));
					frase.setFechaDesde(rs.getDate("fechaDesde"));
					frase.setFecha(rs.getDate("fechaCreado"));
					
					listFrase.add(frase);
				}
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return listFrase;
		}
		
		public List<Frase> consultarFrasePersona()
		{
			return null;
		}
}

