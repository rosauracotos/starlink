package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.UbigeoDepartService;

@RestController
@RequestMapping("/api/ubigeoDepartamento")
public class UbigeoDepartController {

    @Autowired
    private UbigeoDepartService ubigeoDepartService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ubigeoDepartService.listarUbigeoDepart());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerUbigeoDepartId(@PathVariable("id") Long ubigeoDepartId) {
        return ResponseEntity.ok(ubigeoDepartService.findById(ubigeoDepartId));
    }
}
