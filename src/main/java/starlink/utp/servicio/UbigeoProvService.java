package starlink.utp.servicio;


import starlink.utp.entidad.ubigeo.UbigeoProv;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface UbigeoProvService {

    List<UbigeoProv> listarUbigeoProv();

    public RespuestaControlador guardar (UbigeoProv ubigeoProv);

    public abstract UbigeoProv findById(Long idUbigeoProv);
}
