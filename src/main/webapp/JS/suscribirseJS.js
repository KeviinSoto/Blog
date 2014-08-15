function validarSuscripcion(){
    
    var usuario = document.forms["formularioSuscripcion"]["email_sus"].value;
    var expresion = /^\s*$/;
    var email_expr = /^(.+\@.+\..+)$/;
    
    if (usuario === null || usuario === "" || expresion.test(usuario)){
        alert("El campo email es obligatorio.");
        document.forms["formularioSuscripcion"]["email_sus"].focus();
        return false;
    }
    else if(!email_expr.test(usuario)){
        alert("El email introducido no es valido.");
        document.forms["formularioSuscripcion"]["email_sus"].focus();
        return false;
    }

}