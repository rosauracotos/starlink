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
@Table(name = "perfilusuarioobjeto", schema = "usuarios")
@Getter
@Setter
public class PerfilUsuarioObj implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "puo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pus_id")
    private PerfilUsuario perfilUsuario;

    @ManyToOne
    @JoinColumn(name = "obj_id")
    private Objetos objetos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "puo_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "puo_activo")
    private boolean activo;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        activo = true;
    }

}
