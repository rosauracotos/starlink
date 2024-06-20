package starlink.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TicketBusquedaRequestDTO {

    private Long tipoDocumentoId;
    private String numeroDocumento;
    private String fechaInicio;
    private String fechaFin;
    private Long estadoTicketId;
    private Long nroTicket;
    private Integer max;
    private Integer limite;

}
