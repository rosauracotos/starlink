package starlink.utp.servicio;

import starlink.utp.entidad.ubigeo.UbigeoDist;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface UbigeoDistService {

    List<UbigeoDist> findUbigeoDistByActivoTrue();

    RespuestaControlador guardar (UbigeoDist ubigeoDist);

    abstract UbigeoDist findById(Long idUbigeoDist);

    List<UbigeoDist> obtenerDistritosPorProvincia(Long idProvincia);
}
