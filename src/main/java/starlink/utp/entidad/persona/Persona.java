package starlink.utp.entidad.persona;

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
import starlink.utp.entidad.master.TipoDoc;
import starlink.utp.entidad.master.TipoGenero;
import starlink.utp.entidad.ubigeo.UbigeoDist;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "persona", schema = "persona")
@Getter
@Setter
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long id;

    @Column(name = "per_numdoi")
    private String numeroDocumento;

    @Column(name = "per_apepat")
    private String apellidoPaterno;

    @Column(name = "per_apemat")
    private String apellidoMaterno;

    @Column(name = "per_nombre")
    private String nombre;

    @Column(name = "per_telcel")
    private String telefono;

    @Column(name = "per_correo")
    private String correo;

    @Column(name = "per_direcc")
    private String direccion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "per_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "per_activo")
    private boolean estado;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }

    @ManyToOne
    @JoinColumn(name = "tdi_id")
    private TipoDoc tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "tge_id")
    private TipoGenero tipoGenero;

    @ManyToOne
    @JoinColumn(name = "udi_id")
    private UbigeoDist distrito;

}
