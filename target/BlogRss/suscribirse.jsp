<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/registration.ico">
        <link type="text/css" rel="stylesheet" href="CSS/suscribirseCSS.css"/>
        <script type="text/javascript" src="JS/suscribirseJS.js"/></script>
        <title>Suscribirse</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
         <div class="lineaLista">
            Suscribirse
         </div>
        <div class="areaSuscribirse">
        <form action="controlador" method="POST" id="formularioSuscripcion">
            <table class="suscribirse" >
                <tr><td>
                        <h1>Suscribete</h1>
                        <label>Email:</label>
                        <input type="text" name="email_sus" class="email_sus"/><br/>
                        <label>${suscripcion_lista}</label>
                        <input type="submit" name="botonSuscribirse" value="Suscribirse" class="btnSuscribirse" onclick="return validarSuscripcion()"/>
                    </td></tr>
            </table>
        </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>