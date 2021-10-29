<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<header>
		<%
	HttpSession sesion = request.getSession();
	if (sesion.getAttribute("id_cliente") == null) {
		response.sendRedirect("login.jsp");
	}
	
%>
		<a href="index.jsp"><img class="logo-nav"
			src="logo/logo_white_large.png" alt=""></a>
	</header>
	
	<section>
			<h4 id="mensajeError" class="mensajeError">Debe completar todos los campos</h4>
	
		<h2 class="titulo">Cargar Libro Nuevo</h2>
		<div class="form">
			<form action="ProcesoNuevoLibroServ" name="cargarLibro" method="POST"
				class="fromulario" id="nuevoLibro">

				<div class="campos-form">
					<!-- <label for="user">Nombre</label> -->
					<input type="text" name="titulo" id="titulo" placeholder="Titulo">
				</div>
				<div class="campos-form">
					<!-- <label for="user">Apellido</label> -->
					<input type="text" name="autor" id="autor" placeholder="autor">
				</div>
				<div class="campos-form">
					<!-- <label for="password">Contraseña</label> -->
					<input type="text" name="ISBN" id="isbn" placeholder="ISBN">
				</div>
				<div class="campos-form">
					<!-- <label for="user">Email</label> -->
					<input type="text" name="genero" id="genero" placeholder="Genero">
				</div>
				<div class="campos-form">
					<!-- <label for="user">Usuario</label> -->
					<input type="text" name="precio" id="precio" placeholder="Precio">
				</div>

				<div class="btn-box">
					<input class="submit" id="login" type="submit"
						value="Guardar Libro" name="enviar">
				</div>
			</form>
		</div>
	</section>
	<footer>
		<a class="icon-footer" href="https//:www.facebook.com"><img
			class="icon" src="img/facebook.png" alt=""></a> <a
			class="icon-footer" href="https//:www.instagram.com"><img
			class="icon" src="img/instagram.png" alt=""></a> <a
			class="icon-footer" href="https//:www.twitter.com"><img
			class="icon" src="img/twitter.png" alt=""></a>
	</footer>
<script src="validacion.js"></script>
</body>
</html>