package starlink.utp.servicio;

import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface TicketService {

    List<Ticket> listarTicketActivos();

    public RespuestaControlador guardar (Ticket ticket);

    public RespuestaControlador actualizar (Ticket ticket);

    public Ticket findById(Long idTicket);
}
