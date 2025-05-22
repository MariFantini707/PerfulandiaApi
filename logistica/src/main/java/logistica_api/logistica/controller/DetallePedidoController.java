package logistica_api.logistica.controller;

import logistica_api.logistica.logisticaApiDto.DetallePedidoDto;
import logistica_api.logistica.logisticaApiDto.ProductoDto;
import logistica_api.logistica.model.DetallePedido;
import logistica_api.logistica.model.Pedido;
import logistica_api.logistica.service.ApiSucursalClient;
import logistica_api.logistica.service.DetallePedidoService;
import logistica_api.logistica.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ApiSucursalClient apiSucursalClient;

    @GetMapping
    public List<DetallePedido> listar() {
        return detallePedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> obtenerPorId(@PathVariable Integer id) {
        return detallePedidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetallePedido crear(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.guardar(detallePedido);
    }

    @PostMapping("/crearValidacion")
    public ResponseEntity<?> crearValidacion(@RequestBody DetallePedidoDto dto) {
        //Esto es para consultar los productos
        ProductoDto producto = apiSucursalClient.obtenerProductoDesdeSucursal(
                dto.getIdSucursal(), dto.getIdProducto());

        if (producto == null) {
            return ResponseEntity.badRequest().body("Producto no encontrado en la sucursal");
        }

        if (dto.getCantidad() <= 0) {
            return ResponseEntity.badRequest().body("Cantidad inválida");
        }

        // Aquí se valida el stock usando precio como campo temporal
        if (producto.getPrecio_producto() < dto.getCantidad()) {
            return ResponseEntity.badRequest().body("Stock insuficiente");
        }

        // 2. Convertir y guardar
        DetallePedido detalle = new DetallePedido();
        detalle.setCantidad(dto.getCantidad());

        Optional<Pedido> pedido = pedidoService.obtenerPorId(dto.getIdPedido());
        if (pedido.isPresent()) {
            detalle.setPedido(pedido.get());
        } else {
            return ResponseEntity.badRequest().body("Pedido no encontrado");
        }

        DetallePedido guardado = detallePedidoService.guardar(detalle);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody DetallePedido datos) {
        try {
            Optional<DetallePedido> actualizado = detallePedidoService.actualizar(id, datos);
            if (actualizado.isPresent()) {
                return ResponseEntity.ok(actualizado.get());
            } else {
                return ResponseEntity.status(404).body("Detalle de envío no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el detalle: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (detallePedidoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
