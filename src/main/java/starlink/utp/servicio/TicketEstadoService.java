package starlink.utp.servicio;

import starlink.utp.entidad.ticket.TicketEstado;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface TicketEstadoService {

    List<TicketEstado> listarTicketEstadoActivos();

    public RespuestaControlador guardar (TicketEstado ticketEstado);

    public RespuestaControlador actualizar (TicketEstado ticketEstado);

    public TicketEstado findById(Long idTicketEstado);
}
