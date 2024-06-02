package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.UbigeoProvService;

@RestController
@RequestMapping("/api/ubigeoProvincia")
public class UbigeoProvController {

    @Autowired
    private UbigeoProvService ubigeoProvService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(ubigeoProvService.listarUbigeoProv());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerUbigeoProvId(@PathVariable("id") Long ubigeoProvtId) {
        return ResponseEntity.ok(ubigeoProvService.findById(ubigeoProvtId));
    }
}
