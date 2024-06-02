package starlink.utp.entidad.ticket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketestado", schema = "tickets")
@Getter
@Setter
public class TicketEstado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tie_id")
    private Long id;

    @Column(name = "tie_descri")
    private String descripcion;

    @Column(name = "tie_abrevi")
    private String abreviatura;

    @Column(name = "tie_siglas")
    private String siglas;

    @Column(name = "tie_numord")
    private Integer numOrden;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tie_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "tie_activo")
    private boolean estado;


    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
