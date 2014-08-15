function validarIniciarSesion(){
    
    var usuario = document.forms["formularioSesion"]["usuario"].value;
    var password = document.forms["formularioSesion"]["password"].value;
    var expresion = /^\s*$/;
    var email_expr = /^(.+\@.+\..+)$/;
    
    if (usuario === null || usuario === "" || expresion.test(usuario)){
        alert("El campo usuario es obligatorio.");
        document.forms["formularioSesion"]["usuario"].focus();
        return false;
    }
    else if(!email_expr.test(usuario)){
        alert("El email introducido no es valido.");
        document.forms["formularioSesion"]["usuario"].focus();
        return false;
    }
    else if(password === null || password === "" || expresion.test(password)){
        alert("El campo contraseña es obligatorio.");
        document.forms["formularioSesion"]["password"].focus();
        return false;
    }
}