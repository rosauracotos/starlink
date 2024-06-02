package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.ubigeo.UbigeoProv;
import starlink.utp.repositorio.UbigeoProvRepository;
import starlink.utp.servicio.UbigeoProvService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class UbigeoProvServiceImpl implements UbigeoProvService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private UbigeoProvRepository ubigeoProvRepository;
    @Override
    public List<UbigeoProv> listarUbigeoProv() {
        return ubigeoProvRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(UbigeoProv ubigeoProv) {
        return null;
    }

    @Override
    public UbigeoProv findById(Long idUbigeoProv) {
        return ubigeoProvRepository.findById(idUbigeoProv).orElse(null);
    }
}
