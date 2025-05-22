package soporte_api.soporte.SoporteApiDto;

import java.sql.Date;

import lombok.Data;

@Data
public class Ticket_soporteDto {
    private Integer id_ticket;
    private String descripcion;
    private String estado_ticket;
    private Date fecha_termino;
    private Date fecha_inicio;
    private String respuesta_ticket;
}
