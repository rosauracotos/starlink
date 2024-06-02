package starlink.utp.servicio;

import starlink.utp.entidad.master.TipoDoc;
import starlink.utp.entidad.master.TipoGenero;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface TipoDocService {

    List<TipoDoc> listarTipoDoc();

    public RespuestaControlador guardar (TipoDoc tipoDoc);

    public RespuestaControlador actualizar (TipoDoc tipoDoc);

    public abstract TipoDoc findById(Long idTipoDoc);
}
