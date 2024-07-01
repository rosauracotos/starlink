package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.entidad.ticket.Ticket;
import starlink.utp.servicio.TicketService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.dto.TicketBusquedaRequestDTO;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ticketService.listarTicketActivos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerTicketId(@PathVariable("id") Long ticketId) {
        return ResponseEntity.ok(ticketService.findById(ticketId));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody Ticket ticket){
        try {
            RespuestaControlador rc = ticketService.guardar(ticket);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PutMapping("/editar/{ticketid}")
    public ResponseEntity<?> editar(@PathVariable Long ticketid, @RequestBody Ticket ticket) {
        Ticket ticketDb = ticketService.findById(ticketid);
        if (ticketDb != null) {
            ticketDb.setAsunto(ticket.getAsunto());
            ticketDb.setTicketTipo(ticket.getTicketTipo());
            RespuestaControlador rc = ticketService.actualizar(ticketDb, ticket.getPersona().getDireccion());
            return ResponseEntity.ok(rc);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/busquedaPagina")
    public ResponseEntity<?> busquedaPaginada(@RequestBody TicketBusquedaRequestDTO dto) {
        return ResponseEntity.ok(ticketService.busquedaPaginada(dto));
    }
}
