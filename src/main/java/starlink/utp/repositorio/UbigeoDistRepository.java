package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ubigeo.UbigeoDist;

@Repository
public interface UbigeoDistRepository extends JpaRepository<UbigeoDist, Long> {
}
