package administracion_api.administracion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SucursalDto {
    private Integer id_sucursal;
    private String nombre_sucursal;
    private String direccion_sucursal;
    private Integer telefono;
}