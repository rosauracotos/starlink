package starlink.utp.entidad.seguridad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "usuariotipo", schema = "seguridad")
@Getter
@Setter
public class UsuarioTipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ust_id")
    private Long id;

    @Column(name = "ust_descri")
    private String descripcion;

    @Column(name = "ust_abrevi")
    private String abreviatura;

    @Column(name = "ust_siglas")
    private String siglas;

    @Column(name = "ust_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "ust_activo")
    private boolean activo;
}
