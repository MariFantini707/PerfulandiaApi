package operaciones_api.operaciones.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha_emision;

    @OneToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;
}
