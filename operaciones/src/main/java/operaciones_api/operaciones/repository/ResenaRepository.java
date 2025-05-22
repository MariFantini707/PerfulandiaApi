package operaciones_api.operaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import operaciones_api.operaciones.model.Resena;

public interface ResenaRepository extends JpaRepository<Resena, Integer> {
}