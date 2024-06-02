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
import starlink.utp.entidad.persona.Persona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios", schema = "usuarios")
@Getter
@Setter
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_login")
    private String login;

    @Column(name = "usu_apepat")
    private String apellidoPaterno;

    @Column(name = "usu_apemat")
    private String apellidoMaterno;

    @Column(name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_numcel")
    private String celular;

    @Column(name = "usu_correo")
    private String correo;

    @Column(name = "usu_fecini")
    private LocalDate fechaInicio;

    @Column(name = "usu_fecfin")
    private LocalDate fechaFin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usu_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "usu_activo")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "ust_id")
    private UsuarioTipo usuarioTipo;

    @ManyToOne
    @JoinColumn(name = "per_id")
    private Persona persona;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }
}
