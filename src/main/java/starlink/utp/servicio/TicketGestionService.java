package starlink.utp.servicio;


import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface TicketGestionService {

    List<TicketGestion> listarTicketGestionActivos();

    public RespuestaControlador guardar (TicketGestion ticketGestion);

    public RespuestaControlador actualizar (TicketGestion ticketGestion);

    public TicketGestion findById(Long idTicketGestion);
}
