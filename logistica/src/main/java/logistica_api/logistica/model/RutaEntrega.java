package logistica_api.logistica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ruta_entrega")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RutaEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Integer id;

    @Column(length = 200, nullable = false)
    private String descripcionRuta;

    @Column(nullable = false)
    private Double distanciaKm;

    @Column(nullable = false)
    private Integer tiempoEstimado; // creo que lo dejaré en minutos, en los envios no suelen hablar en horas (creo(?))

    // una ruta puede tener muchos envios de por medio... 
    @OneToMany(mappedBy = "rutaEntrega")
    private List<Envio> envios;
}
