package starlink.utp.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ticket.TicketGestion;

import java.util.List;

@Repository
public interface TicketGestionRepository extends JpaRepository<TicketGestion, Long> {

    List<TicketGestion> findTicketGestionByEstadoTrue();
}
