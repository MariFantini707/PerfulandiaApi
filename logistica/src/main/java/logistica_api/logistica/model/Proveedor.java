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
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(length=150, nullable = false, name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(nullable = false, name = "telefono_proveedor")
    private Integer telefonoProveedor;

    @Column(length = 100, nullable = false, name = "correo_proveedor")
    private String correoProveedor;

    @Column(length = 150, nullable = false, name = "direccion_proveedor")
    private String direccionProveedor;

    
}
