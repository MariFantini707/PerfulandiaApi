package logistica_api.logistica.controller;

import logistica_api.logistica.model.RutaEntrega;
import logistica_api.logistica.service.RutaEntregaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica/rutas-entrega")

public class RutaEntregaController {
    @Autowired
    private RutaEntregaService rutaEntregaService;

    @GetMapping
    public List<RutaEntrega> listarRutas() {
        return rutaEntregaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaEntrega> obtenerPorId(@PathVariable Integer id) {
        return rutaEntregaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RutaEntrega crearRuta(@RequestBody RutaEntrega rutaEntrega) {
        return rutaEntregaService.guardar(rutaEntrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarRuta(@PathVariable Integer id, @RequestBody RutaEntrega datos) {
        try {
            Optional<RutaEntrega> rutaActualizada = rutaEntregaService.actualizar(id, datos);
            if (rutaActualizada.isPresent()) {
                return ResponseEntity.ok(rutaActualizada.get());
            } else {
                return ResponseEntity.status(404).body("Ruta no encontrada con LA ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la ruta: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRuta(@PathVariable Integer id) {
        if (rutaEntregaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
