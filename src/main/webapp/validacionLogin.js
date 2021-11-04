/* VALIDACION DE FORMULARIO - CONTACTO */
var usuarioRegex = /\s/g
var loginForm = document.querySelector("#loginForm");
var mensajeError = document.querySelector("#mensajeError");
var user = document.querySelector("#user");
var password = document.querySelector("#password");

loginForm.addEventListener("submit", function(e){
	if(user.value.length == 0 || password.value.length == 0){				
			e.preventDefault()
			mensajeError.innerHTML = "Los campos no pueden estar vacios"
	}
	else if(usuarioRegex.test(user.value) || usuarioRegex.test(password.value)){
			
			e.preventDefault()
			mensajeError.innerHTML = "No puede contener espacios en blanco"
		} 
}) 
























//var numRandom ='?random=' + parseInt(Math.floor(Math.random() * 9999999999999));
//var botonPresionado = ""

//var register = document.querySelector("#register");
//var nuevoLibro = document.querySelector("#nuevoLibro")
/*
var opcion ="&opcion="
var mensajeError = document.querySelector("#mensajeError");
mensajeError.style.display = "none"
*/
/*

logIn.addEventListener("submit", function(e){
	e.preventDefaul()

  let usuario = document.querySelector('#user');
  let password = document.querySelector('#password');
	console.log(usuario.value + " " + password.value)
	//if(usuario.value.length == 0 || password.value.length == 0){
//		console.log("listo")

		
	//	mensajeError.style.display = "block"
//	}
})
*/
/*
register.addEventListener("submit", function(e){
var emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
var passwordRegex = "[0-9]{4}"
let nombre = document.querySelector('#nombre');
let apellido = document.querySelector('#apellido');
let fecha = document.querySelector('#fechaNacimiento');
let email = document.querySelector('#email'); 
let user = document.querySelector('#user'); 
let password = document.querySelector('#password'); 
let password1 = document.querySelector('#password1'); 
	if(nombre.length == 0 || apellido.length == 0 || fecha.length == 0 || email.length == 0 || user.length == 0 || password.length == 0 || password1.length == 0){
		e.preventDefaul()
		mensajeError.style.display = "block"
	} else if(!emailRegex.test(email.value)){
		e.preventDefaul()
		mensajeError.style.display = "block"
	}else if(!passwordRegex.test(password)){
		e.preventDefaul()
		mensajeError.style.display = "block"
	} else if(password1 != password){
		e.preventDefaul()
		mensajeError.style.display = "block"
	}
})

nuevoLibro.addEventListener("submit", function(){
	let titulo = document.querySelector('#titulo');
	let autor = document.querySelector('#autor');
	let isbn = document.querySelector('#isbn');
	let genero = document.querySelector('#genero');
	let precio = document.querySelector('#precio');

	if(titulo.length == 0 || autor.length == 0 || isbn.length == 0 || genero.length == 0 || precio.length == 0){
		e.preventDefaul()
		mensajeError.style.display = "block"
}
})


function validarLogin(){
  document.querySelector('.formulario').style.display = "none";
  document.querySelector('.mensajeEnviado').style.display = "block";
}
  let usario = document.getElementsByName('user');
  let password = document.getElementsByName('password');
function validacionLogin(){
	usuario = ""
	usuarioRegex = "/^[a-zA-Z0-9]+$/"
	var password = ""
	var passwordRegex = "[0-9]{4}"
}

function validacionRegistro(){

  
	var nombreRegex = "/^[a-zA-Z\-]+$/"

  let ok = 4;

  if(nombre.value.length == 0){
    nombre.style.border = "2px solid red";
  } else{
    nombre.style.border = "none";
    ok--;
  }
  console.log(ok)
  if(apellido.value.length == 0){
    apellido.style.border  = "2px solid red";
  }else{
    apellido.style.border = "none";
    ok--;
  }
  console.log(ok)
  if(fecha.value.length == 0){
    fecha.style.border = "2px solid red";
  }else{
    fecha.style.border  = "none";
    ok--;
  }
  console.log(ok)
  if (!emailRegex.test(email.value)){
    email.style.border = "2px solid red";
   } else {
    email.style.border  = "none";
    ok--;
   }
   
  if(ok == 0){
    miFuncion();
  }

}


*/


// var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[1-9]|2[1-9])$/;
// var testDate = "03/17/21"
// if (date_regex.test(testDate)) {
//     document.getElementById("message").innerHTML = "Date follows dd/mm/yy format";
// }
// else{
//   document.getElementById("message").innerHTML = "Invalid date format";
// }