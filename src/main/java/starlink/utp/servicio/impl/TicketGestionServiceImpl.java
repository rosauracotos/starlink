package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.repositorio.TicketGestionRepository;
import starlink.utp.repositorio.TicketRepository;
import starlink.utp.servicio.EmailService;
import starlink.utp.servicio.TicketGestionService;
import starlink.utp.servicio.TicketService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;

@Service
public class TicketGestionServiceImpl implements TicketGestionService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketGestionRepository ticketGestionRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmailService emailService;

    @Override
    public List<TicketGestion> listarTicketGestionActivos() {
        return ticketGestionRepository.findTicketGestionByEstadoTrue();
    }

    @Override
    public RespuestaControlador guardar(TicketGestion ticketGestion) throws MessagingException {
        RespuestaControlador respuestaControlador;
        ticketGestionRepository.save(ticketGestion);
        Ticket ticket = ticketService.findById(ticketGestion.getTicket().getId());
        ticket.setTicketEstado(ticketGestion.getTicketEstado());
        ticketRepository.save(ticket);
        // Enviar correo luego se implementa
        String mensaje = "Estimado(a) " + ticket.getPersona().getApellidoPaterno() + " " + ticket.getPersona().getApellidoMaterno() + " " + ticket.getPersona().getNombre() +
                ", se ha actualizado su Ticket Nro: "+ ticket.getNumero() + "\n" + "\n" +
                " Estado : " + ticketGestion.getTicketEstado() + "\n" +
                " Comentario:" + ticketGestion.getComentario();

        emailService.sendEmail(ticket.getPersona().getCorreo(), "Actualización Ticket N° " + ticket.getNumero() , mensaje);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Ticket Gestion");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(TicketGestion ticketGestion) {
        return null;
    }

    @Override
    public TicketGestion findById(Long idTicketGestion) {
        return ticketGestionRepository.findById(idTicketGestion).orElse(null);
    }

    @Override
    public List<Map<String, Object>> obtenerEstadosPorTicket(Long ticketId) {
        return ticketGestionRepository.findEstadosGestionPorTicket(ticketId);
    }
}
