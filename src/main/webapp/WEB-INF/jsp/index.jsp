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

		<div id="titulo" class="areas">

			<h3 id="media"> Media </h3>

			<img id="logo" src="../../resources/img/logo.png" />

			<h3 id="box"> Box </h3>

		</div>

		<% if (session.getAttribute("usr") == null ) { %>

			<div id="login" class="areas">
				<h4>Inicio</h4>
				<form action="/iniSesion" method="post">

					<input type="text"     class="imp_gen" name="user"     placeholder="Usuario" />
					<br><br>

					<input type="password" class="imp_gen" name="password" placeholder="Contrase�a" />
					<br><br>

	 				<input type="submit" class="btns" id="impIni"  value="Enviar"/>

	 				<a href="altausuarios">
	 					<input class="btns" type="button" value="Reg�strate"/>
	 				</a>
				</form>
				<br>
				<p id="m_control"> ${ mensaje_login } </p>
			</div>

		<% }else{ %>

			<div id="d_bienvenido" class="areas">
				<h3>
					Bienvenido,
				</h3>

				<a href="admin_usuario">
					<input id="btns_admin" class="btns" type="button" value="Configura tu cuenta"/>
				</a>

				<a href="cerrarSesion">
					<input id="btns_close" class="btns" type="button" value="Salir"/>
				</a>

			</div>

			<div id="menu" class="areas">

				<div id="pelis">
	 				<a href="pelis" class="med_gen">
	 					<img src=""/> Peliculas
	 				</a> <br><br>
				</div>

				<div id="series">
	 				<a href="series" class="med_gen">
	 					<img src=""/> Series
	 				</a>
 				</div>

			</div>

			<div id="favoritos" class="areas">

				<div id="fav_pelis">
	 				<a href="fav_pelis" class="med_gen">
	 					<img src=""/> Pel�culas favoritas
	 				</a>
				</div>

				<div id="fav_series">
	 				<a href="fav_series" class="med_gen">
	 					<img src=""/> Series favoritas
	 				</a>
				</div>
			</div>

		<% } %>
	</body>
</html>
