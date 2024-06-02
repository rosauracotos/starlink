package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.TicketEstado;
import starlink.utp.repositorio.TicketEstadoRepository;
import starlink.utp.servicio.TicketEstadoService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class TicketEstadoServiceImpl implements TicketEstadoService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketEstadoRepository ticketEstadoRepository;

    @Override
    public List<TicketEstado> listarTicketEstadoActivos() {
        return ticketEstadoRepository.findTicketEstadoByEstadoTrue();
    }

    @Override
    public RespuestaControlador guardar(TicketEstado ticketEstado) {
        return null;
    }

    @Override
    public RespuestaControlador actualizar(TicketEstado ticketEstado) {
        return null;
    }

    @Override
    public TicketEstado findById(Long idTicketEstado) {
        return ticketEstadoRepository.findById(idTicketEstado).orElse(null);
    }
}
