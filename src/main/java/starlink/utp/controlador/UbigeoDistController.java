package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.entidad.ubigeo.UbigeoDist;
import starlink.utp.servicio.UbigeoDistService;

import java.util.List;

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

    @GetMapping("/provincia/{idProvincia}")
    public ResponseEntity<?> obtenerDistritosPorProvincia(@PathVariable Long idProvincia) {
        List<UbigeoDist> distritos = ubigeoDistService.obtenerDistritosPorProvincia(idProvincia);
        if (!distritos.isEmpty()) {
            return new ResponseEntity<>(distritos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
