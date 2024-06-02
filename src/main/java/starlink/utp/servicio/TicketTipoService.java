package starlink.utp.servicio;


import starlink.utp.entidad.ticket.TicketTipo;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface TicketTipoService {


    List<TicketTipo> listarTicketTipoActivos();
    public RespuestaControlador guardar (TicketTipo ticketTipo);

    public RespuestaControlador actualizar (TicketTipo ticketTipo);

    public TicketTipo findById(Long idTicketTipo);

}
