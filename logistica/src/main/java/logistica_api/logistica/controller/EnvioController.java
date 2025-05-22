package logistica_api.logistica.controller;

import logistica_api.logistica.model.Envio;
import logistica_api.logistica.service.EnvioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica/envios")

public class EnvioController {
    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> obtenerEnvio(@PathVariable Integer id) {
        return envioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Envio crearEnvio(@RequestBody Envio envio) {
        return envioService.guardar(envio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEnvio(@PathVariable Integer id, @RequestBody Envio datos) {
        try {
            Optional<Envio> envioActualizado = envioService.actualizar(id, datos);
            if (envioActualizado.isPresent()) {
                return ResponseEntity.ok(envioActualizado.get());
            } else {
                return ResponseEntity.status(404).body("Envio no encontrado con la ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el envio: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEnvio(@PathVariable Integer id) {
        if (envioService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
