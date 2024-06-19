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
@Table(name = "perfilusuario", schema = "usuarios")
@Getter
@Setter
public class PerfilUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pus_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usu_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "prf_id")
    private Perfil perfil;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pus_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "pus_activo")
    private boolean activo;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        activo = true;
    }

}
