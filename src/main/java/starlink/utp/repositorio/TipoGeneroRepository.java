package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.master.TipoGenero;

@Repository
public interface TipoGeneroRepository extends JpaRepository<TipoGenero, Long> {
}
