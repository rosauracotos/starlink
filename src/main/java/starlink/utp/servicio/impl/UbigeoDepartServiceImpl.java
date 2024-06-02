package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ubigeo.UbigeoDepart;
import starlink.utp.repositorio.UbigeoDepartRepository;
import starlink.utp.servicio.UbigeoDepartService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class UbigeoDepartServiceImpl implements UbigeoDepartService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private UbigeoDepartRepository ubigeoDepartRepository;
    @Override
    public List<UbigeoDepart> listarUbigeoDepart() {
        return ubigeoDepartRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(UbigeoDepart ubigeoDepart) {
        return null;
    }

    @Override
    public UbigeoDepart findById(Long idUbigeoDepart) {
        return ubigeoDepartRepository.findById(idUbigeoDepart).orElse(null);
    }
}
