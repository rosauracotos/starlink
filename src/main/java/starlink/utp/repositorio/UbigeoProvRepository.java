package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ubigeo.UbigeoProv;

@Repository
public interface UbigeoProvRepository extends JpaRepository<UbigeoProv, Long> {
}
