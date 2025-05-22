package sucursal_api.sucursal.controller;

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

import sucursal_api.sucursal.model.Inventario;
import sucursal_api.sucursal.service.InventarioService;


@RestController
@RequestMapping("/api/sucursal/inventarios")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listarinventarioes() {
        return inventarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerinventario(@PathVariable Integer id) {
        return inventarioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventario crearinventario(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarinventario(@PathVariable Integer id, @RequestBody Inventario datos) {
        try {
            Optional<Inventario> inventarioActualizado = inventarioService.actualizar(id, datos);
        
            if (inventarioActualizado.isPresent()) {
                return ResponseEntity.ok(inventarioActualizado.get());
            } else {
                return ResponseEntity.status(404).body("inventario no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el inventario: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarinventario(@PathVariable Integer id) {
        if (inventarioService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
