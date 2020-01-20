package com.exercise35frases.fmmvc.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise35frases.fmmvc.DatabaseUtil;
import com.exercise35frases.fmmvc.db.DatabaseManager;
import com.exercise35frases.fmmvc.model.Persona;

import java.util.List;
import java.util.ArrayList;


@WebServlet("/persona")
public class PersonaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		DatabaseManager dbManager = null;
		List<Persona> list = null;
		
		RequestDispatcher disp = null;
		
		conn = DatabaseUtil.getConnection();
		dbManager = new DatabaseManager(conn);
		list = dbManager.consultarPersonas();
		
		req.setAttribute("List", list);
		
		disp = req.getRequestDispatcher("personas.jsp");
		
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = null;
		DatabaseManager dbManager = null;
		Persona persona = null;
		
		String txtNombre = req.getParameter("txtNombre");
		String txtEdad = req.getParameter("txtEdad");
		String txtCarrera = req.getParameter("txtCarrera");
		
		//Validar datos
		
		// Modelar datos
		persona = new Persona();
		persona.setNombre(txtNombre);
		persona.setEdad(Byte.parseByte(txtEdad));
		persona.setCarrera(txtCarrera);
		
		//Guardar datos
		conn = DatabaseUtil.getConnection();
		
		dbManager = new DatabaseManager(conn);
		
		dbManager.crearPersona(persona);
		
		
		DatabaseUtil.closeConnection(conn);
		
	}
}
