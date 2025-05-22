package operaciones_api.operaciones.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import operaciones_api.operaciones.model.Detalle_venta;
import operaciones_api.operaciones.service.DetalleVentaService;

@RestController
@RequestMapping("/api/operaciones/detalle_venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<Detalle_venta> listarDetalles() {
        return detalleVentaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_venta> obtenerDetalle(@PathVariable Integer id) {
        return detalleVentaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Detalle_venta crearDetalle(@RequestBody Detalle_venta detalle) {
        return detalleVentaService.guardar(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDetalle(@PathVariable Integer id, @RequestBody Detalle_venta datos) {
        try {
            Optional<Detalle_venta> detalleActualizado = detalleVentaService.actualizar(id, datos);
            if (detalleActualizado.isPresent()) {
                return ResponseEntity.ok(detalleActualizado.get());
            } else {
                return ResponseEntity.status(404).body("Detalle no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el detalle: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Integer id) {
        if (detalleVentaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}