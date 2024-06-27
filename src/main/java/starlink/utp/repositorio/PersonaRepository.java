package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.persona.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findByNumeroDocumentoAndTipoDocumentoIdAndEstadoIsTrue(String numeroDocumento, Long tipoDocumento);

}
