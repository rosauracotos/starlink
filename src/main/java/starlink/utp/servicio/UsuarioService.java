package starlink.utp.servicio;

import starlink.utp.entidad.persona.Persona;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.dto.LoginRequestDTO;


public interface UsuarioService {

    RespuestaControlador validarLogin(LoginRequestDTO loginRequestDTO);

}
