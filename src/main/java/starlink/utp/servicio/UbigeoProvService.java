package starlink.utp.servicio;


import starlink.utp.entidad.ubigeo.UbigeoProv;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface UbigeoProvService {

    List<UbigeoProv> listarUbigeoProv();

    RespuestaControlador guardar (UbigeoProv ubigeoProv);

    abstract UbigeoProv findById(Long idUbigeoProv);

    List<UbigeoProv> obtenerProvinciasPorDepartamento(Long idDepartamento);
}
