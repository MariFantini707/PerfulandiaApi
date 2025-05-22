package operaciones_api.operaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import operaciones_api.operaciones.model.Detalle_venta;

public interface DetalleVentaRepository extends JpaRepository<Detalle_venta, Integer> {
}