package sucursal_api.sucursal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import sucursal_api.sucursal.model.Categoria;
import sucursal_api.sucursal.repository.CategoriaRepository;


public class CategoriaService {
@Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obtenerPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> actualizar(Integer id, Categoria datos) {
        return categoriaRepository.findById(id).map(p -> {
            p.setNombre_categoria(datos.getNombre_categoria());
            return categoriaRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}