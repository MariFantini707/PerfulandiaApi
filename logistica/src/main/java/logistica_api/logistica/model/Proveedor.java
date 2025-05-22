package logistica_api.logistica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=150,nullable = false)
    private String nombre_proveedor;

    @Column(nullable = false)
    private Integer telefono_proveedor;

    @Column(length=100,nullable = false)
    private String correo_proveedor;

    @Column(length=150,nullable = false)
    private String direccion_proveedor;

    
}
