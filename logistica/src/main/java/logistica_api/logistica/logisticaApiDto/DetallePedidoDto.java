package logistica_api.logistica.logisticaApiDto;

import lombok.Data;

@Data
public class DetallePedidoDto {
    private Integer id;
    private Integer idPedido;
    private Integer idProducto;
    private Integer idSucursal;
    private Integer cantidad;
}
