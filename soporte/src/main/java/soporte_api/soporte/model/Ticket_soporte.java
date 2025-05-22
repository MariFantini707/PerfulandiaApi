package soporte_api.soporte.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "ticket_soporte")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket_soporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer idTicket;

    @Column(name = "descripcion", length = 200, nullable=false)
    private String descripcion;

    @Column(name = "estado_ticket", length = 30, nullable=false)
    private String estadoTicket;

    @Column(name = "fecha_termino", nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date fecha_termino;

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date fecha_inicio;

    @Column(name = "respuesta_ticket", length = 200, nullable=false)
    private String respuesta_ticket;

    @Column(name = "id_usuario_soporte")
    private Integer idUsuarioSoporte;


}
