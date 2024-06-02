package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.seguridad.UsuarioTipo;

@Repository
public interface UsuarioTipoRepository extends JpaRepository<UsuarioTipo, Long> {
}
