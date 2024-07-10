package starlink.utp.servicio;


import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.util.RespuestaControlador;

import java.util.List;
import java.util.Map;

public interface TicketGestionService {

    List<TicketGestion> listarTicketGestionActivos();

    public RespuestaControlador guardar (TicketGestion ticketGestion);

    public RespuestaControlador actualizar (TicketGestion ticketGestion);

    public TicketGestion findById(Long idTicketGestion);

    List<Map<String, Object>> obtenerEstadosPorTicket(Long ticketId);

}
