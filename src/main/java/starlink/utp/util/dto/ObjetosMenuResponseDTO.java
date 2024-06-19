package starlink.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObjetosMenuResponseDTO {

    private Long id;
    private String nombre;
    private String url;
    private List<ObjetosMenuResponseDTO> detalle;

}
