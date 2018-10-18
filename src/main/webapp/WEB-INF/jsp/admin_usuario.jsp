<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administrar cuenta</title>

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">

<!--
		<link href="<c:url value="/resources/css/admin_usuario.css" />" rel="stylesheet">
-->
		<link rel="stylesheet" type="text/css" href="../../css/base.css">
		<link rel="stylesheet" type="text/css" href="../../css/admin_usuario.css">

	</head>

	<body>
		<% if ( session.getAttribute("usr").equals("") || session.getAttribute("usr") == null ) { response.sendRedirect("index"); } %>

		<div id="titulo" class="areas">

			<h3 id="media"> Media </h3>

			<img id="logo" src="../../resources/img/logo.png" />

			<h3 id="box"> Box </h3>

		</div>

		<div id="d_bienvenido">
			<h3>
				Usuario: <%=session.getAttribute("usr")%>

				<a href="cerrarSesion">
					<input class="btns" type="button" value="Cerrar sesion"/>
				</a>
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

		<!--  A D M I N I S T R A C I O N     D E     U S U A R I O  -->


	</body>
</html>
