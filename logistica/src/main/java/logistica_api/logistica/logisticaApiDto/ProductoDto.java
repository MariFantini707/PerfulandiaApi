package logistica_api.logistica.logisticaApiDto;

import lombok.Data;

@Data
public class ProductoDto {
    private Integer id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Integer precio_producto;
}
