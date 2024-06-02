package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.seguridad.UsuarioTipo;
import starlink.utp.repositorio.UsuarioTipoRepository;
import starlink.utp.servicio.UsuarioTipoService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class UsuarioTipoServiceImpl implements UsuarioTipoService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private UsuarioTipoRepository usuarioTipoRepository;
    @Override
    public List<UsuarioTipo> listarUsuarioTipo() {
        return usuarioTipoRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(UsuarioTipo usuarioTipo) {
        return null;
    }

    @Override
    public UsuarioTipo findById(Long idUsuarioTipo) {
        return usuarioTipoRepository.findById(idUsuarioTipo).orElse(null);
    }
}
