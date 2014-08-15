function validarAdministrador(){
    
    var titulo = document.forms["formularioAdministrador"]["titulo"].value;
    var contenido = document.forms["formularioAdministrador"]["NoticiaA"].value;
    var expresion = /^\s*$/;
    
    if (titulo === null || titulo === "" || expresion.test(titulo)){
        alert("El campo titulo es obligatorio.");
        document.forms["formularioAdministrador"]["titulo"].focus();
        return false;
    }
    else if(contenido === null || contenido === "" || expresion.test(contenido)){
        alert("El campo contenido es obligatorio.");
        document.forms["formularioAdministrador"]["NoticiaA"].focus();
        return false;
    }
}