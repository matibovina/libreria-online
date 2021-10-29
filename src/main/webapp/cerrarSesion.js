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
var cerrarSesion = document.querySelector("#cerrarSesion");

cerrarSesion.addEventListener("click", function(){
	llamadaServidor5();
})

var llamada5 = getXMLHTTPRequest();
function llamadaServidor5() {

	var destino = "CerrarSesionServ";
	var numRandom = parseInt(Math.floor(Math.random() * 9999999999999));
	var miUrl = destino + '?random=' + numRandom + "";
	llamada5.open("POST", miUrl, true);
	llamada5.onreadystatechange = respuestaServidor5;
	llamada5.send(null);
}

function respuestaServidor5() {

	if (llamada5.readyState == 4) {
		if (llamada5.status == 200) {
	
			}
		}
	}

