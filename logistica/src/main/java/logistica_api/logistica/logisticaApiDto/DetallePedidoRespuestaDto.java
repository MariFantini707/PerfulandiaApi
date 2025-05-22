package logistica_api.logistica.logisticaApiDto;

import lombok.Data;

@Data
public class DetallePedidoRespuestaDto {
    private Integer id;                // ID del DetallePedido
    private Integer cantidad;          // la antidad pedida
    private Integer pedidoId;          // ID del Pedido asociado
    private ProductoDto producto;      // Información del producto,esta se obtiene de la api sucursal 
}
