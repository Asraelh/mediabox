
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Media Box</title>

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">


		<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">

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

					<input type="text"     class="imp_gen" name="user"     placeholder="Usuario o email" />
					<br><br>

					<input type="password" class="imp_gen" name="password" placeholder="Contraseña" />
					<br><br>

	 				<input type="submit" class="btns" id="impIni"  value="Acceder"/>

					<p id="m_control"> ${ mensaje_login } </p>

	 				<a href="altausuarios">
	 					<input id="impReg" class="btns" type="button" value="Regístrate"/>
	 				</a>
				</form>
			</div>

			<% }else{ %>

			<div id="d_bienvenido" class="areas">

				<h3 id="mediaL"> Media </h3>
					<img id="logoL" src="../../resources/img/logo.png" />
				<h3 id="boxL"> Box </h3>

				<h4>
					Bienvenido,${ usr }
				</h4>

				<a href="admin_usuario">
					<input id="btns_admin" class="btns" type="button" value="Configura tu cuenta"/>
				</a>

				<a href="cerrarSesion">
					<input id="btns_close" class="btns" type="button" value="Cerrar sesión"/>
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
	 					<img src=""/> Películas favoritas
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
