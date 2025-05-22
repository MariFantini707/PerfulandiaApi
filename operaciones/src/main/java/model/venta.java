package model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "venta")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha_venta;

    @Column(nullable = false)
    private Integer total_venta;
}
