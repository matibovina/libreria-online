<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <script src="https://kit.fontawesome.com/3758ab675a.js" crossorigin="anonymous"></script>

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
   <a href="index.jsp"><img class="logo-nav" src="logo/logo_white_large.png" alt=""></a> 
   			<div>
			<a class="btn2" href="" id="cerrarSesion">Cerrar Sesion</a>
			</div>
  </header>
  <div class="buscar">
  </div>
  <section id="pago">
  <div class="form-box">
<form action="" id="form-pago" class="form">
  <label for="tarjetas">Seleccione la tarjeta</label>
  <select name="tarjetas" id="tarjetas">
    <option value="1">Visa</option>
    <option value="2">Visa Debit</option>
    <option value="3">MasterCard</option>
    <option value="4">American Express</option>
  </select>
  <input type="text" placeholder="Numero de tarjeta" required>
  <input type="text" placeholder="Nombre en la tarjeta" required>
  <input type="text" placeholder="CSV" required>
  <input type="text" name="domicilio" id="" placeholder="Direccion de envio" required>
  <input type="text" name="ciudad" placeholder="Ciudad" required>
  <input type="submit" class="submit" value="Pagar">
</form>
 <a href="carrito.jsp" class="btn2">Atras</a>   
</div>
</section>
<div id="confirmacionCompra" class="confirmacionCompra">
  <h2 class="titulo">Su compra se ha realizado con exito</h2>
  <a href="tablaLibros.jsp" class="btn2">Inicio</a>
</div>
  <section>
  	<div class="botonesCarrito" id="botonesCarrito">     
  	    <a href="tablaLibros.jsp" class="btn2">Atras</a>     
  		<a href="#" id="botonPagar" class="btn2">Pagar</a>

      </div>
	 
    <table id="tablaCarrito" class="table">
	</table>
    
</section>
  <footer>
    <a class="icon-footer" href="https//:www.facebook.com"><img class="icon" src="img/facebook.png" alt=""></a>
    <a class="icon-footer" href="https//:www.instagram.com"><img class="icon" src="img/instagram.png" alt=""></a>
    <a class="icon-footer" href="https//:www.twitter.com"><img class="icon" src="img/twitter.png" alt=""></a>
  </footer>
<script src="carrito_app.js"></script>
<script src="cerrarSesion.js"></script>

</body>
</html>