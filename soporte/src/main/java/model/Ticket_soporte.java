package model;
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

    @Column(nullable=true)
    private Integer precio_producto;

    @Column(length = 200, nullable=false)
    private String respuesta_ticket;

    /*@ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;  */
}
