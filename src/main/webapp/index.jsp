<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tienda de libros</title>
</head>
<body>
	<section>
		<div class="logo">
			<h2 class="titulo">Bienvenido a</h2>

			<img class="img" src="logo/logo_white_large.png" alt="">
		</div>
		<%
		String mensaje = (String) request.getAttribute("mensaje");
		%>
		<%
		if (mensaje != null) {
		%>
		<h4 class="mensaje"><%=mensaje%></h4>
		<%}%>
		<form action="LoginServ" method="post">
			<div class="login">
				<input type="hidden" name="opcion" value="1"> 
				
			<input class="btn" type="submit" value="Log in">  
					
				<input type="hidden" name="opcion" value="2"> 
				<input class="btn" type="submit" value="Register">  
				<!-- 	<a class="btn" href="LoginServ?opcion=2">Registrarse</a> -->
			</div>
		</form>
	</section>
	<footer>
		<a class="icon-footer" href="https//:www.facebook.com"><img
			class="icon" src="img/facebook.png" alt=""></a> <a
			class="icon-footer" href="https//:www.instagram.com"><img
			class="icon" src="img/instagram.png" alt=""></a> <a
			class="icon-footer" href="https//:www.twitter.com"><img
			class="icon" src="img/twitter.png" alt=""></a>
	</footer>





</body>
</html>