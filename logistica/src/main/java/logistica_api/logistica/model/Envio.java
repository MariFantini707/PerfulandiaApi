package logistica_api.logistica.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "envio")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Integer id;

    @Column(name = "fecha_envio", nullable = false)
    private Date fecha_envio;

    @Column(name = "estado_envio", length = 100, nullable = false)
    private String estado_envio;

    @Column(name = "origen", length = 100, nullable = false)
    private String origen;

    @OneToMany(mappedBy = "envio")
    private List<Pedido> pedidos;
}
