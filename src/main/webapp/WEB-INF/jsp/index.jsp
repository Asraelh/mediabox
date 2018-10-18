<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Media Box</title>
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">

<!--
		<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">		
-->
		<link rel="stylesheet" type="text/css" href="../../css/base.css">
		<link rel="stylesheet" type="text/css" href="../../css/index.css">
		
	</head>
	
	<body>
	
		<div id="d_bienvenido">
			<h1>
				Media Box
			</h1>
		</div>	
	
		<% if (session.getAttribute("usr") == null ) { %>
			
			<div id="login">
				<h4>Inicio sesión</h4>
				<form action="/iniSesion"  method="post">
					<input type="text"     class="imp_gen" name="user"     placeholder="Usuario" /> <br><br>
					<input type="password" class="imp_gen" name="password" placeholder="Contraseña" /> <br><br>  
	 				<input type="submit"      id="impIni"  value="Enviar"/>
	 				<a href="altausuarios"> <input type="button" value="Registro"/> </a>
				</form>
				<br>
				<p id="m_control"> ${ mensaje_login } </p>
			</div>		

		<% }else{ %>
			
			<div id="d_bienvenido">
				<h3>
					Bienvenido, <%=session.getAttribute("usr")%> 
					<a href="cerrarSesion"><input class="btns" type="button" value="Cerrar sesion"/></a>
				</h3>
			</div>
			
			<div id="menu">
				
				<h4>Menu</h4>
				
 				<a href="pelis"> 
 					<img src=""/>
 				</a> <br><br>
 				
 				<a href="series"> 
 					<img src=""/>
 				</a> <br><br>

			</div>
			
			<div id="favoritos">
				
				<h4>Menu</h4>
				
 				<a href="fav_pelis"> 
 					<img src=""/>
 				</a> <br><br>
 				
 				<a href="fav_series"> 
 					<img src=""/>
 				</a> <br><br>

			</div>			

		<% } %>
	
	</body>
</html>