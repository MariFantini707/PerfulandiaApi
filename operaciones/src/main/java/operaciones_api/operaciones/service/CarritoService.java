package operaciones_api.operaciones.service;

import org.springframework.stereotype.Service;
import operaciones_api.operaciones.model.Carrito;
import operaciones_api.operaciones.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> obtenerTodos() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> obtenerPorId(Integer id) {
        return carritoRepository.findById(id);
    }

    public Carrito guardar(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Optional<Carrito> actualizar(Integer id, Carrito datos) {
        return carritoRepository.findById(id).map(c -> {
            c.setCantidad_carrito(datos.getCantidad_carrito());
            return carritoRepository.save(c);
        });
    }

    public boolean eliminar(Integer id) {
        if (carritoRepository.existsById(id)) {
            carritoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}