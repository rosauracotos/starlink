package starlink.utp.servicio;

import starlink.utp.entidad.master.TipoGenero;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface TipoGeneroService {

    List<TipoGenero> listarTipoGenero();

    public RespuestaControlador guardar (TipoGenero tipoGenero);

    public RespuestaControlador actualizar (TipoGenero tipoGenero);

    public abstract TipoGenero findById(Long idTipoGenero);
}
