package logistica_api.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import logistica_api.logistica.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    List<Proveedor> findByNombreProveedorContainingIgnoreCase(String nombre);
     //buscar a los proveedores por nombre 

}
