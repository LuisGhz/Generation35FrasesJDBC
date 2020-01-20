<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Persona</title>
</head>
<body>

	<form action="persona" method="post">
		<h2>Registrar persona</h2>
		<p>
			<input type="text" name="txtNombre" placeholder="Nombre ">
		</p>
		<p>
			<input type="text" name="txtEdad" placeholder="Edad ">
		</p>
		<p>
			<input type="text" name="txtCarrera" placeholder="Carrera ">
		</p>
		<input type="submit" value="Agregar" >
	</form>
	
	<form action="frase" method="post">
		<h2>Registrar frase</h2>
		<p>
			<input type="text" name="txtContenido" placeholder="Contenido " >
		</p>
		<p>
			<input type="text" name="txtCantidad" placeholder="Cantidad " >
		</p>
		<p>
			<input type="text" name="txtFechaDesde" placeholder="Fecha desde " >
		</p>
		<input type="submit" value="Agregar" >
	</form>
	
	<style rel="stylesheet">
		form {
			display: block;
		}
	</style>
</body>
</html>