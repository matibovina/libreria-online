

function getXMLHTTPRequest() {
	try {
	req = new XMLHttpRequest();
	} catch(err1) {
	  try {
	  req = new ActiveXObject("Msxml2.XMLHTTP");
	  } catch (err2) {
		try {
		req = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (err3) {
		  req = false;
		}
	  }
	}
	return req;
	} 
	
var llamada = getXMLHTTPRequest();
function llamadaServidorBuscador(){

  var destino2 = "accionesLibrosServ";
  var numRandom = Math.floor(Math.random()*9999999999999999);
  var miUrl2 = destino2 + '?random=' + numRandom;
	console.log(miUrl2);
  llamada.open("GET", miUrl2, true);
  llamada.onreadystatechange = respuestaBusquedaServidor;
  llamada.send(null);
}

function respuestaBusquedaServidor(){
	console.log("esta funcion es llamada");

  if(llamada.readyState == 4){
	console.log(llamada.status);
	if(llamada.status == 200){
	
	   listaLibros = llamada.responseText; 
		listaLibrosJSON = JSON.parse(listaLibros);
		
		console.log("ESTA LISTA ESTA EN EL AJAX"+listaLibros);
	 /* document.getElementById('resultado').innerHTML = listaLibros;*/
	console.log(listaLibros);
	
 

  var row =  "<tr>"+
   " <th>ID</th>"+
   " <th>Titulo</th>"+
	"<th>Autor</th>"+
	"<th>ISBN</th>"+
	"<th>Genero</th>"+
	"<th>Precio</th>"+
	"<th>Editar / Borrar / Agregar al carrito / Comprar</th>"+
  "</tr>";
 
  for(let i = 0; i < listaLibrosJSON.length; i++){
	row += "<tr><td>"+listaLibrosJSON[i].id_libro+"</td>"+
	"<td>"+ listaLibrosJSON[i].titulo +"</td>"+
	"<td>"+ listaLibrosJSON[i].autor +"</td>"+
	"<td>"+ listaLibrosJSON[i].ISBN +"</td>"+
	"<td>"+ listaLibrosJSON[i].precio +"</td>"+
	"<td>"+ listaLibrosJSON[i].genero +"</td>"+
	"<td><input type=\"hidden\" name=\"opcion\" value=\"3\">"+
	"<a class=\"actions\" href=\"\"><i class=\"fas fa-edit\"></i></a>"+
	"<input type=\"hidden\" name=\"opcion\" value=\"4\">"+
	  "<a class=\"actions\" href=\"\"><i class=\"fas fa-trash-alt\"></i></a>"+
	   "<input type=\"hidden\" name=\"opcion\" value=\"5\">"+
	   "<a class=\"actions\" href=\"\"><i class=\"fas fa-cart-plus\"></i></a> "+
	   "<input type=\"hidden\" name=\"opcion\" value=\"6\">"+
	   "<a class=\"actions\" href=\"\"><i class=\"fas fa-credit-card\"></i></a>"+
	   "</td></tr>"
  }

  document.getElementById('pintarTabla').innerHTML = row;
}
} 
}






/*var mostrarTabla = function (tablaCompleta) {
	tablaCompleta.style.display = 'block';
};

var esconderTabla = function (tablaCompleta) {
	tablaCompleta.style.display = 'none';
};

var toggle = function (elem) {

	// If the element is visible, hide it
	if (window.getComputedStyle(tablaCompleta).display === 'block') {
		esconderTabla(tablaCompleta);
		return;
	}

	// Otherwise, show it
	mostrarTabla(elem);

};*/
const formulario = document.getElementById("buscarBtn");
var selectedItem = document.getElementById("selector");
var valorBuscar = document.getElementById("valorBuscar");
var tablaCompleta = document.getElementById("pintarTabla");
formulario.addEventListener("submit", function(e) {
console.log(selectedItem + "nombre Libro" +valorBuscar);
	e.preventDefault();
	if (selectedItem != 0 && valorBuscar.length != 0) {
		
console.log(selectedItem.value + " nombre Libro " +valorBuscar.value);
	llamadaServidorBuscador();
	}

});

