<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registrate</title>

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">

<!--
		<link href="<c:url value="/resources/css/registro.css" />" rel="stylesheet">		
-->
		<link rel="stylesheet" type="text/css" href="../../css/base.css">
		<link rel="stylesheet" type="text/css" href="../../css/registro.css">

	</head>

	<body>

		<div id="titulo">
			<h1>
				Registrate
			</h1>
		</div>

		<div id="formulario">
			<form action="addusuario" method="post">
				<p> Usuario:    
					<input type="text"     name="usu"      placeholder="Usuario"/>    
				</p>
				
				<p> Contraseña: 
					<input type="password" name="password" placeholder="Contraseña"/> 
				</p>
				
				<p> Repita la contraseña: 
					<input type="password" name="re_password" placeholder="Contraseña"/> 
				</p>
				
				<p> Email:      
					<input type="email"    name="email"    placeholder="Email"/>      
				</p>
			
				<input type="submit" value="Registrar"/>
			</form>
			
			<div id="resRegistro">
				<p> ${ mensaje_registro } </p> 
			</div>
			
		</div>	

	</body>
</html>