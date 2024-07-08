package starlink.utp.servicio.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import starlink.utp.servicio.EmailService;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        // Configuración de las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia esto por tu servidor SMTP
        props.put("mail.smtp.port", "587"); // Puerto SMTP

        // Credenciales del remitente
        String username = "peruexpressutp@gmail.com";
        String password = "ecvj svtm iecu oeks";

        // Inicialización de la sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Creación del mensaje de correo
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username)); // Dirección de correo del remitente
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Dirección de correo del destinatario
        message.setSubject(subject); // Asunto del correo
        message.setText(body); // Contenido del correo (texto plano)

        // Envío del mensaje
        Transport.send(message);
    }

}
