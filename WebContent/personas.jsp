<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Personas</title>
</head>
<body>
	<c:forEach var="persona" items="${List}">
		<div>		
			<h4>${persona.getId_Persona()}</h4>
			<h4>${persona.getName()}</h4>
			<h4>${persona.getEdad()}</h4>
			<h4>${persona.getCarrera()}</h4>
			<h4>${persona.getFecha()}</h4>
		</div>
	</c:forEach>
	<style rel="stylesheet">
		div {
			margin-top: 5px;
			border: 1px solid black;
		}
		h4 {
			display: block;
		}
	</style>
</body>
</html>