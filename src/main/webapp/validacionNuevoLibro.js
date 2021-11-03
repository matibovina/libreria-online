/* VALIDACION DE FORMULARIO - CONTACTO */
	let formLibroNuevo = document.querySelector("#nuevoLibro")

formLibroNuevo.addEventListener("submit", function(e){
	let usuarioRegex = /\s/g
	let mensajeError = document.querySelector("#mensajeError");
	let regexPrecio = /^[0-9]+$/gm
	let titulo = document.querySelector('#titulo');
	let autor = document.querySelector('#autor');
	let genero = document.querySelector('#genero');
	let precio = document.querySelector('#precio');
	let isbnValue = ""
	let isbnRegex = /^[0-9]{3}[\-][0-9]{3}?$/gm
	mensajeError.innerHTML = "";
	let isbn = document.getElementById('isbn');
	isbnValue = isbn.value
	mensajeError.innerHTML = "";
	if(titulo.value.length == 0 || autor.value.length == 0 || isbn.value.length == 0 || genero.value.length == 0 || precio.value.length == 0){
		e.preventDefault()
		mensajeError.innerHTML = "Debe completar todos los campos"
	} 
	else if(!isbnRegex.test(isbnValue)){
		e.preventDefault()
		mensajeError.innerHTML = "Formato ISBN incorrecto. 000-000 (3 digitos un guion 3 digitos)"
	}
	else if (!regexPrecio.test(precio.value)) {
		e.preventDefault()
		mensajeError.innerHTML = "Ingrese un numero entero"
	}
}) 

