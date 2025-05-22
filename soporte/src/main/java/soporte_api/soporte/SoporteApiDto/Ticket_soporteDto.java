package soporte_api.soporte.SoporteApiDto;

import java.sql.Date;

import lombok.Data;

@Data
public class Ticket_soporteDto {
    private Integer idTicket;
    private String descripcion;
    private String estadoTicket;
    private Date fecha_termino;
    private Date fecha_inicio;
    private String respuesta_ticket;
}
