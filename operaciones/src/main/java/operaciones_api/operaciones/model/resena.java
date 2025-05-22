package operaciones_api.operaciones.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "resena")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private Integer puntiacion;
}
