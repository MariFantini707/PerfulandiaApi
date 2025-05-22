package sucursal_api.sucursal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import sucursal_api.sucursal.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

}
