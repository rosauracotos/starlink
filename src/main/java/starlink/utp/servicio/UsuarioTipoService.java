package starlink.utp.servicio;

import starlink.utp.entidad.seguridad.UsuarioTipo;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface UsuarioTipoService {

    List<UsuarioTipo> listarUsuarioTipo();

    public RespuestaControlador guardar (UsuarioTipo usuarioTipo);

    public abstract UsuarioTipo findById(Long idUsuarioTipo);
}
