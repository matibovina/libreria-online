var id_libro = "";
var button = "";
var totalPrecioCarrito = 0;

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

var llamada3 = getXMLHTTPRequest();
function llamadaServidorCarrito() {

	var destino = "ListarCarritoServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + "";
	console.log(miUrl + "esta url es de la lista")
	llamada3.open("POST", miUrl, true);
	llamada3.onreadystatechange = respuestaServidor;
	llamada3.send(null);
}

function respuestaServidor() {
	if (llamada3.readyState == 4) {
		console.log(llamada3.status);
		if (llamada3.status == 200) {
			listaCarrito = llamada3.responseText;
			console.log(listaCarrito);
			listaCarritoJSON = JSON.parse(listaCarrito);
			console.log(listaCarritoJSON);
			var row = "<tr>" +
				" <th>ID Ciente</th>" +
				" <th>ID Libro</th>" +
				"<th>Titulo</th><th>Precio</th><th>Borrar</th></tr>";
			console.log("el json tiene: " + listaCarritoJSON.length);
			for (let i = 0; i < listaCarritoJSON.length; i++) {
				console.log("ENTRA AL FOR LOOP");
				row += "<tr><td>" + listaCarritoJSON[i].id_cliente + "</td>" +
					"<td>" + listaCarritoJSON[i].id_libro + "</td>" +
					"<td>" + listaCarritoJSON[i].titulo + "</td>" +
					"<td>" + listaCarritoJSON[i].precio + "&euro;</td>" +
					"<td><button id=\"2\" class=\"actions\" type=\"submit\" onclick=\"obtenerIdLibro(" + 
					listaCarritoJSON[i].id_libro + 
					",this)\"><i class=\"fas fa-trash-alt\"></i></button>" +
					"</td></tr>";
					totalPrecioCarrito += listaCarritoJSON[i].precio;
			}
			var bottomRow =  "<tr>" +
				" <th></th>" +
				" <th></th>" +
				"<th>Total</th><th>" + totalPrecioCarrito + "&euro;</th><th></th></tr>";
			document.getElementById('tablaCarrito').innerHTML = row;
			document.getElementById('tablaCarrito').innerHTML += bottomRow;

		}
	}
}



window.onload = function() {
	llamadaServidorCarrito();
}


function obtenerIdLibro(idLibro, btn){
	id_libro = idLibro
	
	button = btn.id
	llamadaServidorCarritoBorrar()
	}
	function llamadaServidorCarritoBorrar() {

	var destino = "ListarCarritoServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));

	var miUrl = destino + '?random=' + numRandom + "&opcion=1" + "&id_libro=" + id_libro ;
	console.log(miUrl);
	llamada3.open("POST", miUrl, true);
	llamada3.onreadystatechange = respuestaServidorBorrar;
	llamada3.send(null);
}

function respuestaServidorBorrar() {
	console.log("esta funcion es llamada boton borrar");

	if (llamada3.readyState == 4) {
		console.log(llamada3.status);
		if (llamada3.status == 200) {
				llamadaServidorCarrito()
			}
			}
			}
	
