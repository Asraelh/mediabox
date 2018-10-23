<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Administrar cuenta</title>

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		        crossorigin="anonymous">
		</script>

		<link rel="stylesheet"
		      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		      crossorigin="anonymous">

		<script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>


		<script type="text/javascript" src="/resources/js/alertify.js"></script>

		<link rel="stylesheet" href="<c:url value="/resources/css/alertify.core.css" />" />

		<link rel="stylesheet" href="<c:url value="/resources/css/alertify.default.css" />" />

		<script src="/resources/js/validaciones.js"></script>

		<link href="<c:url value="/resources/css/admin_usuario.css" />" rel="stylesheet">

		<link href="<c:url value="/resources/css/base.css" />" rel="stylesheet">

	</head>

	<body>


		<div id="titulo" class="areas">
			<h1> ${usr.idusuario} </h1>
		</div>

		<div id="d_bienvenido" class="areas">
			<a href="/">
				<h3 id="mediaL"> Media </h3>
					<img id="logoL" src="../../resources/img/logo.png" />
				<h3 id="boxL"> Box </h3>
			</a>

			<h4>
				Bienvenido,${usr.idusuario}
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

		<div id="formulario">

			<h3> Modifique sus datos: </h3>

			<form action="modificar_usuario" onsubmit="return checkForm(this);" method="post">

				<p> Usuario: </p>
				<input class="imp_gen_mod" type="text"     name="idusuario"    id="idusuario"     placeholder="idusuario" value="${usr.idusuario}" readonly/>
				<br><br><br>

				<p> Antigua contraseña: </p>
				<input class="imp_gen_mod" type="password" name="pwd0"  id="password"  placeholder="Antigua contraseña"/>
				<br><br><br>

				<p> Nueva contraseña: </p>
				<input class="imp_gen_mod" type="password" name="pwd1"  id="password"  placeholder="Nueva contraseña"/>
				<br><br><br>

				<p> Repita la contraseña: </p>
				<input class="imp_gen_mod" type="password" name="pwd2"  id="password"  placeholder="Repita la contraseña"/>
				<br><br><br>

				<p> Email: </p>
				<input class="imp_gen_mod" type="email"    name="email"   id="email"    placeholder="email" value="${usr.email}"/>
				<br><br><br>

				<input id="btn_reg" type="submit" value="Modificar datos"/>

			</form>

			<div id="resRegistro">
				<p> ${ mensaje_admin } </p>
			</div>

		</div>

	</body>
</html>
