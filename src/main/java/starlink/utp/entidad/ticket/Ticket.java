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
import starlink.utp.entidad.persona.Persona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "ticket", schema = "tickets")
@Getter
@Setter
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tkt_id")
    private Long id;

    @Column(name = "tkt_numero")
    private Integer numero;

    @Column(name = "tkt_fectkt")
    private LocalDate fechaRegistro;

    @Column(name = "tkt_hortkt")
    private LocalTime horaRegistro;

    @Column(name = "tie_asunto")
    private String asunto;

    @ManyToOne
    @JoinColumn(name = "tit_id")
    private TicketTipo ticketTipo;

    @ManyToOne
    @JoinColumn(name = "tie_id")
    private TicketEstado ticketEstado;

    @ManyToOne
    @JoinColumn(name = "per_id")
    private Persona persona;

    @PrePersist
    protected void onCreate() {
        horaRegistro = LocalTime.now();
        fechaRegistro = LocalDate.now();
    }
}
