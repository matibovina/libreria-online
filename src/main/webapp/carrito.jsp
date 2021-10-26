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
   <a href="index.jsp"><img class="logo-nav" src="logo/logo_white_large.png" alt=""></a> 
  </header>
  <div class="buscar">
    <form action="">
      <p>
        Comprar todos los elementos de la lista
      </p>
      <input type="submit" value="Comprar">
    </form>
  </div>
  <section>
    <table class="tabla">
			<tr>
				<th>ID</th>
				<th>Titulo</th>
        <th>Autor</th>
        <th>Genero</th>
        <th>Precio</th>
        <th>Borrar</th>
			</tr>
					
<%-- 				<!-- <% 
					for(Libro libro : (ArrayList<Libro>)request.getAttribute("listaLibros")){
				%> --> --%>
			<tr>
				<td>001</td>
				<td>Harry Potter</td>
				<td>JK Rowling</td>
        <td>Fantasia</td>
        <td>50 euros</td>
        <td>
          <a class="actions" href=""><i class="fas fa-trash-alt"></i></a>
        </td>
			</tr>
			<tr>
				<td>001</td>
				<td>Harry Potter</td>
				<td>JK Rowling</td>
        <td>Fantasia</td>
        <td>50 euros</td>
        <td>
          <a class="actions" href=""><i class="fas fa-trash-alt"></i></a>
        </td>
			</tr>
			<tr>
				<td>001</td>
				<td>Harry Potter</td>
				<td>JK Rowling</td>
        <td>Fantasia</td>
        <td>50 euros</td>
        <td>
          <a class="actions" href=""><i class="fas fa-trash-alt"></i></a>
        </td>
			</tr>
			<tr>
				<td>001</td>
				<td>Harry Potter</td>
				<td>JK Rowling</td>
        <td>Fantasia</td>
        <td>50 euros</td>
        <td>
          <a class="actions" href=""><i class="fas fa-trash-alt"></i></a>
        </td>
			</tr>
      <tr>
				<th></th>
        <th></th>
        <th></th>
        <th>Total a pagar</th>
        <th>$2000</th>
        <th></th>


			</tr>
		</table>
    
</section>
  <footer>
    <a class="icon-footer" href="https//:www.facebook.com"><img class="icon" src="img/facebook.png" alt=""></a>
    <a class="icon-footer" href="https//:www.instagram.com"><img class="icon" src="img/instagram.png" alt=""></a>
    <a class="icon-footer" href="https//:www.twitter.com"><img class="icon" src="img/twitter.png" alt=""></a>
  </footer>

</body>
</html>