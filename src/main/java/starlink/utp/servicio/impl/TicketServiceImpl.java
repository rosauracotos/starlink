package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.repositorio.TicketRepository;
import starlink.utp.servicio.TicketService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;
import starlink.utp.util.dto.TicketBusquedaRequestDTO;
import starlink.utp.util.dto.TicketBusquedaResponseDTO;

import java.util.List;
import java.util.Map;

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

    @Override
    public TicketBusquedaResponseDTO busquedaPaginada(TicketBusquedaRequestDTO dto) {
        List<Map<String, Object>> data = ticketRepository.busquedaPaginadaTicket(dto.getTipoDocumentoId(), dto.getNumeroDocumento(), dto.getFechaInicio(),
                dto.getFechaFin(), dto.getEstadoTicketId(), dto.getNroTicket(), dto.getMax(), dto.getLimite());
        Integer cantidadTotal = ticketRepository.busquedaPaginadaTicketContar(dto.getTipoDocumentoId(), dto.getNumeroDocumento(), dto.getFechaInicio(),
                dto.getFechaFin(), dto.getEstadoTicketId(), dto.getNroTicket());
        TicketBusquedaResponseDTO responseDTO = new TicketBusquedaResponseDTO();
        responseDTO.setData(data);
        responseDTO.setPaginaActual(dto.getLimite());
        responseDTO.setTotalRegistros(cantidadTotal);
        responseDTO.setCantidadPorPagina( dto.getMax());
        return responseDTO;
    }
}
