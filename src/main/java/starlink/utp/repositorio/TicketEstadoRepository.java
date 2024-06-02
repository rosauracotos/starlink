package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ticket.TicketEstado;


import java.util.List;


@Repository
public interface TicketEstadoRepository extends JpaRepository<TicketEstado, Long> {

    List<TicketEstado> findTicketEstadoByEstadoTrue();
}
