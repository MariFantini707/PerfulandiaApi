package logistica_api.logistica.controller;

import logistica_api.logistica.logisticaApiDto.DetallePedidoDto;
import logistica_api.logistica.logisticaApiDto.DetallePedidoRespuestaDto;
import logistica_api.logistica.logisticaApiDto.ProductoDto;
import logistica_api.logistica.model.DetallePedido;
import logistica_api.logistica.model.Pedido;
import logistica_api.logistica.service.ApiSucursalClient;
import logistica_api.logistica.service.DetallePedidoService;
import logistica_api.logistica.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<?> crear(@RequestBody DetallePedido detallePedido) {
        try {
            // Cargar el objeto Pedido completo desde su ID
            if (detallePedido.getPedido() == null || detallePedido.getPedido().getId() == null) {
                return ResponseEntity.badRequest().body("Se requiere un ID de pedido válido");
            }

            Optional<Pedido> pedidoOpt = pedidoService.obtenerPorId(detallePedido.getPedido().getId());

            if (pedidoOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("Pedido no encontrado con ID: " + detallePedido.getPedido().getId());
            }

            detallePedido.setPedido(pedidoOpt.get());

            DetallePedido guardado = detallePedidoService.guardar(detallePedido);
            return ResponseEntity.ok(guardado);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el detalle de pedido: " + e.getMessage());
        }
    }

    @GetMapping("/detalle-con-producto")
    public ResponseEntity<List<DetallePedidoRespuestaDto>> obtenerDetallesConProducto() {
        List<DetallePedido> detalles = detallePedidoService.obtenerTodos();
        List<DetallePedidoRespuestaDto> respuesta = new ArrayList<>();

        for (DetallePedido detalle : detalles) {
            ProductoDto producto = apiSucursalClient.obtenerProductoDesdeSucursal(
                detalle.getPedido().getEnvio().getId(), // ID de la sucursal
                detalle.getIdProducto()                 // ID del producto
            );

            DetallePedidoRespuestaDto dto = new DetallePedidoRespuestaDto();
            dto.setId(detalle.getId());
            dto.setCantidad(detalle.getCantidad());
            dto.setPedidoId(detalle.getPedido().getId());
            dto.setProducto(producto);

            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }



    @PostMapping("/detalleProducto")
    public ResponseEntity<?> detalleProducto(@RequestBody DetallePedidoDto dto) {
        try {
            // 1. Consultar el producto desde la API de sucursal
            ProductoDto producto = apiSucursalClient.obtenerProductoDesdeSucursal(
                    dto.getIdSucursal(), dto.getIdProducto());

            if (producto == null) {
                return ResponseEntity.badRequest().body("Producto no encontrado en la sucursal.");
            }

            if (dto.getCantidad() == null || dto.getCantidad() <= 0) {
                return ResponseEntity.badRequest().body("Cantidad inválida.");
            }

            if (producto.getPrecio_producto() < dto.getCantidad()) {
                return ResponseEntity.badRequest().body("Stock insuficiente.");
            }

            // 2. Buscar el pedido
            Optional<Pedido> pedido = pedidoService.obtenerPorId(dto.getIdPedido());
            if (pedido.isEmpty()) {
                return ResponseEntity.badRequest().body("Pedido no encontrado.");
            }

            // 3. Crear y guardar el detalle
            DetallePedido detalle = new DetallePedido();
            detalle.setCantidad(dto.getCantidad());
            detalle.setPedido(pedido.get());

            DetallePedido guardado = detallePedidoService.guardar(detalle);

            // 4. Crear el DTO de respuesta
            DetallePedidoRespuestaDto respuesta = new DetallePedidoRespuestaDto();
            respuesta.setId(guardado.getId());
            respuesta.setCantidad(guardado.getCantidad());
            respuesta.setPedidoId(pedido.get().getId());
            respuesta.setProducto(producto); // aquí usas el producto recibido desde la API

            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno: " + e.getMessage());
        }
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
