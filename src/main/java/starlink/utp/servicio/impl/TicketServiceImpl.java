package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.persona.Persona;
import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.entidad.ticket.TicketEstado;
import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.repositorio.PersonaRepository;
import starlink.utp.repositorio.TicketGestionRepository;
import starlink.utp.repositorio.TicketRepository;
import starlink.utp.servicio.EmailService;
import starlink.utp.servicio.TicketService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;
import starlink.utp.util.dto.TicketBusquedaRequestDTO;
import starlink.utp.util.dto.TicketBusquedaResponseDTO;
import starlink.utp.util.enums.EstadoTicketEnum;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TicketGestionRepository ticketGestionRepository;

    @Override
    public List<Ticket> listarTicketActivos() {
        return ticketRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(Ticket ticket) throws MessagingException {
        RespuestaControlador respuestaControlador;
        TicketEstado ticketEstado = new TicketEstado();
        ticketEstado.setId(EstadoTicketEnum.REGISTRADO.getId());
        ticket.setTicketEstado(ticketEstado);
        ticket.setNumero(obtenerSiguienteNroTicket());
        ticketRepository.save(ticket);

        TicketGestion ticketGestion = new TicketGestion();
        ticketGestion.setTicket(ticket);
        ticketGestion.setTicketEstado(ticketEstado);
        ticketGestion.setComentario("Ticket Registrado");
        ticketGestionRepository.save(ticketGestion);

        Persona persona = personaRepository.findById(ticket.getPersona().getId()).orElse(null);
        persona.setDireccion(ticket.getPersona().getDireccion());
        personaRepository.save(persona);

        String mensaje = "Estimado(a) " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + " " + persona.getNombre() +
                ", se ha registrado su Ticket Nro: "+ ticket.getNumero() + "\n" + "\n" +
                " Descripción : " + ticket.getAsunto();

        emailService.sendEmail(persona.getCorreo(), "Ticket N° " + ticket.getNumero() , mensaje);

        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Ticket ");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(Ticket ticket, String direccion) {
        RespuestaControlador respuestaControlador;
        ticketRepository.save(ticket);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoActualizar("Ticket");

        Persona persona = personaRepository.findById(ticket.getPersona().getId()).orElse(null);
        persona.setDireccion(direccion);
        personaRepository.save(persona);

        return respuestaControlador;
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

    private Integer obtenerSiguienteNroTicket() {
        return (int) ticketRepository.contarTickets() + 1;
    }
}
