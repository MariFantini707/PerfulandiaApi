package logistica_api.logistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import logistica_api.logistica.model.Pedido;
import logistica_api.logistica.service.PedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica/pedidos")

public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Integer id) {
        return pedidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardar(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPedido(@PathVariable Integer id, @RequestBody Pedido datos) {
        try {
            Optional<Pedido> pedidoActualizado = pedidoService.actualizar(id, datos);

            if (pedidoActualizado.isPresent()) {
                return ResponseEntity.ok(pedidoActualizado.get());
            } else {
                return ResponseEntity.status(404).body("Pedido no encontrado con la ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el pedido: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        if (pedidoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
