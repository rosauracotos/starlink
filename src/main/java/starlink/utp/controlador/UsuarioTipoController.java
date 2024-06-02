package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.UsuarioTipoService;

@RestController
@RequestMapping("/api/usuarioTipo")
public class UsuarioTipoController {

    @Autowired
    private UsuarioTipoService usuarioTipoService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(usuarioTipoService.listarUsuarioTipo());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerUsuarioTipoId(@PathVariable("id") Long usuarioTipoId) {
        return ResponseEntity.ok(usuarioTipoService.findById(usuarioTipoId));
    }
}
