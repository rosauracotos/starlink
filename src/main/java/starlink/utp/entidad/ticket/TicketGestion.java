package starlink.utp.entidad.ticket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketgestion", schema = "tickets")
@Getter
@Setter
public class TicketGestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tig_id")
    private Long id;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tig_fecest")
    private LocalDateTime fechaEstado;

    @Column(name = "tig_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "tig_activo")
    private boolean estado;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        fechaEstado = LocalDateTime.now();
        estado = true;
    }

    @ManyToOne
    @JoinColumn(name = "tkt_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "tie_id")
    private TicketEstado ticketEstado;
}
