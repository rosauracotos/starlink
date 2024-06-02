package starlink.utp.servicio;

import starlink.utp.entidad.persona.Persona;
import starlink.utp.util.RespuestaControlador;

import java.util.List;

public interface PersonaService {

    List<Persona> findPersonaByActivoTrue();

    public RespuestaControlador guardar (Persona persona);

    public abstract Persona findById(Long idPersona);
}
