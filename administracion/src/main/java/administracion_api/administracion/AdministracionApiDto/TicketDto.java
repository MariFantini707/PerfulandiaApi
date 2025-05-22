package administracion_api.administracion.AdministracionApiDto;

import lombok.Data;
import java.util.Date;

@Data
public class TicketDto {
    private Integer id_ticket;
    private String descripcion;
    private String estado_ticket;
    private Date fecha_inicio;
    private Date fecha_termino;
    private String respuesta_ticket;
    private Integer idUsuarioSoporte;
}
