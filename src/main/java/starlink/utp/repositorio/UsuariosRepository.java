package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.seguridad.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Usuarios findByLoginAndEstadoTrue(String login);

}
