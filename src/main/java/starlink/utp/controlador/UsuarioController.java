package starlink.utp.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starlink.utp.servicio.UsuarioService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.dto.LoginRequestDTO;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequestDTO loginRequestDTO){
        try {
            RespuestaControlador rc = usuarioService.validarLogin(loginRequestDTO);
            return ResponseEntity.ok(rc);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

}
