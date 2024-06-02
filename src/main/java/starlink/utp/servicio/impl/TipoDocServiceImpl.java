package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.master.TipoDoc;
import starlink.utp.repositorio.TipoDocRepository;
import starlink.utp.servicio.TipoDocService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class TipoDocServiceImpl implements TipoDocService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TipoDocRepository tipoDocRepository;


    @Override
    public List<TipoDoc> listarTipoDoc() {
        return tipoDocRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(TipoDoc tipoDoc) {
        return null;
    }

    @Override
    public RespuestaControlador actualizar(TipoDoc tipoDoc) {
        return null;
    }

    @Override
    public TipoDoc findById(Long idTipoDoc) {
        return tipoDocRepository.findById(idTipoDoc).orElse(null);
    }
}
