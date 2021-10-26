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
var carrito = document.querySelector("#carrito");
var contadorCarrito = 0;
function aceptarCancelar(id_boton){
	dialogoPrecio = id_boton.id;
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

var llamada = getXMLHTTPRequest();
function llamadaServidor() {

	var destino = "ListarLibrosServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + "";
	console.log(miUrl);
	llamada.open("GET", miUrl, true);
	llamada.onreadystatechange = respuestaServidor;
	llamada.send(null);
}

function respuestaServidor() {
	console.log("esta funcion es llamada");

	if (llamada.readyState == 4) {
		console.log(llamada.status);
		if (llamada.status == 200) {

			listaLibros = llamada.responseText;
			listaLibrosJSON = JSON.parse(listaLibros);

			console.log("ESTA LISTA ESTA EN EL AJAX" + listaLibros);

			console.log(listaLibros);



			var row = "<tr>" +
				" <th>ID</th>" +
				" <th>Titulo</th>" +
				"<th>Autor</th>" +
				"<th>ISBN</th>" +
				"<th>Genero</th>" +
				"<th>Precio</th>" +
				"<th>Editar / Borrar / Agregar al carrito / Comprar</th>" +
				"</tr>";
			console.log("el json tiene: " + listaLibrosJSON.length);
			for (let i = 0; i < listaLibrosJSON.length; i++) {
				row += "<tr><td>" + listaLibrosJSON[i].id_libro + "</td>" +
					"<td>" + listaLibrosJSON[i].titulo + "</td>" +
					"<td>" + listaLibrosJSON[i].autor + "</td>" +
					"<td>" + listaLibrosJSON[i].ISBN + "</td>" +
					"<td>" + listaLibrosJSON[i].genero + "</td>" +
					"<td>" + listaLibrosJSON[i].precio + "</td>" +
					"<td><input type=\"hidden\" name=\"opcion\" value=\"3\">" +
					"<button id=\"1\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"fas fa-edit\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"4\">" +
					"<button id=\"2\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"fas fa-trash-alt\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"5\">" +
					"<button id=\"3\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"fas fa-cart-plus\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"6\">" +
					"<button id=\"4\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + listaLibrosJSON[i].id_libro + ",this)\"><i class=\"fas fa-credit-card\"></i></button>" +
					"</td></tr>"
			}

			document.getElementById('pintarTabla').innerHTML = row;
		}
	}
}

window.onload = function() {
	llamadaServidor();
}



botonAtras.style.display = "none";
formulario.addEventListener("submit", function(e) {
	e.preventDefault();

	llamadaServidorBuscador();
})


function llamadaServidorBuscador() {
	buscador = "&buscador=" + valorBusqueda.value;
	var destino = "AccionesServ";
	if (selectedItem.value == 1 && valorBusqueda.value.length != 0) {
		optionUrl = "&opcion=1";
	} else if (selectedItem.value == 2 && valorBusqueda.value.length != 0) {
		optionUrl = '&opcion=2';
	}

	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + optionUrl + buscador;
	console.log(miUrl);
	llamada2.open("POST", miUrl, true);
	llamada2.onreadystatechange = respuestaServidorBuscador;
	llamada2.send(null);
	buscador = "";
}



function respuestaServidorBuscador() {
	if (llamada2.readyState == 4) {
		console.log(llamada2.status);
		if (llamada2.status == 200) {

			resultadoBusqueda = llamada2.responseText;
			console.log(llamada2.responseText);
			resultadoBusquedaJSON = JSON.parse(resultadoBusqueda);

			console.log("ESTA LISTA ESTA EN EL AJAX del buscador" + resultadoBusqueda);
		/*	document.getElementById('resultado').innerHTML = resultadoBusqueda; */
			console.log(resultadoBusqueda);
			if (resultadoBusquedaJSON.length != 0) {


					tablaCompleta.style.display = "none";

				var row = "<tr>" +
				" <th>ID</th>" +
				" <th>Titulo</th>" +
				"<th>Autor</th>" +
				"<th>ISBN</th>" +
				"<th>Genero</th>" +
				"<th>Precio</th>" +
				"<th>Editar / Borrar / Agregar al carrito / Comprar</th>" +
				"</tr>";

				for (let i = 0; i < resultadoBusquedaJSON.length; i++) {
					console.log("Entro al loop");
					row += "<tr><td>" + resultadoBusquedaJSON[i].id_libro + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].titulo + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].autor + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].ISBN + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].genero + "</td>" +
						"<td>" + resultadoBusquedaJSON[i].precio + "</td>" +
					"<td><input type=\"hidden\" name=\"opcion\" value=\"3\">" +
					"<button id=\"1\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"fas fa-edit\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"4\">" +
					"<button id=\"2\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"fas fa-trash-alt\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"5\">" +
					"<button id=\"3\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"fas fa-cart-plus\"></i></button>" +
					"<input type=\"hidden\" name=\"opcion\" value=\"6\">" +
					"<button id=\"4\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + resultadoBusquedaJSON[i].id_libro + ",this)\"><i class=\"fas fa-credit-card\"></i></button>" +
					"</td></tr>"
				}
				document.getElementById('pintarTablaBuscador').style.display = "block";
				document.getElementById('pintarTablaBuscador').innerHTML = row;
				botonAtras.style.display = "block";
			}
		}
	}
}



botonAtras.addEventListener("click", function(){
	tablaCompleta.style.display = "block";
	document.getElementById('pintarTablaBuscador').style.display = "none";
	botonAtras.style.display = "none";
})

var llamadaDelete = getXMLHTTPRequest();

function obtenerIdLibro(idLibro, btn){
	id_libro = idLibro
	button = btn.id
	console.log(button + "este es el boton tocado");
	if(button == "1"){
		formPrecio = document.querySelector(".cambioPrecio");
		formPrecio.style.display = "flex";
		document.querySelector(".precioNuevo-form").addEventListener("submit", function(e){
			e.preventDefault()
			if(dialogoPrecio == "true"){
		inputPrecio = document.querySelector("#precioNuevo");
		precioNuevo ="&precio=" + inputPrecio.value;
		console.log("el precio nuevo es: " + precioNuevo)
		formPrecio.style.display = "none";
		llamadaServidorAcciones()
		} else if(dialogoPrecio == "false") {
		formPrecio.style.display = "none";
		inputPrecio.value = "";
		}
		})
		
		
	} else {
		llamadaServidorAcciones() 
	}
	console.log(id_libro + "id libro + id boton " + button)
}

function llamadaServidorAcciones() {
	var destino = "AccionesServ";
	console.log(id_libro + " con este id entra a la llamada del servidor")
	var numRandom = Math.floor(Math.random() * 9999999999999);
	var miUrl = "";
	if(button == "1"){
		optionUrl = "&opcion=3";
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro + precioNuevo;
		
	} else if(button == "2"){
		console.log(id_libro + "este es el id del libro elegeido")
		optionUrl = "&opcion=4";
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro;
	} else if(button == "3"){
		optionUrl = "&opcion=5";
		miUrl = destino + '?random=' + numRandom + optionUrl + "&id_libro=" + id_libro;
	} else if(button == "4"){
		optionUrl = "&opcion=6";
	}

	console.log(miUrl)
	llamada.open("POST", miUrl, true);
	llamada.onreadystatechange = respuestaServidorAcciones;
	llamada.send(null);
	inputPrecio.value = "";
}

function respuestaServidorAcciones(){
		if (llamada.readyState == 4) {
		if (llamada.status == 200) {
	  
	 
		llamadaServidor()
	  if(button == "3"){
		carrito.innerHTML = "("+ (contadorCarrito++) +")";
		console.log("respuesta servidor en boton carrito")
		llamadaServidor()
	} else if(button == "4"){
		console.log("respuesta servidor en boton comprar")
	}
			
		}
	}
}
