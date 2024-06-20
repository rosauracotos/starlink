package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.entidad.ubigeo.UbigeoProv;
import starlink.utp.servicio.UbigeoProvService;

import java.util.List;

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

    @GetMapping("/departamento/{idDepartamento}")
    public ResponseEntity<?> obtenerProvinciasPorDepartamento(@PathVariable Long idDepartamento) {
        List<UbigeoProv> provincias = ubigeoProvService.obtenerProvinciasPorDepartamento(idDepartamento);
        if (!provincias.isEmpty()) {
            return new ResponseEntity<>(provincias, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
