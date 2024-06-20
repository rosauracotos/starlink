package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ubigeo.UbigeoProv;

import java.util.List;

@Repository
public interface UbigeoProvRepository extends JpaRepository<UbigeoProv, Long> {

    List<UbigeoProv> findByDepartamentoIdAndEstadoIsTrue(@Param("idDepartamento") Long idDepartamento);

}
