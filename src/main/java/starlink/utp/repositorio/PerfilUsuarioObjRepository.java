package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.seguridad.PerfilUsuarioObj;

import java.util.List;

@Repository
public interface PerfilUsuarioObjRepository extends JpaRepository<PerfilUsuarioObj, Long> {

    List<PerfilUsuarioObj> findByPerfilUsuarioIdAndActivo(Long id, Boolean activo);

}
