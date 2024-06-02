package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.TicketTipo;
import starlink.utp.repositorio.TicketTipoRepository;
import starlink.utp.servicio.TicketTipoService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class TicketTipoServiceImpl implements TicketTipoService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketTipoRepository ticketTipoRepository;


    @Override
    public List<TicketTipo> listarTicketTipoActivos() {
        return ticketTipoRepository.findTicketTipoByEstadoTrue();
    }

    @Override
    public RespuestaControlador guardar(TicketTipo ticketTipo) {
        RespuestaControlador respuestaControlador;
        ticketTipoRepository.save(ticketTipo);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Ticket Tipo");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(TicketTipo ticketTipo) {
        RespuestaControlador respuestaControlador;
        ticketTipoRepository.save(ticketTipo);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoActualizar("Ticket Tipo");
        respuestaControlador.setExtraInfo(ticketTipo.getId());
        return respuestaControlador;
    }

    @Override
    public TicketTipo findById(Long idTicketTipo) {
        return ticketTipoRepository.findById(idTicketTipo).orElse(null);
    }
}
