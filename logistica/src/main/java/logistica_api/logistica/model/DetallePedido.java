package logistica_api.logistica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "detalle_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Integer id;

    @Column(nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
}
