package operaciones_api.operaciones.service;

import org.springframework.stereotype.Service;
import operaciones_api.operaciones.model.Venta;
import operaciones_api.operaciones.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> obtenerTodos() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> obtenerPorId(Integer id) {
        return ventaRepository.findById(id);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> actualizar(Integer id, Venta datos) {
        return ventaRepository.findById(id).map(v -> {
            // Actualiza los campos necesarios aquí
            return ventaRepository.save(v);
        });
    }

    public boolean eliminar(Integer id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}