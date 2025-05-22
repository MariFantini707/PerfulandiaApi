package sucursal_api.sucursal.sucursalApiDto;
import lombok.Data;
import sucursal_api.sucursal.model.Categoria;
import sucursal_api.sucursal.model.Inventario;
@Data
public class ProductoDto {
    private Integer id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Integer precio_producto;
    private Inventario inventario;
    private Categoria categoria;
}
