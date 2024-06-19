package starlink.utp.entidad.seguridad;

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
@Table(name = "perfil", schema = "usuarios")
@Getter
@Setter
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prf_id")
    private Long id;

    @Column(name = "prf_descri")
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prf_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "prf_activo")
    private boolean activo;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        activo = true;
    }

}
