<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/administrador.ico">
        <link type="text/css" rel="stylesheet" href="CSS/admCSS.css"/>
        <script type="text/javascript" src="JS/admJS.js"/></script>
        <title>Agregar Noticia</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
         <div class="lineaLista">
            Administrador
         </div>
        <form action="controlador" method="POST" id="formularioAdministrador">
            <input type="submit" value="Cerrar sesión" name="botonCerrarSesion" class="btnCerrarSesion">
            <table class="nuevaNoticia" >
                <tr><td>
                        <h2>Nueva noticia</h2>
                        <label>Titulo:</label>
                        <input type="text" name="titulo" class="titulo"/><br/>
                        <label>Contenido:</label>
                        <textarea name="NoticiaA" rows="10" cols="160" class="txtArea" /></textarea><br/>
                        <label>${contacto_listo}</label><br/>
                        <input type="submit" value="Publicar Noticia" name ="botonPublicarNotica" class="botonPublicarNoticia" onclick="return validarAdministrador()"/>
                        <input type="submit" value="Guardar Resumen" name ="botonGuardarResumen" class="botonGuardarResumen" onclick="return validarAdministrador()"/>
                        <input type="submit" value="Enivar Noticia" name ="botonEnviarNotica" class="botonEnviarNoticia"/>
                    </td></tr>
            </table>
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
