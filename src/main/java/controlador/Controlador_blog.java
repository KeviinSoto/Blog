package controlador;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import modelo.Noticia;
import modelo.Resumen;
import modelo.Suscriptor;
import servicios.Operaciones;
import servicios.EmailService;

public class Controlador_blog extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cad = request.getParameter("id");
        Operaciones operacion = new Operaciones();
        request.getSession().setAttribute("titulo", "Iniciar Sesión");
        request.getSession().setAttribute("link", "\"./iniciarSesion.jsp\"");
        if (cad == null) {
            request.setAttribute("noticia_completa", operacion.mostrarNoticia());

        } else {
            request.setAttribute("noticia_completa", operacion.mostrarNoticiaElegida(Integer.valueOf(cad)));
        }
        request.setAttribute("menu_titulo1", operacion.mostrarListaCompleta());
        request.setAttribute("menu_titulo", operacion.mostrarListado());
        String form = request.getParameter("form");
        if (form != null) {
            RequestDispatcher rd = request.getRequestDispatcher("noticias.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //CODIGO PARA INICIAR SESION
        Operaciones operacion = new Operaciones();
        String usuario, password_iniciar_sesion, botonIniciarSesion, usuario_valor, password_valor;
        boolean autentificacion;
        usuario = request.getParameter("usuario");
        password_iniciar_sesion = request.getParameter("password");
        botonIniciarSesion = request.getParameter("botonIniciarSesion");
        usuario_valor = getServletConfig().getInitParameter("email").toString();
        password_valor = getServletConfig().getInitParameter("password").toString();
        if (botonIniciarSesion != null) {
            try {
                autentificacion = usuario_valor.equals(usuario) && password_valor.equals(password_iniciar_sesion);
                if (autentificacion == true) {
                    HttpSession Session = request.getSession();
                    Session.setAttribute("usuario", usuario);
                    request.getSession().setAttribute("titulo", "Administrador en línea");
                    request.getSession().setAttribute("link", "#");
                    RequestDispatcher rd = request.getRequestDispatcher("administrador.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("incorrecto", "El usuario/contraseña es incorrecto. \n Verifique.");
                    RequestDispatcher rd = request.getRequestDispatcher("iniciarSesion.jsp");
                    rd.forward(request, response);

                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

        //CODIGO PARA OPERACIONES
        Date date = new Date();
        EmailService emailEnvio = new EmailService();
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("NoticiaA");
        String botonEnviarNotica = request.getParameter("botonEnviarNotica");
        String botonPublicarNotica = request.getParameter("botonPublicarNotica");
        String botonGuardarResumen = request.getParameter("botonGuardarResumen");
        String email_sus = request.getParameter("email_sus");
        String botonSuscribirse = request.getParameter("botonSuscribirse");
        String botonCerrarSesion = request.getParameter("botonCerrarSesion");
        Noticia noticia = new Noticia(titulo, descripcion, date);
        Resumen resumen = new Resumen(titulo, descripcion, date);
        Suscriptor suscriptor = new Suscriptor(email_sus, date);

        if (botonPublicarNotica != null) {
            operacion.guardarNoticia(noticia);
            request.setAttribute("contacto_listo", "La noticia ha sido publicada correctamente");
            RequestDispatcher rd = request.getRequestDispatcher("administrador.jsp");
            rd.forward(request, response);
        }

        if (botonSuscribirse != null) {
            if (operacion.verificarCorreo(email_sus) == false) {
                operacion.guardarSuscriptor(suscriptor);
                emailEnvio.sendEmailSuscripcion(email_sus);
                request.setAttribute("suscripcion_lista", "Su suscripción se ha realizado correctamente.");
                RequestDispatcher rd = request.getRequestDispatcher("suscribirse.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("suscripcion_lista", "El correo que introdujo ya está suscrito a nuestra página");
                RequestDispatcher rd = request.getRequestDispatcher("suscribirse.jsp");
                rd.forward(request, response);
            }
        }
        if (botonCerrarSesion != null) {
            request.getSession().invalidate();
            request.getSession().setAttribute("titulo", "Iniciar Sesión");
            request.getSession().setAttribute("link", "\"./iniciarSesion.jsp\"");
            RequestDispatcher rd = request.getRequestDispatcher("iniciarSesion.jsp");
            rd.forward(request, response);
        }
        if (botonGuardarResumen != null) {
            operacion.guardarResumen(resumen);
            request.setAttribute("contacto_listo", "El resumen de la noticia ha sido almacenado correctamente");
            RequestDispatcher rd = request.getRequestDispatcher("administrador.jsp");
            rd.forward(request, response);
        }
        if (botonEnviarNotica != null) {
            operacion.enviarCorreo();
            request.setAttribute("contacto_listo", "El resumen de las noticias semanales ha sido enviado correctamente.");
            RequestDispatcher rd = request.getRequestDispatcher("administrador.jsp");
            rd.forward(request, response);
        }

    }

}
