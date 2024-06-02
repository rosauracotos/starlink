package starlink.utp.entidad.ubigeo;

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
@Table(name = "ubigeodep", schema = "ubigeo")
@Getter
@Setter
public class UbigeoDepart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ude_id")
    private Long id;

    @Column(name = "ude_descri")
    private String descripcion;

    @Column(name = "ude_codigo")
    private String codigo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ude_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "ude_activo")
    private boolean estado;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
