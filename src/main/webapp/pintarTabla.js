

var llamada2 = getXMLHTTPRequest();
var formulario = document.querySelector("#buscarBtn");
var selectedItem = document.getElementById("selector");
var valorBusqueda = document.querySelector("#valorBuscar");
var tablaCompleta = document.getElementById("pintarTabla");
var botonAtras = document.querySelector("#atras");
var formPrecio = "";
var inputPrecio = "";
var precioNuevo = "";
var optionUrl = "";
var buscador = "";
var dialogoPrecio = "";
var botonDelete = document.querySelector(".delete");
var id_libro = "";
var button = "";
var carrito = document.querySelector("#cantidadCarrito");
var contadorCarrito = 0;
var id_cliente = document.querySelector("#id_cliente");
var regexPrecio =   /^[0-9]+([.][0-9]{2})?$/gm
var mensajeError = ""


//FUNCION QUE SEGUN EL ID DEL USUARIO DEFINE LOS ACCESOS
function rolUsuario() {
	var botonEditar = document.querySelectorAll(".editar");
	var botonBorrar = document.querySelectorAll(".borrar");
	var botonCarrito = document.querySelectorAll(".carrito");
	var botonComprar = document.querySelectorAll(".comprar");
	var botonLibroNuevo = document.querySelector("#libroNuevo");
	var thRol = document.querySelector("#thRol");
	if (id_cliente.value != 1) {
		botonLibroNuevo.style.display = "none";
		thRol.innerHTML = "Agregar al carrito / Comprar";

		for (let i = 0; i < botonEditar.length; i++) {
			botonEditar[i].style.display = "none";
			botonBorrar[i].style.display = "none";
		}
	}
}



function getXMLHTTPRequest() {
	try {
		req = new XMLHttpRequest();
	} catch (err1) {
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
//LLAMADA AL SERVIDOR PARA TRAER LA TABLA LIBROS COMPLETA
var llamada = getXMLHTTPRequest();
function llamadaServidor() {

	var destino = "ListarLibrosServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + "";
	llamada.open("GET", miUrl, true);
	llamada.onreadystatechange = respuestaServidor;
	llamada.send(null);
}

function respuestaServidor() {

	if (llamada.readyState == 4) {
		if (llamada.status == 200) {

			listaLibros = llamada.responseText;
			listaLibrosJSON = JSON.parse(listaLibros);

			var row = "<tr>" +
				" <th>ID</th>" +
				" <th>Titulo</th>" +
				"<th>Autor</th>" +
				"<th>ISBN</th>" +
				"<th>Genero</th>" +
				"<th>Precio</th>" +
				"<th id=\"thRol\">Editar / Borrar / Agregar al carrito / Comprar</th>" +
				"</tr>";
			for (let i = 0; i < listaLibrosJSON.length; i++) {
				row += "<tr><td>" + listaLibrosJSON[i].id_libro + "</td>" +
					"<td>" + listaLibrosJSON[i].titulo + "</td>" +
					"<td>" + listaLibrosJSON[i].autor + "</td>" +
					"<td>" + listaLibrosJSON[i].ISBN + "</td>" +
					"<td>" + listaLibrosJSON[i].genero + "</td>" +
					"<td>" + listaLibrosJSON[i].precio + "&euro;</td>" +
					"<td><input type=\"hidden\" name=\"opcion\" value=\"3\">" +
					"<button id=\"1\" class=\"actions editar\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"editar fas fa-edit\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"4\">" +
					"<button id=\"2\" class=\"actions borrar\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"borrar fas fa-trash-alt\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"5\">" +
					"<button id=\"3\" class=\"actions carrito\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"fas fa-cart-plus\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"6\">" +
					"<button id=\"4\" class=\"actions comprar\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><a href=\"carrito.jsp\" class=\"actions\"><i class=\"fas fa-credit-card\"></i></a></button>" +
					"</td></tr>"
			}

			document.getElementById('pintarTabla').innerHTML = row;
			rolUsuario()
		}
	}
}
botonAtras.style.display = "none";
// FUNCION PARA UTILIZAR EL BUSCADOR POR TITULO O ISBN
formulario.addEventListener("submit", function(e) {
	e.preventDefault();
	if(selectedItem.value == 0 && valorBusqueda.value.length == 0){
		e.preventDefault();
	} else {
		llamadaServidorBuscador();
	}
	
})
// LLAMADA AJAX AL SERVIDOR PARA OBTENER LOS VALORES SEGUN LA BUSQUEDA REALIZADA
//PINTA UNA NUEVA TABLA CON EL RESULTADO DE LA BUSQUEDA Y ESCONDE LA TABLA COMPLETA DE LIBROS
function llamadaServidorBuscador() {
	buscador = "&buscador=" + valorBusqueda.value;
	var destino = "AccionesServ";
	console.log("intenta hacer la llamada");
	if (selectedItem.value == 1 && valorBusqueda.value.length != 0) {
		optionUrl = "&opcion=1";
	} else if (selectedItem.value == 2 && valorBusqueda.value.length != 0) {
		optionUrl = '&opcion=2';
	}

	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + optionUrl + buscador;
	llamada2.open("POST", miUrl, true);
	llamada2.onreadystatechange = respuestaServidorBuscador;
	llamada2.send(null);
	buscador = "";
}

function respuestaServidorBuscador() {
	if (llamada2.readyState == 4) {
		if (llamada2.status == 200) {

			resultadoBusqueda = llamada2.responseText;
			resultadoBusquedaJSON = JSON.parse(resultadoBusqueda);

			if (resultadoBusquedaJSON.length != 0) {

				var row = "<tr>" +
					" <th>ID</th>" +
					" <th>Titulo</th>" +
					"<th>Autor</th>" +
					"<th>ISBN</th>" +
					"<th>Genero</th>" +
					"<th>Precio</th>" +
					"<th id=\"thRol\">Editar / Borrar / Agregar al carrito / Comprar</th>" +
					"</tr>";

				for (let i = 0; i < resultadoBusquedaJSON.length; i++) {
					row += "<tr><td>" + resultadoBusquedaJSON[i].id_libro + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].titulo + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].autor + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].ISBN + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].genero + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].precio + "&euro;</td>" +
						"<td><input type=\"hidden\" name=\"opcion\" value=\"3\">" +
						"<button id=\"1\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"editar fas fa-edit\"></i></button>" +
						"<input type=\"hidden\" name=\"opcion\" value=\"4\">" +
						"<button id=\"2\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"borrar fas fa-trash-alt\"></i></button>" +
						"<input type=\"hidden\" name=\"opcion\" value=\"5\">" +
						"<button id=\"3\" class=\"actions carrito\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"fas fa-cart-plus\"></i></button>" +
						"<input type=\"hidden\" name=\"opcion\" value=\"6\">" +
						"<button id=\"4\" class=\"actions comprar\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><a href=\"carrito.jsp\" class=\"actions\"><i class=\"fas fa-credit-card\"></i></a></button>" +
						"</td></tr>"
				}
				
				tablaCompleta.style.display = "none";
				document.querySelector("#resultadoBusqueda").innerHTML = "Se encontraron  " + resultadoBusquedaJSON.length + " libros que coinciden";
				document.getElementById('pintarTablaBuscador').style.display = "block";
				document.getElementById('pintarTablaBuscador').innerHTML = row;
				botonAtras.style.display = "block";
				rolUsuario()

			}
		}
	}
}

//FUNCION PARA OBTENER EL ID DEL BOTON DEL FORMULARIO DE CAMBIAR PRECIO
function aceptarCancelar(id_boton) {
	dialogoPrecio = id_boton.id;
}
//FUNCION PARA EL BOTON ATRAS - ESCONDE LA TABLA BUSQUEDA Y MUESTRA LA TABLA COMPLETA
botonAtras.addEventListener("click", function() {
	tablaCompleta.style.display = "block";
	document.getElementById('pintarTablaBuscador').style.display = "none";
	botonAtras.style.display = "none";
	document.querySelector("#resultadoBusqueda").innerHTML = "";
	selectedItem.value = 0 
	valorBusqueda.value = ""
})
var llamadaAcciones = getXMLHTTPRequest();
//FUNCION PARA OBTENER EL ID DEL LIBRO DE LA FILA Y LA ACCION SELECCIONADAS
function obtenerIdLibro(idLibro, btn) {
	id_libro = idLibro
	button = btn.id
	mensajeError = document.querySelector("#mensajeError");
	mensajeError.innerHTML = ""
	//SI EL BOTON ES 1 - EDITAR
	if (button == "1") {
		formPrecioBox = document.querySelector(".cambioPrecio");
		formPrecioBox.style.display = "flex";
		formPrecio = document.querySelector(".precioNuevo-form")
		formPrecio.addEventListener("submit", function(e) {
		var precioOk = 0;
		inputPrecio = document.querySelector("#precioNuevo");
			e.preventDefault()
			mensajeError.innerHTML = "3"
			if (dialogoPrecio == "true" && inputPrecio.value.length != 0 && regexPrecio.test(inputPrecio.value)) {
				precioNuevo = "&precio=" + inputPrecio.value;
				inputPrecio.value = "";
				formPrecioBox.style.display = "none";
				mensajeError.innerHTML = "1"
				llamadaServidorAcciones()
				precioOk = 1;
				}  else if(dialogoPrecio == "true" && precioOk == 0) {
					e.preventDefault()
				mensajeError.innerHTML = "Solo admite numeros sin espacios"
				
			} else if (dialogoPrecio == "false") {
				formPrecioBox.style.display = "none";
				mensajeError.innerHTML = "2"
				inputPrecio.value = "";
			}
		})
	} else {
		llamadaServidorAcciones()
	}
}
//LLAMADA AJAX AL SERVIDOR CON TODAS LAS ACCIONES DE LA TABLA 

function llamadaServidorAcciones() {
	var destino = "AccionesServ";
	var numRandom = Math.floor(Math.random() * 9999999999999);
	var miUrl = "";
	if (button == "1") {
		optionUrl = "&opcion=3";
		
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro + precioNuevo;
		console.log(miUrl)
	} else if (button == "2") {
		optionUrl = "&opcion=4";
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro;
	} else if (button == "3") {
		optionUrl = "&opcion=5";
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro;
	} else if (button == "4") {
		optionUrl = "&opcion=6";
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro;
	}
	llamadaAcciones.open("POST", miUrl, true);
	llamadaAcciones.onreadystatechange = respuestaServidorAcciones;
	llamadaAcciones.send(null);

}
function respuestaServidorAcciones() {
	if (llamadaAcciones.readyState == 4) {
		if (llamadaAcciones.status == 200) {
			if (button == "3") {
				llamadaServidorContador()
			}
			llamadaServidor()
		}
	}
}

var llamadaContadorCarrito = getXMLHTTPRequest();
//LLAMADA AJAX AL SERVIDOR DE CONTADOR CARRITO PARA IMPRIMIR LA CANTIDAD DE INFORMACION QUE TIENE CARRITO
function llamadaServidorContador() {
	var destino = "contadorCarritoServ";
	var numRandom = Math.floor(Math.random() * 9999999999999);
	console.log("llama a contador carrito por el GET");
	var miUrl = destino + '?random=' + numRandom;
	llamadaContadorCarrito.open("POST", miUrl, true);
	llamadaContadorCarrito.onreadystatechange = respuestaServidorContador
	llamadaContadorCarrito.send(null);
}

function respuestaServidorContador() {
	if (llamadaContadorCarrito.readyState == 4) {
		if (llamadaContadorCarrito.status == 200) {

			let resultadoBusqueda = llamadaContadorCarrito.responseText;
			console.log(parseInt(resultadoBusqueda))
			contadorCarrito = parseInt(resultadoBusqueda);
			carrito.innerHTML = contadorCarrito;
		}
	}
}


window.onload = function() {
	llamadaServidorContador()
	llamadaServidor();

}


