package operaciones_api.operaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import operaciones_api.operaciones.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
}