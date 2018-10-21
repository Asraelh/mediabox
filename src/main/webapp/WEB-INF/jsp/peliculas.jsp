<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Películas</title>


		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/peliculas.css" />" rel="stylesheet">

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

		<!--  C O N T E N I D O    P A R A    M O S T R A R  -->

		<div class="row">

			<c:forEach var="peli" items="${pelis}">

				<div class="col-md-4">
    				<a href="pelicula?idPel=${peli.idPelicula}">
	    				<img src="${peli.imagen}">
	    				<c:out value = "${peli.titulo}"/>
    				</a>
				</div>
		    </c:forEach>
		</div>



		<ul id="paginas" class="pagination">

		    <a href="pelis?id=">&laquo;</a>

		    <c:forEach var = "i" begin = "1" end = "${npaginas}">

				<c:if test = "${i == 1}">
		        	<li><a href="pelis?id=<c:out value = "${i}"/>" class="active">
		        		<c:out value = "${i}"/>
		        	</a></li>
		        </c:if>

			  	<c:if test = "${i != 1}">
		        	<li><a href="pelis?id=<c:out value = "${i}"/>">
		        		<c:out value = "${i}"/>
		        	</a></li>
		        </c:if>

		    </c:forEach>

		    <a href="pelis?id=">&raquo;</a>
		</ul>

		<nav>
		  	<ul class="pagination justify-content-center pagination-sm"></ul>
		</nav>







	</body>

</html>
