package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.master.TipoDoc;


@Repository
public interface TipoDocRepository extends JpaRepository<TipoDoc, Long> {
}
