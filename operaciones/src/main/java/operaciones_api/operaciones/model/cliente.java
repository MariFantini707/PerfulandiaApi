package operaciones_api.operaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre_cliente;

    @Column(nullable = false)
    private String correo_cliente;

    @Column(nullable = false)
    private String direccion_cliente;

}