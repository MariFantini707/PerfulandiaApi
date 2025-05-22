package operaciones_api.operaciones.service;

import org.springframework.stereotype.Service;
import operaciones_api.operaciones.model.Factura;
import operaciones_api.operaciones.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerTodos() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> obtenerPorId(Integer id) {
        return facturaRepository.findById(id);
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Optional<Factura> actualizar(Integer id, Factura datos) {
        return facturaRepository.findById(id).map(f -> {
            // Actualiza los campos necesarios aquí
            return facturaRepository.save(f);
        });
    }

    public boolean eliminar(Integer id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}