package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.repositorio.TicketRepository;
import starlink.utp.servicio.TicketService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> listarTicketActivos() {
        return ticketRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(Ticket ticket) {
        RespuestaControlador respuestaControlador;
        ticketRepository.save(ticket);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Ticket ");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(Ticket ticket) {
        return null;
    }

    @Override
    public Ticket findById(Long idTicket) {
        return ticketRepository.findById(idTicket).orElse(null);
    }
}
