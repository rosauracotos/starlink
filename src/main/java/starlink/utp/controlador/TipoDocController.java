package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.TipoDocService;


@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocController {

    @Autowired
    private TipoDocService tipoDocService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(tipoDocService.listarTipoDoc());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerTipoDocId(@PathVariable("id") Long tipoDocId) {
        return ResponseEntity.ok(tipoDocService.findById(tipoDocId));
    }
}
