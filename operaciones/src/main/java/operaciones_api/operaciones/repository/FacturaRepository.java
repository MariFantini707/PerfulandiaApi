package operaciones_api.operaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import operaciones_api.operaciones.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}