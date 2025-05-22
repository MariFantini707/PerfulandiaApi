package sucursal_api.sucursal.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column(length = 100, nullable=false)
    private String nombre_producto;

    @Column(length = 200, nullable=false)
    private String descripcion_producto;

    @Column(nullable=true)
    private Integer precio_producto;


    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
        
    
    //@ManyToOne
    //@JoinColumn(name = "id_detalle_pedido", nullable = false)
    //private Detalle_pedido Detalle_pedido;
}
