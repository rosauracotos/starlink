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
@Table(name = "tickettipo", schema = "tickets")
@Getter
@Setter
public class TicketTipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tit_id")
    private Long id;

    @Column(name = "tit_descri")
    private String descripcion;

    @Column(name = "tit_abrevi")
    private String abreviatura;

    @Column(name = "tit_siglas")
    private String siglas;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tit_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "tit_activo")
    private boolean estado;


    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
