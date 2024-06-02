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
@Table(name = "tipodocide", schema = "master")
@Getter
@Setter
public class TipoDoc implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tdi_id")
    private Long id;

    @Column(name = "tdi_descri")
    private String descripcion;

    @Column(name = "tdi_abrevi")
    private String abreviatura;

    @Column(name = "tdi_siglas")
    private String siglas;

    @Column(name = "tdi_lonmin")
    private Integer longMinimo;

    @Column(name = "tdi_lonmax")
    private Integer longMaximo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tdi_fecreg")
    private LocalDateTime fechaRegistro;

    @Column(name = "tdi_activo")
    private boolean estado;

    @Column(name = "tdi_chkpna")
    private boolean chkpna;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        estado = true;
    }

}
