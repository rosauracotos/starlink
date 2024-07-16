package starlink.utp.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ticket.TicketGestion;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketGestionRepository extends JpaRepository<TicketGestion, Long> {

    List<TicketGestion> findTicketGestionByEstadoTrue();

    @Query(value = "SELECT tes.tie_descri estado, tg.tig_fecest fechaestado, tg.tig_comentario comentario " +
            "FROM tickets.ticketgestion tg " +
            "INNER JOIN tickets.ticket tck ON tck.tkt_id = tg.tkt_id " +
            "INNER JOIN tickets.ticketestado tes ON tg.tie_id = tes.tie_id " +
            "WHERE (:ticketId IS NULL OR tck.tkt_id = :ticketId) " +
            "AND tg.tig_activo " +
            "ORDER BY tg.tig_id "
            ,nativeQuery = true)
    List<Map<String, Object>> findEstadosGestionPorTicket(@Param("ticketId") Long ticketId);

    List<TicketGestion> findByTicketIdAndEstadoTrue(Long ticketId);
}
