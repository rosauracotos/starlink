package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.repositorio.TicketGestionRepository;
import starlink.utp.servicio.TicketGestionService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class TicketGestionServiceImpl implements TicketGestionService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketGestionRepository ticketGestionRepository;
    @Override
    public List<TicketGestion> listarTicketGestionActivos() {
        return ticketGestionRepository.findTicketGestionByEstadoTrue();
    }

    @Override
    public RespuestaControlador guardar(TicketGestion ticketGestion) {
        RespuestaControlador respuestaControlador;
        ticketGestionRepository.save(ticketGestion);
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
}
