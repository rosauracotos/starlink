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
import starlink.utp.entidad.persona.Persona;
import starlink.utp.servicio.PersonaService;
import starlink.utp.util.RespuestaControlador;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(personaService.findPersonaByActivoTrue());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerPersonaId(@PathVariable("id") Long personaId) {
        return ResponseEntity.ok(personaService.findById(personaId));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar (@RequestBody Persona persona){
        try {
            RespuestaControlador rc = personaService.guardar(persona);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
