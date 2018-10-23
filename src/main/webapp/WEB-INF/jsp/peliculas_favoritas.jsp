<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tus películas favoritas</title>

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">

		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/peliculas_favoritas.css" />" rel="stylesheet">

	</head>

	<body>
		<% if ( session.getAttribute("usr").equals("") || session.getAttribute("usr") == null ) { response.sendRedirect("index"); } %>

		<div id="titulo" class="areas">
			<h1> Tus películas favoritas </h1>
		</div>

		<div id="d_bienvenido" class="areas">

			<a href="/">
				<h3 id="mediaL"> Media </h3>
					<img id="logoL" src="../../resources/img/logo.png" />
				<h3 id="boxL"> Box </h3>
			</a>

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
 					<img src=""/> Películas
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

		<c:if test = "${comp == 0}">
         	<span id="mensaje"> <c:out value = "${mensaje}"/> </span>
      	</c:if>

		<c:if test = "${comp != 0}">

			<div class="container">
				<div class="row" id="contenedor">
					<c:forEach var="peli" items="${pelis}">
						<div class="col-md-3">
		    				<a class="imagenes" href="pelicula?idPel=${peli.idpelicula}">
			    				<img src="${peli.imagen}"/>
			    				<p>
			    					<c:out value = "${peli.titulo}"/>
			    				</p>
		    				</a>
						</div>
				    </c:forEach>
				</div>
			</div>

			<ul id="paginas" class="pagination">

				<a class="menos" href="fav_pelis?id=<c:out value = "${id-1}"/>">&laquo;</a>

			    <c:forEach var = "i" begin = "1" end = "${npaginas}">

		        	<li>
		        		<a href="fav_pelis?id=<c:out value = "${i}"/>" class="active">
		        			<c:out value = "${i}"/>
		        		</a>
		        	</li>

			    </c:forEach>

			    <a class="mas" href="fav_pelis?id=<c:out value = "${id+1}"/>">&raquo;</a>
			</ul>

		</c:if>

	</body>
</html>
