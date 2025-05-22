package sucursal_api.sucursal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal_api.sucursal.model.Inventario;
import sucursal_api.sucursal.repository.InventarioRepository;

@Service
public class InventarioService {
@Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> obtenerTodos() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> obtenerPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Optional<Inventario> actualizar(Integer id, Inventario datos) {
        return inventarioRepository.findById(id).map(p -> {
            p.setStock_inventario(datos.getStock_inventario());
            return inventarioRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
