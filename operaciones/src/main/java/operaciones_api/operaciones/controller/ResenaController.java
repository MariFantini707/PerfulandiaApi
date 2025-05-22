package operaciones_api.operaciones.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import operaciones_api.operaciones.model.Resena;
import operaciones_api.operaciones.service.ResenaService;

@RestController
@RequestMapping("/api/operaciones/resena")
public class ResenaController {
    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<Resena> listarResenas() {
        return resenaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> obtenerResena(@PathVariable Integer id) {
        return resenaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resena crearResena(@RequestBody Resena resena) {
        return resenaService.guardar(resena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarResena(@PathVariable Integer id, @RequestBody Resena datos) {
        try {
            Optional<Resena> resenaActualizada = resenaService.actualizar(id, datos);
            if (resenaActualizada.isPresent()) {
                return ResponseEntity.ok(resenaActualizada.get());
            } else {
                return ResponseEntity.status(404).body("Reseña no encontrada con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la reseña: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Integer id) {
        if (resenaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}