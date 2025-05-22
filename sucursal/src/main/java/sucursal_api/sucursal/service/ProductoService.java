package sucursal_api.sucursal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal_api.sucursal.model.Producto;
import sucursal_api.sucursal.repository.ProductoRepository;
@Service
public class ProductoService {
@Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizar(Integer id, Producto datos) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre_producto(datos.getNombre_producto());
            p.setDescripcion_producto(datos.getDescripcion_producto());
            p.setPrecio_producto(datos.getPrecio_producto());
            p.setId_inventario(datos.getId_inventario());
            p.setId_categoria(datos.getId_categoria());
            p.setId_detalle_pedido(datos.getId_detalle_pedido());
            return productoRepository.save(p);
        });
    }

    public boolean eliminar(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
