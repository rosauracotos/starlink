package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.TipoGeneroService;

@RestController
@RequestMapping("/api/tipoGenero")
public class TipoGeneroController {

    @Autowired
    private TipoGeneroService tipoGeneroService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(tipoGeneroService.listarTipoGenero());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerTipoGeneroId(@PathVariable("id") Long tipoGeneroId) {
        return ResponseEntity.ok(tipoGeneroService.findById(tipoGeneroId));
    }
}
