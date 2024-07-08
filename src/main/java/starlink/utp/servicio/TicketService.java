package starlink.utp.servicio;

import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.dto.TicketBusquedaRequestDTO;
import starlink.utp.util.dto.TicketBusquedaResponseDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface TicketService {

    List<Ticket> listarTicketActivos();

    public RespuestaControlador guardar (Ticket ticket) throws MessagingException;

    public RespuestaControlador actualizar (Ticket ticket, String direccion);

    public Ticket findById(Long idTicket);

    TicketBusquedaResponseDTO busquedaPaginada(TicketBusquedaRequestDTO dto);
}
