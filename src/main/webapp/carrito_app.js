var id_libro = "";
var button = "";
var totalPrecioCarrito = 0;
var formularioPago = "";
var confirmacionPago = "";
var tablaCarrito = "";
var botonesCarrito = ""
var precioLibro = "";
var opcion = "&opcion="
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
//LLAMADA AJAX PARA LISTAR CARRITO DE COMPRAS 
var llamada3 = getXMLHTTPRequest();
function llamadaServidorCarrito() {

	var destino = "ListarCarritoServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + "";
	llamada3.open("POST", miUrl, true);
	llamada3.onreadystatechange = respuestaServidor;
	llamada3.send(null);
}

function respuestaServidor() {
	if (llamada3.readyState == 4) {
		if (llamada3.status == 200) {
			listaCarrito = llamada3.responseText;
			listaCarritoJSON = JSON.parse(listaCarrito);

			var row = "<tr>" +
				" <th>ID Ciente</th>" +
				" <th>ID Libro</th>" +
				"<th>Titulo</th><th>Precio</th><th>Borrar</th></tr>";
			for (let i = 0; i < listaCarritoJSON.length; i++) {
				row += "<tr><td>" + listaCarritoJSON[i].id_cliente + "</td>" +
					"<td>" + listaCarritoJSON[i].id_libro + "</td>" +
					"<td>" + listaCarritoJSON[i].titulo + "</td>" +
					"<td>" + (Math.round(listaCarritoJSON[i].precio * 100) / 100).toFixed(2) + "&euro;</td>" +
					"<td><button id=\"2\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" +
					listaCarritoJSON[i].precio + "," + listaCarritoJSON[i].id_libro +
					",this)\"><i class=\"fas fa-trash-alt\"></i></button>" +
					"</td></tr>";
				totalPrecioCarrito += listaCarritoJSON[i].precio;
			}
			totalPrecioCarrito = (Math.round(totalPrecioCarrito * 100) / 100).toFixed(2)
			var bottomRow = "<tr>" +
				" <th></th>" +
				" <th></th>" +
				"<th>Total</th><th>" + totalPrecioCarrito + "&euro;</th><th></th></tr>";
			document.getElementById('tablaCarrito').innerHTML = row;
			document.getElementById('tablaCarrito').innerHTML += bottomRow;
			totalPrecioCarrito = 0;
		}
	}
}


//LAMADA AJAX PARA ELIMINAR FILAS DEL CARRITO DE COMPRAS
window.onload = function() {
	llamadaServidorCarrito();

}
formularioPagoBox = document.querySelector("#pago");
confirmacionPago = document.querySelector("#confirmacionCompra");
formularioPagoBox.style.display = "none";
confirmacionPago.style.display = "none";

formularioPago = document.getElementById("form-pago");
formularioPago.addEventListener("submit", function() {


});

function obtenerIdLibro(precio_libro, idLibro, btn) {
	id_libro = idLibro
	precioLibro = precio_libro
	button = btn.id
	opcion += "1"
	llamadaServidorCarritoBorrar()
}
function llamadaServidorCarritoBorrar() {

	var destino = "ListarCarritoServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));

	var miUrl = destino + '?random=' + numRandom + opcion + "&id_libro=" + id_libro;
	llamada3.open("POST", miUrl, true);
	llamada3.onreadystatechange = respuestaServidorBorrar;
	llamada3.send(null);
}

function respuestaServidorBorrar() {
	if (llamada3.readyState == 4) {
		if (llamada3.status == 200) {
			llamadaServidorCarrito()
		}
	}
}
//FUNCIONES PARA MANEJAR EL PAGO DE LOS OBJETOS QUE ESTAN EN CARRITO
botonPagar = document.querySelector("#botonPagar").addEventListener("click", function(e) {
	e.preventDefault()
	mostrarFormulario()
})
function mostrarFormulario() {
	formularioPagoBox.style.display = "flex";
	tablaCarrito = document.querySelector("#tablaCarrito").style.display = "none";
	botonesCarrito = document.querySelector("#botonesCarrito").style.display = "none";
}

formulario = document.getElementById("form-pago").addEventListener("submit", function(e) {
	e.preventDefault()
	opcion += "2"
	console.log(opcion)
	llamadaServidorCarritoBorrar();
	confirmacionPago.style.display = "flex";
	formularioPago.style.display = "none";
})
