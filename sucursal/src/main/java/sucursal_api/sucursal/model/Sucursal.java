package sucursal_api.sucursal.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sucursal")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sucursal;

    @Column(length = 100, nullable=false)
    private String nombre_sucursal;

    @Column(length = 150, nullable=false)
    private String direccion_sucursal;

    @Column(nullable=true)
    private Integer telefono;

    @OneToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;
}
