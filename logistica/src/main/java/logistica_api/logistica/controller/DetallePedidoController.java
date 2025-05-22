package logistica_api.logistica.controller;

import logistica_api.logistica.model.DetallePedido;
import logistica_api.logistica.service.DetallePedidoService;

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
