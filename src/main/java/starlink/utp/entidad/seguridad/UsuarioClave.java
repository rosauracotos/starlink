package starlink.utp.entidad.seguridad;

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
@Table(name = "usuarioclave", schema = "seguridad")
@Getter
@Setter
public class UsuarioClave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usc_id")
    private Long id;

    @Column(name = "usc_numitm")
    private Integer numItm;

    @Column(name = "usc_passwd")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usc_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "usc_activo")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "usu_id")
    private Usuarios usuario;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
