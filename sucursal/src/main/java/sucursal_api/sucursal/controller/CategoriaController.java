package sucursal_api.sucursal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sucursal_api.sucursal.model.Categoria;
import sucursal_api.sucursal.service.CategoriaService;


@RestController
@RequestMapping("/api/sucursal/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarcategoriaes() {
        return categoriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenercategoria(@PathVariable Integer id) {
        return categoriaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria crearcategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarcategoria(@PathVariable Integer id, @RequestBody Categoria datos) {
        try {
            Optional<Categoria> categoriaActualizado = categoriaService.actualizar(id, datos);
        
            if (categoriaActualizado.isPresent()) {
                return ResponseEntity.ok(categoriaActualizado.get());
            } else {
                return ResponseEntity.status(404).body("categoria no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el categoria: " + e.getMessage());
        }
    }
}
