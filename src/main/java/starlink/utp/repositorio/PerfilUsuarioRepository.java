package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.seguridad.PerfilUsuario;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {

    PerfilUsuario findByUsuarioIdAndActivo(Long usuarioId, Boolean activo);

}
