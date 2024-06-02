package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.master.TipoGenero;
import starlink.utp.repositorio.TipoGeneroRepository;
import starlink.utp.servicio.TipoGeneroService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class TipoGeneroServiceImpl implements TipoGeneroService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private TipoGeneroRepository tipoGeneroRepository;


    @Override
    public List<TipoGenero> listarTipoGenero() {
        return tipoGeneroRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(TipoGenero tipoGenero) {
        RespuestaControlador respuestaControlador;
        tipoGeneroRepository.save(tipoGenero);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Tipo Genero");
        return respuestaControlador;
    }

    @Override
    public RespuestaControlador actualizar(TipoGenero tipoGenero) {
        return null;
    }

    @Override
    public TipoGenero findById(Long idTipoGenero) {
        return tipoGeneroRepository.findById(idTipoGenero).orElse(null);
    }
}
