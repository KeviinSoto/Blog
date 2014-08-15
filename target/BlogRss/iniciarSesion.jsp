<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/session.ico">
        <link type="text/css" rel="stylesheet" href="CSS/iniciarSesionCSS.css"/>
        <script type="text/javascript" src="JS/iniciarSesionJS.js"/></script>
        <title>Iniciar Sesion</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
         <div class="lineaLista">
            Iniciar Sesión
         </div>
        <div class="areaIniciarSesion">
        <form action="controlador" method="POST" id="formularioSesion">
            <table class="iniciarSesion" >
                <tr><td>
                        <h1>Iniciar sesión</h1>
                        <label>Usuario:</label>
                        <input type="text" name="usuario" class="usuario"/><br/>
                        <label>Contraseña:</label>
                        <input type="password" name="password" class="password"/><br/>
                        <label>${incorrecto}</label><br/>
                        <input type="submit" value="Iniciar sesión" name ="botonIniciarSesion" class="botonIniciarSesion" onclick="return validarIniciarSesion()"/>
                    </td></tr>
            </table>
        </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
