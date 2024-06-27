package starlink.utp.servicio;

public interface EmailService {

    void enviarCorreo(String destinatario, String asunto, String cuerpo);

}
