package administracion_api.administracion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 150, nullable=false)
    private String nombre_usuario;

    @Column(unique=true, length = 13, nullable=false)
    private String rut_usuario;

    @Column(length = 100, nullable=false)
    private String correo_usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    // recordar que cuando esten unidas las api se debe descomentar para que tenga la columna de sucursal.
    /*@ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal; */ 
}
