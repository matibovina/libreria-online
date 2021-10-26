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
  <% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% if (mensaje!=null){ %>
			<h4 class="mensaje"><%= mensaje %></h4>
		<%}%>
  <div class="form">
		<form action="ProcesoLogin" name="ProcesoLogin" method="POST" class="fromulario">
			<label for="user">Usuario</label>
			<div class="campos-form">

				<input type="text" name="user" id="" placeholder="Ingrese usuario">
			</div>
			<label for="password">Contraseña</label>
			<div class="campos-form">

				<input type="password" name="password" id=""
					placeholder="Ingrese contraseña">
			</div>
			<div class="btn-box">
				<input type="hidden" name="opcion" value="2">
		       <input class="submit" id="login" type="submit" value="Ingresar" name="enviar">
		      
      </div>
      <div class="btn-box">
        <input class="submit" id="register" type="hidden" value="Registrarse" name="enviar">
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