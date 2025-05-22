package administracion_api.administracion.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import administracion_api.administracion.model.Rol;
import administracion_api.administracion.service.RolService;

@RestController
@RequestMapping("/api/administracion/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listarroles() {
        return rolService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerrol(@PathVariable Integer id) {
        return rolService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol crearrol(@RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarrol(@PathVariable Integer id, @RequestBody Rol datos) {
        try {
            Optional<Rol> rolActualizado = rolService.actualizar(id, datos);
        
            if (rolActualizado.isPresent()) {
                return ResponseEntity.ok(rolActualizado.get());
            } else {
                return ResponseEntity.status(404).body("rol no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el rol: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarrol(@PathVariable Integer id) {
        if (rolService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
