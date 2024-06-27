package starlink.utp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import starlink.utp.entidad.ticket.Ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT tck.tkt_numero as numticket, CONCAT(per.per_apepat,' ',per.per_apemat,' ',per.per_nombre) as persona, " +
            "ttp.tit_descri as tipoticket, tck.tkt_fectkt as fechaticket, tes.tie_descri as estadoticket " +
            "FROM tickets.ticket tck " +
            "LEFT OUTER JOIN tickets.tickettipo ttp ON tck.tit_id = ttp.tit_id " +
            "LEFT OUTER JOIN tickets.ticketestado tes ON tck.tie_id = tes.tie_id " +
            "LEFT OUTER JOIN persona.persona per ON tck.per_id = per.per_id " +
            "LEFT OUTER JOIN master.tipodocide tdc ON per.tdi_id = tdc.tdi_id " +
            "WHERE (:tipoDocumentoId IS NULL OR tdc.tdi_id = :tipoDocumentoId) " +
            "AND (:numeroDocumento IS NULL OR per.per_numdoi = :numeroDocumento) " +
            "AND (:fechaInicio IS NULL OR (tck.tkt_fectkt >= (:fechaInicio)::DATE)) " +
            "AND (:fechaFin IS NULL OR (tck.tkt_fectkt < (:fechaInicio)::DATE)) " +
            "AND (:estadoTicketId IS NULL OR tes.tie_id = :estadoTicketId) " +
            "AND (:nroTicket IS NULL OR tck.tkt_numero = :nroTicket) " +
            "LIMIT :maximo OFFSET :limite "
            ,nativeQuery = true)
    List<Map<String, Object>> busquedaPaginadaTicket(
            @Param("tipoDocumentoId") Long tipoDocumentoId,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("estadoTicketId") Long estadoTicketId,
            @Param("nroTicket") Long nroTicket,
            @Param("maximo") Integer maximo,
            @Param("limite") Integer limite);

    @Query(value = "SELECT COUNT(tck.*) " +
            "FROM tickets.ticket tck " +
            "LEFT OUTER JOIN tickets.tickettipo ttp ON tck.tit_id = ttp.tit_id " +
            "LEFT OUTER JOIN tickets.ticketestado tes ON tck.tie_id = tes.tie_id " +
            "LEFT OUTER JOIN persona.persona per ON tck.per_id = per.per_id " +
            "LEFT OUTER JOIN master.tipodocide tdc ON per.tdi_id = tdc.tdi_id " +
            "WHERE (:tipoDocumentoId IS NULL OR tdc.tdi_id = :tipoDocumentoId) " +
            "AND (:numeroDocumento IS NULL OR per.per_numdoi = :numeroDocumento) " +
            "AND (:fechaInicio IS NULL OR (tck.tkt_fectkt >= (:fechaInicio)::DATE)) " +
            "AND (:fechaFin IS NULL OR (tck.tkt_fectkt < (:fechaInicio)::DATE)) " +
            "AND (:estadoTicketId IS NULL OR tes.tie_id = :estadoTicketId) " +
            "AND (:nroTicket IS NULL OR tck.tkt_numero = :nroTicket) "
            ,nativeQuery = true)
    Integer busquedaPaginadaTicketContar(
            @Param("tipoDocumentoId") Long tipoDocumentoId,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("estadoTicketId") Long estadoTicketId,
            @Param("nroTicket") Long nroTicket);

    @Query("SELECT COUNT(c) FROM Ticket c")
    long contarTickets();


}
