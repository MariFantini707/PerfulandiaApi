package operaciones_api.operaciones.service;

import org.springframework.stereotype.Service;
import operaciones_api.operaciones.model.Detalle_venta;
import operaciones_api.operaciones.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<Detalle_venta> obtenerTodos() {
        return detalleVentaRepository.findAll();
    }

    public Optional<Detalle_venta> obtenerPorId(Integer id) {
        return detalleVentaRepository.findById(id);
    }

    public Detalle_venta guardar(Detalle_venta detalle) {
        return detalleVentaRepository.save(detalle);
    }

    public Optional<Detalle_venta> actualizar(Integer id, Detalle_venta datos) {
        return detalleVentaRepository.findById(id).map(d -> {
            d.setCantidad_venta(datos.getCantidad_venta());
            d.setPrecio_unitario(datos.getPrecio_unitario());
            return detalleVentaRepository.save(d);
        });
    }

    public boolean eliminar(Integer id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}