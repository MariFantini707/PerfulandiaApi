package logistica_api.logistica.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;

    @Column(name = "estado_pedido", nullable = false)
    private String estadoPedido;

    @Column(nullable = false)
    private Integer totalPedido;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_envio", nullable = false)
    private Envio envio;

}
