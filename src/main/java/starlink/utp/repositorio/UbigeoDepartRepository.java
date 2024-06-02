package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ubigeo.UbigeoDepart;

@Repository
public interface UbigeoDepartRepository extends JpaRepository<UbigeoDepart, Long> {
}
