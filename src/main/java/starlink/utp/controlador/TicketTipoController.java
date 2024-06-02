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
import starlink.utp.entidad.ticket.TicketTipo;
import starlink.utp.servicio.TicketTipoService;
import starlink.utp.util.RespuestaControlador;

@RestController
@RequestMapping("/api/ticketTipo")
public class TicketTipoController {

    @Autowired
    private TicketTipoService ticketTipoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ticketTipoService.listarTicketTipoActivos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerTicketTipoId(@PathVariable("id") Long ticketTipoId) {
        return ResponseEntity.ok(ticketTipoService.findById(ticketTipoId));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody TicketTipo ticketTipo){
        try {
            RespuestaControlador rc = ticketTipoService.guardar(ticketTipo);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
