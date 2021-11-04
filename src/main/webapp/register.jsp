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
   <a href="index.jsp"><img class="logo-nav" src="logo/logo_white_large.png" alt=""></a> 
  </header>
   <section class="mainSection">
    <h2 class="titulo">Completar el formulario</h2>
	  <% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% if (mensaje!=null){ %>
			<h4 class="mensaje"><%= mensaje %></h4>
		<%}%>
				<h4 id="mensajeError"></h4>
		
  <div class="form" id="register">
		<form action="ProcesoRegisroServ" name="register" method="POST" class="fromulario">
		
			<div class="campos-form">
				<input type="text" name="nombre" id="nombre" placeholder="nombre">
			</div>
			<div class="campos-form">
				<input type="text" name="apellido" id="apellido" placeholder="apellido">
			</div>
			<div class="campos-form">
        <input type="text" onfocus="(this.type='date')" name="fechaNacimiento" id="fechaNamicimiento" placeholder="Fecha Nacimiento">
			</div>
			<div class="campos-form">
				<input type="text" name="email" id="email" placeholder="Email">
			</div>
			<div class="campos-form">
				<input type="text" name="user" id="user" placeholder="Ingrese usuario">
			</div>
			<div class="campos-form">
				<input type="password" name="password" id="password"
					placeholder="Ingrese contraseña">
			</div>
			<div class="campos-form">
				<input type="password" name="password1" id="password1"
					placeholder="Vuelva a ingresar contraseña">
			</div>
			<div class="btn-box">
		       <input class="submit" id="login" type="submit" value="Registarse" name="enviar">
      </div>
      <div class="btn-box">
        <input class="submit" id="register" type="hidden" value="Log in" name="enviar">
   </div>
		</form>
  </div>
</section>
	<%@include file="includes/footer.jsp" %>
   <script src="validacionRegister.js"></script>

</body>
</html>