package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.UbigeoDistService;

@RestController
@RequestMapping("/api/ubigeoDistrito")
public class UbigeoDistController {

    @Autowired
    private UbigeoDistService ubigeoDistService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ubigeoDistService.findUbigeoDistByActivoTrue());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerUbigeoDistId(@PathVariable("id") Long ubigeoDisttId) {
        return ResponseEntity.ok(ubigeoDistService.findById(ubigeoDisttId));
    }
}
