package starlink.utp.servicio;

import starlink.utp.entidad.ubigeo.UbigeoDist;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface UbigeoDistService {

    List<UbigeoDist> findUbigeoDistByActivoTrue();

    public RespuestaControlador guardar (UbigeoDist ubigeoDist);

    public abstract UbigeoDist findById(Long idUbigeoDist);
}
