package sucursal_api.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sucursal_api.sucursal.model.Sucursal;
import java.util.List;


public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
    List<Sucursal> findById_sucursal(Integer id_sucursal);
    List<Sucursal> findByNombre_sucursal(String nombre_sucursal);
    List<Sucursal> findByDireccion_sucursal(String direccion_sucursal);
}
