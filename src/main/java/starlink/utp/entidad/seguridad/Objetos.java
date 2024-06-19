package starlink.utp.entidad.seguridad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "objetos", schema = "usuarios")
@Getter
@Setter
public class Objetos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obj_id")
    private Long id;

    @Column(name = "obj_descri")
    private String descripcion;

    @Column(name = "obj_fecreg")
    private Timestamp fechaRegistro;

    @Column(name = "obj_activo")
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "obj_idpadr")
    private Objetos objetoPadre;

    @Column(name = "obj_urlvis")
    private String url;

}
