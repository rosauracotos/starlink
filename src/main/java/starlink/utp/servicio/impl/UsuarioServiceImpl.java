package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.seguridad.PerfilUsuario;
import starlink.utp.entidad.seguridad.PerfilUsuarioObj;
import starlink.utp.entidad.seguridad.UsuarioClave;
import starlink.utp.entidad.seguridad.Usuarios;
import starlink.utp.repositorio.PerfilUsuarioObjRepository;
import starlink.utp.repositorio.PerfilUsuarioRepository;
import starlink.utp.repositorio.UsuarioClaveRepository;
import starlink.utp.repositorio.UsuariosRepository;
import starlink.utp.servicio.UsuarioService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.dto.LoginRequestDTO;
import starlink.utp.util.dto.LoginResponseDTO;
import starlink.utp.util.dto.ObjetosMenuResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuarioClaveRepository usuarioClaveRepository;

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    private PerfilUsuarioObjRepository perfilUsuarioObjRepository;

    @Override
    public RespuestaControlador validarLogin(LoginRequestDTO loginRequestDTO) {
        final String mensajeError = "Credenciales incorrectas";
        RespuestaControlador respuestaControlador;
        Usuarios usuario = usuariosRepository.findByLoginAndEstadoTrue(loginRequestDTO.getUsuario());
        if (usuario != null) {
            UsuarioClave claveUsuario = usuarioClaveRepository.findByUsuarioIdAndEstado(usuario.getId(), Boolean.TRUE);
            if (claveUsuario != null) {
                if (claveUsuario.getPassword().equals(loginRequestDTO.getPassword())) {
                    List<ObjetosMenuResponseDTO> listado = obtenerMenuUsuarioLogueado(usuario);
                    LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
                    if(usuario != null && usuario.getPersona() != null) {
                        loginResponseDTO.setPersonaId(usuario.getPersona().getId());
                        loginResponseDTO.setTipoDocumentoId(usuario.getPersona().getTipoDocumento().getId());
                        loginResponseDTO.setNumeroDocumento(usuario.getPersona().getNumeroDocumento());
                    }
                    loginResponseDTO.setNumeroIdentificacionUsuarioLogueado(usuario.getLogin());
                    loginResponseDTO.setNombreUsuarioLogueado(usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno() + " " + usuario.getNombre());
                    loginResponseDTO.setDetalle(listado);
                    respuestaControlador = RespuestaControlador.obtenerRespuestaExitoConExtraInfo(loginResponseDTO);
                } else {
                    respuestaControlador = RespuestaControlador.obtenerRespuestaDeError(mensajeError);
                }
            } else {
                respuestaControlador = RespuestaControlador.obtenerRespuestaDeError(mensajeError);
            }
        } else {
            respuestaControlador = RespuestaControlador.obtenerRespuestaDeError(mensajeError);
        }
        return respuestaControlador;
    }

    private List<ObjetosMenuResponseDTO> obtenerMenuUsuarioLogueado(Usuarios usuario){
        List<ObjetosMenuResponseDTO> objetosMenu = new ArrayList<>();
        PerfilUsuario perfilUsuario = perfilUsuarioRepository.findByUsuarioIdAndActivo(usuario.getId(), Boolean.TRUE);
        if (perfilUsuario != null) {
            List<PerfilUsuarioObj> listado = perfilUsuarioObjRepository.findByPerfilUsuarioIdAndActivo(perfilUsuario.getId(), Boolean.TRUE);
            if (!listado.isEmpty()){
                for (PerfilUsuarioObj item : listado) {
                    if (item.getObjetos().getObjetoPadre() == null) {
                        ObjetosMenuResponseDTO menuResponseDTOPadre = new ObjetosMenuResponseDTO();
                        menuResponseDTOPadre.setId(item.getObjetos().getId());
                        menuResponseDTOPadre.setNombre(item.getObjetos().getDescripcion());
                        menuResponseDTOPadre.setUrl(item.getObjetos().getUrl());
                        objetosMenu.add(menuResponseDTOPadre);
                    }
                }
                for (ObjetosMenuResponseDTO menuResponseDTO : objetosMenu) {
                    List<ObjetosMenuResponseDTO> detalle = new ArrayList<>();
                    for (PerfilUsuarioObj item : listado) {
                        if (item.getObjetos().getObjetoPadre() != null) {
                            if (menuResponseDTO.getId().equals(item.getObjetos().getObjetoPadre().getId())) {
                                ObjetosMenuResponseDTO menuResponseDTOPadre = new ObjetosMenuResponseDTO();
                                menuResponseDTOPadre.setId(item.getObjetos().getId());
                                menuResponseDTOPadre.setNombre(item.getObjetos().getDescripcion());
                                menuResponseDTOPadre.setUrl(item.getObjetos().getUrl());
                                detalle.add(menuResponseDTOPadre);
                            }
                        }
                    }
                    menuResponseDTO.setDetalle(detalle);
                }
            }
        }
        return objetosMenu;
    }
}
