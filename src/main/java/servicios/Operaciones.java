package servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Suscriptor;
import modelo.Noticia;
import modelo.Resumen;

public class Operaciones {

    EntityManagerFactory emf;
    EntityManager em;

    public Operaciones() {
        emf = Persistence.createEntityManagerFactory("BLOGRSS");
        em = emf.createEntityManager();
    }

    public void guardarNoticia(Noticia noticia) {
        try {
            em.getTransaction().begin();
            em.persist(noticia);
            em.getTransaction().commit();
        } catch (Exception w) {
            System.out.println(w);
        }
    }
    
    public void guardarResumen(Resumen resumen){
            try {
            em.getTransaction().begin();
            em.persist(resumen);
            em.getTransaction().commit();
        } catch (Exception w) {
            System.out.println(w);
        }
    }

    public void guardarSuscriptor(Suscriptor suscriptor) {
        try {
            em.getTransaction().begin();
            em.persist(suscriptor);
            em.getTransaction().commit();
        } catch (Exception w) {
            System.out.println(w);
        }
    }

    public void enviarCorreo() {
        String email;
        EmailService emailS = new EmailService();
        try {
            List<Suscriptor> lista = em.createQuery("Select s FROM Suscriptor s", Suscriptor.class).getResultList();
            for (Suscriptor suscriptor : lista) {
                email = suscriptor.getEmail();
                emailS.sendEmailNoticias(email);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String mostrarNoticia() {
        String resultado = null, titulo, contenido;
        try {
            List<Noticia> lista = em.createQuery("SELECT n FROM Noticia n where n.id = (SELECT MAX(n.id) FROM Noticia n)", Noticia.class).getResultList();
            for (Noticia noticia : lista) {
                titulo = noticia.getTitulo();
                contenido = noticia.getDescripcion();
                resultado = titulo + "<br/><br/>" + contenido;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return resultado;
    }

    public String mostrarNoticiaElegida(int id) {
        String resultado = null, titulo, contenido;
        try {
            List<Noticia> lista = em.createQuery("SELECT n FROM Noticia n where n.id = :id1", Noticia.class).setParameter("id1", id).getResultList();
            for (Noticia noticia : lista) {
                titulo = noticia.getTitulo();
                contenido = noticia.getDescripcion();
                resultado = titulo + "<br/><br/>" + contenido;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return resultado;
    }

    public boolean verificarCorreo(String email) {
        boolean verificador = false;
        String email_obtenido;
        try {
            List<Suscriptor> lista = em.createQuery("Select s FROM Suscriptor s", Suscriptor.class).getResultList();
            for (Suscriptor suscriptor : lista) {
                email_obtenido = suscriptor.getEmail();
                if (email == null ? email_obtenido == null : email.equals(email_obtenido)) {
                    verificador = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return verificador;
    }

    public String mostrarListaCompleta() {
        String titulo, resultado = "";
        int id;
        try {
            List<Noticia> lista = em.createQuery("SELECT n FROM Noticia n ORDER BY n.id ASC", Noticia.class).getResultList();
            for (Noticia noticia : lista) {
                titulo = noticia.getTitulo();
                id = noticia.getId();
                resultado = "<a href=\"./controlador?id=" + noticia.getId() + "&form=1\">" + titulo + "</a>" + "<br/><br/>" + "<a href=\"./controlador?id=" + noticia.getId() + "&form=1\">" + resultado + "</a>";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public String mostrarListado() {
        Date fecha = new Date();
        Date fecha_base, fecha_final;
        DateFormat df = DateFormat.getDateInstance();
        df.format(fecha);
        String titulo, resultado = "", fecha_c;
        int id, sumar;
        try {
            List<Noticia> lista = em.createQuery("SELECT n FROM Noticia n ORDER BY n.id ASC", Noticia.class).getResultList();
            for (Noticia noticia : lista) {
                fecha_base = noticia.getFecha();
                String formato = "dd";
                SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                fecha_c = dateFormat.format(fecha);
                sumar = Integer.valueOf(fecha_c) - 05;
                if (sumar < 1) {
                    sumar = 1;
                }
                String.valueOf(sumar);
                String formato2 = "yyyy-MM-" + sumar + "";
                SimpleDateFormat dateFormat1 = new SimpleDateFormat(formato2);
                fecha_c = dateFormat1.format(fecha);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fecha_final = formatter.parse(fecha_c);

                if (fecha_base.after(fecha_final)) {
                    titulo = noticia.getTitulo();
                    id = noticia.getId();
                    resultado = "<a href=\"./controlador?id=" + noticia.getId() + "\">" + titulo + "</a>" + "<br/><br/>" + "<a href=\"./controlador?id=" + noticia.getId() + "\">" + resultado + "</a>";
                }

            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public String Noticias() {
        Date fecha = new Date();
        Date fecha_base, fecha_final;
        DateFormat df = DateFormat.getDateInstance();
        df.format(fecha);
        String resultado = "", texto, titulo, fecha_c;
        int sumar;
        try {
            List<Resumen> lista = em.createQuery("Select r FROM Resumen r", Resumen.class).getResultList();
            for (Resumen resumen : lista) {
                fecha_base = resumen.getFecha();
                String formato = "dd";
                SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                fecha_c = dateFormat.format(fecha);
                sumar = Integer.valueOf(fecha_c) - 05;
                if (sumar < 1) {
                    sumar = 1;
                }
                String.valueOf(sumar);
                String formato2 = "yyyy-MM-" + sumar + "";
                SimpleDateFormat dateFormat1 = new SimpleDateFormat(formato2);
                fecha_c = dateFormat1.format(fecha);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fecha_final = formatter.parse(fecha_c);

                if (fecha_base.after(fecha_final)) {
                    texto = resumen.getDescripcion();
                    titulo = resumen.getTitulo();
                    resultado = resultado + "<br/><br/>" + titulo + "<br/><br/>" + texto;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return resultado;
    }
}
