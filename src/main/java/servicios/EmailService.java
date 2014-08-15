package servicios;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    private Session session;
    Operaciones opera = new Operaciones();

    private void init() {

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "CORREO");//Debe escribir su correo
        props.setProperty("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props);
        session.setDebug(true);
    }

    public void sendEmailSuscripcion(String email) {

        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("CORREO"));//Debe escribir su correo
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("¡Gracias por la suscripcion!");
            message.setText("Se ha suscrito a la pagina NewsLadyGaga, en la cual le mantendremos informado de los mas actuales detalles sobre giras, videos, albumes y vida de Lady Gaga.");
            Transport t = session.getTransport("smtp");
            t.connect("CORREO", "CONTRASEÑA");//Debe escribir su correo y contraseña
            t.sendMessage(message, message.getAllRecipients());
            t.close();

        } catch (MessagingException me) {
            System.out.println(me);
        }

    }
    
    public void sendEmailNoticias(String email) {

        init();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("CORREO"));//Debe escribir su correo
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("¡Weekly Newsletter!");
            message.setText(opera.Noticias(), "ISO-8859-1","html");
            Transport t = session.getTransport("smtp");
            t.connect("CORREO", "CONTRASEÑA");//Debe escribir su correo y contraseña
            t.sendMessage(message, message.getAllRecipients());
            t.close();

        } catch (MessagingException me) {
            System.out.println(me);
        }

    }

}
