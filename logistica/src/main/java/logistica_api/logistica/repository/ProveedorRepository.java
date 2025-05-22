package logistica_api.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import logistica_api.logistica.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
}
