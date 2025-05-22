package operaciones_api.operaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import operaciones_api.operaciones.model.cliente;

public interface ClienteRepository extends JpaRepository<cliente, Integer> {
    
}