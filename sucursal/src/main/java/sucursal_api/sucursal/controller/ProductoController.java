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

import sucursal_api.sucursal.model.Producto;
import sucursal_api.sucursal.service.ProductoService;
@RestController
@RequestMapping("/api/sucursal/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarproductoes() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerproducto(@PathVariable Integer id) {
        return productoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto crearproducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarproducto(@PathVariable Integer id, @RequestBody Producto datos) {
        try {
            Optional<Producto> productoActualizado = productoService.actualizar(id, datos);
        
            if (productoActualizado.isPresent()) {
                return ResponseEntity.ok(productoActualizado.get());
            } else {
                return ResponseEntity.status(404).body("producto no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el producto: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarproducto(@PathVariable Integer id) {
        if (productoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
