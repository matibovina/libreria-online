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
   <a href="index.jsp"><img class="logo-nav" src="logo/logo_white_large.png" alt=""></a> 
  </header>
  <section>
    <h2 class="titulo">Completar el formulario</h2>
	  <% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% if (mensaje!=null){ %>
			<h4 class="mensaje"><%= mensaje %></h4>
		<%}%>
  <div class="form">
		<form action="ProcesoRegisroServ" name="register" method="POST" class="fromulario">
		
			<div class="campos-form">
        <!-- <label for="user">Nombre</label> -->
				<input type="text" name="nombre" id="" placeholder="nombre">
			</div>
			<div class="campos-form">
        <!-- <label for="user">Apellido</label> -->
				<input type="text" name="apellido" id="" placeholder="apellido">
			</div>
			<div class="campos-form">
        <!-- <label for="user">Fecha de Nac</label> -->
        <input type="text" onfocus="(this.type='date')" name="fechaNacimiento" id="" placeholder="Fecha Nacimiento">
			</div>
			<div class="campos-form">
        <!-- <label for="user">Email</label> -->
				<input type="email" name="email" id="" placeholder="Email">
			</div>
			<div class="campos-form">
        <!-- <label for="user">Usuario</label> -->
				<input type="text" name="user" id="" placeholder="Ingrese usuario">
			</div>
			<div class="campos-form">
        <!-- <label for="password">Contraseña</label> -->
				<input type="password" name="password" id=""
					placeholder="Ingrese contraseña">
			</div>
			<div class="campos-form">
        <!-- <label for="password">Contraseña</label> -->
				<input type="password" name="password1" id=""
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
  <footer>
    <a class="icon-footer" href="https//:www.facebook.com"><img class="icon" src="img/facebook.png" alt=""></a>
    <a class="icon-footer" href="https//:www.instagram.com"><img class="icon" src="img/instagram.png" alt=""></a>
    <a class="icon-footer" href="https//:www.twitter.com"><img class="icon" src="img/twitter.png" alt=""></a>
  </footer>

</body>
</html>