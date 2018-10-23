<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">

		<title>Media Box</title>

		<link rel="stylesheet"
			  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
  		</script>

  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<script src="/resources/js/carousel.js"></script>

		<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

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
				<a href="/">
					<h3 id="mediaL"> Media </h3>
						<img id="logoL" src="../../resources/img/logo.png" />
					<h3 id="boxL"> Box </h3>
				</a>

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

		<% } %>

<!-- /////////////////////////////////////////////////////// -->
<!-- C A R O U S E L    P E L I C U L A S -->
<!-- /////////////////////////////////////////////////////// -->

			<div id="estrenos">
				Estrenos
			</div>


			<div id="titCarPel" class="titCar">
				Películas
			</div>

			<div id="Carousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
				<ol class="carousel-indicators">
				    <li data-target="#Carousel" data-slide-to="0"></li>
				    <li data-target="#Carousel" data-slide-to="1"></li>
				    <li data-target="#Carousel" data-slide-to="2"></li>
				    <li data-target="#Carousel" data-slide-to="3"></li>
				    <li data-target="#Carousel" data-slide-to="4"></li>
				</ol>

			    <!-- Wrapper for slides -->
			    <div class="carousel-inner" role="listbox">
					<c:forEach var = "i" items="${peliculas5}" varStatus="loopCount">

						<c:if test="${loopCount.count eq 1}">
				        	<div class="item active">
								<img src="${i.imagen}" alt="${i.titulo}"/>
							</div>
				        </c:if>

						<c:if test="${loopCount.count != 1}">
				        	<div class="item">
								<img src="${i.imagen}" alt="${i.titulo}"/>
							</div>
				        </c:if>

				    </c:forEach>
			    </div>

			    <!-- Left and right controls -->
			    <a class="left carousel-control"
			  	   href="#Carousel"
			  	   role="button"
			  	   data-slide="prev">
			       <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			       <span class="sr-only">Previous</span>
			    </a>

			    <a class="right carousel-control"
			  	   href="#Carousel"
			  	   role="button"
			  	   data-slide="next">
			       <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			       <span class="sr-only">Next</span>
			    </a>

			</div>

<!-- /////////////////////////////////////////////////////// -->
<!-- C A R O U S E L    S E R I E S -->
<!-- /////////////////////////////////////////////////////// -->

			<div id="titCarSer" class="titCar">
				Series
			</div>

			<div id="Carousel2" class="carousel slide" data-ride="carousel2">
			  <!-- Indicators -->
				<ol id="carousel-indicators2" class="carousel-indicators">
				    <li data-target="#Carousel2" data-slide-to="0"></li>
				    <li data-target="#Carousel2" data-slide-to="1"></li>
				    <li data-target="#Carousel2" data-slide-to="2"></li>
				    <li data-target="#Carousel2" data-slide-to="3"></li>
				    <li data-target="#Carousel2" data-slide-to="4"></li>
				</ol>

			    <!-- Wrapper for slides -->
			    <div id="carousel-inner2" class="carousel-inner" role="listbox">
					<c:forEach var = "s" items="${series5}" varStatus="loopCount">

						<c:if test="${loopCount.count eq 1}">
				        	<div id="item2" class="item active">
								<img src="${s.imagen}" alt="${s.titulo}"/>
							</div>
				        </c:if>

						<c:if test="${loopCount.count != 1}">
				        	<div id="item2" class="item">
								<img src="${s.imagen}" alt="${s.titulo}"/>
							</div>
				        </c:if>

				    </c:forEach>
			    </div>

			    <!-- Left and right controls -->
			    <a id="carousel-control2"
			       class="left carousel-control carousel-control2"
			  	   href="#Carousel2"
			  	   role="button"
			  	   data-slide="prev">
			       <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			       <span class="sr-only">Previous</span>
			    </a>

			    <a class="right carousel-control carousel-control2"
			  	   href="#Carousel2"
			  	   role="button"
			  	   data-slide="next">
			       <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			       <span class="sr-only">Next</span>
			    </a>

			</div>

	</body>
</html>
