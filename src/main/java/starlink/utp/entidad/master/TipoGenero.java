package starlink.utp.entidad.master;

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
@Table(name = "tipogenero", schema = "master")
@Getter
@Setter
public class TipoGenero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tge_id")
    private Long id;

    @Column(name = "tge_descri")
    private String descripcion;

    @Column(name = "tge_abrevi")
    private String abreviatura;

    @Column(name = "tge_siglas")
    private String siglas;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tge_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "tge_activo")
    private boolean estado;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
