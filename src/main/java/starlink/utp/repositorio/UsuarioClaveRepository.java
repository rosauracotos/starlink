package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.seguridad.UsuarioClave;

@Repository
public interface UsuarioClaveRepository extends JpaRepository<UsuarioClave, Long> {

}
