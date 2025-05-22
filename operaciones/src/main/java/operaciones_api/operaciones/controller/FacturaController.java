package operaciones_api.operaciones.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import operaciones_api.operaciones.model.Factura;
import operaciones_api.operaciones.service.FacturaService;

@RestController
@RequestMapping("/api/operaciones/factura")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable Integer id) {
        return facturaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaService.guardar(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarFactura(@PathVariable Integer id, @RequestBody Factura datos) {
        try {
            Optional<Factura> facturaActualizada = facturaService.actualizar(id, datos);
            if (facturaActualizada.isPresent()) {
                return ResponseEntity.ok(facturaActualizada.get());
            } else {
                return ResponseEntity.status(404).body("Factura no encontrada con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la factura: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Integer id) {
        if (facturaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}