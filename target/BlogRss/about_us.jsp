<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/info.ico">
        <link type="text/css" rel="stylesheet" href="CSS/aboutusCSS.css"/>
        <title>Acerca de nosostros</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
         <div class="lineaLista">
            Sobre nosotros
         </div>
        <div class="sobreNosotros"> 
            <label>
                <img src="./imagenes/vogue.jpg"/><br/><br/>
                <h3>Misión</h3>
                Somos una web dedicada a informar a todos nuestros suscriptores acerca de la artista Lady Gaga.<br/><br/>
                <h3>Visión</h3>
                Poder llegar a ser la comunidad mas grande.
            </label>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
