package starlink.utp.servicio;

import starlink.utp.entidad.persona.Persona;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface PersonaService {

    List<Persona> findPersonaByActivoTrue();

    RespuestaControlador guardar (Persona persona);

    Persona findById(Long idPersona);

    Persona findByNroDocumento(String nroDocumento, Long tipodocumento);
}
