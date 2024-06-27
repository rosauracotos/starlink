package starlink.utp.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starlink.utp.entidad.persona.Persona;
import starlink.utp.repositorio.PersonaRepository;
import starlink.utp.servicio.PersonaService;
import starlink.utp.util.RespuestaControlador;
import starlink.utp.util.RespuestaControladorServicio;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    RespuestaControladorServicio respuestaControladorServicio;

    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> findPersonaByActivoTrue() {
        return personaRepository.findAll();
    }

    @Override
    public RespuestaControlador guardar(Persona persona) {
        RespuestaControlador respuestaControlador;
        personaRepository.save(persona);
        respuestaControlador = respuestaControladorServicio.obtenerRespuestaDeExitoCrear("Persona");
        return respuestaControlador;
    }

    @Override
    public Persona findById(Long idPersona) {
        return personaRepository.findById(idPersona).orElse(null);
    }

    @Override
    public Persona findByNroDocumento(String nroDocumento, Long tipodocumento) {
        return personaRepository.findByNumeroDocumentoAndTipoDocumentoIdAndEstadoIsTrue(nroDocumento, tipodocumento);
    }

}
