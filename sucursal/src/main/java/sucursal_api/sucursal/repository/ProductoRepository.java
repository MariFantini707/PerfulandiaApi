package sucursal_api.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sucursal_api.sucursal.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
