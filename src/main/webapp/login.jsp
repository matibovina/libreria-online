<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://kit.fontawesome.com/3758ab675a.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>

	<header>
		<a href="index.jsp"><img class="logo-nav"
			src="logo/logo_white_large.png" alt=""></a>
	</header>
	<section class="mainSection">
		<%
		String mensaje = (String) request.getAttribute("mensaje");
		%>
		<%
		if (mensaje != null) {
		%>
		<h4 class="mensaje"><%=mensaje%></h4>
		<%}%>
		<div class="form">
			<h3 id="mensajeError" class="mensajeError"></h3>

			<form action="ProcesoLogin" id="loginForm" name="ProcesoLogin"
				method="POST" class="fromulario">
				<label for="user">Usuario</label>
				<div class="campos-form">

					<input type="text" name="user" id="user"
						placeholder="Ingrese usuario">
				</div>
				<label for="password">Contraseña</label>
				<div class="campos-form">

					<input type="password" id="password" name="password"
						placeholder="Ingrese contraseña">
				</div>
				<div class="btn-box">
					<input type="hidden" name="opcion" value="2"> <input
						class="submit" id="login" type="submit" value="Ingresar"
						name="enviar">
				</div>
			</form>
		</div>
	</section>
	<%@include file="includes/footer.jsp"%>
	<script src="validacionLogin.js"></script>

</body>
</html>