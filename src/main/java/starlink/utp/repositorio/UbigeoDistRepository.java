package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ubigeo.UbigeoDist;

import java.util.List;

@Repository
public interface UbigeoDistRepository extends JpaRepository<UbigeoDist, Long> {

    List<UbigeoDist> findByProvinciaIdAndEstadoIsTrue(@Param("idProvincia") Long idProvincia);

}
