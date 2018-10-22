<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Administrar cuenta</title>

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">

		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/pelicula.css" />" rel="stylesheet">

	</head>

	<body>
		<% if ( session.getAttribute("usr").equals("") || session.getAttribute("usr") == null ) { response.sendRedirect("index"); } %>

		<div id="titulo" class="areas">
			<h1> Peliculas </h1>
		</div>

		<div id="d_bienvenido" class="areas">

			<h3 id="mediaL"> Media </h3>
				<img id="logoL" src="../../resources/img/logo.png" />
			<h3 id="boxL"> Box </h3>

			<h4>
				Bienvenido,${usr}
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


		<!--  A D M I N I S T R A C I O N     D E     U S U A R I O  -->

		<div id="detalles">

			<p class="titulos"> Categoría:</p>

			<p id="cCats" class="contenido">
				${pelicula.categoria}
			</p>

			<p class="titulos"> Titulo:</p>

			<p class="contenido">
				${pelicula.titulo}
			</p>

			<p class="titulos"> Año:</p>

			<p class="contenido">
				${pelicula.year}
			</p>

			<p class="titulos"> Duración:</p>

			<p class="contenido">
				${duracion}
			</p>

			<p class="titulos"> Director:</p>

			<p class="contenido">
				${pelicula.director}
			</p>

			<p class="titulos"> Protagonista:</p>

			<p class="contenido">
				${pelicula.protagonista}
			</p>

			<p class="titulos"> Calificación:</p>

			<p class="contenido">
				${pelicula.calificacion}
			</p>

			<p class="titulos"> Descripción:
			</p>

			<p class="contenido">
				${pelicula.descripcion}
			</p>

		</div>

		<div id="portada">

			<img src="${pelicula.imagen}" />
			<br>
			<a id="vNet" href="${pelicula.watch}">
				Ver en Netflix
			</a>
			<br><br>
			<a id="add_fav" href="addPelisFav?idpel=${pelicula.idpelicula}"> 		Añadir a favoritos
		    </a>

		</div>

	</body>
</html>
