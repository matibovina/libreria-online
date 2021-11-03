/* VALIDACION DE FORMULARIO - CONTACTO */
let register = document.querySelector("#register");


register.addEventListener("submit", function(e){

let mensajeError = document.querySelector("#mensajeError");
let emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/gmi;
let passwordRegex = /[0-9]{4,}/
let userRegex = /^[a-z0-9]+$/gm;
let nombre = document.querySelector('#nombre');
let apellido = document.querySelector('#apellido');
let fecha = document.querySelector('#fechaNamicimiento');
let email = document.querySelector('#email'); 
let user = document.querySelector('#user'); 
//|| 
let password = document.querySelector('#password'); 
let password1 = document.querySelector('#password1'); 
	if(nombre.value.length == 0 || apellido.value.length == 0 || fecha.value.length == 0 || email.value.length == 0 || user.value.length == 0 || password.value.length == 0 || password1.value.length == 0){
		e.preventDefault()
		mensajeError.innerHTML = "Los campos no pueden estar vacios en javascript"
	} else if(!emailRegex.test(email.value)){
			
			e.preventDefault()
			mensajeError.innerHTML = "El formato de email es incorrecto - \"usuario@email.com\""
	
			console.log("si el email es incorrecto")
		} else if(!userRegex.test(user.value)){
			e.preventDefault()
			mensajeError.innerHTML = "El usuario debe contener letras minusculas y numeros"
		} else if(!passwordRegex.test(password.value)){
			e.preventDefault()
			mensajeError.innerHTML = "La password debe contener 4digitos no secuenciales o consecutivos"
		} else if(password1.value != password.value){
			e.preventDefault()
			mensajeError.innerHTML = "Las password no coinciden."
		} 
}) 
























//var numRandom ='?random=' + parseInt(Math.floor(Math.random() * 9999999999999));
//var botonPresionado = ""

//
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