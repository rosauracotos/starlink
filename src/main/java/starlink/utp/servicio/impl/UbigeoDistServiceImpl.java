package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ubigeo.UbigeoDist;
import starlink.utp.repositorio.UbigeoDistRepository;
import starlink.utp.servicio.UbigeoDistService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class UbigeoDistServiceImpl implements UbigeoDistService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private UbigeoDistRepository ubigeoDistRepository;

    @Override
    public List<UbigeoDist> findUbigeoDistByActivoTrue() {
        return ubigeoDistRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(UbigeoDist ubigeoDist) {
        return null;
    }

    @Override
    public UbigeoDist findById(Long idUbigeoDist) {
        return ubigeoDistRepository.findById(idUbigeoDist).orElse(null);
    }

    @Override
    public List<UbigeoDist> obtenerDistritosPorProvincia(Long idProvincia) {
        return ubigeoDistRepository.findByProvinciaIdAndEstadoIsTrue(idProvincia);
    }
}
