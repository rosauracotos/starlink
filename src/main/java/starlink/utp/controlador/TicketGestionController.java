package starlink.utp.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.entidad.ticket.TicketGestion;
import starlink.utp.servicio.TicketGestionService;
import starlink.utp.util.RespuestaControlador;

@RestController
@RequestMapping("/api/ticketGestion")
public class TicketGestionController {

    @Autowired
    private TicketGestionService ticketGestionService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ticketGestionService.listarTicketGestionActivos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerTicketGestionId(@PathVariable("id") Long ticketGestionId) {
        return ResponseEntity.ok(ticketGestionService.findById(ticketGestionId));
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<?> obtenerEstadoDeTciket(@PathVariable("id") Long ticketId) {
        return ResponseEntity.ok(ticketGestionService.obtenerEstadosPorTicket(ticketId));
    }

    @PostMapping("/guardarGestion")
    public ResponseEntity<?> registrarGestion(@RequestBody TicketGestion ticketGestion){
        try {
            RespuestaControlador rc = ticketGestionService.guardar(ticketGestion);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
