<%@ page import="java.util.ArrayList"%>
<%@ page import="app.clasesDao.DAOLibro"%>
<%@ page import="app.modelo.Libro"%>
<%@ page import="app.modelo.Cliente"%>

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
	<%
	HttpSession sesion = request.getSession();
	if (sesion.getAttribute("id_cliente") == null) {
		response.sendRedirect("login.jsp");
	}
	
%>
<%int id_cliente = (int)sesion.getAttribute("id_cliente"); %>
	 <input type="hidden" id="id_cliente" value="<%= id_cliente%>">
		<a href="index.jsp"><img class="logo-nav"
			src="logo/logo_white_large.png" alt=""></a>
			
			<div>
			<a class="btn2" href="" id="cerrarSesion">Cerrar Sesion</a>
			</div>
	</header>


	<!-- action="AccionesServ" method="POST" -->
	<div class="buscar">
		<input type="hidden" name="opcion" value="6" >
		<a  id="libroNuevo" class="btn2" href="cargarLibro.jsp">Nuevo Libro</a>
		<input type="hidden" name="opcion" value="7">
		<a id="carrito" class="btn2" href="carrito.jsp"> Carrito (<span id="cantidadCarrito">0</span>)</a>

	</div>
<div class="buscar2">
 <form id="buscarBtn" class="form2"> 
			<label>Buscador</label>
			<select name="buscarPor" id="selector">
				<option value="0">Seleccionar uno</option>
				<option value="1">ISBN</option>
				<option value="2">Titulo</option>
			</select>  
			<input type="text" name="buscador" id="valorBuscar">  
		<!-- 	 	<input type="hidden" name="opcion" value="1">  -->
			<input class="btn2" type="submit"  value="Buscar">
		</form> 
		</div>
	<section>

		
<div id="resultado"></div>

	<table class="table" id="pintarTabla">
	</table>
	<button class="btn-cargar" id="atras">Atras</button>
	<table class="table" id="pintarTablaBuscador">
	</table>
      <div class="cambioPrecio" id="cambioPrecio">
      <form class="precioNuevo-form" action="">
        <p class="parrafoPrecio">Ingrese el nuevo precio</p>
        <input type="text" name="precioNuevo" id="precioNuevo">
        <div class="btn-display">
          <input onclick="aceptarCancelar(this)" class="btn2" id="true" type="submit" value="Aceptar">
          <input onclick="aceptarCancelar(this)" class="btn2" id="false" type="submit" value="Cancelar">
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
<script src="pintarTabla.js"></script>
<script src="cerrarSesion.js"></script>
</body>
</html>