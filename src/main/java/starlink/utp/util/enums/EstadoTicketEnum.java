package starlink.utp.util.enums;

import lombok.Getter;

@Getter
public enum EstadoTicketEnum {

    REGISTRADO("REGISTRADO", 1L),
    PROGRAMADO("PROGRAMADO", 2L),
    ATENDIDO("ATENDIDO", 3L),
    CERRADO("CERRADO", 4L);

    private String nombre;
    private Long id;

    EstadoTicketEnum(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }
}
