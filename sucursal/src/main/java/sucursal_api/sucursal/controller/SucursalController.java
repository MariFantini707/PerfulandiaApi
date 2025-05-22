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

import sucursal_api.sucursal.model.Sucursal;
import sucursal_api.sucursal.service.SucursalService;
@RestController
@RequestMapping("/api/sucursal/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> listarsucursales() {
        return sucursalService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenersucursal(@PathVariable Integer id) {
        return sucursalService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sucursal crearsucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.guardar(sucursal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarsucursal(@PathVariable Integer id, @RequestBody Sucursal datos) {
        try {
            Optional<Sucursal> sucursalActualizado = sucursalService.actualizar(id, datos);
        
            if (sucursalActualizado.isPresent()) {
                return ResponseEntity.ok(sucursalActualizado.get());
            } else {
                return ResponseEntity.status(404).body("sucursal no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el sucursal: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarsucursal(@PathVariable Integer id) {
        if (sucursalService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
