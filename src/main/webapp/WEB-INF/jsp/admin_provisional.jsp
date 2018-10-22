<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registrate</title>

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

	<link href="<c:url value="/resources/css/registro.css" />" rel="stylesheet">

	</head>

	<body>

		<div id="titulo" class="areas">
			<h1> ${usr.idusuario} </h1>
		</div>

		<div id="formulario">

			<h3> Modifique sus datos: </h3>

			<form action="modificar_usuario" method="post">

				<p> Usuario: </p>
				<input class="imp_gen" type="text"     name="idusuario"    id="idusuario"     placeholder="idusuario" value="${usr.idusuario}" readonly/>
				<br><br><br>

				<p> Contraseña: </p>
				<input class="imp_gen" type="password" name="password"  id="password"  placeholder="password" value="${usr.password}"/>
				<br><br><br>

				<p> Email: </p>
				<input class="imp_gen" type="email"    name="email"   id="email"    placeholder="email" value="${usr.email}"/>
				<br><br><br>

				<input id="btn_reg" type="submit" value="Registrar"/>

			</form>

			<div id="resRegistro">
				<p> ${ mensaje_admin } </p>
			</div>

		</div>

	</body>
</html>
