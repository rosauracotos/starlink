package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.TicketEstadoService;

@RestController
@RequestMapping("/api/ticketEstado")
public class TicketEstadoController {

    @Autowired
    private TicketEstadoService ticketEstadoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ticketEstadoService.listarTicketEstadoActivos());
    }

    @GetMapping("/listarlibresPorTicket/{ticketId}")
    public ResponseEntity<?> listarLibresPorTicket(@PathVariable("ticketId") Long ticketId){
        return ResponseEntity.ok(ticketEstadoService.listarTicketEstadoLibres(ticketId));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerTicketEstadoId(@PathVariable("id") Long ticketEstadoId) {
        return ResponseEntity.ok(ticketEstadoService.findById(ticketEstadoId));
    }
}
