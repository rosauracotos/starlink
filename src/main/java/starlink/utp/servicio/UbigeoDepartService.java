package starlink.utp.servicio;


import starlink.utp.entidad.ubigeo.UbigeoDepart;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface UbigeoDepartService {

    List<UbigeoDepart> listarUbigeoDepart();

    public RespuestaControlador guardar (UbigeoDepart ubigeoDepart);

    public abstract UbigeoDepart findById(Long idUbigeoDepart);
}
