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
<title>Tienda de libros</title>
</head>
<body>
	<section class="mainSection">
		<div class="logo index">
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


		<a href="LoginServ?opcion=1" class="btn2">Login</a> <a
			href="LoginServ?opcion=2" class="btn2">Register</a>

	</section>
	<%@include file="includes/footer.jsp"%>
</body>
</html>