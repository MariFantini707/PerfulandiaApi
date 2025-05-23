package sucursal_api.sucursal.sucursalApiDto;

import lombok.Data;

@Data
public class Detalle_pedidoDto {
    private Integer id;
    private Integer idPedido;
    private Integer idProducto;
    private Integer idSucursal;
    private Integer cantidad;
}
