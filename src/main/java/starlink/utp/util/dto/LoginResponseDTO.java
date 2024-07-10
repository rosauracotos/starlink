package starlink.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResponseDTO {

    private String nombreUsuarioLogueado;
    private Long personaId;
    private Long tipoDocumentoId;
    private String numeroDocumento;
    private String numeroIdentificacionUsuarioLogueado;
    private List<ObjetosMenuResponseDTO> detalle;

}
