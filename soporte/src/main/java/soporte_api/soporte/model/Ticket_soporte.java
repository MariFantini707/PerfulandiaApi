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
    private Integer id_ticket;

    @Column(length = 200, nullable=false)
    private String descripcion;

    @Column(length = 30, nullable=false)
    private String estado_ticket;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date fecha_termino;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)  
    private Date fecha_inicio;

    @Column(length = 200, nullable=false)
    private String respuesta_ticket;

    @Column(name = "id_usuario_soporte")
    private Integer idUsuarioSoporte;


}
