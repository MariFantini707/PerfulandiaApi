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

    @Column(nullable = false)
    private Date fecha_Pedido;

    @Column(nullable = false)
    private String estado_pedido;

    @Column(nullable = false)
    private Integer total_pedido;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_envio", nullable = false)
    private Envio envio;

}
