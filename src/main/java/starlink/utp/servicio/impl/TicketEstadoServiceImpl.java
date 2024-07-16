package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ticket.TicketEstado;
import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.repositorio.TicketEstadoRepository;
import starlink.utp.repositorio.TicketGestionRepository;
import starlink.utp.servicio.TicketEstadoService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketEstadoServiceImpl implements TicketEstadoService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TicketEstadoRepository ticketEstadoRepository;

    @Autowired
    private TicketGestionRepository ticketGestionRepository;

    @Override
    public List<TicketEstado> listarTicketEstadoActivos() {
        return ticketEstadoRepository.findTicketEstadoByEstadoTrue();
    }

    @Override
    public List<TicketEstado> listarTicketEstadoLibres(Long ticketId){
        List<TicketEstado> todosEstados = this.listarTicketEstadoActivos();
        List<TicketGestion> gestionTicket = ticketGestionRepository.findByTicketIdAndEstadoTrue(ticketId);
        List<TicketEstado> estadosLibres = new ArrayList<TicketEstado>();
        if (!todosEstados.isEmpty() && !gestionTicket.isEmpty()){
            for (TicketEstado estado : todosEstados){
                Boolean encontrado = Boolean.FALSE;
                for (TicketGestion gestion : gestionTicket){
                    if (estado.getId().equals(gestion.getTicketEstado().getId())) {
                        encontrado = Boolean.TRUE;
                    }
                }
                if (!encontrado) {
                    estadosLibres.add(estado);
                }
            }
        }
        return estadosLibres;
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
