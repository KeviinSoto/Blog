<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/noticia.ico">
        <link type="text/css" rel="stylesheet" href="CSS/indexCSS.css"/>
        <title>Noticias</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="lineaLista">
            Noticias
        </div>
        <div class="muestro_noticia"> 
            <form action="controlador" method="POST" id="formularioNoticias">
                <div class="muestro_noticia_por_fecha"> 
                    <h2>Todas las noticias</h2>
                    <label class="menu_titulos">${menu_titulo1}</label>
                </div>
                <div class="noticia_m">
                    <label class="noticia_label">${noticia_completa}</label>
                </div>
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
