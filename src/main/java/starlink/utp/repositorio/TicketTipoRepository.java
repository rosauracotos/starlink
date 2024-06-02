package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ticket.TicketTipo;

import java.util.List;

@Repository
public interface TicketTipoRepository extends JpaRepository<TicketTipo, Long> {

    List<TicketTipo> findTicketTipoByEstadoTrue();

}

