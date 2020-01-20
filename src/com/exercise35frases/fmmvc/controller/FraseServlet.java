package com.exercise35frases.fmmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;

import com.exercise35frases.fmmvc.DatabaseUtil;
import com.exercise35frases.fmmvc.db.DatabaseManager;
import com.exercise35frases.fmmvc.model.Frase;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;


@WebServlet("/frase")
public class FraseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		DatabaseManager dbManager = null;
		List<Frase> list = null;
		RequestDispatcher disp = null;
		
		conn = DatabaseUtil.getConnection();
		dbManager = new DatabaseManager(conn);
		list = dbManager.consultarFrases();
		
		req.setAttribute("List", list);
		
		disp = req.getRequestDispatcher("frases.jsp");
		
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = null;
		DatabaseManager dbManager = null;
		Frase frase = null;
		
		String txtContenido = req.getParameter("txtContenido");
		String txtCantidad = req.getParameter("txtCantidad");
		String txtFechaDesde = req.getParameter("txtFechaDesde");
		
		frase = new Frase();
		frase.setContenido(txtContenido);
		frase.setCantidad(Integer.parseInt(txtCantidad));
		frase.setFechaDesde(java.sql.Date.valueOf(txtFechaDesde));
		
		conn = DatabaseUtil.getConnection();
		dbManager = new DatabaseManager(conn);
		dbManager.crearFrase(frase);
		
		DatabaseUtil.closeConnection(conn);
	}
}
