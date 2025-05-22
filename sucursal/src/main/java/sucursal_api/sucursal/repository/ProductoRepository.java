package sucursal_api.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sucursal_api.sucursal.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findById_producto(Integer id_producto);
    List<Producto> findByNombre_producto(String nombre_producto);
    List<Producto> findById_categoria(Integer id_categoria);
}
